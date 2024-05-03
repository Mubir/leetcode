package LC;

public class LC55JumpGameOne {
    boolean gameIsOn(int[] nums) {

        int size = nums.length;
        int current = nums[0];
        int i = 1;
        if (size == 1) // [0] : already reached the last index.
            return true;
        if (current <= 0) // [0,1]
            return false;
        // size -1 as need to reach only last index not get passed last index.
        for (i = 1; i < size - 1; i++) {
            current--;
            current = Math.max(current, nums[i]);
            if (current <= 0)
                return false;
        }

        return i == (size - 1); // [2,0,0] -> reaches last index so not true .
        // i==size-1 to check if it reaches last index
    }

    public static void main(String[] args) {
        LC55JumpGameOne obj = new LC55JumpGameOne();

//        System.out.println(obj.gameIsOn(new int[]{2,3,1,1,4})); //true
//        System.out.println(obj.gameIsOn(new int[]{3,2,1,0,4})); // false
//        System.out.println(obj.gameIsOn(new int[]{0,1})); // false
        System.out.println(obj.gameIsOn(new int[]{2, 3, 1, 1, 4})); // true
    }
}
