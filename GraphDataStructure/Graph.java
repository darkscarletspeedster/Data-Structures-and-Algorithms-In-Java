package GraphDataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph<T> {
    private HashMap<T, Vertice<T>> vertices;

    public enum GraphType {
        DIRECTED, UNDIRECTED
    }

    private GraphType graphType;

    public Graph(GraphType graphType) {
        this.vertices = new HashMap<>();
        this.graphType = graphType;
    }

    public void addConnection(T source, T destination) {
        if (vertices.containsKey(source))
            vertices.get(source).addNeighbour(destination);
        else {
            Vertice<T> vertice = new Vertice<T>(source);
            vertice.addNeighbour(destination);
            vertices.put(source, vertice);
        }

        if (graphType == GraphType.UNDIRECTED) {
            if (vertices.containsKey(destination))
                vertices.get(destination).addNeighbour(source);
            else {
                Vertice<T> vertice = new Vertice<T>(destination);
                vertice.addNeighbour(source);
                vertices.put(destination, vertice);
            }
        }
    }

    public int graphSize() {
        return vertices.size();
    }

    public void displayGraph() {
        if (vertices.size() == 0)
            System.out.println("Graph is empty!");
        else {
            for (Map.Entry<T, Vertice<T>> entry : vertices.entrySet()) {
                Vertice<T> value = entry.getValue();
                System.out.println("For Node '" + value.getName() + "' neighbours: ");
                ArrayList<T> neighbours = value.getNeighbours();
                for (T neighbour : neighbours) {
                    System.out.println("   " + value.getName() + " --> " + neighbour);
                }
            }
        }
    }
}