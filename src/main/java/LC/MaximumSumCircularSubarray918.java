package LC;

public class MaximumSumCircularSubarray918 {
    // https://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
    public int maxSubarraySumCircular(int[] A) {
        int total = 0;
        int currentMin = 0;
        int totalMin = Integer.MAX_VALUE;
        int currentMax = 0;
        int totalMax = Integer.MIN_VALUE;

        for (int x : A) {
            total += x;

            // Kadane's Algorithm to find Minimum subarray
            // sum.
            //min/max(a[i], dp[i - 1]+a[i])
            currentMin = Math.min(x, currentMin + x);
            if (currentMin < totalMin) {
                totalMin = currentMin;
            }
            // Kadane's Algorithm to find Maximum subarray
            // sum.
            currentMax = Math.max(x, currentMax + x);
            if (currentMax > totalMax) {
                totalMax = currentMax;
            }
        }

        //if totalMin is equaled to sum, i.e. all values are negative,
        // then we return totalMax.
        if (totalMin == total)
            return totalMax;

        // if we substiture total-min == max
        return Math.max(totalMax, total - totalMin);
    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray918 obj = new MaximumSumCircularSubarray918();
        System.out.println(obj.maxSubarraySumCircular(new int[]{1,-2,3,-2}));
    }
}
