import java.util.*;

public class ImplementingStackAndQueue {

   public static void main(String[] args) {
      MyStack<Integer> stack = new MyStack<>();
      //Stack<Integer> stack = new Stack<>(); // built-in version
      MyQueue<Integer> queue = new MyQueue<>();
      //Queue<Integer> queue = new LinkedList<>(); // LinkedList implements Queue interface
      
      Random r = new Random();
      Scanner console = new Scanner(System.in);
      
      String again = "";
      do {
         System.out.print("add, remove, or end? > ");
         again = console.nextLine().toLowerCase();
         if(again.startsWith("a")) {
            int x = r.nextInt(1000) + 1;
            stack.push(x); // add to top of the stack
            queue.add(x); // add to the back of the queue
         }
         else if(again.startsWith("r")) {
            stack.pop(); // remove from the top of the stack
            queue.remove(); // remove from the front of the queue
         }
         System.out.println("peak = " + stack.peek());
         System.out.println("stack = " + stack);
         System.out.println("queue = " + queue);
      } while(again.startsWith("a") || again.startsWith("r"));
   
   }

}