import java.util.Scanner;

public class temporary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        scanner.close();

        String[] words = text.split(" ");
        String vowels = "aeiouyAEIOUY";

        for (String word : words) {
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                if (!vowels.contains("" + word.charAt(i))) {
                    count++;
                    if (count == 5) {
                        System.out.print(word + " ");
                        break;
                    }
                } else {
                    count = 0;
                }
            }
        }
    }
}
