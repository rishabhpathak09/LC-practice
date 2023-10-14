import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int res = 0;

        for (int x : nums)
        {
            if (!numsSet.contains(x-1)) {
                int count = 1;
                int cur = x;
                while(numsSet.contains(cur+1)){
                    cur++;
                    count++;
                }
                res = Math.max(res, count);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int x = longestConsecutive(new int[]{1, 2, 3, 4, 100, 200});
        System.out.println(x);
    }
}
