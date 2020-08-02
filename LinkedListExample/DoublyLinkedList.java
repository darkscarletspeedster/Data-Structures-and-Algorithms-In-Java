package LinkedListExample;

public class DoublyLinkedList {
    private Node head; // points at tail through previous
    private Node tail; // points at head through next and doing both makes it doubly circular
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int getListSize() {
        return size;
    }

    public void forwardDisplay() {
        if (isEmpty())
            System.out.println("List is Empty!");
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

    public void backwardDisplay() {
        if (isEmpty())
            System.out.println("List is Empty!");
        else {
            Node curNode = tail;
            while (curNode != null) {
                System.out.print(curNode);
                if (curNode.getPrevious() != null)
                    System.out.print(" -> ");
                curNode = curNode.getPrevious();
            }
            System.out.println();
        }
    }

    public void insertFirst(int data) {
        Node newNode = new Node(data, head, null);
        if (isEmpty())
            tail = newNode;
        else
            head.setPrevious(newNode);

        head = newNode;
        size++;
    }

    public Node deleteFirst() {
        if (isEmpty())
            return null;

        Node temp = head;
        head = head.getNext();
        if (head == null)
            tail = null;
        else
            head.setPrevious(null);

        size--;
        return temp;
    }

    public void insertLast(int data) {
        if (isEmpty())
            insertFirst(data);
        else {
            Node newNode = new Node(data, null, tail);
            tail.setNext(newNode);
            tail = newNode;
            size++;
        }
    }

    public Node deleteLast() {
        if (isEmpty())
            return null;

        Node temp = tail;
        tail = tail.getPrevious();

        if (tail == null)
            head = null;
        else
            tail.setNext(null);

        size--;
        return temp;
    }

    public void insertAt(int data, int position) {
        if (position <= 0)
            System.out.println("Undefined size, size should be greater than 0!");
        else if (position > size + 1)
            System.out.println("Position greater than list size, to add at last use size + 1 , current size: " + size);
        else {
            if (position == 1)
                insertFirst(data);
            else if (position == size + 1)
                insertLast(data);
            else {
                Node curNode = head.getNext();
                for (int i = 2; i < position; i++)
                    curNode = curNode.getNext();
                
                Node newNode = new Node(data, curNode, curNode.getPrevious());
                curNode.setPrevious(newNode);
                newNode.getPrevious().setNext(newNode);
                size++;
            }
        }
    }

    public Node deleteAt(int position) {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return null;
        }

        if (position <= 0) {
            System.out.println("Undefined size, size should be greater than 0!");
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

        Node curNode = head.getNext();
        for (int i = 2; i < position; i++)
            curNode = curNode.getNext();
        
        curNode.getNext().setPrevious(curNode.getPrevious());
        curNode.getPrevious().setNext(curNode.getNext());
        size--;

        return curNode;
    }
}