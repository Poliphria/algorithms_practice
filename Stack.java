import java.util.Scanner;

public class Stack {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node top;

    public Stack() {
        this.top = null;
    }
    public static void main(String args[]) {
        Stack test = new Stack();
        Scanner input = new Scanner(System.in);
        String answer = "";
        do {
            try {
                test.print();
                answer = "n";
            } catch (Exception e) {
                System.out.println("Error:");
                System.out.println(e);
            }
            System.out.println("Do you want to continue? (y or n)");
            answer = input.nextLine();
        } while (answer.equals("y"));
       
        
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() throws NullPointerException {
        if (top == null) throw new NullPointerException("stack is empty");
        return top.data; 
    }

    public void push(int data) {
        // create the new node
        Node newNode = new Node(data);

        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() throws NullPointerException {
        if (top == null) throw new NullPointerException("stack is empty");
        int data = top.data;
        top = top.next;
        return data;
    }

    public void print() throws NullPointerException {
        System.out.println("Printing...");
        if (top == null) {
            throw new NullPointerException("stack is empty");
        }
        int count = 0;
        Node iterator = top;
        while (iterator != null) {
            System.out.printf("Node %d's data: %d\n", count, iterator.data);
            iterator = iterator.next;
            count++;
        }
    }

}