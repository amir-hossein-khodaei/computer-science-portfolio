import java.util.Scanner;
import java.util.Arrays;

public class sdfgv {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        Task[] tasks = new Task[n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                n = i;
                break;
            }
            String[] parts = line.split(" ");
            int ai = Integer.parseInt(parts[0]);
            int bi = Integer.parseInt(parts[1]);
            tasks[i] = new Task(ai, bi);
        }

        scanner.close();

        Arrays.sort(tasks, (a, b) -> {
            int diffA = a.ai - a.bi;
            int diffB = b.ai - b.bi;
            return Integer.compare(diffB, diffA);
        });

        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += tasks[i].ai;
        }
        for (int i = m; i < n; i++) {
            sum += tasks[i].bi;
        }

        System.out.println(sum);
    }

    static class Task {
        int ai, bi;

        Task(int ai, int bi) {
            this.ai = ai;
            this.bi = bi;
        }
    }
}
