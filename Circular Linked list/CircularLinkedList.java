
class NodeCircular {
    int data;
    NodeCircular next;

    NodeCircular(int data) {
        this.data = data;

    }
}

class CircularLinkedList {

    // circular linked list traversal
    public static void printData(NodeCircular head) {

        if (head == null)
            return;

        NodeCircular curr = head;

        do {
            System.out.print(curr.data);
            if (curr.next != head)
                System.out.print(" -> ");
            curr = curr.next;
        } while (curr != head);
    }

    // insert the data in the beginning of the node
    public static NodeCircular insertAtBeginning(NodeCircular head, int data) {
        NodeCircular temp = new NodeCircular(data);

        if (head == null) {
            temp.next = temp;
            return temp;
        }

        temp.next = head.next;
        head.next = temp;

        int tempData = head.data;
        head.data = temp.data;
        temp.data = tempData;

        // no need to change the head while we are inserting in the beginning
        return head;

    }

    // inser the data in the end of the node
    public static NodeCircular insertAtEnd(NodeCircular head, int data) {
        NodeCircular temp = new NodeCircular(data);

        if (head == null) {
            temp.next = temp;
            return temp;
        }

        temp.next = head.next;
        head.next = temp;

        int tempData = head.data;
        head.data = temp.data;
        temp.data = tempData;

        // need to change the head, to the newNode that is inserted
        return temp;
    }

    public static void main(String[] args) {
        NodeCircular head = new NodeCircular(20);
        head.next = new NodeCircular(30);
        head.next.next = new NodeCircular(40);
        head.next.next.next = head;

        System.out.println("Before Inserting : ");
        printData(head);

        System.out.println("\nAfter Inserting : ");
        head = insertAtBeginning(head, 10);
        head = insertAtEnd(head, 50);
        // head = insertAtBeginning(head, 50);
        printData(head);

        System.err.println();

    }
}

// class DoublyCircularLinkedList {

// }

// class CircularLinkedList {

// }