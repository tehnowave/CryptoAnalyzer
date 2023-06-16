import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Reader {


    public static char[] reader(Path p, int key) {

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

}
