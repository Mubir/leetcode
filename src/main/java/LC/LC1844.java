package LC;

public class LC1844 {
    public static String replaceDigits(String s) {
        int sz = s.length() - 1;
        int i = 1;

        StringBuilder sb = new StringBuilder();

        while (i <= sz) {
            int c = s.charAt(i - 1) - '0';
            int inc = s.charAt(i) - '0';
            char current = (char) (c + inc + '0');
            sb.append(s.charAt(i - 1)).append(current);
            i += 2;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceDigits("a1b2c3d4e"));
        System.out.println(replaceDigits("a1c1e1"));
//        System.out.println(replaceDigits());
    }
}
