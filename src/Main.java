import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String resultOfEnter;

        do {
            resultOfEnter = JOptionPane.showInputDialog(null, "1. CesarEncryption.\n2. CesarDecryption.\n3. BruteForceCesar.");

            try {
                int choice = Integer.parseInt(resultOfEnter);

                if (choice == 1) {
                    // Perform Cesar Encryption
                    Path path = Paths.get(JOptionPane.showInputDialog(null, "Enter the path of your document:"));
                    int key = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the encryption key:"));
                    char[] charArray = ReaderWriter.reader(path);
                    char[] encryptedArray = new char[charArray.length];

                    for (int i = 0; i < charArray.length; i++) {
                        if (Compare.compare(charArray[i], Dic.russianAlphabet)) {
                            encryptedArray[i] = EncrypteDecrypt.encrypt(charArray[i], key, Dic.russianAlphabet);
                        }
                    }

                    ReaderWriter.writer(encryptedArray, path);
                    JOptionPane.showMessageDialog(null, "Document encrypted");
                } else if (choice == 2) {
                    // Perform Cesar Decryption
                    Path path = Paths.get(JOptionPane.showInputDialog(null, "Enter the path of your document:"));
                    int key = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the decryption key:"));
                    char[] charArray = ReaderWriter.reader(path);
                    char[] decryptedArray = new char[charArray.length];

                    for (int i = 0; i < charArray.length; i++) {
                        if (Compare.compare(charArray[i], Dic.russianAlphabet)) {
                            decryptedArray[i] = EncrypteDecrypt.decrypt(charArray[i], key, Dic.russianAlphabet);
                        }
                    }

                    ReaderWriter.writer(decryptedArray, path);
                    JOptionPane.showMessageDialog(null, "Document decrypted");
                } else if (choice == 3) {
                    // Perform Brute Force Decryption
                    Path path = Paths.get(JOptionPane.showInputDialog(null, "Enter the path of your document:"));
                    char[] charArray = ReaderWriter.reader(path);
                    char[] decryptedArray = new char[charArray.length];

                    for (int j = 0; j < Dic.russianAlphabet.length; j++) {
                        for (int i = 0; i < charArray.length; i++) {
                            if (Compare.compare(charArray[i], Dic.russianAlphabet)) {
                                decryptedArray[i] = EncrypteDecrypt.decrypt(charArray[i], j, Dic.russianAlphabet);
                            }
                        }
                        System.out.println(decryptedArray);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong choice, please try again.");
                }
            } catch (NumberFormatException e) {
                if (resultOfEnter != null) {
                    JOptionPane.showMessageDialog(null, "Wrong input format, please choose a numeric answer.");
                } else {
                    break; // Exit the loop if resultOfEnter is null
                }
            }
        } while (resultOfEnter != null && !resultOfEnter.equals(""));
    }
}
