package Graphs.AdjacencyMatrix;

public class Graph {

    private int V;
    private int E;
    private int adjacencyMatrix[][];

    public Graph(int vertices) {
        this.V = vertices;
        this.E = 0;
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int x, int y) {
        this.adjacencyMatrix[x][y] = 1;
        this.adjacencyMatrix[y][x] = 1;
        E++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (int w : adjacencyMatrix[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        System.out.println(graph);
    }
}
