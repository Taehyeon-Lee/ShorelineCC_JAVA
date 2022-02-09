// Taehyeon Lee
// CS 143
// Core Topic: Linked List
// This program runs Assassin game which each player is assigned with person to assassinate
// and if the target is assassinated assassin is reassigned from the list and player would
// win when there is no more target in the list other than oneself. 

import java.util.*;

public class AssassinManager {

   private AssassinNode targetRing;
   private AssassinNode graveyard;
   
   // complete the methods
   public AssassinManager(List<String> names) {
   // if the list is null or empty throw an exception
      if(names == null)
         throw new IllegalArgumentException();
      
      // build own targetRing of assassin node that contains names in the same order
      for(int i = names.size()-1; i >= 0; i--){
         targetRing = new AssassinNode(names.get(i), targetRing);
      }
   
   }
   
   // this method prints the names of people in the targetRing one per line
   public void printTargetRing() {
      // first name from the targetRing
      String name = targetRing.name;
      System.out.println();
      
      // if game is over(only one person left in the targetRing) prints winner of the game
      if(isGameOver()){
         System.out.println(targetRing.name + "won the game!");
      } else{ // prints the names people in the targetRing one per line
         AssassinNode current = targetRing;
         
         // loop to the end but not printing last node
         while(current.next != null){
            System.out.println(current.name + " is stalking "+ current.next.name);
            current = current.next;
         }
         // printing last node is stalking first node
         System.out.println(current.name + " is stalking " + name);
      }
      System.out.println();
   }
   
   // this method prints the names of people in the graveyard
   // It should print the names in the opposite of the order in which they were assassinated
   // ex) most recent kill should print on the top
   public void printGraveyard() {
      if(graveyard != null){
         AssassinNode current = graveyard;
         while(current != null){
            System.out.println(current.name + " was assassinated by " + current.assassin);
            current = current.next;
         }
      }
      
   }
   
   // this method returns true if given name is in the targetRing
   public boolean targetRingContains(String name) {
   // capitalizing only first letter of name
      name = name.toLowerCase();
      name = name.substring(0,1).toUpperCase() + name.substring(1);
   
      AssassinNode current = targetRing;
      while(current != null){
      // return true if the name matches with the name in the targetRing
         if(current.name.equals(name)){
            return true;
         }
         current = current.next;
      }
      
   // false otherwise
      return false;
   }
   
   // this method returns true if given name is in the graveyard
   public boolean graveyardContains(String name) {
   // capitalizing only first letter of name
      name = name.toLowerCase();
      name = name.substring(0,1).toUpperCase() + name.substring(1);
   
      AssassinNode current = graveyard;
      while(current != null){
      // return true if the name matches with the name in the targetRing
         if(current.name.equals(name)){
            return true;
         }
         current = current.next;
      }
      
      // false otherwise
      return false;
   }
   
   // returns true if the game is over(one person left in the targerRing)
   public boolean isGameOver() {
      return targetRing.next == null;
   }
   
   // prints the name of the winner
   public String winner() {
      // if the game is over prints winner
      if(isGameOver()){
         return targetRing.name;
      } else{ // otherwise null
         return "";

      }
        
   }
   
   // method record the assassination of the person with the given name, 
   // transferring the person from the target ring to the front of the graveyard
   public void assassinate(String name) {
   // capitalizing only first letter of name
      name = name.toLowerCase();
      name = name.substring(0,1).toUpperCase() + name.substring(1);
   
   // if game is over throw exception
      if (isGameOver())
         throw new IllegalStateException();
   // if given name is not in the targetRing throw exception
      if (!targetRingContains(name))
         throw new IllegalArgumentException();  

      String killed = null;
      // if given name is first node, remove from target and set it to front of graveyard
      // and last node's target becomes second node of target 
      if(targetRing.name.equals(name)){
         killed = targetRing.name;
         graveyard = new AssassinNode(killed, graveyard);
         AssassinNode cur = targetRing;
         while(cur.next != null){
            cur = cur.next;
         }
         graveyard.assassin = cur.name;
         targetRing = targetRing.next;
      } else{// else case move killed person to front graveyard and assign new person as next
         AssassinNode current = targetRing;
         
         while(current.next != null){
            if(current.next.name.equals(name)){
               killed = current.next.name;
               graveyard = new AssassinNode(killed, graveyard);
               graveyard.assassin = current.name;
               current.next = current.next.next;
               if(current.next == null){
                  break;
                  }
               
            }
            current = current.next;
         }
      
      
      }
   
         
   }
   
   

}

/*
 Welcome to the CS 143 Assassin Manager
 
 Which file of names should I load?names.txt
 Do you want the names shuffled (y/n)? n
 
 Current target ring:
 
 Joe is stalking Sally
 Sally is stalking Jim
 Jim is stalking Carol
 Carol is stalking Chris
 Chris is stalking Joe
 
 Current graveyard:
 
 next victim? carol
 
 Current target ring:
 
 Joe is stalking Sally
 Sally is stalking Jim
 Jim is stalking Chris
 Chris is stalking Joe
 
 Current graveyard:
 Carol was assassinated by Jim
 
 next victim? sALLY
 
 Current target ring:
 
 Joe is stalking Jim
 Jim is stalking Chris
 Chris is stalking Joe
 
 Current graveyard:
 Sally was assassinated by Joe
 Carol was assassinated by Jim
 
 next victim? Chris
 
 Current target ring:
 
 Joe is stalking Jim
 Jim is stalking Joe
 
 Current graveyard:
 Chris was assassinated by Jim
 Sally was assassinated by Joe
 Carol was assassinated by Jim
 
 next victim? JIM
 
 Game was won by Joe
 Final graveyard is:
 Jim was assassinated by Joe
 Chris was assassinated by Jim
 Sally was assassinated by Joe
 Carol was assassinated by Jim
*/