import java.util.Scanner;
public class kaike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        int t = Integer.parseInt(scanner.nextLine()); // tedad mehmani
        for (int i = 0; i < t; i++) {
            long n = scanner.nextInt(); //tedad kaike (sorat)
            long k = scanner.nextInt(); //tedad mehman (makhrag)
            long test = (9223372036854775807L)/2;
            for (int j = 0 ; n < test*2 ; j++ , n*=2 ){
                if ((n%k)==0){
                    System.out.println(j);
                    break;
                } else if (n>test) {
                    System.out.println(-1);
                    break;
                }
            }
        }
    }
}
