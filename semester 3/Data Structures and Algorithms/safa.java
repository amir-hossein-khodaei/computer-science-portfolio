import java.io.*;
import java.util.*;

public class safa {
    private PriorityQueue<Integer> low;  // Max heap for the lower half
    private PriorityQueue<Integer> high; // Min heap for the upper half

    public safa() {
        low = new PriorityQueue<>(Collections.reverseOrder());
        high = new PriorityQueue<>();
    }

    public void insert(int x) {
        if (low.isEmpty() || x <= low.peek()) {
            low.offer(x);
        } else {
            high.offer(x);
        }
        balanceHeaps();
    }

    public int remove() {
        if (low.isEmpty()) throw new NoSuchElementException("Queue is empty");
        return low.poll();
    }

    public void build(List<Integer> elements) {
        for (int elem : elements) {
            if (low.isEmpty() || elem <= low.peek()) {
                low.offer(elem);
            } else {
                high.offer(elem);
            }
        }
        balanceHeaps();
    }

    private void balanceHeaps() {
        // Ensure low has at most one more element than high
        while (low.size() > high.size() + 1) {
            high.offer(low.poll());
        }
        while (high.size() > low.size()) {
            low.offer(high.poll());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(reader.readLine().trim());
        safa mpq = new safa();

        while (k-- > 0) {
            String line = reader.readLine().trim();
            if (line.startsWith("build")) {
                // Parse elements directly
                String[] parts = line.substring(6, line.length() - 1).split(",");
                List<Integer> elements = new ArrayList<>(parts.length);
                for (String part : parts) {
                    elements.add(Integer.parseInt(part.trim()));
                }
                mpq.build(elements);
            } else if (line.startsWith("insert")) {
                int x = Integer.parseInt(line.substring(7, line.length() - 1));
                mpq.insert(x);
            } else if (line.equals("remove")) {
                writer.write(mpq.remove() + "\n");
            }
        }
        writer.flush(); // Batch output
    }
}
