import java.util.Scanner;
import java.util.Stack;

public class tarickche {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in) ;
        int q = scanner.nextInt();
        scanner.nextLine();
        String history = "";
        Stack<String> operations = new Stack<>();
        Stack<String> undo = new Stack<>();
        String operation;
        String[] parts;
        String command;
        for (int j = 0; j < q; j++) {
            operation= scanner.nextLine();
            parts= operation.split(" ");
            command= parts[0];

            switch (command) {
                case "insert": {
                    int i = Integer.parseInt(parts[1]) - 1;
                    char x = parts[2].charAt(0);
                    history = history.substring(0, i) + x + history.substring(i);
                    operations.push("delete " + (i + 1));
                    break;
                }
                case "undo": {
                    if (!operations.isEmpty()) {
                        String undoOperation = operations.pop();
                        undo.push(undoOperation);
                        String[] undoParts = undoOperation.split(" ");
                        if (undoOperation.startsWith("insert")) {
                            int i = Integer.parseInt(undoParts[1]) - 1;
                            char x = undoParts[2].charAt(0);
                            history = history.substring(0, i) + x + history.substring(i);
                        } else if (undoOperation.startsWith("delete")) {
                            int i = Integer.parseInt(undoParts[1]) - 1;
                            history = history.substring(0, i) + history.substring(i + 1);
                        }
                    }
                    break;
                }
                case "delete": {
                    int i = Integer.parseInt(parts[1]) - 1;
                    char deletedChar = history.charAt(i);
                    history = history.substring(0, i) + history.substring(i + 1);
                    operations.push("insert " + (i + 1) + " " + deletedChar);
                    break;
                }
                default:
                    break;
            }
        }
        System.out.println(history);
    }
}
