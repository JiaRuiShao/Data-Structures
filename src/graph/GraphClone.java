package graph;

public class GraphClone {
    Graph cloneGraph(Graph g) {
        if (g == null || g.vertices < 1) {
            return null;
        }
        Graph result = new Graph(g.vertices);
        for (int vertex = 0; vertex < g.vertices; vertex++) {
            if (g.adjacencyList[vertex] != null) {
                DoublyLinkedList<Integer>.Node curr = g.adjacencyList[vertex].getHeadNode();
                while (curr != null) {
                    result.addEdge(vertex, curr.data);
                    curr = curr.nextNode;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        GraphClone graph = new GraphClone();
        Graph g=new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(3,4);
        g.addEdge(1,4);
        g.printGraph();
        System.out.println();
        graph.cloneGraph(g).printGraph();
    }
}
