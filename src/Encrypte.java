public class Encrypte {
    public static char[] encrypt(char[] readArray, int key) {
        char[] encryptedArray = new char[readArray.length];
        for (int i = 0; i < readArray.length; i++) {
            if (Compare.compare(readArray[i], Dic.russianAlphabet)) {
                int index = Compare.indexReturn(readArray[i], Dic.russianAlphabet);
                encryptedArray[i] = Dic.russianAlphabet[(index + key) % 74];
            }
        }
        return encryptedArray;
    }

}
