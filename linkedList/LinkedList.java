class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class LinkedList {

    // the main opearation performed in linked list ( singly linked list)

    // 1-> creation of node and lint them
    // 2-> traversing the linked list (either iteratively of recursively)
    // 3-> insert opearations
    // a-> insert at beginning
    // b-> insert at end
    // c-> insert at given position
    // 4 -> deletion
    // a-> delete from the beginning
    // b-> delete from the end

    public static void traverseList(Node temp) {
        // traversing the node
        while (temp != null) {
            if (temp.next != null)
                System.out.print(temp.data + "->");

            else
                System.out.print(temp.data);

            temp = temp.next;
        }
    }

    // traversing recursively, but it require some additonal stack trace for
    // managing the function calls
    public static void traverseRec(Node temp) {
        if (temp == null)
            return;

        System.out.print(temp.data + " ");

        traverseRec(temp.next);

        // System.out.print(temp.data + " ");
    }

    // a-> insert at beginning
    public static Node insertAtBeginning(int data, Node head) {
        // create the new node
        Node temp = new Node(data);
        temp.next = head;
        return temp;
    }

    // b-> insert at end
    public static Node insertAtEnd(int data, Node head) {
        Node temp = new Node(data);
        // if list is empty head will be null
        if (head == null)
            return temp;

        Node curr = head;
        while (curr.next != null)
            curr = curr.next;

        curr.next = temp;
        return head;
    }

    // c-> insert at given position
    public static Node insertAtPos(int data, Node head, int pos) {
        Node temp = new Node(data);

        if (pos == 1) {
            temp.next = head;
            return temp;
        }

        Node curr = head;
        // stop at pos-2 and when we found null ( try to insert beyond the limit)
        for (int i = 1; i < pos - 1 && curr != null; i++)
            curr = curr.next;

        // beyond the limit
        if (curr == null)
            return head;

        // when pos is at middle or end
        temp.next = curr.next;
        curr.next = temp;

        return head;
    }

    // delete operation
    // 1-> delete from beginning
    public static Node deleteFromBeginning(Node head) {
        if (head == null)
            return null;

        else
            return head.next;
    }

    // 2-> delete from end
    public static Node deleteFromEnd(Node head) {
        // when there is no element or there is only on element -> return null
        if (head == null || head.next == null)
            return null;

        Node curr = head;
        while (curr.next.next != null)
            curr = curr.next;

        curr.next = null;

        return head;
    }

    public static void main(String[] args) {
        // creating the three linked list to contain data 10 -> 20 -> 30 -> null

        // Node head = new Node(10);
        // Node temp1 = new Node(20);
        // Node temp2 = new Node(30);

        // head.next = temp1;
        // temp1.next = temp2;

        // traverseList(head); // traversing iteratively
        // traverseRec(head); // traversing recursively

        Node head = null;

        // insert at beginning
        // head = insertAtBeginning(10, head);
        // head = insertAtBeginning(20, head);
        // head = insertAtBeginning(30, head);

        // insert at end
        head = insertAtEnd(10, head);
        head = insertAtEnd(20, head);
        head = insertAtEnd(30, head);
        head = insertAtEnd(40, head);

        // insert at any given position
        // head = insertAtPos(30, head, 3);

        head = deleteFromBeginning(head);
        head = deleteFromEnd(head);

        traverseList(head);

        System.out.println();

    }
}
