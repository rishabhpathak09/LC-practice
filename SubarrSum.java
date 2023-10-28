public class SubarrSum {
    static public int subarraySum(int[] nums, int k) {
        int l = 0,r=0,count = 0,cur= 0;

        while (r<nums.length){
            cur+=nums[r];
            while(cur>k){
                cur-=nums[l];
                l++;
            }
            if (cur==k)
                count++;
            r++;
        }
        return count;
    }
}
