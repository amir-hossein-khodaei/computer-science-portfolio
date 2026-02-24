import java.util.Scanner;

public class exam {

    public static int rev_maker(int number){
        int rev = 0;
        for (; number != 0; ) {
            rev *= 10;
            rev += number % 10;
            number /= 10;
        }
        return (rev);
    }

    public static int mabna_to_10 (int number , int mabna ){
        int answer = 0 ;

        for(int counter = 0 ;number!=0 ;counter++)
        {
            int mod = number%10 ;
            number/=10;
            answer += (int)(mod*Math.pow(mabna,counter));
        }
        return answer ;
    }

    public static int mabna_to_x(int number , int mabna ){
        int answer=0;
        for (int i=1 ;number!=0 ;number/=mabna){
            answer=answer+(number%mabna)*i;
            i*=10;
        }
        return answer;
    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int main_number = input.nextInt() ;
        int mabna_1 = input.nextInt() ;
        int mabna_2 = input.nextInt() ;
        int temp = 0 ;
        temp=(mabna_to_x(mabna_to_10(main_number,mabna_1),mabna_2));

        if ((temp== rev_maker(temp)))
        {
            System.out.println("YES");
        }

        else
        {
            System.out.println("NO");
        }

    }
}
