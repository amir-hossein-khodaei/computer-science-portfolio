import java.util.ArrayList;
import java.util.Scanner;
public class tabdil_horof2 {
    public static void main(String[] args) {


//        for (long i = 0; i < Long.MAX_VALUE; i++) {        ///////////////////////////////////
//            to_text(i);
//        }
//    }
//    private static void to_text(long j) {                //////////////////////////////////////


        String one_to_nine[] = {"", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine "};
        String ten_to_nineteen[] = {"ten ", "eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ", "eighteen ", "nineteen "};
        String twenty_to_ninety[] = {"", "", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninety "};
        String next[] = {"", "thousand ", "million ", "billion ", "trillion ", "quadrillion ", "quintillion "};

        while (true) {                                        ///////////////////////////
            Scanner myObj = new Scanner(System.in);
            long number = Long.parseLong((myObj.nextLine())); //////////////////////////////////


//            long number =j;                                 ////////////


            if (number < 0) {
                System.out.print("negetive ");
            }
            number = Math.abs(number);
            if (number == 0) {
                System.out.println("zero");
            } else {
                String temmp_str = "";
                ArrayList<String> final_number = new ArrayList<>();
                ArrayList<String> temp_number = new ArrayList<>();
                for (int temp = 0, i = 0; number != 0; number /= 1000, i++) {
                    temp_number.clear();
                    temmp_str = "";
                    temp = (int) (number % 1000);
                    if (temp == 0) {
                        continue;
                    }
                    if (temp >= 100) {
                        temp_number.add(one_to_nine[temp / 100] + "hundred ");
                        temp = temp % 100;
                    }
                    if (temp >= 20) {
                        temp_number.add(twenty_to_ninety[temp / 10]);
                        temp = temp % 10;
                        if (temp > 0) {
                            temp_number.add(one_to_nine[temp]);
                        }
                    } else if (temp >= 10) {
                        temp_number.add(ten_to_nineteen[temp % 10]);
                        temp = temp % 10;
                    } else {
                        temp_number.add(one_to_nine[temp]);
                    }
                    temp_number.add(next[i]);
                    for (; !(temp_number.isEmpty()); ) {
                        temmp_str = temmp_str + temp_number.getFirst();
                        temp_number.removeFirst();
                    }
                    final_number.add(temmp_str);
                }
                for (; !(final_number.isEmpty()); ) {
                    System.out.print(final_number.getLast());
                    final_number.removeLast();
                }
                System.out.println("");
            }
        }
    }
}          //////////////////////
