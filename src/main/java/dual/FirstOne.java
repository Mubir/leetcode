import java.util.Arrays;

public class FirstOne {

    static int cal(int[] arr) {
        int result = 0;

        if (arr == null || arr.length <= 1) {
            return result; // Empty array or array with a single element
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                // Handle repeated values, you might want to adjust this based on your requirements
                result = result;
            } else if (arr[i] < arr[i + 1]) {
                result++;
            } else if (arr[i] > arr[i + 1]) {
                result += 2;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {2000, 1990, 2005, 2050};
        int[] arr2 = {2000, 2021, 2005};
        int[] arr3 = {2021, 2021, 2005};
        int[] arr4 = {2000}; // Edge case with a single element
        int[] arr5 = {}; // Edge case with an empty array

        System.out.println("args = " + cal(arr1)); // Output: 3
        System.out.println("args = " + cal(arr2)); // Output: 2
        System.out.println("args = " + cal(arr3)); // Output: 2
        System.out.println("args = " + cal(arr4)); // Output: 0
        System.out.println("args = " + cal(arr5)); // Output: 0
    }

}
