import java.util.*;

public class dodoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tedadGhesmat = scanner.nextInt();
        scanner.nextLine();

        for (int shomareGhesmat = 0; shomareGhesmat < tedadGhesmat; shomareGhesmat++) {
            List<Integer> avvalSafhe = parseInput(scanner.nextLine(), "pre: ");
            List<Integer> akharSafhe = parseInput(scanner.nextLine(), "post: ");
            Map<Integer, NakhlNode> nakhl = buildTree(avvalSafhe, akharSafhe);
            int maxMajmoe = calculateMaxSum(nakhl, avvalSafhe.get(0));
            System.out.println(maxMajmoe);
        }
    }

    public static Map<Integer, NakhlNode> buildTree(List<Integer> avvalSafhe, List<Integer> akharSafhe) {
        Map<Integer, NakhlNode> nakhl = new HashMap<>();
        constructTree(avvalSafhe, akharSafhe, nakhl, -1);
        return nakhl;
    }

    private static List<Integer> parseInput(String input, String prefix) {
        return Arrays.stream(input.replace(prefix, "").split(", "))
                .map(Integer::parseInt)
                .toList();
    }

    private static int constructTree(List<Integer> avvalSafhe, List<Integer> akharSafhe, Map<Integer, NakhlNode> nakhl, int vali) {
        if (avvalSafhe.isEmpty()) {
            return -1;
        }

        int rishe = avvalSafhe.get(0);
        nakhl.put(rishe, new NakhlNode(-1, -1, vali));

        if (avvalSafhe.size() == 1) {
            return rishe;
        }

        int tarafBooz = akharSafhe.indexOf(avvalSafhe.get(1)) + 1;
        nakhl.get(rishe).chap = constructTree(avvalSafhe.subList(1, 1 + tarafBooz), akharSafhe.subList(0, tarafBooz), nakhl, rishe);
        nakhl.get(rishe).rast = constructTree(avvalSafhe.subList(1 + tarafBooz, avvalSafhe.size()), akharSafhe.subList(tarafBooz, akharSafhe.size() - 1), nakhl, rishe);

        return rishe;
    }

    public static int calculateMaxSum(Map<Integer, NakhlNode> nakhl, int root) {
        List<Integer> leafNodes = getLeafNodes(nakhl, root);
        return findMaxSumBetweenLeaves(nakhl, leafNodes);
    }

    private static List<Integer> getLeafNodes(Map<Integer, NakhlNode> nakhl, int node) {
        List<Integer> leafNodes = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            NakhlNode currentNode = nakhl.get(current);

            if (currentNode.chap == -1 && currentNode.rast == -1) {
                leafNodes.add(current);
            } else {
                if (currentNode.rast != -1) stack.push(currentNode.rast);
                if (currentNode.chap != -1) stack.push(currentNode.chap);
            }
        }
        return leafNodes;
    }

    private static int findMaxSumBetweenLeaves(Map<Integer, NakhlNode> nakhl, List<Integer> leafNodes) {
        int maxMajmoe = Integer.MIN_VALUE;
        int size = leafNodes.size();

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                maxMajmoe = Math.max(maxMajmoe, sumBetweenLeaves(nakhl, leafNodes.get(i), leafNodes.get(j)));
            }
        }
        return maxMajmoe;
    }

    private static int sumBetweenLeaves(Map<Integer, NakhlNode> nakhl, int leaf1, int leaf2) {
        Set<Integer> ancestors = new HashSet<>();
        int lca = -1;

        int temp = leaf1;
        while (temp != -1) {
            ancestors.add(temp);
            temp = nakhl.get(temp).vali;
        }

        temp = leaf2;
        while (temp != -1) {
            if (ancestors.contains(temp)) {
                lca = temp;
                break;
            }
            temp = nakhl.get(temp).vali;
        }

        int sum = 0;
        temp = leaf1;
        while (temp != lca) {
            sum += temp;
            temp = nakhl.get(temp).vali;
        }

        temp = leaf2;
        while (temp != lca) {
            sum += temp;
            temp = nakhl.get(temp).vali;
        }

        sum += lca;
        return sum;
    }
}

class NakhlNode {
    int chap;
    int rast;
    int vali;

    NakhlNode(int chap, int rast, int vali) {
        this.chap = chap;
        this.rast = rast;
        this.vali = vali;
    }
}
