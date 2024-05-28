import java.util.LinkedList;
import java.util.Queue;

// FIFO = First In First Out DATA STRUCTURE
// Queue is an interface, so we need to use a class that implements it
// LinkedList is a class that implements the Queue interface

public class QueueDS {

    // offer() method is used to insert an element in the Queue
    // poll() method is used to remove an element from the Queue

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);

        System.out.println(queue.isEmpty()); // true

        System.out.println(queue.peek()); // 10
        queue.poll();
        System.out.println(queue.peek()); // 20
        System.out.println(queue); // [20, 30, 40]

    }
}
