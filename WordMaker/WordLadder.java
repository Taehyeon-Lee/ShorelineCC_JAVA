// Taehyeon Lee
// CS 143
// Core Topic: recursion and backtracking
// This program take start word and end word from user and evaluate how startword can be reached to endword.

import java.io.*;
import java.util.*;

public class WordLadder {
    // fields
    private List<String> words;
    private List<String>ladder;

    // constructor and add words that has same length with wordLength into words list
    public WordLadder(String filename, int wordLength){
        words = new ArrayList<String>();
        ladder = new ArrayList<>();

        try {
            Scanner input = new Scanner(new File(filename));
            while (input.hasNext()) {
                String nextWord = input.next();
                if (nextWord.length() == wordLength){
                    words.add(nextWord);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(filename + " does not exist. Cannot read file.");
        }

    }

    // this method returns words list
    public List<String> getWords(){
        return words;
    }

    // this method returns ladder list
    public List<String> getLadder(){
        return ladder;
    }

    public boolean foundLadder(String startWord, String endWord) {
        ladder.add(startWord);
        return findLadder(startWord, endWord);

    }

    // recursion helper method
    private boolean findLadder(String startWord, String endWord){
        //Set<String> visited = new HashSet<>();
        String currentWord = startWord;

        // base case when the recursion stops
        if (currentWord.equals(endWord)){
            //ladder.add(currentWord);
            return true;
        }

        // loop the word list and find one letter different word and find ladder
        else {
            for (int i = 0; i < words.size(); i++) {
                //System.out.println(words.get(i));
                String newWord = words.get(i);

                if (oneDiff(newWord, currentWord) && !inLadder(newWord)) {
                    ladder.add(newWord);
                    //System.out.println(getLadder());
                    if (findLadder(newWord, endWord)) {
                        return true;
                    }

                    ladder.remove(ladder.size()-1);

                }


                }
            return false;
        }

    }

    // this method prints each word in the ladder on the separate line
    public void printLadder(){
        for (int i = 0; i < ladder.size(); i++){
            System.out.println(ladder.get(i));
        }


    }

    // this method return true if word is in the ladder, false otherwise
    public boolean inLadder(String word){
        return ladder.contains(word);
    }

    public boolean oneDiff(String word1, String word2){
        // make word1 and word2 lowercase so it can be case insensitive
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        if (word1.length() != word2.length()) {
            return false;
        }
        int count = 0;
        // loop that count how many letters are different
        for (int i = 0; i < word1.length(); i++){
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
        }
        // if only one letter is different return true, otherwise return false
        if (count == 1) {
            return true;
        } else {
            return false;
        }

    }

}
