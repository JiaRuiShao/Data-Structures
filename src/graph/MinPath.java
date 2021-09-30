/*
 * Given a undirected graph, find the shortest path between two vertices.
 */

package graph;

import java.util.LinkedList;
import java.util.Queue;

public class MinPath {

    /**
     * ??????
     * We are guaranteed to find the shortest distance to destination,
     * once it has already been visited through the longer path and
     * consequently marked because it won’t be visited the same way again.
     *
     * Time: O(V + E)
     *
     * @param g the graph
     * @param source the source vertex
     * @param destination the destination vertex
     * @return the min path from source to destination
     */
    int findShortestPathLength(Graph g, int source, int destination) {
        if (g == null || g.vertices < 1 || g.adjacencyList[source] == null) {
            return -1;
        }
        if (source == destination) {
            return 0;
        }
        //Boolean Array to hold the history of visited nodes (by default-false)
        //Make a node visited whenever you poll it into queue
        boolean[] visited = new boolean[g.vertices];
        //For keeping track of distance of current_node from source
        int[] distance = new int[g.vertices];
        //Create Queue for Breadth First Traversal and enqueue source in it
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;

        //Traverse while queue is not empty
        while (!queue.isEmpty()) {
            //Dequeue a vertex/node from queue and add it to result
            int current_node = queue.poll();
            //Get adjacent vertices to the current_node from the array,
            //and if they are not already visited then enqueue them in the Queue
            //and also update their distance from source by adding 1 in current_nodes's distance
            DoublyLinkedList<Integer>.Node temp = null;
            if (g.adjacencyList[current_node] != null) {
                temp = g.adjacencyList[current_node].headNode;
            }
            while (temp != null) {
                if (!visited[temp.data]) {
                    queue.offer(temp.data);
                    visited[temp.data] = true;
                    distance[temp.data] = distance[current_node] + 1;
                }
                if (temp.data == destination) {
                    return distance[destination];
                }
                temp = temp.nextNode;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Graph g=new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(3,4);
        g.addEdge(1,4);
        System.out.println(new MinPath().findShortestPathLength(g, 0, 4));
    }
}
