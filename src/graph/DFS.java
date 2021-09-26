package graph;

import java.util.Stack;

public class DFS {

    /**
     * DFS Graph -- keep track of whether the vertex is vosited or not
     *
     * @param g the given graph
     * @return the DFS result String
     */
    public static String dfs(Graph g) {
        StringBuilder result = new StringBuilder();
        //Checking if the graph has no vertices
        if (g.vertices < 1) {
            return result.toString();
        }

        //Boolean Array to hold the history of visited nodes (by default-false)
        boolean[] visited = new boolean[g.vertices];

        for (int i = 0; i < g.vertices; i++) {
            //Checking whether the node is visited or not
            if (!visited[i]) {
                dfsVisit(g, i, visited, result);
            }
        }
        return result.toString();
    }

    public static void dfsVisit(Graph g, int source, boolean[] visited, StringBuilder result) {

        //Create Stack(Implemented in previous lesson) for Depth First Traversal and Push source in it
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(source);

        //Traverse while stack is not empty
        while (!stack.isEmpty()) {

            //Pop a vertex/node from stack and add it to the result, mark it as visited
            int current_vertex = stack.pop();
            result.append(String.valueOf(current_vertex));
            visited[current_vertex] = true;

            //Get adjacent vertices to the current_node from the array,
            //and if they are not already visited then push them in the stack
            DoublyLinkedList<Integer>.Node temp = null;
            if (g.adjacencyList[current_vertex] != null)
                temp = g.adjacencyList[current_vertex].headNode;

            while (temp != null) {
                if (!visited[temp.data]) {
                    stack.push(temp.data);
                }
                temp = temp.nextNode;
            }
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("DFS traversal of Graph1 : " + dfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 4);
        g2.addEdge(1, 2);
        g2.addEdge(4, 3);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("DFS traversal of Graph2 : " + dfs(g2));
    }
}
