import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class khayam {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println();
        int radif_kol = Integer.parseInt(myObj.nextLine());

        List<List<Integer>> mosalas = new ArrayList<>();

        for (int i = 0; i < radif_kol; i++) {
            List<Integer> radif = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if ( j == 0 || j == i ) {
                    radif.add(1) ;
                }
                else {
                    int value = (mosalas.get(i - 1).get(j - 1)) + mosalas.get(i - 1).get(j) ;
                    radif.add(value);
                }
            }
            mosalas.add(radif);
        }
        for (int i = 0 , j = 0 ; i < radif_kol ; i++ ) {
            for(int b=0 ; b < (j+1) ; b++) {
                System.out.print(mosalas.get(i).get(b) + " " );
            }
            System.out.println();
            j++;
        }
    }
}
