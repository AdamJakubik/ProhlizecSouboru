import javax.swing.*;
import java.io.File;
import java.util.List;

public class Main extends JFrame{
    private JPanel panel1;
    private JButton openFileButton;
    private JTextArea textArea1;

    private final JFileChooser jFileChooser = new JFileChooser(".");

    public Main(){
        openFileButton.addActionListener(e-> showFileChooser());
        initComponents();
    }

    private void showFileChooser(){
        int result = jFileChooser.showOpenDialog(this);

        if (result == JFileChooser.ERROR_OPTION) {
            JOptionPane.showMessageDialog(null, "Error, please select file again!");
            return;
        }

        System.out.println("Reading...");
        loadData(jFileChooser.getSelectedFile());
    }

    private void loadData(File file) {
        deleteData();

        List<String> listData = FileUtils.readData(file);

        if (listData == null) {
            JOptionPane.showMessageDialog(null, "Error, please select file again!");
            return;
        }

        if (listData.isEmpty()){
            JOptionPane.showMessageDialog(null, "File is empty!");
            return;
        }

        listData.forEach(s-> textArea1.append(s + "\n"));
    }

    private void deleteData(){
        textArea1.setText(null);
    }

    private void initComponents(){
        JMenuBar jMenuBar = new JMenuBar();

        JMenu menu = new JMenu("File");

        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(e -> showFileChooser());

        menu.add(openItem);
        menu.addSeparator();

        JMenuItem deleteData = new JMenuItem("Delete");
        deleteData.addActionListener(e -> deleteData());

        menu.add(deleteData);

        jMenuBar.add(menu);
        setJMenuBar(jMenuBar);

        textArea1.setEditable(false);
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.setVisible(true);
        m.setContentPane(m.panel1);
        m.setSize(400, 400);
        m.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
