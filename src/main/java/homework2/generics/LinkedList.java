package homework2.generics;

public class LinkedList<T> {
    private Node head;
    private Node tail;

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.val + " -> ");
            current = current.next;
        }
        System.out.println();
    }

/*    public void addFirst(T val) {
        if (isEmpty()) {
            head = new Node(val);
            tail = head;
            return;
        }
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(T val) {
        if (isEmpty()) {
            head = new Node(val);
            tail = head;
            return;
        }
        Node newNode = new Node(val);
        tail.next = newNode;
        tail = newNode;
    }*/


    public class Node<T> {
        T val;
        Node next;

        Node(T val) {
            this.val = val;
        }
    }
}
