import java.io.Reader;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *The following program creates a specified number of vertices. Through console
 * entered user input, edges between vertices can be created by connecting
 * the vertices from vertex to vertex with a specified cost of the edge.
 * Enter end or done to finish and print.
 *
 * @author  Aric Schroeder
 * @version 1.0
 * @since   2021-10-14
 */


public class WeightedDirGraph {
    static class Edge{
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static class Graph{
        LinkedList<Edge>[] adjList;

        public Graph(int numVertices) {
            adjList = new LinkedList[numVertices];

            for(int i = 0; i < adjList.length; i++) {
                adjList[i] = new LinkedList<Edge>();
            }
        }

        public void addEdge(int from, int to, int cost){
            Edge edge = new Edge(from, to, cost);
            adjList[edge.from].add(edge);
        }
        public void printGraph(){
            for(int i = 0; i < adjList.length; i++) {
                for(int j = 0; j < adjList[i].size(); j++) {
                    Edge currentEdge = adjList[i].get(j);
                    System.out.print("From " + currentEdge.from + " to " + currentEdge.to + ", Cost: " + currentEdge.cost);
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("How many vertices exist in the graph? ");
        int numOfVertices = Integer.parseInt(reader.readLine());
        System.out.println("Input from, to, then cost. Type 'end' or 'done' to finish.");

        Graph graph = new Graph(numOfVertices);

        boolean isFinished = false;

        while(!isFinished) {
            System.out.print("\tFrom Vertex\t: ");
            String userInput = reader.readLine();

            if(userInput.equals("end") || userInput.equals("done")) {
                isFinished = true;
            } else {
                int fromVertex = Integer.parseInt(userInput);
                System.out.print("\tTo Vertex\t: ");
                int toVertex = Integer.parseInt(reader.readLine());

                System.out.print("\tCost\t\t: ");
                int cost = Integer.parseInt(reader.readLine());

                graph.addEdge(fromVertex, toVertex, cost);
            }
        }
        graph.printGraph();
    }
}
