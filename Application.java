// code for Algorithm project
package javaDoc;
import java.util.*;
public class Application {
    /**
      * This is the main class.
      * @author renad, daliah, taif.
      */
    
    static Scanner input = new Scanner(System.in); // Create a static scanner.
    public static void main(String[] args) {
        // Print a header.
        System.out.println("\tWelcome to the program!\t");
        System.out.println("___________________________________________________________________________________");
        // choices:
        System.out.println("1- Kruskal Algorithm and Prims algorithm using Priority Queue");
        System.out.println("2- Prims algorithm using Min Heap ,and Prim algorithm using Priority Queue");
        // 3 var for the graph
        int Vertices = 0; int Edges = 0; int user_choice = 0;
        
        while (true) {
            //ask user to inter an input 1 or 2 
            System.out.print("You can choose one of these algorithms to print a graph in MST: ");
            user_choice = input.nextInt();
            // wrong input 
            if (user_choice != 1 && user_choice != 2) {
                System.out.println("Invalid input! Try again");
            } else {
                break;}}
         // print all the coices of vertex and edges using n_m method
        n_m();
        System.out.print("Please enter your choice , where n is the number of vertices and m number of edges " );
        int Choice = input.nextInt(); // Enter a choice from user.
        while (true) {
            switch (Choice) { // Take the no. of vertices and edges from the choice.
                case 1:
                    Vertices = 1000;Edges = 10000;CreateGraph(Vertices, Edges, user_choice);break;
                case 2:
                    Vertices = 1000;Edges = 15000;CreateGraph(Vertices, Edges, user_choice);break;
                case 3:
                    Vertices = 1000;Edges = 25000;CreateGraph(Vertices, Edges, user_choice);break;
                case 4:
                    Vertices = 5000;Edges = 15000;CreateGraph(Vertices, Edges, user_choice);break;
                case 5:
                    Vertices = 5000;Edges = 25000;CreateGraph(Vertices, Edges, user_choice);break;
                case 6:
                    Vertices = 10000;Edges = 15000;CreateGraph(Vertices, Edges, user_choice);break;
                case 7:
                    Vertices = 10000;Edges = 25000;CreateGraph(Vertices, Edges, user_choice);break;
                case 8:
                    Vertices = 20000;Edges = 200000;CreateGraph(Vertices, Edges, user_choice);break;
                case 9:
                    Vertices = 20000;Edges = 300000;CreateGraph(Vertices, Edges, user_choice);break;
                case 10:
                    Vertices = 50000;Edges = 1000000;CreateGraph(Vertices, Edges, user_choice);break;
                    
                default:
                    // Print the error massage and try again.
                    System.out.println("Invalid input! Try again!!");} break;}}
    
    //******************************************* Start n_m() *********************************************************
    public static void n_m() {
        System.out.println(" 1: n=1000 ,  m=10000");
        System.out.println(" 2: n=1000 ,  m=15000");
        System.out.println(" 3: n=1000 ,  m=25000");
        System.out.println(" 4: n=5000 ,  m=15000");
        System.out.println(" 5: n=5000 ,  m=25000");
        System.out.println(" 6: n=10000 , m=15000");
        System.out.println(" 7: n=10000 , m=25000");
        System.out.println(" 8: n=20000 , m=200000");
        System.out.println(" 9: n=20000 , m=300000");
        System.out.println("10: n=50000 , m=1000000");
        System.out.println("___________________________________________________________________________________");}
    //******************************************* End n_m() *********************************************************

    //******************************************* Start CreateGraph() *********************************************************
    public static void CreateGraph(int vertices, int edge, int user_choice) {

        for (int i = 1; i <= 10; i++) {
            System.out.println("iteration[" + i + "]:");
            //new object from graph class: 
            Graph graph = new Graph(vertices, edge, false);
            //create a graph with random numbers:
            graph.make_graph();

            // Create the three algorithms.
            KruskalAlg kruskal = new KruskalAlg(graph);
            PQPrimAlg pq = new PQPrimAlg();
           MHPrimAlg mh = new MHPrimAlg(graph);
           
           // For choice 1.
            if (user_choice == 1) {
                System.out.println("Kruskal and Prim priority-queue : ");
                System.out.println();
                // Solve it by two algorithms: Kruskal and Prim(PQ).
                kruskal.kruskal(graph);
                pq.PrimPQ(graph);
            }
                 
             // For choice 2.  
             else if (user_choice == 2) {
                System.out.print("Prim min-heap and Prim priority-queue :");
                System.out.println();
                // Solve it by two algorithms: Prim(PQ) and Prim(min-heap).
                pq.PrimPQ(graph);
                mh.prim_min_heap(graph);               
             }}}
    //******************************************* End CreateGraph() *********************************************************
}