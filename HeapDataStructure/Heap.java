package HeapDataStructure;

public class Heap {
    private Node[] heapArr;
    private int currentSize;
    private int maxSize; // can be made variable as done in Stack implementation

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        this.heapArr = new Node[maxSize];
        this.currentSize = 0;
    }

    public boolean isFull() {
        return currentSize == heapArr.length;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int getSize() {
        return currentSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void insertNode(int key) {
        if (isFull())
            System.out.println("Heap is Full!!! Could not insert: " + key);
        else {
            Node nodeToInsert = new Node(key);
            heapArr[currentSize] = nodeToInsert;
            moveUp(currentSize);
            currentSize++;
            System.out.println("Node with value " + key + " inserted!!!!");
        }
    }

    /*
     * to swap up the order if child is greater than parent
     */
    public void moveUp(int index) {
        int parentIndex = (index - 1) / 2; // as divide by 2 and integer variable 0.5 will always be floored
                                           // parentIndex florring is important

        Node swappingNode = heapArr[index];

        while (index > 0 && swappingNode.getKey() > heapArr[parentIndex].getKey()) {
            heapArr[index] = heapArr[parentIndex];
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }

        heapArr[index] = swappingNode;
    }

    public void deleteNode() {
        if (isEmpty())
            System.out.println("Heap is Empty!!!");
        else {
            Node deletedNode = heapArr[0];
            heapArr[0] = heapArr[--currentSize]; // first reduces size and then returns the value at that index
            heapArr[currentSize] = null; // the last element has been moved up so value has to be nulled

            moveDown(0); // as last element was put here it has to be smaller than it's children
            System.out.println("Node deleted: " + deletedNode);
        }
    }

    /*
     * to swap down the order if parent is smaller than child
     */
    public void moveDown(int index) {
        if (currentSize != 0 || currentSize != 1) {
            int largerIndex = 0;
            Node swappingNode = heapArr[index];

            // given that it won't go below last row as last row elements
            // don't have children to match with.
            // And here every node has only 2 chilren so
            // last row will have 1/2th the elements of the tree
            // if each node had 3 chidren it would be divided by 3
            while (index < currentSize / 2) {
                // while loop used instead of recursion as traversing has to be done only on one side
                int leftChildIndex = 2*index + 1;
                int rightChildIndex = leftChildIndex + 1;

                // as right child is always greater than left only that is conpared to
                // current size as in for the case when left size becomes the last element
                // right will go beyond current size
                if (heapArr[rightChildIndex].getKey() > heapArr[leftChildIndex].getKey() && rightChildIndex < currentSize)
                    largerIndex = rightChildIndex;
                else if (leftChildIndex < currentSize) // for safety
                    largerIndex = leftChildIndex;
                else {
                    System.out.println("Ruined!!!");
                    break;
                }

                // no need to swap
                if (swappingNode.getKey() > heapArr[largerIndex].getKey())
                    break;

                heapArr[index] = heapArr[largerIndex];
                index = largerIndex;
            }

            heapArr[index] = swappingNode;
        }
    }

    public void displayHeap() {
        if (isEmpty())
            System.out.println("Heap is Empty!!!!");
        else {
            System.out.println("Current Heap: ");

            int spaceCounter = 2;
            
            // as a tree of 2 children need to count spaces to highest nearest to maxSize 
            // 2's multiple for proper spacing
            while (spaceCounter <= maxSize)
                spaceCounter *= 2;

            int numberOfElements = 1; // from root

            // loop runs till current size only making extra fields empty
            for (int i = 0; i < currentSize; ) { // i++ done in second loop
                String spaces = createSpaces(spaceCounter - 1);
                System.out.print(spaces);

                for (int j = 0; j < numberOfElements && i < currentSize; j++) {
                    String value = heapArr[i].toString();
                    System.out.print(value.length() == 1 ? " " + value : value);

                    if (j != numberOfElements - 1)
                        System.out.print(spaces + spaces);

                    i++;
                }
                System.out.println();
                spaceCounter /= 2;
                numberOfElements *= 2;
            }
            System.out.println();
        }
    }

    private String createSpaces(int num) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num; i++)
            builder.append(" ");

        return builder.toString();
    }

    public boolean searchNode(int key) {
        if (isEmpty()) {
            System.out.println("Heap is Empty");
            return false;
        } else {
            if (key == heapArr[0].getKey())
                return true;
            else
                return searchedNode(0, key);
        }
    }

    private boolean searchedNode(int index, int key) {
        int leftChildIndex = 2*index + 1;
        int rightChildIndex = leftChildIndex + 1;
        boolean found = false;
        if (leftChildIndex < currentSize && key <= heapArr[leftChildIndex].getKey()) {
            if (heapArr[leftChildIndex].getKey() == key)
                return true;
            
            found = searchedNode(leftChildIndex, key);
        }

        if (leftChildIndex < currentSize && key <= heapArr[rightChildIndex].getKey()) {
            if (heapArr[rightChildIndex].getKey() == key)
                return true;
            
            found = searchedNode(rightChildIndex, key);
        }

        return found;
    }
}