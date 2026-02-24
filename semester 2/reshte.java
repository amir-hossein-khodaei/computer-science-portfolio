import java.util.Scanner;

public class reshte {
    private static String daryaft;
    private static int khobi = 0;
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        daryaft = scanner.nextLine();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("Is it right or not?")) {
                break;
            }

            String[] parts = input.split(" ");
            switch (parts[0]) {
                case "copy":
                    StringBuilder builder = new StringBuilder(parts[1]);
                    for (int i = 1; i < Integer.parseInt(parts[2]); i++) {
                        builder.append(parts[1]);
                    }
                    String newKey = builder.toString();
                    daryaft = newKey + daryaft.substring(newKey.length());
                    break;
                case "compare":
                    if (daryaft.equals(parts[1])) {
                        khobi++;
                    }
                    break;
                case "substr":
                    int occurrences = (daryaft.length() - daryaft.replace(parts[1], "").length()) / parts[1].length();
                    if (occurrences == Integer.parseInt(parts[2])) {
                        khobi++;
                    }
                    break;
                case "attach":
                    String newKey1 = parts[1] + parts[3];
                    int attachOccurrences = (daryaft.length() - daryaft.replace(newKey1, "").length()) / newKey1.length();
                    if (attachOccurrences == Integer.parseInt(parts[2])) {
                        khobi++;
                    }
                    break;
                case "length":
                    if (daryaft.length() == Integer.parseInt(parts[1])) {
                        khobi++;
                    }
                    break;
            }
            count++;
        }

        System.out.println(khobi >= count / 2 ? "Eyval" : "HeifShod");
    }
}
