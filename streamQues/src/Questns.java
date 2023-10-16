import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Questns {
    public static void evenNos(int[] arr){
        Arrays.stream(arr).boxed().filter(x->(x%2)==0).forEach(System.out::println);
    }

    protected static void startsWid1(int[] arr){
        Arrays.stream(arr)
                .boxed()
                .filter(x ->
                    x.toString().matches("1[0-9]*")
                )
                .forEach(System.out::println);
    }

    public static void distinctEles(int[] arr) {
        Set<Integer> hash = new HashSet<Integer>();

        Arrays.stream(arr)
                .boxed()
                .filter(hash::add)
                .forEach(System.out::println);
    }
}
