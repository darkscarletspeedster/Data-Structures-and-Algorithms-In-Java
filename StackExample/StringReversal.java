package StackExample;

import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        Stack str = new Stack(sc.next());
        boolean close = true;
        while (close) {
            System.out.println("Select Operation:");
            System.out.println("1. Select New Stack");
            System.out.println("2. Get Reversed String");
            System.out.println("3. Peek");
            System.out.println("4. Print Stack");
            System.out.println("5. Set Max Length");
            System.out.println("6. Remove Max Length");
            System.out.println("7. Push");
            System.out.println("8. Pop");
            System.out.println("9. Check, is Full?");
            System.out.println("10. Check, is Empty?");
            System.out.println("11. Exit");

            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("Enter String: ");
                    str = new Stack(sc.next());
                    break;
                case 2:
                    System.out.println(str.getReversedString());
                    break;
                case 3:
                    System.out.println(str.peek());
                    break;
                case 4:
                    System.out.println(str);
                    break;
                case 5:
                    System.out.println("Enter Length: ");
                    str.setMaxLength(sc.nextInt());
                    break;
                case 6:
                    str.removeMaxLenght();
                    break;
                case 7:
                    System.out.println("Enter Character to push: ");
                    str.push(sc.next().charAt(0));
                    break;
                case 8:
                    System.out.println(str.pop());
                    break;
                case 9:
                    System.out.println(str.printIsFull());
                    break;
                case 10:
                    System.out.println(str.isEmpty());
                    break;
                default:
                    close = false;
                    break;
            }
        }
        sc.close();
    }
}