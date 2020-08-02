package LinkedListExample;

public class SinglyLinkedList {
    private Node head;
    private Node tail; // makes singly linked list circular linked list if made to point head node
    private int size;

    public SinglyLinkedList() {
        size = 0;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int getListSize() {
        return size;
    }

    public void displayList() {
        if (isEmpty())
            System.out.println("List is Empty");
        else {
            Node curNode = head;
            while (curNode != null) {
                System.out.print(curNode);
                if (curNode.getNext() != null)
                    System.out.print(" -> ");
                curNode = curNode.getNext();
            }
            System.out.println();
        }
    }

    public void insertFirst(int data) {
        Node newNode = new Node(data, head);
        head = newNode;
        if (head.getNext() == null)
            tail = head;
        size++;
    }

    public Node deleteFirst() {
        if (isEmpty())
            return null;

        Node temp = head;
        if (head.getNext() == null )
            tail = null;
        head = head.getNext();
        size--;
        return temp;
    }

    public void insertLast(int data) {
        if (isEmpty())
            insertFirst(data);
        else {
            Node newNode = new Node(data, null);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public Node deleteLast() {
        if (isEmpty())
            return null;

        Node curNode = head;
        Node prevNode = null;
        while (curNode.getNext() != null) {
            prevNode = curNode;
            curNode = curNode.getNext();
        }
        tail = prevNode;
        if (tail != null)
            tail.setNext(null);
        size--;
        return curNode;
    }

    public void insertAt(int data, int position) {
        if (position <= 0) {
            System.out.println("Undefined size, size should be greater than 0!");
        } else if (position > size + 1) {
            System.out.println("Position greater than list size, to add at last use size + 1 , current size: " + size);
        } else {
            if (isEmpty() || position == 1) {
                insertFirst(data);
            } else if (position == size + 1) {
                insertLast(data);
            } else {
                Node prevNode = head;
                Node curNode = head.getNext();
                for (int i = 2; i < position; i++) {
                    prevNode = curNode;
                    curNode = curNode.getNext();
                }
                Node newNode = new Node(data, curNode);
                prevNode.setNext(newNode);
                size++;
            }
        }
    }

    public Node deleteAt(int position) {
        if (position <= 0) {
            System.out.println("Undefined size, size should be greater than 0!");
            return null;
        }

        if (isEmpty()) {
            System.out.println("List is Empty");
            return null;
        }

        if (position > size) {
            System.out.println("Position greater than list size, current size: " + size);
            return null;
        }

        if (position == 1)
            return deleteFirst();

        if (position == size)
            return deleteLast();

        Node prevNode = head;
        Node curNode = prevNode.getNext();

        for (int i = 2; i < position; i++){
            prevNode = curNode;
            curNode = curNode.getNext();
        }

        prevNode.setNext(curNode.getNext());
        size--;
        return curNode;
    }
}