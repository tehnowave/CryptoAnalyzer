import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class Writer {


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
