public class EncrypteDecrypt {
    public static char encrypt(char c, int key, char[] dic) {
        int index = Compare.indexReturn(c, dic);
        return dic[(index + key) % 74];
    }

    public static char decrypt(char c, int key, char[] dic) {
        int index = Compare.indexReturn(c, dic);
        return dic[(index + 74 - key) % 74];
    }
}
