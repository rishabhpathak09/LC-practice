import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MajorityElement2 {
    public static List<Integer> majorityElement(int[] nums) {

        Map<Integer, Long> counter = Arrays
                .stream(nums)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );
        int req = nums.length / 3;
        List<Integer> vals = counter.entrySet().stream().filter(x -> x.getValue() > req).map(Map.Entry::getKey).collect(Collectors.toList());
        return vals;

    }

    public static List<Integer> majorityElementNoSpc(int[] nums) {
        // 1st pass
        int count1 = 0;
        int count2 = 0;

        Integer candidate1 = null;
        Integer candidate2 = null;

        for (int n: nums) {
            if (candidate1 != null && candidate1 == n) {
                count1++;
            } else if (candidate2 != null && candidate2 == n) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = n;
                count1++;
            } else if (count2 == 0) {
                candidate2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // 2nd pass
        List result = new ArrayList <> ();

        count1 = 0;
        count2 = 0;

        for (int n: nums) {
            if (candidate1 != null && n == candidate1) count1++;
            if (candidate2 != null && n == candidate2) count2++;
        }

        int n = nums.length;
        if (count1 > n/3) result.add(candidate1);
        if (count2 > n/3) result.add(candidate2);

        return result;
    }

    public static void main(String[] args) {
        majorityElement(new int[]{1,2,1,2,1,3,1,3,3,3,3,3,3}).stream().forEach(System.out::println);
    }


}
