import java.util.Scanner;

public class betaip {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String betaip = myObj.nextLine();

        for (int i=0 ; i<betaip.length();i++){
            if (betaip.charAt(0)=='='){
                continue;
            }
            if (betaip.isEmpty()){
                break;
            }
            else if (betaip.charAt(i)== '=' ){
                betaip = betaip.substring(0,(i-1))+betaip.substring((i+1));
                i=0;
            }
        }
        System.out.println(betaip);
    }
}