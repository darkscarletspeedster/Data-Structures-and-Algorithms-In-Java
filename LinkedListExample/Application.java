package LinkedListExample;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean open = true;
        SinglyLinkedList linkedList = new SinglyLinkedList();
        while (open) {
            System.out.println("Select Operation: ");
            System.out.println("1.  Display List");
            System.out.println("2.  List Size");
            System.out.println("3.  Insert at first position");
            System.out.println("4.  Insert at last position");
            System.out.println("5.  Insert at given position");
            System.out.println("6.  Delete at first position");
            System.out.println("7.  Delete at last position");
            System.out.println("8.  Delete at given position");
            System.out.println("9.  Check if list is Empty");
            System.out.println("10. Exit");
            int n = sc.nextInt();
            int data = 0;
            int position = 0;
            Node node = null;
            switch (n) {
                case 1:
                    linkedList.displayList();
                    break;
                case 2:
                    System.out.println(linkedList.getListSize());
                    break;
                case 3:
                    System.out.println("Enter Data to Insert: ");
                    data = sc.nextInt();
                    linkedList.insertFirst(data);
                    break;
                case 4:
                    System.out.println("Enter Data to Insert: ");
                    data = sc.nextInt();
                    linkedList.insertLast(data);
                    break;
                case 5:
                    System.out.println("Enter Data to Insert: ");
                    data = sc.nextInt();
                    System.out.println("Enter position to Insert At: ");
                    position = sc.nextInt();
                    linkedList.insertAt(data, position);
                    break;
                case 6:
                    node = linkedList.deleteFirst();
                    System.out.println(node == null ? "List is Empty!" : node);
                    break;
                case 7:
                    node = linkedList.deleteLast();
                    System.out.println(node == null ? "List is Empty!" : node);
                    break;
                case 8:
                    System.out.println("Enter position to Delete At: ");
                    position = sc.nextInt();
                    linkedList.deleteAt(position);
                    break;
                case 9:
                    System.out.println(linkedList.isEmpty());
                    break;
                default:
                    open = false;
                    break;
            }
        }       
        sc.close();
    }
}