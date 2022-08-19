package homework2.generics;

public class CustomLinkedList<T> {

   /* public void addFirst(T val) {
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
    }

    public void insert(int pos, T val){
        //validate pos using size
        if (pos==1){
            addFirst(val);
            return;
        }

        Node current = head;
        int count = 1;
        while (count < pos-1){
            count++;
            current = current.next;
        }
        Node newNode = new Node(val);
        newNode.next = current.next;
        current.next = newNode;
    }

    public T deleteFirst(){
        if(isEmpty()) {
            throw new RuntimeException("List is Empty");
        }
        Node current = head;
        head = head.next;
        current.next = null;
        if(isEmpty()) {
            tail = null;
        }
        return (T) current.val;
    }


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

    public boolean isEmpty(){
        return head == null;
    }*/

    public Node<T> head;
    private int length = 0;

    public CustomLinkedList() {
        this.head = null;
    }

    public void add(T data) {

        Node<T> temp = new Node<>(data);

        if (this.head == null) {
            head = temp;
        } else {

            Node<T> X = head;

            while (X.next != null) {
                X = X.next;
            }

            X.next = temp;
        }

        length++;
    }

    public void add(int position, T data) {

        if (position > length + 1) {
            System.out.println("Position Unavailable in LinkedList");
            return;
        }

        if (position == 1) {

            Node<T> temp = head;

            head = new Node<T>(data);

            head.next = temp;

            return;
        }

        Node<T> temp = head;

        Node<T> prev = new Node<T>(null);

        while (position - 1 > 0) {
            prev = temp;
            temp = temp.next;
            position--;
        }
        prev.next = new Node<T>(data);
        prev.next.next = temp;
    }

    public void remove(T key) {
        Node<T> prev = new Node<>(null);

        prev.next = head;

        Node<T> next = head.next;

        Node<T> temp = head;

        boolean exists = false;

        if (head.data == key) {
            head = head.next;

            exists = true;
        }

        while (temp.next != null) {

            if (String.valueOf(temp.data).equals(String.valueOf(key))) {

                prev.next = next;
                exists = true;

                break;
            }

            prev = temp;

            temp = temp.next;

            next = temp.next;
        }

        if (exists == false && String.valueOf(temp.data).equals(String.valueOf(key))) {

            prev.next = null;

            exists = true;
        }

        if (exists) {

            length--;
        } else {

            System.out.println("Given Value is not present in linked list");
        }
    }

    public void clear() {

        head = null;
        length = 0;
    }

    public boolean empty() {
        return head == null;
    }

    public int length() {
        return this.length;
    }

    @Override
    public String toString() {
        String S = "{ ";

        Node<T> X = head;

        if (X == null) {
            return S + " }";
        }

        while (X.next != null) {
            S += X.data + "; ";
            X = X.next;
        }

        S += String.valueOf(X.data);
        return S + " }";
    }



}
