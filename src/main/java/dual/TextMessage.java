package dual;

import java.util.ArrayList;

public class TextMessage {

    public static ArrayList<String> encoder(String str, int x) {
        if (str == null || str.isEmpty() || x <= 0) {
            return new ArrayList<>(); // Handle invalid input
        }

        ArrayList<String> result = new ArrayList<>();
        int size = str.length();
        int n = size / x;

        int start = 0;
        int end = Math.min(x, size); // Ensure end is within bounds

        while (end <= size) {
            StringBuilder temp = new StringBuilder();
            temp.append(str, start, end).append("<br>");
            result.add(temp.toString());
            if (end == size) {
                break;
            }
            start = end;
            if (end + x < size) {
                end += x;
            } else {
                end = size;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> rt1 = encoder("bouoiklainkluoihouioihloiojfjhsod", 10);
        for (String s : rt1) {
            System.out.println(s);
        }

        ArrayList<String> rt2 = encoder("", 10); // Edge case: Empty string
        for (String s : rt2) {
            System.out.println(s);
        }

        ArrayList<String> rt3 = encoder("abc", 5); // Edge case: String length less than x
        for (String s : rt3) {
            System.out.println(s);
        }
    }
}
