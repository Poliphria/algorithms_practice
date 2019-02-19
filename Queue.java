public class Queue {
    Node head;
    Node tail;
    int length;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    } 

    public static void main(String args[]) {
        Queue test = new Queue();
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(2);

        test.remove();
        test.remove();
        test.remove();
        test.remove();


        
    }
    
    public boolean isEmpty() {
        return length == 0;
    }

    public void add(int data) {
        // create a new node
        Node newNode = new Node(data);
        
        if (tail != null) {
            // append that new node to the tail of queue
            tail.next = newNode;
        }

        tail = newNode;

        if (head == null) {
            head = newNode;
        } 

        length++;
        this.print();
    }

    public void remove() throws NullPointerException {
        if (head == null) throw new NullPointerException("Head is empty");
        head = head.next;
        length--;
        this.print();
    }

    public void print() {
        Node iterator = head;
        System.out.print("(head) ");

        while (iterator != null) {
            System.out.printf("%d ", iterator.data);
            iterator = iterator.next;
        }

        System.out.println("(tail)");
    }

}