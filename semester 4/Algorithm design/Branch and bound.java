import java.util.*;

public class JAP {
    static int size;
    static int[][] costs;
    static int best = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        costs = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                costs[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        solve();

        System.out.println(best);
    }

    static void solve() {
        Map<Integer, String> states = new HashMap<>();
        List<Integer> paths = new ArrayList<>();
        int idCounter = 0;

        String initial = "0,0," + "0".repeat(size);
        states.put(idCounter, initial);
        paths.add(idCounter++);

        while (!paths.isEmpty()) {
            int bestId = -1;
            int lowestBound = Integer.MAX_VALUE;

            for (int id : paths) {
                String current = states.get(id);
                int bound = calculateBound(current);

                if (bound < lowestBound) {
                    lowestBound = bound;
                    bestId = id;
                }
            }

            if (lowestBound >= best) break;

            paths.remove(Integer.valueOf(bestId));
            String data = states.get(bestId);
            String[] parts = data.split(",");
            int level = Integer.parseInt(parts[0]);
            int totalCost = Integer.parseInt(parts[1]);
            String mask = parts[2];

            if (level == size) {
                if (totalCost < best) {
                    best = totalCost;
                }
                continue;
            }

            for (int task = 0; task < size; task++) {
                if (mask.charAt(task) == '0') {
                    int addedCost = costs[level][task];
                    int newTotal = totalCost + addedCost;

                    if (newTotal >= best) continue;

                    char[] newMask = mask.toCharArray();
                    newMask[task] = '1';
                    String newState = (level + 1) + "," + newTotal + "," + new String(newMask);

                    if (calculateBound(newState) < best) {
                        states.put(idCounter, newState);
                        paths.add(idCounter++);
                    }
                }
            }
        }
    }

    static int calculateBound(String state) {
        String[] info = state.split(",");
        int currentCost = Integer.parseInt(info[1]);
        int row = Integer.parseInt(info[0]);
        String assign = info[2];
        int future = calculateMinFuture(row, assign);
        return currentCost + future;
    }

    static int calculateMinFuture(int startRow, String assign) {
        if (startRow >= size) return 0;

        int min = Integer.MAX_VALUE;
        for (int col = 0; col < size; col++) {
            if (assign.charAt(col) == '0') {
                if (costs[startRow][col] < min) {
                    min = costs[startRow][col];
                }
            }
        }

        if (min == Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return min + calculateMinFuture(startRow + 1, assign);
    }
}