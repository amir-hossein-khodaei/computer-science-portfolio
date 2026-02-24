import java.util.Scanner;

public class MathMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.print("عدد طبیعی وارد کنید: ");
            int n = scanner.nextInt();

            System.out.println("منو:");
            System.out.println("1. بررسی کامل بودن یک عدد");
            System.out.println("2. محاسبه مجموع اعداد زوج از ۱ تا عدد وارد شده");
            System.out.println("3. محاسبه توان عدد اول وارد شده با عدد دوم");
            System.out.println("4. بررسی طول یک رشته و چاپ پیام مناسب");
            System.out.println("5. خروج از برنامه");
            System.out.print("لطفا یک گزینه انتخاب کنید: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (isPerfect(n)) {
                        System.out.println("عدد کامل است");
                    } else {
                        System.out.println("عدد کامل نیست");
                    }
                    break;
                case 2:
                    System.out.println("مجموع اعداد زوج: " + sumEvenNumbers(n));
                    break;
                case 3:
                    System.out.print("عدد دوم را وارد کنید: ");
                    int m = scanner.nextInt();
                    System.out.println("نتیجه: " + power(n, m));
                    break;
                case 4:
                    System.out.print("رشته‌ای وارد کنید: ");
                    String input = new Scanner(System.in).nextLine();
                    checkStringLength(input);
                    break;
                case 5:
                    System.out.println("برنامه خاتمه یافت");
                    break;
                default:
                    System.out.println("انتخاب نامعتبر! لطفا دوباره تلاش کنید.");
                    break;
            }
        }
        scanner.close();
    }

    public static boolean isPerfect(int n) {
        int sum = 1;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n && n != 1;
    }

    public static int sumEvenNumbers(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i += 2) {
            sum += i;
        }
        return sum;
    }

    public static long power(int base, int exponent) {
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static void checkStringLength(String str) {
        if (str.length() > 20) {
            System.out.println("رشته بسیار طولانی است!");
        } else {
            System.out.println("طول رشته مناسب است");
        }
    }
}
