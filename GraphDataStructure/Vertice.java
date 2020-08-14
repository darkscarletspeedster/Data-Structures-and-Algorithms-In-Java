package GraphDataStructure;

import java.util.ArrayList;

public class Vertice<T> {
    private T name; // storing vertice name
    private ArrayList<T> connectedVertices; // vertices connected to it

    public Vertice(T name) {
        this.name = name;
        this.connectedVertices = new ArrayList<>();
    }

    public T getName() {
        return name;
    }

    public void addNeighbour(T neighbour) {
        if (!connectedVertices.contains(neighbour))
            connectedVertices.add(neighbour);
    }

    public ArrayList<T> getNeighbours() {
        ArrayList<T> clonedList = new ArrayList<>(); // made so that original list is not manupulated
        clonedList.addAll(this.connectedVertices);
        return clonedList;
    }
}