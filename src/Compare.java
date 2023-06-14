public class Compare {

    public static boolean compare(char c, char[] dictionary) {
        for (char value : dictionary) {
            if (c == value) {
                return true;
            }
        }
        return false;
    }

    public static int indexReturn(char c, char[] dictionary) {
        int index = 0;

        for (int i = 0; i < dictionary.length; i++) {
            if (c == dictionary[i]) {
                index = i;
                break;
            }
        }
        return index;
    }
}

