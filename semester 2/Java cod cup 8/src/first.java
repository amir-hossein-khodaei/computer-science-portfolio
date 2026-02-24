import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt() ;
            for (int i = 0 ; i <t ; i++ ) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int h = scanner.nextInt();
                int j=1;

                for ( int hi=0 ; hi!=h ;j++   ){
                    hi=( hi+a);
                    if (hi>=h){
                        break;
                    }
                    hi-=b;


                }
                System.out.println(j);
            }
    }
}
