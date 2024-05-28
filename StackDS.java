import java.util.Stack;

// LIFO  = Last In First Out DATA STRUCTURE
// Stack is a class that implements the Stack interface
// Stack is a subclass of Vector

public class StackDS {

    // push() method is used to insert an element in the Stack
    // pop() method is used to remove an element from the Stack

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println(stack.empty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.search(20));
        System.out.println("Stack: " + stack);
    }
}

// T.C = O(1) for push(), pop(), peek(), search(), empty()
