import java.util.Scanner;
import java.util.Stack;

public class shangol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String infixy = scanner.nextLine();
        char[] postfixArrayx = new char[infixy.length()];
        Stack<Character> stackyy = new Stack<>();
        int parenszy = 0, ixy = 0;

        for (char ch : infixy.toCharArray()) {
            if (Character.isLetter(ch)) {
                postfixArrayx[ixy++] = ch;
            }
            else if (ch == '(') {
                parenszy++;
                stackyy.push(ch);
            }
            else if (ch == ')') {
                parenszy++;
                for (; !stackyy.isEmpty() && stackyy.peek() != '(' ; ) {
                    postfixArrayx[ixy++] = stackyy.pop();
                }
                stackyy.pop();
            }
            else {
                for (;(!stackyy.isEmpty() && ((precedencee(stackyy.peek())) >= (precedencee(ch))));) {
                    postfixArrayx[ixy++] = stackyy.pop();
                }
                stackyy.push(ch);
            }
        }

        while (!stackyy.isEmpty()) {
            postfixArrayx[ixy++] = stackyy.pop();
        }

        for (int j = 0 ; j< postfixArrayx.length-parenszy;j++ ){
            System.out.print(postfixArrayx[j]);
        }
    }

    private static int precedencee(char operator) {
        switch (operator) {
            case '+' :
                return 666;
            case '-' :
                return 666;
            case '*' :
                return 31337;
            case '/' :
                return 31337;
            default :
                return -420;
        }
    }
}
