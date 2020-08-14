package GraphDataStructure;

import GraphDataStructure.Graph.GraphType;

public class App {
    public static void main(String[] args) {
        Graph<Integer> directedGraph = new Graph<>(GraphType.DIRECTED);
        Graph<String> undirectedGraph = new Graph<>(GraphType.UNDIRECTED);

        // directed graph manipulation
        System.out.println("Directed Graph-");
        directedGraph.displayGraph();
        System.out.println("Current Size: " + directedGraph.graphSize());
        directedGraph.addConnection(1, 2);
        directedGraph.addConnection(1, 3);
        directedGraph.addConnection(1, 4);
        directedGraph.displayGraph();
        directedGraph.addConnection(2, 3);
        directedGraph.addConnection(1, 2);
        directedGraph.addConnection(3, 4);
        directedGraph.addConnection(4, 2);
        directedGraph.displayGraph();
        System.out.println("Current Size: " + directedGraph.graphSize());

        System.out.println();
        System.out.println();

        // undirected graph manipulation
        System.out.println("Undirected Graph-");
        undirectedGraph.displayGraph();
        System.out.println("Current Size: " + undirectedGraph.graphSize());
        undirectedGraph.addConnection("Mumbai", "Pune");
        undirectedGraph.addConnection("Mumbai", "Surat");
        undirectedGraph.addConnection("Mumbai", "Delhi");
        undirectedGraph.displayGraph();
        undirectedGraph.addConnection("Pune", "Surat");
        undirectedGraph.addConnection("Mumbai", "Pune");
        undirectedGraph.addConnection("Surat", "Delhi");
        undirectedGraph.addConnection("Delhi", "Haryana");
        undirectedGraph.displayGraph();
        System.out.println("Current Size: " + undirectedGraph.graphSize());
    }
}