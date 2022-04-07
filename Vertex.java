
package javaDoc;
import java.util.LinkedList;
public class Vertex {
    
    /**
      * This class for make the vertices.
      * @author renad, daliah, taif.
      */
    
    // Data feilds.
    int label;       
    boolean isVisited;
    LinkedList<Edge> adjlist;
    
    /**
  * Constructor and initialize of variables.
  * @param label
  * @param isVisited
  * @param adjlist
  */
    
    public Vertex(){}
    public Vertex(int label){
    this.label=label;
    adjlist=new LinkedList<>();}
    
    // addEdge method to add the edge to adjList.
    public void addEdge(Vertex vertex, Integer weight) {
    this.adjlist.add(new Edge(this, vertex, weight));}
}