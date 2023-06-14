import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderWriter {
    public static char[] reader(Path p) {
        StringBuilder buffer = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(p)) {
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
                buffer.append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return buffer.toString().replace("\r", "").replace("\n", "").toCharArray();
    }


    public static void writer(char[] data, Path p) {
        Path newPath = p.resolveSibling("Enrypted.txt");
        try (FileWriter writer = new FileWriter(newPath.toString())) {
            String strData = new String(data);
            writer.write(strData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
