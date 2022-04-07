
package javaDoc;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
public class PQPrimAlg extends MSTAlgorithm {
    /**
      * This class for make the PQ prim algorithm.
      * @author renad, daliah, taif.
      */
    
    // Create the data feild priority queue.
private PriorityQueue<Edge> pq;
    //cost :
    private int cost;
    
    // Create a constructor.
    public PQPrimAlg() {
        pq = new PriorityQueue<>();
        cost = 0;
        MSTResultList = new LinkedList<>();}

    //******************************************* Start PrimPQ() *********************************************************
    public void PrimPQ(Graph graph) {
        //start time
        long StartTime = System.nanoTime();
        addEdges(graph.adjvertices[0], pq);
        //searsh 
        while (!pq.isEmpty()) {
            //pop :
            Edge short_edge = pq.poll();
           //if its already visited ,skip it
            if (short_edge.target.isVisited) {
                continue;} 
            //add the cost
            cost += short_edge.weight;
            MSTResultList.add(new Edge(short_edge.source,short_edge.target,short_edge.weight  ));
            addEdges(short_edge.target, pq);}
        
        //stop timer
        long FinishTime = System.nanoTime();
        //print time
        System.out.println("Prim's Algorithm time Using Priority Queue: "  + TimeUnit.NANOSECONDS.toMillis(FinishTime - StartTime) + " ms");
        displayResultingMST(MSTResultList);
    }
    //******************************************* End PrimPQ() *********************************************************

    //add all connected edges with 'start' vertex to the priority queue
    void addEdges(Vertex vertex, PriorityQueue pq) {
        vertex.isVisited = true;
        for (Edge edge : vertex.adjlist) {
            if (!edge.target.isVisited) {
                pq.add(edge);
            }}}
    @Override
    //******************************************* Start displayResultingMST() *********************************************************
    public void displayResultingMST(LinkedList<Edge> result) {
        //System.out.println("MST: " + result);
        System.out.println("Minimum Spanning Tree Cost (PQ): " + cost);
         System.out.println("___________________________________________________________________________________");
    }
    //******************************************* End displayResultingMST() *********************************************************
}
