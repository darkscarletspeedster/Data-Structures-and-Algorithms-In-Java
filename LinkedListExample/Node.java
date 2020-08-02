package LinkedListExample;

public class Node {
    private int value;
    private Node next;
    private Node previous; // to be used in doubly linked list only

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node (int value, Node next, Node previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}