public class MaxSubArrSum {

    public static int maxSubArray(int[] nums) {
        int curSum= 0;
        int resMax= 0;

        for (int num: nums){
            if (curSum<=0){
                curSum =num;
            }
            else {
                curSum += num;
            }
            resMax = Math.max(curSum,resMax);
        }
        return resMax;


    }

    public static void main(String[] args) {
        int ans = maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(ans);
    }
}
