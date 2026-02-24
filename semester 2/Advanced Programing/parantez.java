import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class parantez {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        String input = fs.nextLine();
        Stack<Integer> stak = new Stack<>();
        boolean state = true ;
        char parantez;
        for (int i = 0; i < input.length(); i++) {
            parantez = input.charAt(i);
            if (parantez == '(') {
                stak.push(i);
            }
            else if (parantez == ')') {
                if (stak.isEmpty()) {
                    state = false;
                }
                else {
                    stak.pop();
                }
            }
        }
        if (!stak.isEmpty()){
            state=false;
        }

        int pairIndex;
        stak.clear();
        if (!state) {
            System.out.println("-1");
        }
        else {
            for (int i = 0; i < input.length(); i++) {
                parantez = input.charAt(i);
                if (parantez == '(') {
                    stak.push(i);
                } else if (parantez == ')') {
                    pairIndex = stak.pop();
                    System.out.println((pairIndex + 1) + " " + (i + 1));
                }
            }
        }
    }
}

class FastScanner {
    private BufferedReader br;
    private String line;
    private int pos;

    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private void reload() throws IOException {
        line = br.readLine();
        pos = 0;
    }

    public int nextInt() throws IOException {
        while (line == null || pos >= line.length()) {
            reload();
        }
        int num = 0;
        boolean neg = false;
        if (line.charAt(pos) == '-') {
            neg = true;
            pos++;
        }
        while (pos < line.length() && line.charAt(pos) >= '0' && line.charAt(pos) <= '9') {
            num = num * 10 + (line.charAt(pos) - '0');
            pos++;
        }
        if (neg) {
            num = -num;
        }
        pos++;
        return num;
    }

    public String nextLine() throws IOException {
        if (line == null || pos >= line.length()) {
            reload();
        }
        String ret = line;
        line = null; return ret;
    }
}
