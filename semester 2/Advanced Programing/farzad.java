
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class farzad {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int number_of_movies = Integer.parseInt(myObj.nextLine());
        List<String> the_names = new ArrayList<>();
        for (int i = 0 ; i < number_of_movies ; i++ ) {
            the_names.add(myObj.nextLine()) ;

        }
        List<String> the_names_sort = new ArrayList<>();
        for (int i = 0 ; i < number_of_movies ; i++ ){
            String[] temp = the_names.get(i).toLowerCase().split(" ");
            for (int j = 0 ; j < Arrays.stream(temp).count(); j++){
                System.out.print(temp[j].substring(0,1).toUpperCase()+temp[j].substring(1) );
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
