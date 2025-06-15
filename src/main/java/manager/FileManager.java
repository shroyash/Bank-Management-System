package manager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
        return lines;
    }

    public void writeFile(String fileName, List<String> toWriteData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (String line : toWriteData) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
