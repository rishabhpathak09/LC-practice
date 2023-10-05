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

    public static void main(String[] args) {
        majorityElement(new int[]{1,2,1,2,1,3,1,3,3,3,3,3,3}).stream().forEach(System.out::println);
    }


}
