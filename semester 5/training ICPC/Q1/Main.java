//package Q1;
//
//import java.io.*;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        FastReader sc = new FastReader();
//        PrintWriter out = new PrintWriter(System.out);
//
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//
//        char[][] flower = new char[m][n];
//
//
//        for (int i=0 ; i<m;i++){
//                flower[i] = sc.nextLine().toCharArray();
//        }
//
//        for (int i=0;i<n;i++){
//            int sum=0;
//            for (int j=0; j<m ;j++){
//                if (flower[j][i]=='W')sum++;
//            }
//            if (sum%2==0){
//                out.print('B');
//            }else out.print('F');
//
//
//        }
//
//        out.flush();
//    }
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