package LC;

public class LC1249 {
    public static String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        int close = 0;
        for (char x : s.toCharArray()) {
            if (x == '(') {
                open++;
                sb.append(x);
            } else if (x == ')' && open > 0) {
                open--;
                sb.append(x);
            } else if (x >= 'a' && x <= 'z') {
                sb.append(x);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));

    }
}
