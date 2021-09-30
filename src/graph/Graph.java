package graph;

public class Graph {
    /**
     * Total number of vertices in graph
     */
    int vertices;

    /**
     * An array of linked lists to store adjacent vertices.
     */
    DoublyLinkedList<Integer>[] adjacencyList;

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new DoublyLinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new DoublyLinkedList<>();
        }
    }

    /**
     * Prints Graph (Adjaceny List)
     */
    public void printGraph() {
        System.out.println(">> Adjacency List of Directed Graph <<");
        for (int i = 0; i < vertices; i++) {
            if (adjacencyList[i] != null) {
                System.out.print("|" + i + "| => ");
                DoublyLinkedList<Integer>.Node curr = adjacencyList[i].getHeadNode();
                while (curr != null) {
                    System.out.print("[" + curr.data + "] -> ");
                    curr = curr.nextNode;
                }
                System.out.println("null");
            } else {
                System.out.println("|" + i + "| => " + "null");
            }
        }
    }

    /**
     * Adds an Edge from source vertex to destination vertex; source --> destination
     *
     * @param source source vertex
     * @param destination destination vertex
     */
    public void addEdge(int source, int destination) {
        if (source < vertices && destination < vertices) { // if valid, add at the end
            this.adjacencyList[source].insertAtEnd(destination);
            //for undirected graph uncomment the line below
            //this.adjacencyList[destination].insertAtEnd(source);
        }
    }

    public void addEdgeUndirected(int source, int destination) {
        if (source < vertices && destination < vertices) { // if valid, add at the end
            this.adjacencyList[source].insertAtEnd(destination);
            this.adjacencyList[destination].insertAtEnd(source);
        }
    }

}
