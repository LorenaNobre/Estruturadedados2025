package org.example;

import java.util.NoSuchElementException;


public class ListaDuplamenteEncadeada {


    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    private Node head; // primeiro nó
    private Node tail; // último nó
    private int size;  // número de elementos


    public ListaDuplamenteEncadeada() {
        head = null;
        tail = null;
        size = 0;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }


    public void insertAtStart(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }


    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }


    private Node nodeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }


    public void insertAtPosition(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice inválido para inserção: " + index);
        }
        if (index == 0) {
            insertAtStart(value);
            return;
        }
        if (index == size) {
            insertAtEnd(value);
            return;
        }
        Node current = nodeAt(index);
        Node prev = current.prev;
        Node newNode = new Node(value);


        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = current;
        current.prev = newNode;

        size++;
    }


    public int removeFromStart() {
        if (isEmpty()) {
            throw new NoSuchElementException("Lista vazia");
        }
        int value = head.data;
        if (size == 1) {
            head = tail = null;
        } else {
            Node next = head.next;
            head.next = null;
            next.prev = null;
            head = next;
        }
        size--;
        return value;
    }


    public int removeFromEnd() {
        if (isEmpty()) {
            throw new NoSuchElementException("Lista vazia");
        }
        int value = tail.data;
        if (size == 1) {
            head = tail = null;
        } else {
            Node prev = tail.prev;
            tail.prev = null;
            prev.next = null;
            tail = prev;
        }
        size--;
        return value;
    }


    public int removeAtPosition(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido para remoção: " + index);
        }
        if (index == 0) return removeFromStart();
        if (index == size - 1) return removeFromEnd();

        Node toRemove = nodeAt(index);
        Node prev = toRemove.prev;
        Node next = toRemove.next;


        prev.next = next;
        next.prev = prev;


        toRemove.prev = null;
        toRemove.next = null;

        int value = toRemove.data;
        size--;
        return value;
    }


    public boolean removeElement(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                if (current == head) {
                    removeFromStart();
                } else if (current == tail) {
                    removeFromEnd();
                } else {
                    Node prev = current.prev;
                    Node next = current.next;
                    prev.next = next;
                    next.prev = prev;
                    current.prev = null;
                    current.next = null;
                    size--;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }


    public void displayForward() {
        System.out.println(this.toString());
    }


    public void displayBackward() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node cur = tail;
        while (cur != null) {
            sb.append(cur.data);
            if (cur.prev != null) sb.append(", ");
            cur = cur.prev;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }


    public int indexOf(int value) {
        Node current = head;
        int idx = 0;
        while (current != null) {
            if (current.data == value) return idx;
            current = current.next;
            idx++;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node cur = head;
        while (cur != null) {
            sb.append(cur.data);
            if (cur.next != null) sb.append(", ");
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        // inserções
        lista.insertAtEnd(10);           // [10]
        lista.insertAtStart(5);          // [5, 10]
        lista.insertAtEnd(20);           // [5, 10, 20]
        lista.insertAtPosition(1, 15);   // [5, 15, 10, 20]

        System.out.println("Forward: " + lista);    // [5, 15, 10, 20]
        System.out.print("Backward: "); lista.displayBackward(); // [20, 10, 15, 5]

        System.out.println("indexOf(10) = " + lista.indexOf(10)); // 2

        // remoções
        int removed = lista.removeAtPosition(2); // remove 10
        System.out.println("removeAtPosition(2) -> " + removed + ", lista agora = " + lista); // [5,15,20]

        boolean r = lista.removeElement(15); // remove primeira ocorrência de 15
        System.out.println("removeElement(15) -> " + r + ", lista agora = " + lista); // [5,20]

        System.out.println("removeFromStart() -> " + lista.removeFromStart()); // 5
        System.out.println("removeFromEnd() -> " + lista.removeFromEnd());     // 20

        System.out.println("Lista vazia? " + lista.isEmpty()); // true
    }
}

