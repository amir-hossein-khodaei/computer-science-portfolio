//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class matris {
//    public static void main(String[] args) {
//        FastScanner fs = new FastScanner();
//        int a = fs.nextInt();
//        int b = fs.nextInt();
//        int c = fs.nextInt();
//        int[][] A = new int[a][b];
//        int[][] B = new int[b][c];
//        int[][] AB = new int[a][c];
//        int sum = 0;
//
//        for (int i=0 ; i <=a-1 ; i++ ){
//            for (int j=0 ; j<=b-1 ;j++){
//                A[i][j]= fs.nextInt();
//                System.out.println(i +" "+A[i][j]+" " + j);
//            }
//        }
//        System.out.println("------------------------");
//        for (int i=0 ; i <=b-1 ; i++ ){
//            for (int j=0 ; j<=c-1 ;j++){
//                B[i][j]= fs.nextInt();
//                System.out.println(i +" "+B[i][j]+" " + j);
//            }
//        }
//        System.out.println("-------------------");
//
//        for(int i = 0 ; i <= a-1 ; i ++){
//            for (int j = 0 ; j <= c-1 ; j ++){
//                sum=0;
//                for (int k = 0 ; k<= b-1 ; k++ ){
//                    sum+=(A[i][k]*B[k][j]);
//                    System.out.println(i + "  " + k + "  " + j);
//                    System.out.print(A[i][k]*B[k][j]+" ");
//                    System.out.println();
//                    System.out.print(sum);
//                }
//                AB[i][j]=sum;
//            }
//        }
//        System.out.println("-----------------");
//        for (int i=0 ; i <=a-1 ; i++ ){
//            for (int j=0 ; j<=c-1 ;j++){
//                System.out.print(AB[i][j]+" ");
//            }
//            System.out.println("");
//        }
//
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
