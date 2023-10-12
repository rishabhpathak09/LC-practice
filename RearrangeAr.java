public class RearrangeAr {
    public static int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0, j = 1;

        for (int el : nums){
            if (el>0 && i<nums.length) {
                res[i] = el;
                i += 2;
            }
            else {
                res[j] = el;
                j += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        rearrangeArray(new int[]{3, 1, -2, -5, 2, -4});
    }
}
