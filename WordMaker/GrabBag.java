// Taehyeon Lee
// CS 143
// Core topic: recursion
// this object creates method that is required to create random words on the WordMakerEngine

import java.util.*;

public class GrabBag {

   // field
   private ArrayList<Character> bag;

   // constructor bag and add a-z in the bag
   public GrabBag() {
      bag = new ArrayList<>();
      for(char c = 'a'; c <= 'z'; c++) {
         add(c);
      }
   }

   // this method add a character to the bag List
   public void add(Character data) {
      bag.add(data);
   }

   // this method remove index of random number that crated range of bag size
   public Character grab() {
      Random r = new Random();
      return bag.remove(r.nextInt(bag.size()));
   }

   // this method check whether the bag is empty
   public boolean isEmpty() {
      return bag.size() == 0;
   }

   // toString method that prints bag in the console
   public String toString() {
      return bag.toString();
   }
}