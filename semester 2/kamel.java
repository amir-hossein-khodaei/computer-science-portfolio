import java.util.Scanner;

public class kamel {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        int sum = 0 ;
        for (int i=1;i<n;i++){
            if (n%i==0){
                sum+=i;
            }
        }

        if (sum==n){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}
