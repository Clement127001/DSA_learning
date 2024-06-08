class Node {
    int data;
    Node prev;
    Node next;

    Node(int x) {
        data = x;
        prev = null;
        next = null;
    }
}

class DoublyLinkedList {

    // traverse a doubly linked list
    public static void traverseList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.err.print(curr.data + " ");
            curr = curr.next;
        }
    }

    // insert at begin
    public static Node insertAtBeginning(Node head, int data) {
        Node temp = new Node(data);

        if (head == null)
            return temp;

        temp.next = head;
        head.prev = temp;

        return temp;
    }

    public static Node reverseList(Node head) {
        Node prev = null, curr = head;

        if (head == null || head.next == null) {
            return head;
        }

        while (curr != null) {
            Node after = curr.next;

            // the only change in double linked list reversal is just altering the two ref
            // instead of one
            curr.prev = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }

        return prev;
    }

    public static void main(String[] args) {
        // step 1: creating the node
        // Node head = new Node(10);
        // Node temp1 = new Node(20);
        // Node temp2 = new Node(30);

        // step 2: linking them
        // head.next = temp1;
        // temp1.prev = head;
        // temp1.next = temp2;
        // temp2.prev = temp1;

        Node head = null;
        head = insertAtBeginning(head, 10);
        head = insertAtBeginning(head, 20);
        head = insertAtBeginning(head, 30);

        head = reverseList(head);

        System.out.println("Successfully created doubly linked list :)");
        traverseList(head);
    }

}
