import java.util.*;

public class Jam {
    public static void main(String[] args) {
        List<Integer> endDays = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        scanner.nextLine();
        List<String> names = new ArrayList<>();
        Iterator<Integer> days;
        Iterator<String> nameeeee;
        int k , durations , end ,minimum;
        String name_temp;

        for (int day = 1; day <= q; day++) {
            List<String> expiredSubscriptions = new ArrayList<>();
            k = scanner.nextInt();

            for (int i = 0; i < k; i++) {
                name_temp = scanner.next();
                durations = scanner.nextInt();
                names.add(name_temp);
                endDays.add(day + durations - 1);
            }

            scanner.nextLine();
            days = endDays.iterator();
            nameeeee = names.iterator();

            while (nameeeee.hasNext() && days.hasNext()) {
                name_temp = nameeeee.next();
                end = days.next();
                if (end == day) {
                    expiredSubscriptions.add(name_temp);
                    nameeeee.remove();
                    days.remove();
                }
            }

            if (!names.isEmpty()) {
                minimum = 0;
                for (int i = 1; i < names.size(); i++) {
                    if (names.get(i).compareTo(names.get(minimum)) < 0) {
                        minimum = i;
                    }
                }
                expiredSubscriptions.add(names.get(minimum));
                endDays.remove(minimum);
                names.remove(minimum);
            }

            bubbleSort(expiredSubscriptions);

            if (!expiredSubscriptions.isEmpty()) {
                for (String s : expiredSubscriptions) {
                    System.out.print(s + " ");
                }
                System.out.println();
            } else {
                System.out.println();
            }
        }
    }
    private static void bubbleSort(List<String> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    String temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}