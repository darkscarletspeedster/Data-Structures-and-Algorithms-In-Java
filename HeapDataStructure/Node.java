package HeapDataStructure;

public class Node {
    private int key;

    public Node (int key) {
        this.key = key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    @Override
    public String toString() {
        return String.valueOf(key);
    }

    @Override
    public boolean equals(Object obj) {
        Node nodeObj = (Node)obj;
        return key == nodeObj.getKey();
    }
}