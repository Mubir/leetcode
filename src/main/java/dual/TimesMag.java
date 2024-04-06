package dual;

import java.util.ArrayList;
import java.util.List;

public class TimesMag {
    static List<String> newsT(String str, int sz) {
        List<String> result = new ArrayList<String>();
        result.add("*".repeat(sz + 2));
        //int rSz = sz - 2;
        int rSz = sz;
        int remaining = rSz;
        Boolean addMe = false;
        Boolean lastWord = false;
        String temp = "";

        // String[] words = str.split(" ");
        String[] sentense = str.split("(?<=[!.?])");
        System.out.println(sentense.length);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentense.length; i++) {
            String[] words = sentense[i].split(" ");
            System.out.println(words.length);
            temp = "";
            remaining = rSz;
            sb.delete(0, sb.length());
            sb.append("  ");
            remaining -= 2;
            for (String word : words) {
                temp = "";
                String wrd = word;
                int currStrLen = wrd.length();
                if (remaining - (currStrLen + 1) >= 0 || remaining - (currStrLen) == 0) {
                    if (remaining - (currStrLen) == 0) {
                        sb.append(wrd);
                        remaining = remaining - (currStrLen);
                    } else {
                        sb.append(wrd + " ");
                        remaining = remaining - (currStrLen + 1);
                    }

                    // System.out.println(remaining);
                } else {
                    addMe = true;
                    temp = wrd;
                }
                if (currStrLen > 1 && (wrd.charAt(currStrLen - 1) == '!' || wrd.charAt(currStrLen - 1) == '.' || wrd.charAt(currStrLen - 1) == '?')) {
                    addMe = true;
                    lastWord = true;
//                    temp = wrd;
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
            if (temp.length() != 0)
                result.add("*" + temp.toString() + " ".repeat(remaining + 1) + "*");
            temp = "";

        }
        result.add("*".repeat(sz + 2));
        return result;
    }

    public static void main(String[] args) {
        String text = "Hi! This is the article you have to format properly. Could you do that for me, please?";
        int width = 16;
        List<String> result = newsT(text, width);
        for (String line : result) {
            System.out.println(line);
        }

        String text2 = "OO my god! how did i do it. i cant believe it.";
        int width2 = 12;
        List<String> result2 = newsT(text2, width2);
        for (String line : result2) {
            System.out.println(line);
        }
    }
}
