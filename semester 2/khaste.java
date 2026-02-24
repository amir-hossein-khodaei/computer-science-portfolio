import java.util.Scanner;

public class khaste {
    public static int rev_maker(int number){
        int rev = 0;
        for (; number != 0; ) {
            rev *= 10;
            rev += number % 10;
            number /= 10;
        }
       return (rev);
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println();
        int number_1 = Integer.parseInt(myObj.nextLine());
        System.out.println();
        int number_2 = Integer.parseInt(myObj.nextLine());
        int rev_number_1 = rev_maker(number_1) ;
        int rev_number_2 = rev_maker(number_2) ;
        if (rev_number_2<rev_number_1){
            int temp = 0 ;
            temp=number_2 ;
            number_2 = number_1 ;
            number_1 = temp ;
            temp = 0 ;
            temp=rev_number_2 ;
            rev_number_2 = rev_number_1 ;
            rev_number_1 = temp ;
        }
        if (rev_number_1<rev_number_2){
            System.out.println(number_1+" < "+number_2);
        }
        else {
            System.out.println(number_1+" = "+number_2);
        }



    }
}