package LC;

import java.util.HashMap;

public class ContinuousSubarraySum523 {
    public boolean checkSubarraySum(int[] nums, int k) {

        if(nums.length==0 || k<=0)
            return false;

        int sum=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            int cand = sum%k;

            if(map.containsKey(cand) && (i - map.get(cand))>1) // 0 fails for [0] k=1 -> false
                return true;

            if(!map.containsKey(cand)) // else fails for:: [0,0] k=1 -> true
                map.put(cand,i);
        }

        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum523 obj = new ContinuousSubarraySum523();
        System.out.println(obj.checkSubarraySum(new int[]{23,2,4,6,6},7));
    }
}
