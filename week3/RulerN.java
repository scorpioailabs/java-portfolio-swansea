package week3;
public class RulerN {
    public static void main (String[] args) {
        int N = Integer.parseInt(args[0]);
        String ruler = " ";
        for (int i = 1; i <= N; i++)    {
            ruler = ruler + i + ruler;
        }
        System.out.println(ruler);
    }
}
