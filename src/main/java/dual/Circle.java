package dual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Circle {
    public static void main(String[] args) {
        List<Integer> numbers =  new ArrayList<>(Arrays.asList(13, 5604, 31, 2, 13, 4560, 546, 654, 456));
        int pairsFound = 0;

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            int length = String.valueOf(number).length();
            int numberToRotate = number;
            int shiftRemaining = length - 1;
            List<Integer> tempList = numbers.subList(i + 1, numbers.size());

            while (shiftRemaining >= 0) {
                int tRemainder = numberToRotate % 10;
                numberToRotate /= 10;
                numberToRotate += tRemainder * Math.pow(10, length - 1);

                // Check if numberToRotate exists in tempList and has the same length
                if (tempList.contains(numberToRotate) && String.valueOf(numberToRotate).length() == length) {
                    System.out.printf("(%d,%d)%n", number, numberToRotate);
                    pairsFound++;
                }
                shiftRemaining--;
            }
        }
        System.out.println("No of pairs: " + pairsFound);
    }
}


