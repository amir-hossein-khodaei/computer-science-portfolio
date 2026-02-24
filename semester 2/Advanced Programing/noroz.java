import java.util.Scanner;

public class noroz {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println();
        int x = Integer.parseInt(myObj.nextLine());
        int n = Integer.parseInt(myObj.nextLine());
        if (n==0){
            System.out.println(20);
        } else if (n==7) {
            System.out.println(x);
        } else {
            if ((x-n)<=0){
                System.out.println(0);
            }
            else {
                System.out.println((x-n));
            }
        }
    }
}
