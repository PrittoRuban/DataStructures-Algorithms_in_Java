import java.util.LinkedList;

// LinkedList is a class that implements the List interface
// It is a data structure that stores elements in a sequential order
// It is a linear data structure
// It is a collection of nodes where each node contains a data field and a reference to the next node in the sequence

public class LinkedListDS {

    // addFirst() method to add elements to the beginning of the LinkedList
    // addLast() method to add elements to the end of the LinkedList
    // add() method to add elements to the LinkedList
    // removeFirst() method to remove elements from the beginning of the LinkedList
    // removeLast() method to remove elements from the end of the LinkedList
    // remove() method to remove elements from the LinkedList
    
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        System.out.println("LinkedList: " + list);

        list.addFirst("Z"); // Adds Z at the beginning

        list.addLast("F"); // Adds F at the end

        list.add(2, "Y"); // Adds Y at index 2

        list.removeFirst(); // Removes the first element

        list.removeLast(); // Removes the last element

        list.remove(2); // Removes the element at index 2

        System.out.println("LinkedList: " + list);
        
    }
}

// T.C = O(1) for addFirst(), addLast(), removeFirst(), removeLast()
// T.C = O(n) for add(), remove() methods