// Taehyeon Lee
// CS 143
// Core Topic: recursion and backtracking


import java.util.*;

public class WordLadderClient {
    public static void main(String args[]) {

          Scanner scanner = new Scanner(System.in);
        do {

            System.out.print("Enter a starting word: ");
            String startWord = scanner.next();
            System.out.print("Enter a ending word: ");
            String endWord = scanner.next();
            WordLadder words = new WordLadder("words.txt", startWord.length());

            boolean wordLadder = words.foundLadder(startWord, endWord);
            if (wordLadder) {
                System.out.println("Success");
                System.out.println(words.getLadder());
            } else {
                System.out.println("No word ladder found");
            }
            System.out.print("Do you want to continue? (Y/N) ");
        } while(scanner.next().toLowerCase().startsWith("y"));


    }
}
/*
Enter a starting word: cake
Enter a ending word: baby
Success
[cake, bake, babe, baba, babu, baby]
Do you want to continue? (Y/N) n

 */