//this class for create a new graph 
package javaDoc;
import java.util.LinkedList;
import java.util.Random;

public class Graph{
    
    /**
      * This class for make the graph.
      * @author renad, daliah, taif.
      */
    
    // Create data feilds.
int veticesNo;
int edgeNo;
boolean isDigraph;
Vertex vertex;
Edge edge;
LinkedList<Edge>[] edges;
Vertex[] adjvertices;

/**
  * Constructor and initialize of variables.
  * @param veticesNo
  * @param edgeNo
  * @param isDigraph
  * @param vertex
  * @param edge
  * @param edges
  * @param adjvertices
  */

 // Create constructor.
 public Graph(int vertices, int edgess,boolean isDigraph) {
        this.veticesNo = vertices;
        this.edgeNo = edgess;
        this.isDigraph = isDigraph;
        this.adjvertices=new Vertex[vertices];
        for (int i = 0; i < vertices; i++) {
            adjvertices[i] = new Vertex(i);}}
  
//******************************************* Start addEdge() *********************************************************
 public void addEdge(Vertex v, Vertex u, int w) {
     
        Edge edge = new Edge(v, u, w);// Create a class edge.
        v.adjlist.add(edge); // Add edges.
    if (!isDigraph) { // Check if it is direct or not.
          edge = new Edge(u, v, w);
         u.adjlist.add(edge);} }
 //******************************************* End addEdge() *********************************************************
 
 //******************************************* Start make_graph() *********************************************************
 public void make_graph() {
     // object from random for the graph 
        Random random = new Random();
        // Take tha random no. of weight and add edges.
        for (int i = 0; i < veticesNo - 1; i++) {
            int r_number = random.nextInt(10) + 1;
            addEdge(adjvertices[i], adjvertices[i + 1], r_number);}
        
        int reminder = edgeNo - (veticesNo - 1); // Find the reminder.

        for (int i = 0; i < reminder; i++) {
            // create the source and target from Vertex class 
             Vertex source = adjvertices[random.nextInt(veticesNo)];Vertex target = adjvertices[random.nextInt(veticesNo)];
             int weight = random.nextInt(10) + 1; // Take the random weight.
             
            if (source==target || isConnected(source, target)) {i--;} // Check if the source and target is equal and is connected to each other, otherwise add new edges.
                
            else{
            addEdge(source, target, weight);}}}
 
 //******************************************* Start isConnected() *********************************************************
 public boolean isConnected(Vertex Source, Vertex target) {
     // Check if the edge is connected to each other.
      for (Edge edge : Source.adjlist) {
               if (edge.target == target) {
                   return true;}}
       return false;}
 //******************************************* End isConnected() *********************************************************
 
 
}