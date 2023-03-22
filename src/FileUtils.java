import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    public static List<String> readData(File file) {
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)))) {
            List<String> list = new ArrayList<>();

            while(scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }

            return list;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Can't read file!");
            return null;
        }
    }
}
