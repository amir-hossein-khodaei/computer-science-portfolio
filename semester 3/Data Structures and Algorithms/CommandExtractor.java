import java.io.*;
import java.util.*;
import java.util.regex.*;

public class CommandExtractor {
    public static List<String> extractCommands(String text) {
        List<String> commands = new ArrayList<>();
        Pattern pattern = Pattern.compile("Game\\.AddToInventory\\(\".*?\"\\)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            commands.add(matcher.group());
        }
        return commands;
    }

    public static String formatCommands(List<String> commands) {
        return String.join(";\n", commands) + ";";
    }

    public static void main(String[] args) {
        try {
            // Replace 'input.txt' with your input file path or input method
            String filePath = "input.txt";
            StringBuilder text = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
            reader.close();

            List<String> commands = extractCommands(text.toString());
            String formattedCommands = formatCommands(commands);

            // Output the formatted commands
            System.out.println(formattedCommands);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
