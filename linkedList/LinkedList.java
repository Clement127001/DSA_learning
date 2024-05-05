class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class LinkedList {
    public static void main(String[] args) {
        // creating the three linked list to contain data 10 -> 20 -> 30 -> null

        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);

        head.next = temp1;
        temp1.next = temp2;

        Node temp = head;

        // traversing the node
        while (temp != null) {
            if (temp.next != null)
                System.out.print(temp.data + "->");

            else
                System.out.print(temp.data);

            temp = temp.next;
        }

        System.out.println();

    }
}