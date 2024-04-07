package dual;

import java.util.ArrayList;
import java.util.List;

public class NewsReporter {

    static List<String> news(String str, int sz) {
        List<String> result = new ArrayList<String>();
        result.add("*".repeat(sz));
        int rSz = sz - 2;
        int remaining = rSz;
        Boolean addMe = false;
        String temp = "";
        // String[] words = str.split(" ");
        String[] words = str.split("(?<=[ !?])");
        // print(words);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String currStr = words[i];
            int currStrLen = currStr.length();

            //   if(currStr.charAt(currStrLen-1) == '?' &&
            if (remaining - (currStrLen + 1) >= 0) {
                sb.append(currStr + " ");
                remaining = remaining - (currStrLen + 1);
            } else {
                addMe = true;
                temp = words[i];
            }
//                    else {
//                sb.append(currStr);
//                remaining -=currStrLen;
//            }
            if (currStr.charAt(currStrLen - 1) == '!') {
                addMe = true;
            }

            if (addMe) {
                result.add("*" + sb.toString() + " ".repeat(remaining) + "*");
                sb.delete(0, sb.length());
                addMe = false;
                remaining = rSz;
                sb.append(temp + " ");
                remaining = remaining - (temp.length() + 1);
            }
        }
        result.add("*" + temp + " ".repeat(remaining + 1) + "*");
        result.add("*".repeat(sz));
        return result;
    }

    public static void main(String[] args) {

        String text = "Hi! This is the article you have to format properly. Could you do that for me, please?";
        int width = 16;
        List<String> result = news(text, width);
        for (String line : result) {
            System.out.println(line);
        }

    }
}
