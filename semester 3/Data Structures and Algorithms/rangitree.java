import java.util.*;

class RedBlackTree {
    private static class Node {
        int value;
        char color; // 'r' for red, 'b' for black
        Node left, right, parent;

        Node(int value) {
            this.value = value;
            this.color = 'r'; // New nodes are red by default
        }
    }

    private Node root;
    private final Node NIL = new Node(-1); // Sentinel node for NIL

    public RedBlackTree() {
        NIL.color = 'b';
        root = NIL;
    }

    // Left rotation
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != NIL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // Right rotation
    private void rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        if (x.right != NIL) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == null) {
            root = x;
        } else if (y == y.parent.left) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }
        x.right = y;
        y.parent = x;
    }

    // Insert a new value
    public void insert(int value) {
        Node newNode = new Node(value);
        newNode.left = newNode.right = NIL;
        if (root == NIL) {
            root = newNode;
            root.color = 'b';
            root.parent = null;
            return;
        }

        Node current = root;
        Node parent = null;
        while (current != NIL) {
            parent = current;
            if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        newNode.parent = parent;
        if (value < parent.value) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        fixInsert(newNode);
    }

    // Fix violations after insertion
    private void fixInsert(Node node) {
        while (node.parent != null && node.parent.color == 'r') {
            if (node.parent == node.parent.parent.left) {
                Node uncle = node.parent.parent.right;
                if (uncle.color == 'r') {
                    node.parent.color = 'b';
                    uncle.color = 'b';
                    node.parent.parent.color = 'r';
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        leftRotate(node);
                    }
                    node.parent.color = 'b';
                    node.parent.parent.color = 'r';
                    rightRotate(node.parent.parent);
                }
            } else {
                Node uncle = node.parent.parent.left;
                if (uncle.color == 'r') {
                    node.parent.color = 'b';
                    uncle.color = 'b';
                    node.parent.parent.color = 'r';
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rightRotate(node);
                    }
                    node.parent.color = 'b';
                    node.parent.parent.color = 'r';
                    leftRotate(node.parent.parent);
                }
            }
        }
        root.color = 'b';
    }

    // Delete a value
    public void delete(int value) {
        Node node = search(root, value);
        if (node == NIL) return;

        Node y = node;
        Node x;
        char originalColor = y.color;

        if (node.left == NIL) {
            x = node.right;
            transplant(node, node.right);
        } else if (node.right == NIL) {
            x = node.left;
            transplant(node, node.left);
        } else {
            y = minimum(node.right);
            originalColor = y.color;
            x = y.right;
            if (y.parent == node) {
                x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = node.right;
                y.right.parent = y;
            }
            transplant(node, y);
            y.left = node.left;
            y.left.parent = y;
            y.color = node.color;
        }

        if (originalColor == 'b') {
            fixDelete(x);
        }
    }

    // Fix violations after deletion
    private void fixDelete(Node x) {
        while (x != root && x.color == 'b') {
            if (x == x.parent.left) {
                Node sibling = x.parent.right;
                if (sibling.color == 'r') {
                    sibling.color = 'b';
                    x.parent.color = 'r';
                    leftRotate(x.parent);
                    sibling = x.parent.right;
                }
                if (sibling.left.color == 'b' && sibling.right.color == 'b') {
                    sibling.color = 'r';
                    x = x.parent;
                } else {
                    if (sibling.right.color == 'b') {
                        sibling.left.color = 'b';
                        sibling.color = 'r';
                        rightRotate(sibling);
                        sibling = x.parent.right;
                    }
                    sibling.color = x.parent.color;
                    x.parent.color = 'b';
                    sibling.right.color = 'b';
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                Node sibling = x.parent.left;
                if (sibling.color == 'r') {
                    sibling.color = 'b';
                    x.parent.color = 'r';
                    rightRotate(x.parent);
                    sibling = x.parent.left;
                }
                if (sibling.left.color == 'b' && sibling.right.color == 'b') {
                    sibling.color = 'r';
                    x = x.parent;
                } else {
                    if (sibling.left.color == 'b') {
                        sibling.right.color = 'b';
                        sibling.color = 'r';
                        leftRotate(sibling);
                        sibling = x.parent.left;
                    }
                    sibling.color = x.parent.color;
                    x.parent.color = 'b';
                    sibling.left.color = 'b';
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = 'b';
    }

    // Transplant nodes
    private void transplant(Node u, Node v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    // Search for a node
    private Node search(Node node, int value) {
        while (node != NIL && node.value != value) {
            if (value < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    // Find minimum node
    private Node minimum(Node node) {
        while (node.left != NIL) {
            node = node.left;
        }
        return node;
    }

    // Print the tree in level-order
    public void print() {
        if (root == NIL) {
            System.out.println();
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            sb.append(current.value).append(current.color).append(" ");
            if (current.left != NIL) queue.add(current.left);
            if (current.right != NIL) queue.add(current.right);
        }

        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RedBlackTree tree = new RedBlackTree();

        while (sc.hasNextLine()) {
            String[] command = sc.nextLine().split(" ");
            if (command[0].equals("insert")) {
                tree.insert(Integer.parseInt(command[1]));
            } else if (command[0].equals("delete")) {
                tree.delete(Integer.parseInt(command[1]));
            } else if (command[0].equals("print")) {
                tree.print();
            }
        }

        sc.close();
    }
}