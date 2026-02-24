////package Q5;//package Q4;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        FastReader sc = new FastReader();
//        PrintWriter out = new PrintWriter(System.out);
//        while (sc.hasNext()) {
//            long x = sc.nextLong();
//            long y = sc.nextLong();
//            out.println(Math.abs(x - y));
//            out.flush();
//        }
//
//    }
//
//    //65
//
//    // Fast I/O class
//    static class FastReader {
//        BufferedReader br;
//        StringTokenizer st;
//
//        public FastReader() {
//            br = new BufferedReader(new InputStreamReader(System.in));
//        }
//
//        String next() {
//            while (st == null || !st.hasMoreElements()) {
//                try {
//                    st = new StringTokenizer(br.readLine());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return st.nextToken();
//        }
//        int[] nextIntArray() {
//            String line = nextLine(); // Read the full line
//            String[] parts = line.trim().split("\\s+"); // Split by spaces
//            int[] arr = new int[parts.length];
//            for (int i = 0; i < parts.length; i++) {
//                arr[i] = Integer.parseInt(parts[i]);
//            }
//            return arr;
//        }
//
//        int nextInt() {
//            return Integer.parseInt(next());
//        }
//
//        long nextLong() {
//            return Long.parseLong(next());
//        }
//
//        double nextDouble() {
//            return Double.parseDouble(next());
//        }
//        boolean hasNext() {
//            try {
//                while (st == null || !st.hasMoreTokens()) {
//                    String line = br.readLine();
//                    if (line == null) return false; // EOF reached
//                    st = new StringTokenizer(line);
//                }
//                return true;
//            } catch (IOException e) {
//                return false;
//            }
//        }
//
//
//
//
//        String nextLine() {
//            String str = "";
//            try {
//                str = br.readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return str;
//        }
//    }
//}