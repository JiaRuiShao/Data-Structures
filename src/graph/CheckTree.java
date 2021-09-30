package graph;

import java.util.Stack;

class CheckTree {

    /**
     * Check two things:
     * 1 - whether there is a mother vertex that connect all the other vertices
     * 2 - whether there is a cycle
     * That means, all nodes/vertices can be visited only once
     *
     * Time: O(V + E)
     * Space: O(V * (V + E)) = O(V^2 + VE)
     *
     * @param g the given graph
     * @return true if there's a mother vertex and no cycle
     */
    boolean isTree(Graph g) {
        if (g == null || g.vertices < 1) {
            return false;
        }
        for (int vertex = 0; vertex < g.vertices; vertex++) {
            if (isTreeHelper(g, vertex)) {
                return true;
            }
        }
        return false;
    }

    boolean isTreeHelper(Graph g, int vertex) {
        Stack<Integer> stack = new Stack<>(); // store the passed vertices
        boolean[] isVisited = new boolean[g.vertices];
        int temp;
        stack.push(vertex);

        while (!stack.isEmpty()) {
            temp = stack.pop();
            if (isVisited[temp]) {
                return false; // if the vertex has been visited before
            } else {
                isVisited[temp] = true;
            }

            if (g.adjacencyList[temp] != null) {
                DoublyLinkedList<Integer>.Node curr = g.adjacencyList[temp].getHeadNode();
                while (curr != null) {
                    stack.push(curr.data);
                    curr = curr.nextNode;
                }
            }
        }
        // check whether all vertices are visited
        for (boolean visited : isVisited) {
            if (!visited) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckTree graph = new CheckTree();

        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(3,4);
        g.printGraph();
        System.out.println("isTree : " + graph.isTree(g));

        Graph g2 = new Graph(4);
        g2.addEdge(0,1);
        g2.addEdge(0,2);
        g2.addEdge(0,3);
        g2.addEdge(3,2);
        g2.printGraph();
        System.out.println("isTree : " + graph.isTree(g2));

        Graph g3 = new Graph(6);
        g3.addEdge(0,1);
        g3.addEdge(0,2);
        g3.addEdge(0,3);
        g3.addEdge(4,5);
        g3.printGraph();
        System.out.println("isTree : " + graph.isTree(g3));
    }
}
