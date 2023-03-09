public class ExcelColToNum {
    public int titleToNumber(String columnTitle) {
        // C = A - 'A' + 1
        // (Cn) * 26^n + ... + (C0) * 26^0
        // (Cn * 26 + Cn-1) * 26 + Cn-2 ...

        int result = 0, letterVal;

        for (char c : columnTitle.toCharArray()) {
            letterVal = c - 'A' + 1;
            result = result * 26 + letterVal;

            //result += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, columnTitle.length() - 1 - i);
        }
        return result;
    }
}
