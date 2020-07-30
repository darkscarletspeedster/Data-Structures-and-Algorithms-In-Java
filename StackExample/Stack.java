package StackExample;

public class Stack {
    private char[] charArray;
    private int top;
    private int maxLength;
    private boolean isMaxLengthPresent;

    public Stack(String str) {
        charArray = str.toCharArray();
        top = str.length() - 1;
        removeMaxLenght();
    }

    public String getReversedString() {
        if (isEmpty()) {
            return "Stack is Empty";
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = top; i >= 0; i--) {
                stringBuffer.append(charArray[i]);
            }
            return stringBuffer.toString();
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == charArray.length - 1;
    }

    public boolean printIsFull() {
        if (!isMaxLengthPresent)
            return false;
        else
            return isFull();
    }

    public char peek() {
        return isEmpty() ? ' ' : charArray[top];
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return ' ';
        } else {
            int oldTop = top;
            top--;
            return charArray[oldTop];
        }
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
        isMaxLengthPresent = true;
    }

    public void removeMaxLenght() {
        System.out.println("No Limit");
        maxLength = 0;
        isMaxLengthPresent = false;
    }

    public void push(char c) {
        if ((isFull() && top >= maxLength - 1) || (!isFull() && top >= maxLength - 1))
            System.out.println("Stack is Full! Remove Max Lenght to operate unlimited!");
        else if (!isFull()) {
            top++;
            charArray[top] = c;
        } else {
            char[] newArray = new char[charArray.length + 10];
            if (isMaxLengthPresent) {
                newArray = new char[charArray.length + maxLength - top - 1];
            }

            for (int i = 0; i < charArray.length; i++) {
                newArray[i] = charArray[i];
            }
            charArray = newArray;
            top++;
            charArray[top] = c;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            stringBuilder.append(charArray[i]);
        }
        return stringBuilder.toString();
    }

}