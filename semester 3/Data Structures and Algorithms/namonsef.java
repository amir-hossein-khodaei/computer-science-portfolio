import java.io.*;
import java.util.*;

//public class namonsef {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String[] firstLine = reader.readLine().split(" ");
//        int n = Integer.parseInt(firstLine[0]);
//        int c = Integer.parseInt(firstLine[1]);
//
//        ArrayDeque<Integer> saf = new ArrayDeque<>();
//        for (int i = 1; i <= n; i++) {
//            saf.addLast(i);
//        }
//
//        for (int i = 0; i < c; i++) {
//            int func = Integer.parseInt(reader.readLine().trim());
//
//            if (func == 0) {
//                int person = saf.pollFirst();
//                saf.addLast(person);
//                System.out.println(person);
//            } else {
//                saf.remove(func);
//                saf.addFirst(func);
//            }
//        }
//    }
//}

public class namonsef {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int c = Integer.parseInt(firstLine[1]);

        int[] position = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            position[i] = i;
        }

        int front = 0;
        for (int i = 0; i < c; i++) {
            int func = Integer.parseInt(reader.readLine().trim());
            if (func == 0) {

                front = (front + 1) % n;
                System.out.println(position[front]);
            } else {
                int index = -1;
                for (int j = 0; j < n; j++) {
                    if (position[(front + j) % n] == func) {
                        index = (front + j) % n;
                        break;
                    }
                }

                int temp = position[index];
                for (int j = index; j != front; j = (j - 1 + n) % n) {
                    position[j] = position[(j - 1 + n) % n];
                }
                position[front] = temp;
            }
        }
    }
}
