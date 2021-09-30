package graph;

import java.util.*;

class TopologicalSort {

    /**
     * TopologicalSort -- provide a partial ordering among the vertices of the graph
     * such that if there is an edge from U to V then U ≤ V
     *
     * Time: O(3V + 2E) = O(V + E)
     * Space: O(3V + E) = O(V + E)
     *
     * @param vertices the graph vertex number
     * @param edges the edges of the given graph
     * @return the topologicalSort result
     */
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (vertices < 1 || edges == null || edges[0].length == 0) {
            return sortedOrder;
        }

        // 1 - add the edges and their frequencies to a hashmap
        Map<Integer, Integer> map = new HashMap<>(); //used to store the num of times a vertex is an adjacent vertex
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>(); // used to store the vertex and its adjacent edges
        for (int v = 0; v < vertices; v++) { // O(V)
            map.put(v, 0);
            adjacencyList.put(v, new ArrayList<>());
        }
        for (int[] edge : edges) { // O(E)
            map.put(edge[1], map.get(edge[1]) + 1);
            adjacencyList.get(edge[0]).add(edge[1]);
        }

        // 2 - find all the source vertices, and add them to the result sortedOrder list
        // the source vertices are the ones whose map.get(vertex) == 0
        Queue<Integer> sources = new LinkedList<>();
        for (int vertex : map.keySet()) { // O(V)
            if (map.get(vertex) == 0) { // source vertex who has no incoming edge and has only outgoing edges
               sources.offer(vertex);
            }
        }

        // 3 - find the next source vertices
       while (!sources.isEmpty()) { // O(V + E)
           int temp = sources.poll();
           sortedOrder.add(temp);
           List<Integer> adjacentEdges = adjacencyList.get(temp);
           for (int edge : adjacentEdges) {
               map.put(edge, map.get(edge) - 1); // reduce the source edges frequencies
               if (map.get(edge) == 0) {
                   sources.offer(edge);
               }
           }
       }

        if (sortedOrder.size() != vertices) { // topological sort is not possible as the graph has a cycle
            return new ArrayList<>();
        }

        return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0}, new int[]{2, 1}});
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][]{new int[]{4, 2}, new int[]{4, 3}, new int[]{2, 0},
                new int[]{2, 1}, new int[]{3, 1}});
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][]{new int[]{6, 4}, new int[]{6, 2}, new int[]{5, 3},
                new int[]{5, 4}, new int[]{3, 0}, new int[]{3, 1}, new int[]{3, 2}, new int[]{4, 1}});
        System.out.println(result);
    }
}