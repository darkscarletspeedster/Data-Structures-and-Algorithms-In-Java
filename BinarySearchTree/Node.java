package BinarySearchTree;

public class Node {
    private int key;
    private String value;
    Node rightNode;
    Node leftNode;

    public Node (int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key + ":" + value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        Node compareNode = (Node)obj;
        return (key == compareNode.getKey()) && (value.equals(compareNode.getValue()))
        && rightNode.equals(compareNode.rightNode) && leftNode.equals(compareNode.leftNode);
    }
}