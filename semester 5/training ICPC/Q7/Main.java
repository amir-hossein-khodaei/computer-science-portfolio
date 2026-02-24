//package Q7;
//
//import java.io.*;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer("");
//        String next() throws Exception {
//            while (!st.hasMoreTokens()) {
//                String line = br.readLine();
//                if (line == null) return null;
//                st = new StringTokenizer(line);
//            }
//            return st.nextToken();
//        }
//        // read n
//        String tok = next();
//        if (tok == null) {
//            System.out.println(0);
//            return;
//        }
//        int n = Integer.parseInt(tok);
//        long[] a = new long[n];
//        for (int i = 0; i < n; i++) {
//            tok = next();
//            while (tok == null) {
//                tok = next();
//            }
//            a[i] = Long.parseLong(tok);
//        }
//        int lo = 1, hi = n, ans = 0;
//        while (lo <= hi) {
//            int mid = (lo + hi) >>> 1;
//            if (existsSegment(a, mid)) {
//                ans = mid;
//                lo = mid + 1;
//            } else hi = mid - 1;
//        }
//        System.out.println(ans);
//    }
//
//    static boolean existsSegment(long[] a, int k) {
//        int run = 0;
//        for (long v : a) {
//            if (v >= k) {
//                run++;
//                if (run >= k) return true;
//            } else run = 0;
//        }
//        return false;
//    }
//}
