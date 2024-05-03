package LC;

public class LC75 {
    public static void sortColors(int[] nums) {

        int indx = 0;
        int right = nums.length;
        int left = 0;
        while (indx < 0) {
            if (nums[indx] == 1) {
                indx++;
            } else if (nums[indx] == 0) {
                int temp = nums[left];
                nums[left] = 0;
                left++;
            }
        }
    }

    public static void main(String[] args) {

    }
}
