import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class airport{
    public static void main(String[] args) throws IOException {
        Integer floor , ceiling;
        FastScanner scanner = new FastScanner();
        TreeSet<Integer> tree=new TreeSet<>();
        int q=scanner.nextInt();
        int location;
        int k=scanner.nextInt();
        for(int a=0;a<q;a++){
            location=scanner.nextInt();
            floor=tree.floor(location);
            ceiling=tree.ceiling(location);
            if(((floor==null)||((location-floor)>=k))&&((ceiling==null)||((ceiling-location)>=k))){
                System.out.print("Permission Granted!");
                System.out.println();
                tree.add(location);
            }
            else {
                System.out.print("Permission Denied!");
                System.out.println();
            }
        }
    }
}

//class FastScanner {
//    private BufferedReader br;
//    private String line;
//    private int pos;
//
//    public FastScanner() {
//        br = new BufferedReader(new InputStreamReader(System.in));
//    }
//
//    private void reload() throws IOException {
//        line = br.readLine();
//        pos = 0;
//    }
//
//    public int nextInt() throws IOException {
//        while (line == null || pos >= line.length()) {
//            reload();
//        }
//        int num = 0;
//        boolean neg = false;
//        if (line.charAt(pos) == '-') {
//            neg = true;
//            pos++;
//        }
//        while (pos < line.length() && line.charAt(pos) >= '0' && line.charAt(pos) <= '9') {
//            num = num * 10 + (line.charAt(pos) - '0');
//            pos++;
//        }
//        if (neg) {
//            num = -num;
//        }
//        pos++;
//        return num;
//    }
//
//    public String nextLine() throws IOException {
//        if (line == null || pos >= line.length()) {
//            reload();
//        }
//        String ret = line;
//        line = null; return ret;
//    }
//}