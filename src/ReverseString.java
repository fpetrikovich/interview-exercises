public class ReverseString {
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length-1; i < j; i++, j--) {
            swap(s, i, j);
        }
    }

    private void swap(char[]s, int i, int j) {
        char aux = s[i];
        s[i] = s[j];
        s[j] = aux;
    }
}
