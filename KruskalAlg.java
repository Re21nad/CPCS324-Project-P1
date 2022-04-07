package javaDoc;

import java.util.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
 public class KruskalAlg extends MSTAlgorithm{

     /**
      * This class for Kruskal algorithm.
      * @author renad, daliah, taif.
      */
     
    // Create constructor.
    public KruskalAlg( Graph graph) {
        super(graph);}
    
    //******************************************* Start kruskal() *********************************************************
    public void kruskal(Graph graph) {
        
        //  compute time in nano
        long StartTime = System.nanoTime();
       
        int num = 0;
        
        //create the array of parent from the edge class
        Edge[] parent = new Edge[graph.adjvertices.length];
        // linked list for mst
        LinkedList<Edge> tree = new LinkedList<>();
        //using asList method in Array class :
        Arrays.asList(graph.adjvertices.clone());
         // by using PriorityQueuewe can convert the array to linked list 
        PriorityQueue<Edge> Q_convertor = new PriorityQueue<>( Comparator.comparingInt(o -> o.weight));
        
        // start fill the PriorityQueue 
        for (int i = 0; i < graph.adjvertices.length; i++) {
            for (int j = 0; j < graph.adjvertices[i].adjlist.size() ;j++) {
                Q_convertor.add(graph.adjvertices[i].adjlist.get(j));}
        }
        
        // fill the array :
        for (int i = 0; i < graph.adjvertices.length; i++) {
            parent[i]=new Edge();}
        //make a set from parent
        makeSet(parent);
        
        //System.out.println(Q_convertor.size());
        for (int vertex = 0; vertex < graph.adjvertices.length; ++vertex) {  
            parent[vertex].parent .label= vertex;  
            parent[vertex].weight = 0;  
        }
        while (num < graph.adjvertices.length - 1 && !Q_convertor.isEmpty()) {
            Edge edge = Q_convertor.remove();
            
            // avoid cycles by using method find 
            int set1 = find(parent, edge.source.label); int set2 = find(parent, edge.target.label);
            if (set1 == set2) {
              //cycle,skip it
            }
                else {
                
                tree.add(new Edge(edge.source,edge.target,edge.weight) );
                num++;
                union(parent, set1, set2);}}
        
       // stop timer
        long FinishTime = System.nanoTime();
       // print the cost
        System.out.println("Total runtime of Kruskal's Algorithm: " + TimeUnit.NANOSECONDS.toMillis(FinishTime - StartTime) + " ms");
       
        displayResultingMST(tree);}
    //******************************************* End kruskal() *********************************************************
    
    //******************************************* Start makeSet() *********************************************************
      // makeset method 
    public void makeSet(Edge[] parent) {
        for (int i = 0; i < parent.length; i++) {
            parent[i].source = new Vertex(); 
            parent[i].source.label=i;
            parent[i].parent= new Vertex();
            parent[i].parent.label=i;}}
    //******************************************* End makeSet() *********************************************************
             
    //******************************************* Start find() *********************************************************
      // the find method to return a vertex
    public int find(Edge[] parent, int vertex) {
        if (parent[vertex].source.label != vertex) {
            return find(parent, parent[vertex].source.label); }; return vertex;}
    //******************************************* End find() *********************************************************
    
    //******************************************* Start union() *********************************************************
      // union algorithm 
   public void union(Edge[] parent, int set1, int set2) {
        int parent_set1 = find(parent, set1);
        int parent_set2 = find(parent, set2);
        
        parent[parent_set2].source.label = parent_set1;}
   //******************************************* End union() *********************************************************
   
   //******************************************* Start displayResultingMST() *********************************************************
   // Override from MSTAlgorithm class.
    @Override
    public void displayResultingMST(LinkedList<Edge> result) {
        int cost = 0;
        for (int i = 0; i < result.size(); i++) {
            Edge edge = result.get(i); cost += edge.weight;}
        System.out.println("Minimum Spanning Tree Cost = " + cost);
        System.out.println("___________________________________________________________________________________");}
    //******************************************* End displayResultingMST() *********************************************************
 }