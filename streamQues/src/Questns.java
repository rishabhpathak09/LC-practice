import java.sql.SQLOutput;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
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

    public static void firstEle(int[] arr) {


                Arrays.stream(arr)
                .boxed()
                .findFirst()
                .ifPresent(System.out::println)
        ;
    }

    public static void maxEle(int[] arr) {
         double x = Arrays.stream(arr)
                .boxed()
                .mapToDouble(Integer::doubleValue)
                .average()
                 .getAsDouble();
        System.out.println("Hi "+x);
    }

    public static void firstRepeated(String str) {
        /*
        Set s = new HashSet();

        String res =
                Stream.of(str.toLowerCase().split(""))
                .filter(x -> !s.add(x))
//                        .forEach(System.out::println);
                .toList()
                .get(0);

         */
        Integer res = str.chars()
                .mapToObj(Character::toLowerCase)
                .collect(Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()
                        )
                )
                .entrySet()
                .stream()
                .filter(x -> x.getValue()>1L)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();

        System.out.println("firstRepeated: " +(char)res.intValue());
    }

    public static void sort(int[] ints) {
    }

    public static void concatStream(int[] ints, int[] ints1) {
    }

    public static void countWords(String[] strings) {
    }

    public static void nullableList(int[] ints) {
    }

    public static void countEach(String str) {
        HashMap<String, Long> res = Stream.of(str.toLowerCase().split(""))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        HashMap::new,
                        Collectors.counting()
                ));
        res.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue()
                )
                .forEach(
                        x->{
                            System.out.println(x.getKey()+" = "+x.getValue());
                        }
                );
    }
}
