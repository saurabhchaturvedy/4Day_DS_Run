package Graphs.AdjacencyList;

import java.util.*;

public class Graph {

    private int V;
    private int E;
    private LinkedList<Integer>[] adjacencyList;

    public Graph(int vertices) {
        this.V = vertices;
        this.E = 0;
        this.adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            this.adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int x, int y) {
        this.adjacencyList[x].add(y);
        this.adjacencyList[y].add(x);
        E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (int w : adjacencyList[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void bfs(int node) {
        boolean[] visited = new boolean[this.V];
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.offer(node);

        while (!queue.isEmpty()) {
            Integer poppedNode = queue.poll();
            System.out.print(poppedNode + " ");
            for (int nodeInList : adjacencyList[poppedNode]) {
                if (!visited[nodeInList]) {
                    visited[nodeInList] = true;
                    queue.offer(nodeInList);
                }
            }
        }
    }

    public void dfs(int node) {
        boolean[] visited = new boolean[this.V];
        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Integer poppedNode = stack.pop();

            if (!visited[poppedNode]) {
                visited[poppedNode] = true;
                System.out.print(poppedNode + " ");

                for (int nodeInList : adjacencyList[poppedNode]) {
                    if (!visited[nodeInList]) {
                        stack.push(nodeInList);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"abc");
        map.put(2,"def");
        map.put(3,"ghi");
        map.put(4,"jkl");
        map.put(5,"mno");

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(2, 4);
        System.out.println(graph);
        graph.bfs(0);
        System.out.println();
        graph.dfs(0);
    }
}
