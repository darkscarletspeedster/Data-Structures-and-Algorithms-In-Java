package BinarySearchTree;

public class App {
    public static void main(String[] args) {

        // For Operations to work in O(logn) the tree should always be balanced
        BTSClass btsClass = new BTSClass();
        btsClass.insertNode(50, "Fifty");
        btsClass.insertNode(10, "Ten");
        btsClass.insertNode(3, "Three");
        btsClass.insertNode(67, "Sixty-Seven");
        btsClass.insertNode(80, "Eighty");
        btsClass.insertNode(75, "Seventy-Five");
        btsClass.insertNode(25, "Twenty-Fine");
        btsClass.insertNode(10, "Ten");
        btsClass.insertNode(12, "Twelve");
        btsClass.insertNode(5, "Five");

        System.out.println("Our Tree: ");
        btsClass.displayTree();

        System.out.println("Min: " + btsClass.getMinNode());
        System.out.println("Max: " + btsClass.getMaxNode());

        System.out.println("Deleted: " + btsClass.deleteNode(3));
        System.out.println("Deleted: " + btsClass.deleteNode(80));

        System.out.println("Min: " + btsClass.getMinNode());
        System.out.println("Max: " + btsClass.getMaxNode());

        btsClass.insertNode(90, "Ninty");
        System.out.println("Inserted 90");
        btsClass.insertNode(1, "One");
        System.out.println("Inserted 1");

        System.out.println("Min: " + btsClass.getMinNode());
        System.out.println("Max: " + btsClass.getMaxNode());

        System.out.println("Our Tree: ");
        btsClass.displayTree();

        System.out.println("Deleted: " + btsClass.deleteNode(10));
        System.out.println("Deleted: " + btsClass.deleteNode(101));

        System.out.println("Our Tree: ");
        btsClass.displayTree();
    }
}