//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class array {
//    public static void main(String[] args) {
//        FastScanner fs = new FastScanner();
//        int a = fs.nextInt();
//        int[] A = new int[a];
//        for (int i = 0; i <= a - 1; i++) {
//            A[i] = fs.nextInt();
//        }
//        int sum ;
//        for (int j = 0 ;j <= a - 1;j++){
//            sum=0;
//            for (int i = j; i <= a - 1; i++) {
//                sum += A[i];
//                if (sum==0){
//                    System.out.println("TRUE");
//                return;
//                }
//            }
//        }
//        System.out.println("FALSE");
//    }
//}
//
//class FastScanner {
//    private BufferedReader br;
//    private StringTokenizer st;
//
//    public FastScanner() {
//        br = new BufferedReader(new InputStreamReader(System.in));
//    }
//
//    private String next() {
//        while (st == null || !st.hasMoreTokens()) {
//            try {
//                st = new StringTokenizer(br.readLine());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return st.nextToken();
//    }
//
//    public int nextInt() {
//        return Integer.parseInt(next());
//    }
//
//    public long nextLong() {
//        return Long.parseLong(next());
//    }
//
//    public double nextDouble() {
//        return Double.parseDouble(next());
//    }
//
//    public String nextLine() {
//        String str = "";
//        try {
//            str = br.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return str;
//    }
//}