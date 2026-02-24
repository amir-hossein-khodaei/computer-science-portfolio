import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class second {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int value= scanner.nextInt();
        int[] a = new int[value];
        int k = scanner.nextInt();

        for (int i=0 ;i< value;i++)
        {
            a[i]= scanner.nextInt();
        }

        int[] b= Arrays.stream(a).sorted().toArray();
        int j=0;
        for( int max = 0 ; max <= k ; j++  ){
            if (j==value){
                break;
            }
            max += b[j]+1;
        }
        if (value==0){
            System.out.println(0);
        }

        System.out.println(j);
    }
}
