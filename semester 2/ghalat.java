import java.util.Scanner;

public class ghalat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        String[] words = inputText.split("[\\s+.,_!?]");

        for (String i : words)
        {
            if (i.length() > 4 && !i.equals(i.toUpperCase()))
            {
                boolean checker = false ;

                for (int j = 0; j <= i.length() - 5; j++)
                {
                    checker = false;
                    for (int k = j; k < j + 5; k++)
                    {
                        char c = i.charAt(k);
                        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y' ||
                                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'Y')
                            {
                                checker = true;
                                break;
                            }
                    }
                    if (!checker) {
                        System.out.print(i + " ");
                        break;
                    }
                }
            }
        }
    }
}
