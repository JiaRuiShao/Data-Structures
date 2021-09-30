/*
 * A cycle is formed when a few vertices are connected in such a way that they make a loop.
 * In this problem, try to detect whether there's a cycle given a directed graph.
 */

package graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class DetectCycle {

    /**
     * Time: O(V + E)
     * Space: Math.max(O(v), O(E))
     *
     * @param g the given directed graph
     * @return true if a cycle is found; false if not
     */
    boolean detectCycle(Graph g) {
        // check corner case
        if (g.vertices < 1) {
            return false;
        }

        // use a boolean arr to skip the passed non-cyclic vertices
        boolean[] isVisited = new boolean[g.vertices]; // default is false

        for (int vertex = 0; vertex < g.vertices; vertex++) {
            if (!isVisited[vertex] && isCycle(g, vertex, isVisited)) {
                return true;
            }
        }

        return false;
    }

    private boolean isCycle(Graph g, int vertex, boolean[] isVisited) {
        int temp;
        Stack<Integer> stack = new Stack<>(); // Space: O(E)
        Set<Integer> verticesConnected = new HashSet<>(); // Space: O(V)

        stack.push(vertex);
        isVisited[vertex] = true;

        while (!stack.isEmpty()) {
            temp = stack.pop();
            if (verticesConnected.contains(temp)) {
                return true;
            } else {
                verticesConnected.add(temp);
            }

            if (g.adjacencyList[temp] != null) {
                DoublyLinkedList<Integer>.Node curr = g.adjacencyList[temp].getHeadNode();
                while (curr != null) {
                    stack.push(curr.data);
                    isVisited[curr.data] = true;
                    curr = curr.nextNode;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycle cycle = new DetectCycle();
        Graph g1 = new Graph(4);
        g1.addEdge(0,1);
        g1.addEdge(1,2);
        g1.addEdge(1,3);
        g1.addEdge(3,0);
        g1.printGraph();
        System.out.println(cycle.detectCycle(g1));

        System.out.println();
        Graph g2 = new Graph(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.printGraph();
        System.out.println(cycle.detectCycle(g2));
    }
}
