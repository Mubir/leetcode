package LC;

public class LC1556 {
    public static String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();

        int i = 0;

        while (n != 0) {
            int current = n % 10;
            n = n / 10;
            if (i != 0 && i % 3 == 0) {
                sb.append('.');
            }
            i++;
            sb.append(current);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(thousandSeparator(987));
        System.out.println(thousandSeparator(1234));
        System.out.println(thousandSeparator(123456));
    }
}
