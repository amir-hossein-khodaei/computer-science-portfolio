import java.util.Scanner;
public class tabdil_horof {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int number = Integer.parseInt(myObj.nextLine());
        if (number==0){
            System.out.println("zero");
        }
        else {




            if (number>=1000){
                System.out.print(to_string((number/1000))+" thousand ");
                number=number%1000 ;
            }
            if (number>=100){
                System.out.print(to_string(number/100)+" hundred ");
                number=number%100;
            }
            if (number>=20){
                System.out.print(to_string_tenth(number/10) +" ");
                number=number%10;

                if (number>0){
                    System.out.print(to_string(number));
                }

            }
            else if (number>=10) {
                System.out.print(to_string_ten_twenty(number));
                number=number%10;
            }
        }
    }

    public static String to_string(int number) {
        switch (number){
            case 1 :
                return "one" ;
            case 2 :
                return "two" ;
            case 3 :
                return "three" ;
            case 4 :
                return "four" ;
            case 5 :
                return "five" ;
            case 6 :
                return "six" ;
            case 7 :
                return "seven" ;
            case 8 :
                return "eight" ;
            case 9 :
                return "nine" ;
        }
        return "";
    }

    public static String to_string_tenth(int number) {
        switch (number){
            case 2 :
                return "twenty" ;
            case 3 :
                return "thirty" ;
            case 4 :
                return "forty" ;
            case 5 :
                return "fifty" ;
            case 6 :
                return "sixty" ;
            case 7 :
                return "seventy" ;
            case 8 :
                return "eighty" ;
            case 9 :
                return "ninety" ;
        }
        return "";
    }

    public static String to_string_ten_twenty(int number) {
        switch (number){
            case 10 :
                return "ten" ;
            case 11 :
                return "eleven" ;
            case 12 :
                return "twelve" ;
            case 13 :
                return "thirteen" ;
            case 14 :
                return "fourteen" ;
            case 15 :
                return "fifteen" ;
            case 16 :
                return "sixteen" ;
            case 17 :
                return "seventeen" ;
            case 18 :
                return "eighteen" ;
            case 19 :
                return "nineteen" ;
        }
        return "";
    }
}