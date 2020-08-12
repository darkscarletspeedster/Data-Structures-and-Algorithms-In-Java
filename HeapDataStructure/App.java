package HeapDataStructure;

public class App {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.displayHeap();

        heap.insertNode(6);
        heap.displayHeap();
        heap.insertNode(10);
        System.out.println("Current Size: " + heap.getSize());
        heap.displayHeap();
        heap.insertNode(25);
        heap.displayHeap();
        heap.insertNode(18);
        heap.insertNode(1);
        heap.insertNode(37);
        System.out.println("Current Size: " + heap.getSize());
        heap.displayHeap();
        heap.insertNode(17);
        heap.insertNode(15);
        heap.insertNode(10);
        heap.insertNode(20);
        heap.displayHeap();
        heap.insertNode(99);
        heap.displayHeap();
        System.out.println("Current Size: " + heap.getSize());
        System.out.println("Max Size: " + heap.getMaxSize());

        heap.deleteNode();
        heap.displayHeap();
        heap.deleteNode();
        heap.displayHeap();
        heap.deleteNode();
        heap.displayHeap();

        System.out.println(heap.searchNode(10) ? "Element Found!!" : "Element Not Found!!");
        System.out.println(heap.searchNode(99) ? "Element Found!!" : "Element Not Found!!");
        System.out.println(heap.searchNode(2) ? "Element Found!!" : "Element Not Found!!");
        System.out.println(heap.searchNode(1) ? "Element Found!!" : "Element Not Found!!");
    }
}