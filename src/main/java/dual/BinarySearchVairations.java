package dual;

/**
 * ref:https://www.geeksforgeeks.org/variants-of-binary-search/
 */
public class BinarySearchVairations {
    boolean isContain(int[] arr, int cand) {
        int left = 0;
        int right = arr.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == cand)
                return true;
            else if (arr[mid] < cand) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    /**
     * If the length of the range is odd, adding +1 ensures
     * that the division results in rounding up to the next integer.
     * This is important because when dividing an odd number by 2,
     * the result should be rounded up to get the midpoint.
     * <p>
     * For example, if low = 2 and high = 5, the length of the range
     * is 5 - 2 + 1 = 4, and the midpoint should be at index 2 + 4 / 2 = 4.
     * If we didn't add +1, the midpoint would be at index 2 + 3 / 2 = 3,
     * which would be incorrect.
     * <p>
     * Choose the appropriate expression based on the specific requirements
     * of your algorithm. If you want the midpoint to be rounded up when the
     * range is odd, use `left + (right - left) / 2`.
     * If you want the midpoint to be rounded down in all cases,
     * use  `left + (right - left + 1) / 2`.
     */
    int firstSeen(int[] arr, int cand) {

        int left = 0;
        int right = arr.length;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid] == cand) {
                index = mid;
                right = mid - 1;
            } else if (arr[mid] < cand) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }

    int lastSeen(int[] arr, int cand) {

        int left = 0;
        int right = arr.length;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid] == cand) {
                index = mid;
                left = mid + 1;
            } else if (arr[mid] < cand) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }
    public static void main(String[] args) {
        BinarySearchVairations search = new BinarySearchVairations();
        int arr[] = {2, 3, 3, 5, 5, 5, 6, 6, 7, 8,
                8, 9, 9, 10, 234, 666, 777, 777, 1000};
        System.out.println("***** isContain() check *****");
        System.out.println(search.isContain(arr, 10)); //true
        System.out.println(search.isContain(arr, 555)); //false
        System.out.println("***** firstSeen() check *****");
        System.out.println(search.firstSeen(arr, 5)); // 3
        System.out.println(search.firstSeen(arr, 9)); // 11
        System.out.println(search.firstSeen(arr, 555)); // -1
        System.out.println("***** lastSeen() check *****");
        System.out.println(search.lastSeen(arr, 5)); // 5
        System.out.println(search.lastSeen(arr, 9)); // 12
        System.out.println(search.lastSeen(arr, 555)); // -1
    }
}
