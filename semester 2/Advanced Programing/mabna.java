import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
public class mabna {

    public static void main(String[] args) {
        while (true){
            Scanner myObj = new Scanner(System.in);
            String input =  myObj.nextLine();
            ArrayList<Character> number = new ArrayList<>(create_array(input));
            int mabna1 = Integer.parseInt((myObj.nextLine()));
            int mabna2 = Integer.parseInt(myObj.nextLine());
            int dot = find_dot(number);
            float decimal = to_decimal(number , dot , mabna1);
            System.out.println(decimal);
            for (Character ch : decimal_to(decimal,mabna2)) {
                System.out.print(ch);
            }
            System.out.println(' ');
            System.out.println("*******");
        }
    }

    public static ArrayList<Character> decimal_to(float decimal , int mabna2 ){
        char[] characters2={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        HashMap<String ,  Character> charMap = new HashMap<>();
        for (int i = 0; i < characters2.length; i++) {
            charMap.put(Integer.toString(i), characters2[i]);
        }
        charMap.put(".",'.');

        ArrayList<String> number = new ArrayList<String>();
        int temp = (int) decimal;
        for (int i=1 ; true ; i*=10 ){
            number.add( Integer.toString (temp%mabna2));
            temp=(temp-(temp%mabna2))/mabna2;
            if (temp < mabna2){
                number.add(Integer.toString (temp));
                break;
            }
        }

        Collections.reverse(number);
        number.add(".");
        float temp2 = decimal%1;

        if (temp2 > 0) {
            for (float i = 0; (i < 10)&&(temp2 != 0.0)  ; i++) {

                number.add(Integer.toString ( (int)(temp2 * mabna2)));
                temp2 = (temp2 * mabna2) - (int) (temp2 * mabna2);
            }
        }
        ArrayList<Character> numbers = new ArrayList<Character>();

        for (int i=0 ; i< number.size();i++){
            numbers.add(charMap.get(number.get(i)));
        }

        return numbers ;
    }

    public static float to_decimal(ArrayList<Character> not_decimal , int dot ,int mabna ){

        char[] characters = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] characters2={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < characters.length; i++) {
            charMap.put(characters[i], i);
        }
        for (int i = 0; i < characters.length; i++) {
            charMap.put(characters2[i], i);
        }

         float number=0 ;

         for (int i = dot , j=0 ; i >= 0 ; i--, j++ ){

             number += charMap.get(not_decimal.get(i)) * Math.pow(mabna , j) ;

         }

         for (int i = dot+2,j=-1; (i < not_decimal.size())&&(i<dot+12) ; i++ , j--){
             number += charMap.get(not_decimal.get(i)) * Math.pow(mabna ,j ) ;
         }

         return number ;
    }

    public static ArrayList<Character> create_array(String number) {
        ArrayList<Character> answer = new ArrayList<>();
        for(char ch : number.toCharArray()){
            answer.add(ch);
        }
        return answer ;
    }

    public static int find_dot(ArrayList<Character> number){
        for (int i=0 ; i < number.size(); i++){
            if (number.get(i)==('.')){
                return i-1;
            }
        }
        return number.size()-1;
    }
}
