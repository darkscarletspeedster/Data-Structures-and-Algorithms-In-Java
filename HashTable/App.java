package HashTable;

public class App {
    public static void main(String[] args) {
        HashTableAlgo hash = new HashTableAlgo(20);

        hash.displayTable();
        System.out.println("Current Size: " + hash.getCurrentSize());
        System.out.println("Is Empty? " + hash.isEmpty());
        System.out.println("Is Full? " + hash.isFull());
        System.out.println("Max Size: " + hash.getMaxSize());

        String value = hash.getValueAt(33);
        System.out.println(value == null ? "Value Not Found!" : "Value: " + value);

        int index = hash.searchValue("Iran");
        System.out.println(index == -1 ? "Value Not Found!" : "Value Found At: " + index);

        hash.deleteValueAt(10);
        System.out.println("Value Deleted: " + hash.deleteValue("Iran"));

        hash.insert("India");
        hash.insert("Australia");
        hash.insert("USA");
        hash.insert("England");
        hash.insert("New Zealand");
        hash.insert("Bhutan");
        hash.insert("Nepal");
        hash.insert("Iran");
        hash.insert("Sri Lanka");
        hash.insert("Bangladesh");
        hash.insert("Canada");
        hash.insert("Singapore");
        hash.insert("Iran");
        hash.insert("India");
        hash.insert("Spain");
        hash.insert("Germany");
        hash.insert("Italy");
        hash.insert("France");
        hash.insert("Iceland");
        hash.insert("Wales");
        hash.insert("Ireland");
        hash.insert("Scotland");
        hash.insert("Afghanistan");
        hash.insert("Russia");
        hash.insert("China");
        hash.insert("West Indies");

        hash.displayTable();
        System.out.println("Current Size: " + hash.getCurrentSize());
        System.out.println("Is Empty? " + hash.isEmpty());
        System.out.println("Is Full? " + hash.isFull());
        System.out.println("Max Size: " + hash.getMaxSize());

        value = hash.getValueAt(33);
        System.out.println(value == null ? "Value Not Found!" : "Value: " + value);
        value = hash.getValueAt(10);
        System.out.println(value == null ? "Value Not Found!" : "Value: " + value);
        value = hash.getValueAt(0);
        System.out.println(value == null ? "Value Not Found!" : "Value: " + value);

        index = hash.searchValue("Iran");
        System.out.println(index == -1 ? "Value Not Found!" : "Value Found At: " + index);

        hash.deleteValueAt(10);
        value = hash.getValueAt(10);
        System.out.println(value == null ? "Value Not Found!" : "Value: " + value);

        System.out.println("Value Deleted: " + hash.deleteValue("Iran"));
        index = hash.searchValue("Iran");
        System.out.println(index == -1 ? "Value Not Found!" : "Value Found At: " + index);

        hash.deleteValueAt(99);

        hash.displayTable();
        System.out.println("Current Size: " + hash.getCurrentSize());
        System.out.println("Is Empty? " + hash.isEmpty());
        System.out.println("Is Full? " + hash.isFull());
        System.out.println("Max Size: " + hash.getMaxSize());
    }
}