// Because code can get mixed up with referencing the head, wrap head into a class called LinkedList
public class LinkedList<T> {
    Node head;

    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        // add random values to list to test
        for (int i = 0; i < 10; i++) {
            list.append(i);
        }

        list.print();
        
        list.search(10, list.head);

        try {
            Node found = list.getPosition(3);

            System.out.println("The node at position 3 (the 3rd node) is: " + found.data);

            Node newNode = new Node(20);
         
            list.insert(3, newNode);

            list.print();
        } catch(NullPointerException e) {
            System.out.println("You have tried getting the position of a node outside the size of the list");
        }
        
    }

    public void append(T data) {
        if (head == null) {
            head = new Node<T>(data);
            return;
        }

        // Create a reference to iterate over
        Node current = head;

        // Iterate over the linked list until we reach the last node
        while (current.next != null) {
            // Make current point to the next node;
            current = current.next;
        }

        // Now that we've reached the end of the list we can add a new Node with the
        // data received
        current.next = new Node(data);
    }

    public void prepend(T data) {
        // Create a new node to prepend to list
        Node<T> newHead = new Node<T>(data);

        // Point the newHead to the oldHead
        newHead.next = head;

        // Point the head of the linked list to the prepended node
        this.head = newHead;
    }

    public void deleteWithValue(T data) {
        if (head == null)
            return;
        if (head.data == data) {
            head = head.next;
            return;
        }

        // Iterate through the list until we find the value which holds the data to
        // delete
        Node<T> current = head;

        while (current.next != null) {
            // If the next node holds the data to delete, then point the current node's next
            // node to the
            // next node of the next node
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

    }

    public void print() {
        int count = 0;
        if (head == null) {
            System.out.println("This list is empty.");
            return;
        }

        // Iterate through the linked list and print each nodes data value
        Node<T> current = head;

        while (current != null) {
            System.out.printf("Node %d's data: %d\n", count, current.data);
            current = current.next;
            count++;
        }
    }

    public void search(T data, Node<T> node) {
        // Base case is when we reach the end of the list which in this case
        // the node will be null
        Node<T> current = node;

        if (current == null)
            return;

        if (current.data == data) {
            System.out.println("Data found!");
        }

        search(data, current.next);

    }

    // Returns the Node at the position passed to the function. Position starts at
    // 1.
    // Throws null pointer exception when the position passed exceeds the number of
    // nodes in the list.
    public Node getPosition(int position) throws new NullPointerException("Position exceeds list size") {
        int count = 1;
        Node current = head;

        while (count != position) {
            current = current.next;
            count++;
        }

        return current;
    }

    public void insert(int position, Node nodeToInsert) {
        Node previousNode = getPosition(position - 1);
        nodeToInsert.next = previousNode.next;
        previousNode.next = nodeToInsert;
    }
}
