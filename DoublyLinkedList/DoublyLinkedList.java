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

        temp.next = head;

        if (head != null)
            head.prev = temp;

        return temp;
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

        System.out.println("Successfully created doubly linked list :)");
        traverseList(head);
    }

}