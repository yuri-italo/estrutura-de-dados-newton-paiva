package br.newtonpaiva.desafio1;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    private static class Node {
        private String data;
        private Node next;
        private Node previous;

        public Node(String data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0; // head == null
    }

    public int length() {
        return length;
    }

    public void displayForward() {
        if (head == null)
            return;

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void displayBackward() {
        if (tail == null)
            return;

        Node temp = tail;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.previous;
        }
    }

    public String getNodeData(int index){
        Node current = head;
        for(int i= 0; i < index; i++)
            if (current.next != null)
                current = current.next;

        return current.data;
    }


    public void insertFirst(String str) {
        Node newNode = new Node(str);

        if (isEmpty())
            tail = newNode;
        else
            head.previous = newNode;

        newNode.next = head;
        head = newNode;
        length++;
    }

    public void insertLast(String str) {
        Node newNode = new Node(str);

        if (isEmpty())
            head = newNode;
        else {
            tail.next = newNode;
            newNode.previous = tail;
        }

        tail = newNode;
        length++;
    }

    public Node deleteFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        Node temp = head;
        if (head == tail)
            tail = null;
        else
            head.next.previous = null;

        head = head.next;
        temp.next = null;
        length--;

        return temp;
    }

    public Node deleteLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        Node temp = tail;
        if (head == tail)
            head = null;
        else
            tail.previous.next = null;

        tail = tail.previous;
        temp.previous = null;
        length--;

        return temp;
    }

    // sortList() will sort nodes of the list in ascending order
    public void sortList() {
        // Node current will point to head
        Node current = head, index;
        String temp;

        if (head == null)
            return;
        else {
            while (current != null) {
                // Node index will point to node next to current
                index = current.next;

                while (index != null) {
                    // If current node's data is greater
                    // than index's node data, swap the data
                    // between them
                    if (current.data.compareTo(index.data) > 0) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }
}
