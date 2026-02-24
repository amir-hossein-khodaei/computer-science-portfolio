//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class temp {
//    public static void main(String[] args) throws IOException {
//        LinkedList list = new LinkedList();
//        FastScanner fs = new FastScanner();
//
//        int operation = fs.nextInt();
//        fs.nextLine();  // To consume the newline after the integer
//        for (int i = 0; i < operation; i++) {
//            String input = fs.nextLine();
//            if (input.startsWith("insert ")) {
//                char element = input.charAt(7);
//                list.add(element);
//            } else if (input.equals("-")) {
//                list.negative();
//            } else if (input.equals("+")) {
//                list.positive();
//            }
//        }
//        list.printList();
//    }
//}
//
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
//        line = null;
//        return ret;
//    }
//}
//
//class LinkedList {
//    Node head;
//    Node pointer;
//
//    public void add(char data) {
//        Node newNode = new Node(data);
//        if (head == null) {
//            head = newNode;
//            pointer = newNode;
//        } else if (pointer.next == null) {
//            pointer.next = newNode;
//            newNode.before = pointer;
//            pointer = newNode;
//        } else {
//            newNode.next = pointer.next;
//            pointer.next.before = newNode;
//            newNode.before = pointer;
//            pointer.next = newNode;
//            pointer = newNode;
//        }
//    }
//
//    public void positive() {
//        if (pointer != null && pointer.next != null) {
//            pointer = pointer.next;
//        }
//    }
//
//    public void negative() {
//        if (pointer != null && pointer.before != null) {
//            pointer = pointer.before;
//        }
//    }
//
//    public void printList() {
//        Node current = head;
//        while (current != null) {
//            System.out.print(current.data);
//            current = current.next;
//        }
//        System.out.println();
//    }
//}
//
//class Node {
//    char data;
//    Node next;
//    Node before;
//
//    Node(char data) {
//        this.data = data;
//        this.next = null;
//        this.before = null;
//    }
//}
