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
        Arrays.stream(ints).boxed()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    public static void concatStream(int[] ints, int[] ints1) {
        Stream.of(ints)
                .forEach(System.out::println);
        Stream.concat(
                Arrays.stream(ints)
                                .boxed(),
                        Arrays.stream(ints1)
                                .boxed()
                )
                .forEach(System.out::println);
    }

    public static void countWords(String[] strings) {
        Stream.of(strings)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                HashMap::new,
                                Collectors.counting()
                        )
                )
                .forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static void nullableList(int[] ints) {
        class Notes{
            int id;
            String name;
            long val;

            public Notes(int id, String name, long val) {
                this.id = id;
                this.name = name;
                this.val = val;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public long getVal() {
                return val;
            }

            public void setVal(long val) {
                this.val = val;
            }
        }

        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "note1", 11));
        noteLst.add(new Notes(2, "note2", 22));
        noteLst.add(new Notes(3, "note3", 33));
        noteLst.add(new Notes(4, "note4", 44));
        noteLst.add(new Notes(5, "note5", 55));
        noteLst.add(new Notes(5, "note9", 99));
        noteLst.add(new Notes(6, "note4", 66));

        LinkedHashMap<Integer, ArrayList> abc = noteLst.stream()
                .sorted(Comparator.comparingLong(Notes::getVal).reversed())
                .collect(Collectors.toMap(
                        Notes::getId,
                        x -> {
                            ArrayList t = new ArrayList();
                            t.add(x.getName());
                            t.add(x.getVal());
                            return t;
                        },
                        //works when duplicates found
                        (oldValue, newValue) -> {
                            ArrayList<Object> x = new ArrayList<>();
                            x.add(newValue);
                            x.add("Hi");
                            x.add(oldValue);
                            return x;
                        },
                        LinkedHashMap::new)
                );
        System.out.println(abc);

        Optional.ofNullable(noteLst)
                .orElseGet(Collections::emptyList)
                .stream().map(Notes::getName)
                .forEach(System.out::println);
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
