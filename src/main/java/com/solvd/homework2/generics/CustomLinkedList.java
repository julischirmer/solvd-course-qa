package com.solvd.homework2.generics;

public class CustomLinkedList<U> {
    private Node head;


    public CustomLinkedList() {

    }

    // Insertion
    // Insertion can be done at 3 places in a linked list.
    // We can either insert at head, tail or at a particular location.

    public void insert(U data){
        Node newNode = new Node(data);
        if(this.head == null){
            head = newNode;
        }else {
            Node currentNode = head;
            while(currentNode.getNextNode() != null){
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        }
    }

    public void insertHead(U data){
        Node newNode = new Node(data);
        newNode.setNextNode(head);
        head = newNode;
    }

    //Insertion in a partular place

    public void insertAt(int index, U data){
        Node nodeToBeInserted = new Node(data);
        Node node = head;
        for(int i = 0; i< index -1; i++){
            node = node.getNextNode();
        }
        nodeToBeInserted.setNextNode(node.getNextNode());
        node.setNextNode(nodeToBeInserted);
    }

    // Delete a node

    public void deleteNodeAt(int index){
        Node node = head;
        for(int i = 0; i< index -1; i++){
            node = node.getNextNode();
        }
        node.setNextNode(node.getNextNode().getNextNode());
    }

    // Display CustomLinkedList
    public void display(){
        if(head != null){
            Node currentNode = head;
            while(currentNode.getNextNode() != null){
                System.out.println(currentNode.getData());
                currentNode = currentNode.getNextNode();
            }
            System.out.println(currentNode.getData());
        }
    }


}
