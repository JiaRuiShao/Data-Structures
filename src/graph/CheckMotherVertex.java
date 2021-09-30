package graph;

import java.util.Stack;

class CheckMotherVertex {

    /**
     * Time: O(V^2 + VE) when all vertices are mother vertex
     * Space: O(V + V + V + E)
     * @param g the given graph
     * @return the mother vertices
     */
    String findMotherVertex(Graph g) {
        if (g.vertices < 1) {
            return null;
        }
        StringBuilder result = new StringBuilder();

        for (int vertex = 0; vertex < g.vertices; vertex++) {
            if (isMotherVertex(g, vertex)) {
                result.append(vertex).append(" ");
            }
        }
        return result.toString().trim();
    }

    boolean isMotherVertex(Graph g, int vertex) {
        boolean[] isVisited = new boolean[g.vertices]; // default is false
        Stack<Integer> stack = new Stack<>();
        int temp;

        stack.push(vertex);
        while (!stack.isEmpty() && !allVisited(isVisited)) {
            temp = stack.pop();
            isVisited[temp] = true;

            if (g.adjacencyList[temp] != null) {
                DoublyLinkedList<Integer>.Node curr = g.adjacencyList[temp].getHeadNode();
                while (curr != null) {
                    stack.push(curr.data);
                    curr = curr.nextNode;
                }
            }
        }
        // terminate the while loop if stack is empty or we already traverse all vertices
        // in case there's cycle exist & the loop never ends
        return allVisited(isVisited);
    }

    private boolean allVisited(boolean[] isVisited) {
        for (boolean visited : isVisited) {
            if (!visited) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,0);
        g.addEdge(3,1);
        g.printGraph();
        System.out.println("Mother Vertex is: " + new CheckMotherVertex().findMotherVertex(g));

        Graph g2 = new Graph(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.addEdge(2,0);
        g2.printGraph();
        System.out.println("Mother Vertex is: " + new CheckMotherVertex().findMotherVertex(g2));
    }
}
