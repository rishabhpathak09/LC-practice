import java.util.Scanner;

public class ReverseLC {
    public int reverse(Integer x) {
        int maxInt = (1<<31)-1;
        int minInt = -1*(1<<31);

        StringBuilder t = new StringBuilder(x.toString());

        return Integer.parseInt(t.reverse().toString());
    }

    public static void main(String[] args) {
        ReverseLC lc = new ReverseLC();
        Scanner sc = new Scanner(System.in);
        System.out.println(lc.reverse(sc.nextInt()));
    }
}
