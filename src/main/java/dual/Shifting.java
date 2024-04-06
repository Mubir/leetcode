package dual;

import java.util.ArrayList;
import java.util.List;

public class Shifting {

    public static ArrayList<Integer> sortedCyclicShiftDifferences(int[] num1, int[] num2) {
        int len = num1.length;

        if (len != num2.length) {
            throw new IllegalArgumentException("Arrays must be of the same length.");
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int shift = 0; shift < len; shift++) {
            int temp = 0;
            for (int i = 0; i < len; i++) {
                int index = (shift + i) % len;

                temp += Math.abs(num1[index] - num2[i]);
            }
            result.add(temp);
        }

        result.sort(null);
        return result;

        // return differences;
    }

    public static void main(String[] args) {
//        int[] num1 = {1, 2, 3};
//        int[] num2 = {2, 3, 4};

        int[] num1 = {1, 4, 2, 11};
        int[] num2 = {10, 1, 8, 4};

        List<Integer> result = sortedCyclicShiftDifferences(num1, num2);

        for (int s : result) {
            System.out.print(s + " ");
        }
    }
}
