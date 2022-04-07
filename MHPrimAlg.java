package javaDoc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MHPrimAlg extends MSTAlgorithm {

    /**
      * This class for HM prim algorithm.
      * @author renad, daliah, taif.
      */
    
    Graph graph; // Create a data feild.
    // Create a constructor.
    public MHPrimAlg(Graph graph) {
        super(graph);
    }

    @Override
    public void displayResultingMST(LinkedList<Edge> result) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Class heap node.
    static class HeapNode {

        int vertex;
        int var;
    }

    // Class min heap.
    static class MinHeap {

        int[] indexes;
        int num;
        int size;
        HeapNode[] min_heap;

        // is empty method.
        public boolean isEmpty() {
            return size == 0;
        }

        // heap size method.
        public int heapSize() {
            return size;
        }

        // Create constructor.
        public MinHeap(int num) {
            this.num = num;
            min_heap = new HeapNode[num + 1];
            size = 0;
            indexes = new int[num];
            min_heap[0] = new HeapNode();
            min_heap[0].var = Integer.MIN_VALUE;
            min_heap[0].vertex = -1;
        }

        //******************************************* Start insert() *********************************************************
        public void insert(HeapNode index) {
            // Insert a heap node.
            size++;
            int index2 = size;
            min_heap[index2] = index;
            indexes[index.vertex] = index2;
            heap_method(index2);
        }
        //******************************************* End insert() *********************************************************

        //******************************************* Start heap_method() *********************************************************
        public void heap_method(int x) {
            // Initialize the parent and current index.
            int parent_index = x / 2;
            int index = x;
            // Check if the min heap of parent is greater than the min heap of current index. swap them. 
            while (index > 0 && min_heap[parent_index].var > min_heap[index].var) {
                HeapNode Node1 = min_heap[index];
                HeapNode Node2 = min_heap[parent_index];

                //swap 
                indexes[Node1.vertex] = parent_index;
                indexes[Node2.vertex] = index;
                swap(index, parent_index);
                // Update the parent and current.
                index = parent_index;
                parent_index = parent_index / 2;
            }
        }
        //******************************************* End heap_method() *********************************************************

        //******************************************* Start min() *********************************************************
        public HeapNode min() {
            // Find the exact min heap node.
            HeapNode min = min_heap[1];
            HeapNode lastNode = min_heap[size];
            indexes[lastNode.vertex] = 1;
            min_heap[1] = lastNode;
            min_heap[size] = null;
            Down(1);
            size--;
            return min;
        }
        //******************************************* End min() *********************************************************

        //******************************************* Start Down() *********************************************************
        public void Down(int k) {
            // Initialize the min, left and right variable.
            int min_k = k;
            int left = 2 * k;
            int right = 2 * k + 1;
            // Check if the min heap is greater then the left node, swap them.
            if (left < heapSize() && min_heap[min_k].var > min_heap[left].var) {
                min_k = left;
            }
            // Check if the min heap is greater then the right node, swap them.
            if (right < heapSize() && min_heap[min_k].var > min_heap[right].var) {
                min_k = right;
            }
            // Check if the min key is not equal the key node.
            if (min_k != k) {
                HeapNode smallestNode = min_heap[min_k];
                HeapNode kNode = min_heap[k];

                // swap 
                indexes[smallestNode.vertex] = k;
                indexes[kNode.vertex] = min_k;
                swap(k, min_k);
                Down(min_k);
            }
        }
        //******************************************* End Down() *********************************************************

        // Swap method.
        public void swap(int a, int b) {
            HeapNode temp = min_heap[a];
            min_heap[a] = min_heap[b];
            min_heap[b] = temp;
        }
    }

    //******************************************* Start prim_min_heap() *********************************************************
    public void prim_min_heap(Graph graph) {
        double StartTime = System.currentTimeMillis();
        int graph_vertices = graph.veticesNo; // No. of vertices.
        boolean[] heap = new boolean[graph_vertices]; // Create a heap.
        MSTResultList2 = new ArrayList<>(); // Create the array list result set.
        // new array from edge class 
        Edge[] set = new Edge[graph_vertices];
        int[] key = new int[graph_vertices]; // new array for key class.
        HeapNode[] heapNodes = new HeapNode[graph_vertices]; // new heap node.
        for (int i = 0; i < graph_vertices; i++) {
            heapNodes[i] = new HeapNode();
            heapNodes[i].vertex = i;
            heapNodes[i].var = Integer.MAX_VALUE;
            set[i] = new Edge();
            set[i].parent = new Vertex();
            set[i].parent.label = -1;
            heap[i] = true;
            key[i] = Integer.MAX_VALUE;
        }
        heapNodes[0].var = 0;

        // fill the min heap
        MinHeap minHeap = new MinHeap(graph_vertices);
        // fill the queue
        for (int i = 0; i < graph_vertices; i++) {
            minHeap.insert(heapNodes[i]);
        }

        // check if it empty
        while (!minHeap.isEmpty()) {
            HeapNode new_node = minHeap.min(); // Find the minimum of min heap.
            int new_node2 = new_node.vertex; // no. of nodes.
            heap[new_node2] = false;
            PriorityQueue<Edge> Priority_Queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight)); // Create a priority queue class.
            for (int i = 0; i < graph.adjvertices[new_node2].adjlist.size(); i++) {
                Edge edge = graph.adjvertices[new_node2].adjlist.get(i); // Create a class edge for adjvertices.
                int node = edge.target.label;// Take the target node.
                Priority_Queue.add(edge); // Add edge to priority queue.
                if (heap[edge.target.label]) {
                    int destination = edge.target.label;
                    int k2 = edge.weight;
                    // Check if the key destination is grater than the key.
                    if (key[destination] > k2) {
                        dec(minHeap, k2, destination);
                        //update the parent node for destination
                        set[destination].parent.label = new_node2;
                        set[destination].weight = k2;
                        key[destination] = k2;
                    }
                }
            }
        }

        double FinishTime = System.currentTimeMillis();
        System.out.println("Total runtime of Prim's Algorithm (Usin MH): " + (FinishTime - StartTime) + " ms.");

        printMST(set);
    }
    //******************************************* End prim_min_heap() *********************************************************

    //******************************************* Start printMST() *********************************************************
    public void printMST(Edge[] set) {
        int min_w = 0;
        for (int i = 1; i < set.length; i++) {
            min_w += set[i].weight;
        }
        System.out.println("Total Minimum Spanning Tree Cost mn: " + min_w);
        System.out.println("___________________________________________________________________________________");
    }
    //******************************************* End printMST() *********************************************************

    //******************************************* Start dec() *********************************************************
    // This method for decrease the node.
    public void dec(MinHeap minHeap, int k2, int vertex) {

        // get the vertex & node
        int n = minHeap.indexes[vertex];
        HeapNode node = minHeap.min_heap[n];
        node.var = k2;
        minHeap.heap_method(n);
    }
    //******************************************* End dec() *********************************************************
}
