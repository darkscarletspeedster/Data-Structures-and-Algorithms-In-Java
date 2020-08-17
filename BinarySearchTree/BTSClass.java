package BinarySearchTree;

public class BTSClass {
    private Node root;

    public void insertNode(int key, String value) {
        Node newNode = new Node(key, value);

        if (root == null)
            root = newNode;
        else {
            Node currentNode = root;
            Node parent = null;
            boolean isLeftChild = false;
            while (currentNode != null) {
                parent = currentNode;
                if (newNode.getKey() > currentNode.getKey()) {
                    currentNode = currentNode.rightNode;
                    isLeftChild = false;
                } else {
                    currentNode = currentNode.leftNode;
                    isLeftChild = true;
                }
            }

            if (isLeftChild)
                parent.leftNode = newNode;
            else
                parent.rightNode = newNode;
        }
    }

    public Node getMinNode() {
        Node currentNode = root;
        while (currentNode.leftNode != null)
            currentNode = currentNode.leftNode;
        return currentNode;
    }

    public Node getMaxNode() {
        Node currentNode = root;
        while (currentNode.rightNode != null)
            currentNode = currentNode.rightNode;
        return currentNode;
    }

    public boolean deleteNode(int key) {
        Node currentNode = root;
        Node parent = null;
        boolean isLeftChild = false;

        while (currentNode.getKey() != key) {
            parent = currentNode;
            if (key > currentNode.getKey()) {
                currentNode = currentNode.rightNode;
                isLeftChild = false;
            } else {
                currentNode = currentNode.leftNode;
                isLeftChild = true;
            }

            if (currentNode == null)
                return false;
        }

        // if node to be deleted is a leaf node
        if (currentNode.leftNode == null && currentNode.rightNode == null) {
            if (currentNode == root)
                root = null;
            else if (isLeftChild)
                parent.leftNode = null;
            else
                parent.rightNode = null;

            return true;
        }

        // if node to be deleted has only one direct child
        if (currentNode.leftNode == null) {
            if (currentNode == root)
                root = currentNode.rightNode;
            else if (isLeftChild)
                parent.leftNode = currentNode.rightNode;
            else
                parent.rightNode = currentNode.rightNode;
            return true;
        }
        if (currentNode.rightNode == null) {
            if (currentNode == root)
                root = currentNode.leftNode;
            else if (isLeftChild)
                parent.leftNode = currentNode.leftNode;
            else
                parent.rightNode = currentNode.leftNode;

            return true;
        }

        // if node to be deleted has two nodes
        Node successor = getSuccessor(currentNode);

        if (currentNode == root)
            root = successor;
        else if (isLeftChild)
            parent.leftNode = successor;
        else
            parent.rightNode = successor;

        successor.leftNode = currentNode.leftNode;

        return true;
    }

    private Node getSuccessor(Node nodeToDelete) {
        Node parentSuccessor = nodeToDelete;
        Node successor = nodeToDelete.rightNode;
        while (successor.leftNode != null) {
            parentSuccessor = successor;
            successor = successor.leftNode;
        }

        if (successor != nodeToDelete.rightNode) {
            parentSuccessor.leftNode = successor.rightNode;
            // if not done here and made general, if successor is right of node to delete
            // doing this will point to itself
            successor.rightNode = nodeToDelete.rightNode;
        }

        return successor;
    }

    public void displayTree() {
        if (root == null) {
            System.out.println("Tree is Empty!!");
            return;
        }

        int depth = getMaxdepth(root);
        int arrlength = 2;
        for (int i = 0; i < depth; i++) {
            arrlength *= 2; 
        }
        
        String[] arr = new String[arrlength - 1];
        arr[0] = String.valueOf(root.getKey());
        fillArray(arr, root.leftNode, root.rightNode, 0);

        int spaceCounter = arrlength;
        int numberofElements = 1;
        for (int i = 0; i< arr.length; ) { // i is incremented in second loop
            String spaces = createSpaces(spaceCounter - 1);
            System.out.print(spaces);
            for (int j = 0; j < numberofElements; j++) {
                System.out.print((arr[i].length() == 1 ? " " + arr[i] : arr[i]));
                if (j != numberofElements - 1)
                    System.out.print(spaces + spaces);
                i++;
            }
            numberofElements *= 2;
            spaceCounter /= 2;
            System.out.println();
        }
    }

    private void fillArray(String[] arr, Node leftNode, Node rightNode, int num) {
        if (num >= arr.length - 2)
            return;

        arr[num + 1] = leftNode == null ? "--" : String.valueOf(leftNode.getKey());
        arr[num + 2] = rightNode == null ? "--" : String.valueOf(rightNode.getKey());

        fillArray(arr, leftNode == null ? null : leftNode.leftNode, leftNode == null ? null : leftNode.rightNode, (num + 1) * 2);
        fillArray(arr, rightNode == null ? null : rightNode.leftNode, rightNode == null ? null : rightNode.rightNode, (num + 2) * 2);
    }

    private int getMaxdepth(Node rootNode) {
        if (rootNode.leftNode == null && rootNode.rightNode == null)
            return 0;

        int leftdepth = 0;
        int rightdepth = 0;
        if (rootNode.leftNode != null)
            leftdepth += getMaxdepth(rootNode.leftNode) + 1;
        
        if (rootNode.rightNode != null)
            rightdepth += getMaxdepth(rootNode.rightNode) + 1;

        return leftdepth > rightdepth ? leftdepth : rightdepth;
    }

    private String createSpaces(int num) {
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < num; i++)
            builder.append(" ");

        return builder.toString();
    }
}