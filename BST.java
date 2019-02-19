public class BST {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.insert(5);
        root.insert(15);
        root.insert(8);
        root.printInOrder();
    }


    private static class Node {
        int data; 
        Node left;
        Node right;

        public Node(int value) {
            data = value;
        }

        public void insert(int value) {
            if (value <= data) {
                if (left == null) {
                    left = new Node(value);
                } else {
                    left.insert(value);
                }
            } else if (value >= data) {
                if (right == null) {
                    right = new Node(value);
                } else {
                    right.insert(value);
                }
            }
        }

        public boolean contains(int value) {
            if (value == data) {
                return true;
            } else if (value < data) {
                if (left == null) {
                    return false;
                } else {
                    return left.contains(value);
                }
            } else {
                if (right == null) {
                    return false;
                } else {
                    return right.contains(value);
                }
            }
        }

        public void printInOrder() {
            if (left != null) {
                left.printInOrder();
            }

            System.out.println(data);

            if (right != null) {
                right.printInOrder();
            }
        }

        public void printPreOrder() {
            System.out.println(data);

            if (left != null) left.printPreOrder();

            if (right != null) right.printPreOrder();
        }
    }
}