/*
MyStack<E>()   Constructs a new stack with elements of type E 
push(val)      Places val on top of the stack
pop()          Removes top value from the stack and returns it; throws NoSuchElementException if stack is empty
peek()         Returns top value from the stack without removing it; throws NoSuchElementException if stack is empty
isEmpty()      Returns true if the stack has no elements
size()         Returns the number of elements in the stack
*/

import java.util.*;

public class MyStack<E> {

   private ArrayList<E> stack; // null

   public MyStack() {
      stack = new ArrayList<E>(); // not null with size 0
   }
   
   public void push(E val) {
      stack.add(val);
   }
   
   public E pop() {
      if (isEmpty()){
         throw new NoSuchElementException();
      }
      return stack.remove(stack.size()-1);
   }
   
   public E peek() {
      if (isEmpty()){
         throw new NoSuchElementException();
      }
      return stack.get(stack.size()-1); // peak at the top element

   }
   
   public boolean isEmpty() {
      return stack.size() == 0;
   }
   
   public int size() {
      return stack.size();
   }
   
   public String toString() {
      return stack.toString();
   }


}
