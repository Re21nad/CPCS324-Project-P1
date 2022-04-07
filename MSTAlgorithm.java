package javaDoc;

import java.util.LinkedList;
import java.util.*;
import java.util.ArrayList;

// This is the abstract class.
public abstract class MSTAlgorithm {
    /**
      * This class for MST algorithm.
      * @author renad, daliah, taif.
      */

    // Create the linked list and array list.
    LinkedList<Edge> MSTResultList = new LinkedList<>();

    ArrayList<Edge> MSTResultList2 = new ArrayList<Edge>();
    /**
  * Constructor and initialize of variables.
  * @param MSTResultList
  * @param MSTResultList2
  * 
  */
    
    // Create  constructors.

    public MSTAlgorithm() {
    }

    public MSTAlgorithm(Graph graph) {
    }
    // Create the abstruct method.

    public abstract void displayResultingMST(LinkedList<Edge> result);

}
