//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class spars {
//    public static void main(String[] args) {
//        FastScanner fs = new FastScanner();
//        int row = fs.nextInt();
//        int col = fs.nextInt();
//        int value = fs.nextInt();
//        int[][] A = new int[(value+1)][4];
//        int[][] rev = new int[value+1][3];
//        A[0][0]=col;
//        A[0][1]=row;A[0][2]=value;
//        rev[0][0]=col;
//        rev[0][1]=row;rev[0][2]=value;
//
//        for (int i=1 ; i <=value ; i++ ){
//            for (int j=0 ; j<3 ;j++){
//                A[i][j]= fs.nextInt();
//            }
//        }
//
//        for (int i=0 ; i <=value ; i++ ){
//            for (int j=0 ; j<3 ;j++){
//                System.out.print(A[i][j]+" ");
//            }
//            System.out.println("");
//        }
//        System.out.println("---------------------");
//
//        if (value>0){
//            int position=1;
//            for (int i=0 ; i < row ; i++){
//                for (int j=0 ; j <= value ; j++){
//                    if (A[j][1]==i){
//                        rev[position][0]=A[j][1];
//                        rev[position][1]=A[j][0];
//                        rev[position][2]=A[j][2];
//                        position++;
//                    }
//                }
//            }
//        }
//
//        for (int i=0 ; i <=value ; i++ ){
//            for (int j=0 ; j<3 ;j++){
//                System.out.print(rev[i][j]+" ");
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
//}