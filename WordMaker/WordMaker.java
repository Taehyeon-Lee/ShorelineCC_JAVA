// Taehyeon Lee
// CS 143
// Core Topic: Recursion
// This program uses recursion to make words

import java.util.*;
import java.io.*;

public class WordMaker {

   // field
   private Set<String> words; 

   // constructor words and save all words from document into words set
   public WordMaker(String filePath) {
      words = new HashSet<>();     
      load(filePath);
   }

   // this method load the document file and convert the words into lowercase
   public void load(String filePath) {
      try (Scanner file = new Scanner(new File(filePath))){
         // add all words in the file to the words set Scanner file
         while(file.hasNext()) {
            words.add(file.next().toLowerCase());
         }
      } catch(FileNotFoundException e) {
         System.out.println("Something went wrong with: " + filePath);
      }
   }
   
   // not a recursive method - makeL is an overloaded method
   // kicks off the recursive method with a public method
   public String makeLexiographically(int length) {
      return makeLexiographically(length, "");
   }

   // recursive helper method - declared as private
   private String makeLexiographically(int length, String word) {
      System.out.println("potential choice: " +  word );
      // base condition - found solution - we will no longer recurse
       if(length == word.length() && words.contains(word)){
           return word;
       }

       if(word.length() < length) {
          for(char c = 'a'; c <= 'z'; c++) {
             // pick a letter choice
             word += c;
             String attempt = makeLexiographically(length, word);
             if(!attempt.equals(""))
                return attempt;
             // undo the choice
             word = word.substring(0, word.length() - 1);
          }
        }
       return "";
   }

   // non recursive method kicks off recursive method
   public String makeRandomly(int length) {
      return makeRandomly(length, "");
      
   }
   
   // recursive helper method
   private String makeRandomly(int length, String word){
      System.out.println("potential words: " + word);
      // base case
      if (word.length() == length && words.contains(word)){
         return word; // good solution
      }

      if (word.length() < length) {
         GrabBag alphabet = new GrabBag();
         while (!alphabet.isEmpty()) {
            // choice
            word += alphabet.grab();

            // recurse with choice
            String attempt = makeRandomly(length, word);
            if (!attempt.equals("")) {
               return attempt; // good solution
            }

            // undo choice if not a solution
            word = word.substring(0, word.length() - 1);
         }
      }
      return ""; // if choice is not a solution because it is not in the words set
                 // but it does have a correct length
   }
   
  
   
   public String toString() {
      return "This is a word maker object.";
   }
}