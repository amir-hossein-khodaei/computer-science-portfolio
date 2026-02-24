import java.util.Scanner;
import java.util.ArrayList;

public class AdadJadoi {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String line = input.nextLine();
        int groupCount = Integer.parseInt(line.trim());

        ArrayList<Integer>[] groups = new ArrayList[groupCount];

        int i = 0;
        while (i < groupCount) {
            String currentLine = input.nextLine();
            String trimmedLine = currentLine.trim();
            groups[i] = readAndSort(trimmedLine);
            i++;
        }

        String rangeLine = input.nextLine();
        String trimmedRangeLine = rangeLine.trim();
        String[] rangeParts = trimmedRangeLine.split("\\s+");
        String lowerStr = rangeParts[0];
        String upperStr = rangeParts[1];
        int lowerLimit = Integer.parseInt(lowerStr);
        int upperLimit = Integer.parseInt(upperStr);

        input.close();

        ArrayList<Integer> list;
        if (groupCount == 0) {
            list = new ArrayList<>();
        } else {
            list = mergeGroups(groups, 0, groupCount - 1);
        }

        display(list);

        int result = calculateSum(list, lowerLimit, upperLimit);

        System.out.println(result);
    }

    static ArrayList<Integer> readAndSort(String inputLine) {
        ArrayList<Integer> list = new ArrayList<>();

        if (!inputLine.isEmpty()) {
            String[] numbers = inputLine.split("\\s+");
            for (String number : numbers) {
                int num = Integer.parseInt(number);
                list.add(num);
            }
        }

        sort(list);

        return list;
    }

    static void sort(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int temp = list.get(i);
            int j = i - 1;

            while (j >= 0) {
                int prev = list.get(j);
                if (prev > temp) {
                    list.set(j + 1, prev);
                    j--;
                } else {
                    break;
                }
            }
            list.set(j + 1, temp);
        }
    }

    static ArrayList<Integer> mergeGroups(ArrayList<Integer>[] groups, int start, int end) {
        if (start == end) {
            return groups[start];
        }

        int mid = (start + end) / 2;

        ArrayList<Integer> first = mergeGroups(groups, start, mid);
        ArrayList<Integer> second = mergeGroups(groups, mid + 1, end);

        return mergeLists(first, second);
    }

    static ArrayList<Integer> mergeLists(ArrayList<Integer> listA, ArrayList<Integer> listB) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < listA.size() && j < listB.size()) {
            int a = listA.get(i);
            int b = listB.get(j);

            if (a < b) {
                addUnique(result, a);
                i++;
            } else if (b < a) {
                addUnique(result, b);
                j++;
            } else {
                addUnique(result, a);
                i++;
                j++;
            }
        }

        while (i < listA.size()) {
            addUnique(result, listA.get(i));
            i++;
        }

        while (j < listB.size()) {
            addUnique(result, listB.get(j));
            j++;
        }

        return result;
    }

    static void addUnique(ArrayList<Integer> list, int number) {
        if (list.isEmpty() || list.get(list.size() - 1) != number) {
            list.add(number);
        }
    }

    static void display(ArrayList<Integer> list) {
        for (int k = 0; k < list.size(); k++) {
            System.out.print(list.get(k));
            if (k < list.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    static int calculateSum(ArrayList<Integer> list, int lower, int upper) {
        int sum = 0;
        for (int number : list) {
            if (number > lower && number < upper) {
                sum += number;
            }
        }
        return sum;
    }
}
