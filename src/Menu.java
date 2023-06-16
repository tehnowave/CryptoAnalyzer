import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Menu {
    public static void menu() {
        String resultOfEnter;
        Path path;
        int key;

        do {
            resultOfEnter = JOptionPane.showInputDialog(null, "1. CesarEncryption.\n2. CesarDecryption.\n3. BruteForceCesar.");

            try {
                int choice = Integer.parseInt(resultOfEnter);

                if (choice >= 1 && choice <= 3) {
                    String filePath = JOptionPane.showInputDialog(null, "Enter the path of your document:");

                    if (filePath == null) {
                        break;
                    }

                    path = Paths.get(filePath);

                    if (!Files.exists(path)) {
                        JOptionPane.showMessageDialog(null, "The file doesn't exist, please check your path.");
                        continue;
                    }

                    switch (choice) {
                        case 1:
                            key = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the encryption key:"));
                            char[] readArray = Reader.reader(path, key);
                            char[] encryptArray = Encrypte.encrypt(readArray, key);
                            Writer.writer(encryptArray, path);
                            JOptionPane.showMessageDialog(null, "Document encrypted");
                            break;
                        case 2:
                            key = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the decryption key:"));
                            char[] readEncryptArray = Reader.reader(path, key);
                            char[] decryptArray = Decrypt.decrypt(readEncryptArray, key);
                            Writer.writer(decryptArray, path);
                            JOptionPane.showMessageDialog(null, "Document decrypted");
                            break;
                        case 3:
                            char[] readEncryptArray2 = Reader.reader(path);
                            String[] decryptedArray = Decrypt.decrypt(readEncryptArray2);
                            for (String s : decryptedArray) {
                                System.out.println(s);
                            }
                            JOptionPane.showMessageDialog(null, "Document encrypted by Brute Force");
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong choice, please try again.");
                }
            } catch (NumberFormatException e) {
                if (resultOfEnter != null) {
                    JOptionPane.showMessageDialog(null, "Wrong input format, please choose a numeric answer.");
                } else {
                    break;
                }
            }
        } while (resultOfEnter != null && !resultOfEnter.equals(""));
    }

}
