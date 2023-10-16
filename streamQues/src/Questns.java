import java.util.Arrays;
import java.util.stream.Stream;

public class Questns {
    public static void evenNos(int[] arr){
        Arrays.stream(arr).boxed().filter(x->(x%2)==0).forEach(System.out::println);
    }
}
