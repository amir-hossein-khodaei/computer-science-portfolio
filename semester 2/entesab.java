import java.util.Scanner;

public class entesab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            boolean check = true;
            for (int i = 0; i < n; i++)
            {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++)
            {
                b[i] = scanner.nextInt();
                boolean find = false;
                for (int j = 0; j < n; j++)
                {
                    if (b[i] == a[j])
                    {
                        a[j] = -1;
                        find = true;
                        break;
                    }
                }
                if (!find)
                {
                    check = false;
                    break;
                }
            }
            if (check)
            {
                System.out.println("YES");
            } else
            {
                System.out.println("NO");
            }
        }
        scanner.close();
    }
}
