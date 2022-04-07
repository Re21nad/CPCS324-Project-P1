
package javaDoc;
 class Edge implements Comparable<Edge>{
     /**
      * This class for make the edges. 
      * @author renad, daliah, taif.
      */
     // Create data fields.
 int weight;
 Vertex source;
 Vertex target; 
 Vertex parent;
 
 /**
  * Constructor and initialize of variables.
  * @param wieght
  * @param source
  * @param target
  * @param parent
  */
 
 // Create constructors.
 public Edge(){}
 
 public Edge(Vertex source, Vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
        this.parent=source;
    }
 // Method for comparator.
 public int compareTo(Edge other) {
        return weight - other.weight;
    }

    @Override
    
    // Print the edges.
    public String toString() {
        return this.source.label + "---" + this.target.label + " :" + weight;
    }}