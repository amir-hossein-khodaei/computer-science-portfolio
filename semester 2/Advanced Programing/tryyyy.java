public class tryyyy {

    public static int mabna_to_10 (int number , int mabna ){
        int count = 0 ;
        int answer = 0 ;
        while(number!=0){
            int mod = number%10 ;
            number/=10;
            answer += (int)(mod*Math.pow(mabna,count));
            count++;
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
        System.out.println(mabna_to_x((mabna_to_10(505 , 6)),6));
    }

}
