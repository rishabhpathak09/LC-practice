import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee{
    int id;
    int age;
    String dept;
    double sal;

    public Employee(int id, int age, String dept, double sal) {
        this.id = id;
        this.age = age;
        this.dept = dept;
        this.sal = sal;
    }
    @Override
    public String toString(){
        return "Employee details: "+id+", "+age+","+dept+", "+sal;
    }
}
public class Test {
    public static void main(String[] args) {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee(1,24,"abc",24.5));
        emps.add(new Employee(2,34,"xyz",34.5));
        emps.add(new Employee(3,44,"abc",44.5));
        emps.add(new Employee(4,54,"xyz",54.5));
        emps.add(new Employee(5,21,"abc",51.5));

        emps.stream().filter(x -> x.age>30).forEach(System.out::println);
        Set<Map.Entry<String, List<Employee>>> tempRes = emps.stream().filter(x -> x.age > 30)
                .collect(Collectors.groupingBy(x -> x.dept
                ))
                .entrySet();

        String s = "abcdefdefghiabcdef";

        int i =0;
        int j = 3;
        Map<String,Integer> map = new HashMap<>();
        while(j<=s.length()){
            String subStr = s.substring(i,j);
            if (map.containsKey(subStr)){
                map.put(subStr,map.get(subStr)+1);
            }
            else{
                map.put(subStr,1);
            }
            i+=3;
            j+=3;


        }
        map.forEach((k,v)->System.out.println(k+"="+v));
    }
}
