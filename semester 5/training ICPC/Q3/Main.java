////package Q3;//package Q2;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        FastReader sc = new FastReader();
//        PrintWriter out = new PrintWriter(System.out);
//
//        int x = sc.nextInt();
//        int b = sc.nextInt();
//        StringBuilder result = new StringBuilder();
//        while (x>0) {
//            int digit = x % b;
//            if (digit < 10) {
//                result.append(digit); // 0–9
//            } else {
//                result.append((char) ('A' + digit - 10)); // 10–35 → A–Z
//            }
//
//            x/=b;
//        }
//
//        out.println(result.reverse().toString());
//        out.flush();
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