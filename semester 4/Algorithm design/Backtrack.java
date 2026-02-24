import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class aghab {

    public boolean checkPartition(int[] inputValues, int desiredPartitions) {
        if (inputValues == null || inputValues.length == 0 || desiredPartitions <= 0) {
            return false;
        }

        long totalVal = 0;
        Map<Integer, Integer> valueCounts = new HashMap<>();
        for (int val : inputValues) {
            totalVal += val;
            valueCounts.put(val, valueCounts.getOrDefault(val, 0) + 1);
        }

        if (totalVal % desiredPartitions != 0) {
            return false;
        }

        long targetValuePerPart = totalVal / desiredPartitions;

        for (int val : inputValues) {
            if (val > targetValuePerPart) {
                return false;
            }
        }

        return formPartitions(valueCounts, targetValuePerPart, desiredPartitions);
    }

    private boolean formPartitions(Map<Integer, Integer> currentCounts,
                                   long targetSum, int remainingPartitions) {

        if (remainingPartitions == 0) {
            return true;
        }

        int currentStartingNumber = -1;
        for (Map.Entry<Integer, Integer> entry : currentCounts.entrySet()) {
            if (entry.getValue() > 0) {
                if (currentStartingNumber == -1 || entry.getKey() > currentStartingNumber) {
                    currentStartingNumber = entry.getKey();
                }
            }
        }

        if (currentStartingNumber == -1) {
            return false;
        }

        currentCounts.put(currentStartingNumber, currentCounts.get(currentStartingNumber) - 1);

        boolean result = fillCurrentPartition(currentCounts, targetSum - currentStartingNumber,
                currentStartingNumber, targetSum, remainingPartitions);

        currentCounts.put(currentStartingNumber, currentCounts.get(currentStartingNumber) + 1);

        return result;
    }

    private boolean fillCurrentPartition(Map<Integer, Integer> currentCounts,
                                         long remainingSumNeeded,
                                         int maxNumConsideredForThisPart,
                                         long originalTargetSum,
                                         int totalPartitionsToForm) {

        if (remainingSumNeeded == 0) {
            return formPartitions(currentCounts, originalTargetSum, totalPartitionsToForm - 1);
        }

        if (remainingSumNeeded < 0) {
            return false;
        }

        for (Map.Entry<Integer, Integer> entry : currentCounts.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (count > 0 && num <= remainingSumNeeded && num <= maxNumConsideredForThisPart) {

                currentCounts.put(num, count - 1);

                if (fillCurrentPartition(currentCounts, remainingSumNeeded - num,
                        num, originalTargetSum, totalPartitionsToForm)) {
                    return true;
                }

                currentCounts.put(num, count + 1);
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);

        Map<Integer, Integer> inputNumCounts = new HashMap<>();

        st.parseNumbers();
        st.whitespaceChars(' ', ' ');
        st.eolIsSignificant(true);

        while (st.nextToken() != StreamTokenizer.TT_EOF && st.ttype != StreamTokenizer.TT_EOL) {
            if (st.ttype == StreamTokenizer.TT_NUMBER) {
                int num = (int) st.nval;
                inputNumCounts.put(num, inputNumCounts.getOrDefault(num, 0) + 1);
            }
        }

        int[] originalInputArray = new int[inputNumCounts.values().stream().mapToInt(Integer::intValue).sum()];
        int currentIdx = 0;
        for(Map.Entry<Integer, Integer> entry : inputNumCounts.entrySet()){
            for(int i = 0; i < entry.getValue(); i++){
                originalInputArray[currentIdx++] = entry.getKey();
            }
        }

        st.nextToken();
        int kValue = 0;
        if (st.ttype == StreamTokenizer.TT_NUMBER) {
            kValue = (int) st.nval;
        } else {
            while (st.nextToken() != StreamTokenizer.TT_EOF && st.ttype != StreamTokenizer.TT_NUMBER) {
            }
            if (st.ttype == StreamTokenizer.TT_NUMBER) {
                kValue = (int) st.nval;
            }
        }

        aghab solver = new aghab();
        if (solver.checkPartition(originalInputArray, kValue)) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }

    }
}