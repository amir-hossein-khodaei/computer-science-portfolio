import java.util.Scanner;

public class karkon {
    public static void main(String[] args)
    {
        Scanner myObj = new Scanner(System.in);
        int row = Integer.parseInt((myObj.nextLine()));
        int[] shercat = resiver();
        int max = 0 ;
        int test = 0 ;
        for (int i = 0 ; i < row ; i++)
        {
            test=shercat[i];
            for (int j = i+1 ; j < row ; j++ )
            {
                test = test+shercat[j];
                if (test>max)
                {
                    max=test;
                }
            }
        }
        if (max<=0)
        {
            System.out.println(0);
        }
        else
        {
            System.out.println(max);
        }
    }
    static int[] resiver() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] numberStrings = line.split(" ");
        int[] numbers = new int[numberStrings.length];
            for (int i = 0; i < numberStrings.length; i++) {
                numbers[i] = Integer.parseInt(numberStrings[i]);
            }
        return (numbers);
    }
}
