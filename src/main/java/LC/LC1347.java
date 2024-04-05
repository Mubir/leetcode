package LC;

public class LC1347 {
    public static int minSteps(String s, String t) {
        char[] bucket = new char[26];
        int count = 0;
        for(char x:s.toCharArray())
        {
            bucket[x-'a']++;
        }
        for(char x:t.toCharArray())
        {
            if(bucket[x-'a']<=0)
                count++;
            bucket[x-'a']--;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(minSteps("bab","aba"));
        System.out.println(minSteps("leetcode","practice"));
        System.out.println(minSteps("anagram","mangaar"));
    }
}
