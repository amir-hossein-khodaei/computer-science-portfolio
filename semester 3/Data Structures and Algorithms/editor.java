    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    public class editor {
        public static void main(String[] args) throws IOException {
            LinkedList list = new LinkedList();
            FastScanner fs = new FastScanner();

            int operation = fs.nextInt();

            for (int i = 0 ; i<operation ; i++ ){
                String input = fs.nextLine();
                if (input.startsWith("insert ")) {
                    char element = input.charAt(7);
                    list.add(element);
                }
                else if (input.equals("-")) {
                        list.negetive();
                }
                else if (input.equals("+")) {
                        list.positive();
                }
            }
            list.printList();
        }
    }

    class LinkedList {
        Node Null = new Node('0');
        Node head;
        Node pointer;
        public void add(char data){
            Node newNode = new Node(data);
            Node First =  pointer;
            if ((head == null) ) {
                head = newNode;
                pointer = newNode;
                newNode.before=Null;
                Null.next=head;
            } else if (pointer.next == null){
                First.next = newNode;
                newNode.before = First;
                newNode.next = null;
                pointer = newNode;
            } else if ((pointer.next == head)) {
                head.before=newNode;
                newNode.next=head;
                head=newNode;
                newNode.before=Null;
                Null.next=newNode;
                pointer=newNode;

            }
            else {
                newNode.next=pointer.next;
                First.next = newNode;
                newNode.before = First;
                newNode.next.before=newNode;
                pointer = newNode;
            }
        }

        public void positive(){
            if (pointer != null && pointer.next != null) {
                pointer = pointer.next;
            }
        }

        public void negetive(){
            if (pointer.before!=null) {
                pointer = pointer.before;
            }
        }

        public void printList() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data );
                current = current.next;
            }
            System.out.println();
        }
    }

    class Node {
        char data;
        Node next;
        Node before;

        Node(char data) {
            this.data = data;
            this.next = null;
            this.before=null;
        }
    }













    class FastScanner {
        private BufferedReader br;
        private String line;
        private int pos;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private void reload() throws IOException {
            line = br.readLine();
            pos = 0;
        }

        public int nextInt() throws IOException {
            while (line == null || pos >= line.length()) {
                reload();
            }
            int num = 0;
            boolean neg = false;
            if (line.charAt(pos) == '-') {
                neg = true;
                pos++;
            }
            while (pos < line.length() && line.charAt(pos) >= '0' && line.charAt(pos) <= '9') {
                num = num * 10 + (line.charAt(pos) - '0');
                pos++;
            }
            if (neg) {
                num = -num;
            }
            pos++;
            return num;
        }

        public String nextLine() throws IOException {
            if (line == null || pos >= line.length()) {
                reload();
            }
            String ret = line;
            line = null; return ret;
        }
    }