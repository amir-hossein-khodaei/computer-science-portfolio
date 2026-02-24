import java.util.Scanner;
public class adsfaadsfg {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // گرفتن ورودی‌ها از کاربر
            System.out.print("عدد n را وارد کنید: ");
            int n = scanner.nextInt();
            System.out.print("عدد m را وارد کنید: ");
            int m = scanner.nextInt();

            // محاسبه‌ی حاصل عبارت
            int result = 0;
            for (int i = -10; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    result += Math.pow(i + j, 3) / Math.pow(j, 2);
                }
            }

            // چاپ نتیجه
            System.out.println(result);
        }
    }
