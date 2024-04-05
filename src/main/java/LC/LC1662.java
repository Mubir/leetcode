package LC;

public class LC1662 {

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder sbOne = new StringBuilder();
        StringBuilder sbTwo = new StringBuilder();
        int i = 0;
        while (word1.length > i) {
             sbOne.append(word1[i]);
            i++;
        }
        i = 0;
        while (word2.length > i) {
            sbTwo.append(word2[i]);
            i++;
        }
        return sbOne.toString().compareTo(sbTwo.toString()) == 0;
    }

    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqual(new String[]{"abc", "d", "defg"},new String[]{"abcddefg"}));
        System.out.println(arrayStringsAreEqual(new String[]{"a", "cb"},new String[]{"ab", "c"}));


    }
}
