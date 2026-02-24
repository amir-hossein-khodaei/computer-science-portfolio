import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        if (a > b) { int temp = a; a = b; b = temp; }
        if (c > d) { int temp = c; c = d; d = temp; }

        int piecesFirstCut = 2;

        if ((a < c && c < b && b < d) || (c < a && a < d && d < b) || (a == c && b == d)) {
            piecesFirstCut++;
        }

        else if ((a < c && b < c) || (d < a && d < b)) {
            piecesFirstCut += 1;
        }

        else {
            piecesFirstCut += 2;
        }

        System.out.println(piecesFirstCut);

        sc.close();
    }
}
