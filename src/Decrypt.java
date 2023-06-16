
public class Decrypt {
    public static char[] decrypt(char[] encryptedArray, int key) {
        char[] decryptedArray = new char[encryptedArray.length];

        for (int i = 0; i < encryptedArray.length; i++) {
            if (Compare.compare(encryptedArray[i], Dic.russianAlphabet)) {
                int index = Compare.indexReturn(encryptedArray[i], Dic.russianAlphabet);
                decryptedArray[i] = Dic.russianAlphabet[(index + 74 - key) % 74];
            }

        }
        return decryptedArray;
    }



    public static String[] decrypt(char[] encryptedArray) {
        char[] temp = new char[encryptedArray.length];
        String[] decryptedArray = new String[Dic.russianAlphabet.length];

        for (int j = 0; j < Dic.russianAlphabet.length; j++) {
            for (int i = 0; i < encryptedArray.length; i++) {
                if (Compare.compare(encryptedArray[i], Dic.russianAlphabet)) {
                    int index = Compare.indexReturn(encryptedArray[i], Dic.russianAlphabet);
                    temp[i] = Dic.russianAlphabet[(index + Dic.russianAlphabet.length - j) % Dic.russianAlphabet.length];
                }
            }
            decryptedArray[j] = new String(temp);
        }

        return decryptedArray;
    }



}