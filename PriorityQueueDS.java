import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// PriorityQueue is a class that implements the Queue interface
// It is a data structure that stores elements in a sorted order
// The elements are stored in a way that the element with the highest priority is at the front

public class PriorityQueueDS {
    

    // offer() method is used to insert an element in the Queue
    // poll() method is used to remove an element from the Queue

    public static void main(String[] args) {
        
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.offer(40);
        queue.offer(80);
        queue.offer(60);
        queue.offer(100);
        queue.offer(20);

        System.out.println(queue.isEmpty()); // false

        System.out.println(queue.peek()); // 100
        queue.poll(); 
        System.out.println(queue.peek()); // 80
        System.out.println(queue); // [80, 40, 60, 20]
    }
}
