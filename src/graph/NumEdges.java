/*
 * Get number of edges for undirected graph.
 */

package graph;

public class NumEdges {

    /**
     * For undirected graph, just sum up the size of
     * all the adjacency lists for each vertex and then divide it by 2.
     * It will give us total number of edges in the graph.
     * Time: O(V + E)
     * Space: O(V)
     *
     * @param g the given graph
     * @return the number of edges
     */
    int getEdges(Graph g) {
        if (g == null || g.vertices < 1) {
            return -1;
        }
        int edge = 0;
        for (int vertex = 0; vertex < g.vertices; vertex++) {
            if (g.adjacencyList[vertex] != null) {
                DoublyLinkedList<Integer>.Node curr = g.adjacencyList[vertex].getHeadNode();
                while (curr != null) {
                    edge++;
                    curr = curr.nextNode;
                }
            }
        }
        return edge / 2;
    }

    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdgeUndirected(0,2);
        g.addEdgeUndirected(0,5);
        g.addEdgeUndirected(2,3);
        g.addEdgeUndirected(2,4);
        g.addEdgeUndirected(5,3);
        g.addEdgeUndirected(5,6);
        g.addEdgeUndirected(3,6);
        g.addEdgeUndirected(6,7);
        g.addEdgeUndirected(6,8);
        g.addEdgeUndirected(6,4);
        g.addEdgeUndirected(7,8);

        g.printGraph();
        System.out.println("Number of edges: " + new NumEdges().getEdges(g));
        System.out.println();

        Graph g2 = new Graph(7);
        g2.addEdgeUndirected(1,2);
        g2.addEdgeUndirected(1,3);
        g2.addEdgeUndirected(3,4);
        g2.addEdgeUndirected(3,5);
        g2.addEdgeUndirected(2,5);
        g2.addEdgeUndirected(2,4);
        g2.addEdgeUndirected(4,6);
        g2.addEdgeUndirected(4,5);
        g2.addEdgeUndirected(6,5);

        g2.printGraph();
        System.out.println("Number of edges: " + new NumEdges().getEdges(g2));
    }
}
