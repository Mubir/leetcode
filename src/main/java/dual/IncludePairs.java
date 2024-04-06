package dual;

import java.util.Arrays;

public class IncludePairs {

    public static int includePairs(String[] words) {
        Arrays.sort(words);
        int answer = 0;

        for (int i = 0; i < words.length; i++) {
            // Gallop forward until we're past the words that pair with this.
            int gap = 1;
            int lower = i;
            int upper = i + gap;

            while (upper < words.length && words[upper].startsWith(words[i])) {
                lower = upper;
                upper += gap;
                gap += gap;
            }

            // Be sure we are not off the end of the word list.
            upper = Math.min(upper, words.length);

            // Binary search to find the end.
            while (lower + 1 < upper) {
                int mid = (upper + lower) / 2;
                if (words[mid].startsWith(words[i])) {
                    lower = mid;
                } else {
                    upper = mid;
                }
            }

            // Count words that pair with this one.
            answer += lower - i;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] words = {"back", "backdoor", "gammon", "backgammon", "comeback", "come", "door"};
        int result = includePairs(words);
        System.out.println(result);

        String[] col2 = {"abc", "a", "a", "b", "ab", "ac"};
        System.out.println(includePairs(col2));
    }
}

