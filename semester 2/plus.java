import java.util.*;

public class plus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] makan = new Integer[n];

        for (int i = 0; i < n; i++) {
            makan[i] = scanner.nextInt();
        }

        Set<Integer> uniqueMakan = new HashSet<>(Arrays.asList(makan));
        makan = uniqueMakan.toArray(new Integer[0]);
        Arrays.sort(makan);

        List<Pair> pair = new ArrayList<>();
        for (int i = 0; i < makan.length; i++) {
            for (int j = i + 1; j < makan.length; j++) {
                int difference = Math.abs(makan[i] - makan[j]);
                pair.add(new Pair(makan[i], makan[j], difference));
            }
        }

        pair.sort((p1, p2) -> {
            if (p1.difference != p2.difference) {
                return p1.difference - p2.difference;
            } else {
                return p1.x - p2.x;
            }
        });

        for (Pair p : pair) {
            System.out.println("[" + p.x + ", " + p.y + "]");
        }
    }

    static class Pair {
        int x, y, difference;

        public Pair(int x, int y, int difference) {
            this.x = x;
            this.y = y;
            this.difference = difference;
        }
    }
}
