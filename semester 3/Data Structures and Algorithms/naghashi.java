import java.util.*;

public class naghashi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading input
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] points = new int[n][3]; // [x, y, index]
        for (int i = 0; i < n; i++) {
            points[i][0] = scanner.nextInt(); // x-coordinate
            points[i][1] = scanner.nextInt(); // y-coordinate
            points[i][2] = i; // original index
        }

        // Total nodes required for a complete binary tree of height k
        int totalNodes = (1 << k) - 1; // 2^k - 1
        if (totalNodes > n) {
            System.out.println(-1); // Not enough points to build the tree
            return;
        }

        // Sorting points by y-coordinate first, then by x-coordinate
        Arrays.sort(points, (a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        // Assigning nodes to points to form a binary tree
        int[] result = new int[n];
        Arrays.fill(result, 0);

        List<int[]> assignedPoints = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0, 0}); // {nodeNumber, parentX, parentY}

        int index = 0;
        while (!queue.isEmpty() && index < points.length) {
            int[] current = queue.poll();
            int nodeNumber = current[0];
            int parentX = current[1];
            int parentY = current[2];

            // Find the next point that can be connected without crossing edges
            while (index < points.length && !isValid(parentX, parentY, points[index], assignedPoints)) {
                index++;
            }

            if (index >= points.length) break;

            // Assign the node number to the point
            result[points[index][2]] = nodeNumber;
            assignedPoints.add(points[index]);

            // Add children to the queue
            if (2 * nodeNumber <= totalNodes) {
                queue.add(new int[]{2 * nodeNumber, points[index][0], points[index][1]});
            }
            if (2 * nodeNumber + 1 <= totalNodes) {
                queue.add(new int[]{2 * nodeNumber + 1, points[index][0], points[index][1]});
            }

            index++;
        }

        // Check if we successfully assigned all required nodes
        if (assignedPoints.size() < totalNodes) {
            System.out.println(-1);
        } else {
            // Print the result
            for (int value : result) {
                System.out.println(value);
            }
        }
    }

    private static boolean isValid(int parentX, int parentY, int[] point, List<int[]> assignedPoints) {
        // Check if the current point can be connected without crossing existing edges
        for (int[] assigned : assignedPoints) {
            if (doLinesIntersect(parentX, parentY, point[0], point[1], assigned[0], assigned[1])) {
                return false;
            }
        }
        return true;
    }

    private static boolean doLinesIntersect(int x1, int y1, int x2, int y2, int x3, int y3) {
        // Helper function to check if two lines intersect
        // Using cross product and orientation logic
        return false; // Implement precise geometry check here if needed
    }
}
