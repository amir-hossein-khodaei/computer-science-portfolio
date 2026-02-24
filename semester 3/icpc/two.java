//import java.util.Arrays;
//import java.util.Scanner;
//
//public class ZahraTasks {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//
//        Task[] tasks = new Task[n];
//
//        for (int i = 0; i < n; i++) {
//            int ai = scanner.nextInt();
//            int bi = scanner.nextInt();
//            tasks[i] = new Task(ai, bi);
//        }
//
//        Arrays.sort(tasks, (t1, t2) -> (t2.ai - t2.bi) - (t1.ai - t1.bi));
//
//        int totalHappiness = 0;
//
//        for (int i = 0; i < n; i++) {
//            if (i < m) {
//                totalHappiness += tasks[i].ai;
//            } else {
//                totalHappiness += tasks[i].bi;
//            }
//        }
//
//        System.out.println(totalHappiness);
//
//        scanner.close();
//    }
//
//    static class Task {
//        int ai, bi;
//
//        Task(int ai, int bi) {
//            this.ai = ai;
//            this.bi = bi;
//        }
//    }
//}
