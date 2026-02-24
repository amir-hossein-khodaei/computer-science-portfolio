import java.util.Scanner;

public class Karkon2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int[] shercat = resiver(scanner.nextLine());

        int max = 0;
        int test = 0;
        for (int i = 0; i < row; i++) {
            test += shercat[i];
            if (test > max) {
                max = test;
            }
            if (test < 0) {
                test = 0;
            }
        }

        System.out.println(max);
    }

    static int[] resiver(String input) {
        String[] numberStrings = input.split(" ");
        int[] numbers = new int[numberStrings.length];
        for (int i = 0; i < numberStrings.length; i++) {
            numbers[i] = Integer.parseInt(numberStrings[i]);
        }
        return numbers;
    }
}
