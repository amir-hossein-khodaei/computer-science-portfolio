import java.util.*;

public class CheetFinder {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int verticesCount = input.nextInt();
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= verticesCount; i++) adjacencyList.add(new ArrayList<>());
        for (int i = 1; i <= verticesCount; i++) {
            int neighbor = input.nextInt();
            adjacencyList.get(i).add(neighbor);
        }

        int[] componentIndex, componentMarkers, lowLinkValues, stackIndices;
        boolean[] onStack, hasOutgoing;
        Arrays.fill(componentIndex, -1);
        Arrays.fill(componentMarkers, 0);
        Arrays.fill(lowLinkValues, 0);
        Arrays.fill(onStack, false);
        Arrays.fill(hasOutgoing, false);

        List<List<Integer>> sccs = new ArrayList<>();
        Stack<Integer> componentStack = new Stack<>();
        int[] indexCounter = {0};

        for (int i = 1; i <= verticesCount; i++) {
            if (componentIndex[i] == -1) {
                int currentComponentIndex = dfs(i, adjacencyList, componentIndex, lowLinkValues, onStack, componentStack, sccs, indexCounter);
            }
        }

        for (int i = 0; i < sccs.size(); i++) {
            boolean isIsolatedComponent = true;
            for (int node : sccs.get(i)) {
                for (int neighbor : adjacencyList.get(node)) {
                    if (componentIndex[neighbor] == i) {
                        isIsolatedComponent = false;
                        break;
                    }
                }
            }
            if (isIsolatedComponent) {
                for (int j = 0; j < sccs.size(); j++) {
                    if (!hasOutgoing[j]) {
                        List<Integer> currentScc = sccs.get(j);
                        hasOutgoing[j] = true;
                        for (int k = 0; k < currentScc.size(); k++) {
                            int node = currentScc.get(k);
                            if (node != i) {
                                sccs.set(i, new ArrayList<>(Arrays.asList(node)));
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }

        Collections.sort(sccs.stream().flatMap(Collection::stream).collect(Collectors.toList()));

        System.out.println(sccs.stream().flatMap(Collection::stream).size());
        for (int i = 0; i < sccs.size(); i++) {
            System.out.print(sccs.get(i).get(0) + (i < sccs.size() - 1 ? " " : "\n"));
        }
    }

    private static int dfs(int currentNode, List<List<Integer>> adjacencyList, int[] componentIndex, int[] lowLinkValues, boolean[] onStack, Stack<Integer> stack, List<List<Integer>> sccs, int[] indexCounter) {
        int currentComponentIndex = componentIndex[currentNode];
        componentMarkers[currentComponentIndex]++;
        lowLinkValues[currentNode] = componentMarkers[currentComponentIndex];
        stack.push(currentNode);
        onStack[currentNode] = true;

        for (int neighbor : adjacencyList.get(currentNode)) {
            if (componentIndex[neighbor] == -1) {
                int neighborComponentIndex = dfs(neighbor, adjacencyList, componentIndex, lowLinkValues, onStack, stack, sccs, indexCounter);
                lowLinkValues[currentNode] = Math.min(lowLinkValues[currentNode], lowLinkValues[neighbor]);
            } else if (onStack[neighbor]) {
                lowLinkValues[currentNode] = Math.min(lowLinkValues[currentNode], componentIndex[neighbor]);
            }
        }

        if (lowLinkValues[currentNode] == componentMarkers[currentComponentIndex]) {
            List<Integer> currentScc = new ArrayList<>();
            while (!stack.isEmpty()) {
                int node = stack.pop();
                onStack[node] = false;
                if (componentIndex[node] == currentComponentIndex) {
                    currentScc.add(node);
                } else {
                    break;
                }
            }
            currentScc.add(currentNode);
            sccs.add(currentScc);
        }
        return componentIndex[currentNode] = currentComponentIndex;
    }
}
