import java.util.*;

public class pastartib {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] inOrder = new int[n];
        int[] preOrder = new int[n];

        for (int i = 0; i < n; i++) {
            inOrder[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            preOrder[i] = sc.nextInt();
        }

        // Create a map to quickly find the index of any element in inOrder array
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inOrderMap.put(inOrder[i], i);
        }

        // Helper function to find post-order traversal
        List<Integer> postOrder = new ArrayList<>();

        // Call the recursive function to fill the postOrder list
        constructPostOrder(preOrder, 0, n - 1, 0, n - 1, inOrderMap, postOrder);

        // Output the post-order traversal
        for (int i : postOrder) {
            System.out.print(i + " ");
        }
    }

    // Recursive function to construct post-order from pre-order and in-order
    private static void constructPostOrder(int[] preOrder, int preStart, int preEnd,
                                           int inStart, int inEnd,
                                           Map<Integer, Integer> inOrderMap,
                                           List<Integer> postOrder) {
        if (preStart > preEnd || inStart > inEnd) {
            return;
        }

        // The root is the first element in the pre-order segment
        int root = preOrder[preStart];
        int rootIndexInOrder = inOrderMap.get(root);

        // Number of elements in the left subtree
        int leftSize = rootIndexInOrder - inStart;

        // Recursively construct the left subtree
        constructPostOrder(preOrder, preStart + 1, preStart + leftSize,
                inStart, rootIndexInOrder - 1,
                inOrderMap, postOrder);

        // Recursively construct the right subtree
        constructPostOrder(preOrder, preStart + leftSize + 1, preEnd,
                rootIndexInOrder + 1, inEnd,
                inOrderMap, postOrder);

        // Add the root to the post-order list
        postOrder.add(root);
    }
}
