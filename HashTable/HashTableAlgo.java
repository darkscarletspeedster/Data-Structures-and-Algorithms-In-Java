package HashTable;

import java.lang.Math;

public class HashTableAlgo {
    private String[] hashArray;
    private int hashArraySize; // can be dynamic but to keep this simple meaking fixed
    private int currentSize;

    public HashTableAlgo(int hashArraySize) {
        if (hashArraySize > 2) {
            if (isPrime(hashArraySize))
                this.hashArraySize = hashArraySize;
            else {
                this.hashArraySize = getNextPrime(hashArraySize);
                System.out.println("Given size: " + hashArraySize + " not a prime number!");
                System.out.println("Size changed to: " + this.hashArraySize);
            }
        } else {
            this.hashArraySize = 3;
            System.out.println("Given size two small.");
            System.out.println("Size changed to: " + this.hashArraySize);
        }

        hashArray = new String[this.hashArraySize];
        currentSize = 0;
    }

    private boolean isPrime(int num) {
        int numSqrt = (int) Math.sqrt(num);

        for (int i = 2; i <= numSqrt; i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }

    private int getNextPrime(int num) {
        for (int i = num + 1; true; i++) // will run till a prime num not found
            if (isPrime(i))
                return i;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == hashArraySize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public int getMaxSize() {
        return hashArraySize;
    }

    public void insert(String value) {
        if (isFull())
            System.out.println("Hash Table is Full!!");
        else {
            int index = hashFunctionPrimary(value);
            
            if (hashArray[index] == null)
                hashArray[index] = value;
            else {
                int step = hashFunctionSecondary(value);
                while (hashArray[index] != null) {
                    if (hashArray[index].equals(value))
                        return;
                    index += step;
                    index %= hashArraySize;
                }
                hashArray[index] = value;
            }
            System.out.println("Value inserted: " + value);
            currentSize++;
        }
    }

    private int hashFunctionPrimary(String value) {
        int index = value.hashCode();
        index = index % hashArraySize;

        if (index < 0) // as strings return negative hashcodes as well
            index += hashArraySize;

        return index;
    }

    private int hashFunctionSecondary(String value) {
        int index = value.hashCode();
        index = index % hashArraySize;

        if (index < 0)
            index += hashArraySize;

        // logic where it changes from primary function
        // get a prime number smaller than array size
        int primeNum = getPreviousPrime(hashArraySize); // to get step within array size
        return primeNum - (index % primeNum); // to prevent step from being zero
    }

    private int getPreviousPrime(int num) {
        for (int i = num - 1; i > 2; i--) // will run till a prime num not found
            if (isPrime(i))
                return i;

        return 3; // smallest prime number as default
    }

    public boolean deleteValue(String value) {
        if (isEmpty()) {
            System.out.println("Hash table is Empty");
            return false;
        } else {
            int index = hashFunctionPrimary(value);
            if (hashArray[index].equals(value)) {
                hashArray[index] = null;
                currentSize--;
                return true;
            } else {
                int step = hashFunctionSecondary(value);
                int firstIndex = index;
                while (hashArray[index] != null) {
                    if (hashArray[index].equals(value)) {
                        hashArray[index] = null;
                        currentSize--;
                        return true;
                    }

                    index += step;
                    index %= hashArraySize;

                    if (firstIndex == index) // safe check
                        return false;
                }

                return false;
            }
        }
    }

    public void deleteValueAt(int key) {
        if (isEmpty())
            System.out.println("Hash Table is Empty!");
        else if (key > hashArraySize || key < 0)
            System.out.println("Undefined key value!");
        else {
            if (hashArray[key] != null) {
                System.out.println("Deleted Value: " + hashArray[key - 1] + " at key: " + key);
                hashArray[key] = null;
                currentSize--;
            } else
                System.out.println("No such Key Found!");
        }
    }

    public int searchValue(String value) {
        if (isEmpty()) {
            System.out.println("Hash table is Empty");
            return -1;
        } else {
            int index = hashFunctionPrimary(value);
            if (hashArray[index].equals(value))
                return index;
            else {
                int step = hashFunctionSecondary(value);
                int firstIndex = index;
                while (hashArray[index] != null) {
                    if (hashArray[index].equals(value))
                        return index;

                    index += step;
                    index %= hashArraySize;

                    if (firstIndex == index) // safe check
                        return -1;
                }

                return -1;
            }
        }
    }

    public String getValueAt(int key) {
        if (isEmpty()) {
            System.out.println("Hash Table is Empty!");
            return null;
        } else if (key > hashArraySize || key < 0) {
            System.out.println("Undefined key value!");
            return null;
        } else {
            if (hashArray[key] != null)
                return hashArray[key];
            else {
                System.out.println("No such Key Found!");
                return null;
            }
        }
    }

    public void displayTable() {
        if (isEmpty())
            System.out.println("Hash Table is Empty!");
        else
            for (int i = 0; i < hashArraySize; i++)
                if (hashArray[i] != null)
                    System.out.println("Key: " + i + " - Value: " + hashArray[i]);
    }
}