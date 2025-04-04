package data_structure.graph;
import java.util.*;
public class Graph {

    int node;
    int adjMatrix[][];

    List<List<Integer>>adjlist;
    List<List<Pair>> adjListWeighted;

    static class Pair {
        int vertex;
        int weight;

        Pair(int v, int w) {
            this.vertex = v;
            this.weight = w;
        }

        public String toString() {
            return "(" + vertex + ", " + weight + ")";
        }
    }



    public Graph(int node){
          this.node=node;
        adjMatrix = new int[node][node];

        adjlist=new ArrayList<>();
        adjListWeighted = new ArrayList<>();
        for(int i=0;i<node;i++){
            adjlist.add(new ArrayList<>());
            adjListWeighted.add(new ArrayList<>());
        }
    }

    public void addEdgeWeight(int edges[][],boolean isDirected){

        for(int edge[]:edges){

            int u = edge[0];
            int v=edge[1];
            if(!isDirected){


                adjMatrix[u][v]=1;
                adjMatrix[v][u]=1;
            }else {

                adjMatrix[u][v]=1;

            }

        }
    }

    public void addEdge(int edges[][],boolean isDirected){

        for(int edge[]:edges){

            int u = edge[0];
            int v=edge[1];
            int w= edge[2];
            if(!isDirected){


                adjMatrix[u][v]=w;
                adjMatrix[v][u]=w;
            }else {

                adjMatrix[u][v]=w;

            }

        }
    }

    public void adjlist(int edges[][],boolean isDirected){

        for(int edge[]:edges){

            int u = edge[0];
            int v=edge[1];

            if(!isDirected){

                 adjlist.get(u).add(v);
                 adjlist.get(v).add(u);
            }else {

                adjlist.get(u).add(v);

            }

        }
    }

    public void addEdgeAdjListWeighted(int[][] edges, boolean isDirected) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adjListWeighted.get(u).add(new Pair(v, w));
            if (!isDirected) {
                adjListWeighted.get(v).add(new Pair(u, w));
            }
        }
    }

    public void printAdjListWeighted() {
        for (int i = 0; i < adjListWeighted.size(); i++) {
            System.out.print(i + " -> ");
            for (Pair pair : adjListWeighted.get(i)) {
                System.out.print(pair + " ");
            }
            System.out.println();
        }
    }

    public void printmatrix(){
        for (int i=0;i<adjMatrix.length;i++){
            for(int j=0;j< adjMatrix[0].length;j++){
                System.out.print(adjMatrix[i][j]+ " ");

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
     /*   int edges[][]={{0,2},{0,1},{1,3}};

        Graph graph = new Graph(4);
       graph.addEdge(edges,true);
       graph.printmatrix();

        System.out.println();
        graph.addEdge(edges,false);
        graph.printmatrix();*/


        int[][] edges = {{0, 2}, {0, 1}, {1, 3}};
        int[][] edges2 = {{0, 2, 10}, {0, 1, 5}, {1, 3, 2}};

        Graph graph = new Graph(4);

        System.out.println("Adjacency Matrix (Unweighted Directed):");
        graph.addEdge(edges2, true);
        graph.printmatrix();

        System.out.println("\nAdjacency Matrix (Unweighted Undirected):");
        graph.addEdge(edges2, false);
        graph.printmatrix();

        System.out.println("\nWeighted Adjacency List:");
        graph.addEdgeAdjListWeighted(edges2, false);
        graph.printAdjListWeighted();
    }



}
