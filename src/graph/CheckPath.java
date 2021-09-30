/*
 * In this problem, you have to implement checkPath() method to take a graph
 * and two vertices as an input and find out if a path exists between them.
 */

package graph;

import java.util.Stack;

public class CheckPath {
    boolean isPathExist(Graph g, int v1, int v2) {
        if (g == null || g.vertices < 2) {
            return false;
        }
        return pathExist(g, v1, v2);
    }

    private boolean pathExist(Graph g, int source, int destination) {
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[g.vertices];
        stack.push(source);
        int temp;

        while (!stack.isEmpty()) {
            temp = stack.pop();
            isVisited[temp] = true;

            if (g.adjacencyList[temp] != null) {
                DoublyLinkedList<Integer>.Node curr = g.adjacencyList[temp].getHeadNode();
                while (curr != null) {
                    if (curr.data.equals(destination)) {
                        return true;
                    }
                    if (!isVisited[curr.data]) {
                        isVisited[curr.data] = true;
                        stack.push(curr.data);
                    }
                    curr = curr.nextNode;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(9);
        g1.addEdge(0,2);
        g1.addEdge(0,5);
        g1.addEdge(2,3);
        g1.addEdge(2,4);
        g1.addEdge(5,3);
        g1.addEdge(5,6);
        g1.addEdge(3,6);
        g1.addEdge(6,7);
        g1.addEdge(6,8);
        g1.addEdge(6,4);
        g1.addEdge(7,8);
        g1.printGraph();
        System.out.println("Path exists: " + new CheckPath().isPathExist(g1, 0, 7));
        System.out.println();
        Graph g2 = new Graph(4);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.addEdge(1,3);
        g2.addEdge(2,3);

        g2.printGraph();
        System.out.println("Path exists: " + new CheckPath().isPathExist(g2, 3, 0));
    }
}
