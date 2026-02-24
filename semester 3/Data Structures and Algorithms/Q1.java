import java.sql.SQLOutput;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a==0||b==0||c==0) {
            System.out.println("No");
        }else if ((a+b+c)==180){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}
