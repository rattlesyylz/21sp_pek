// Cynthia Hong
// 5/4/2021
// CSE142
// TA: Ana Jojic
// Take-home Assessment #5
//
/*
This program allows the user to play a game 
where the program thinks of a random integer 
and accepts guesses from the user 
until the user guesses the integer correctly.
*/

import java.util.*;

public class GuessingGame {
   // enter the maxium possible secret number
   public static final int MAX_VALUE = 100; 

   public static void main (String[] args) {
      Scanner console = new Scanner(System.in);
      Random rand = new Random();
     
      boolean test = true;
      int gameTime =1;
      int oneGameGuesses=0;
      int totalGuesses=0;
      int minGuesses=1000000;
      // print an introduction in the form of a haiku
      haiku();
      // produce and print multiple games
      while (test) {
         oneGameGuesses = oneTimeGame(console, rand);
         totalGuesses += oneGameGuesses;
         minGuesses = Math.min(minGuesses, oneGameGuesses);
         System.out.print("Do you want to play again? ");
         String playChoice = console.next();
         System.out.println();
         if (playChoice.startsWith("y") || playChoice.startsWith("Y")) {
            gameTime++;
         } else {
            test = false;
         }
      }
      // print the overall statistics across multiple games
      gameResults(gameTime, totalGuesses, minGuesses);
   }
    
   // produce out a haiku poem consisting of three lines
   // in a specific structure: the first line has five syllables,
   // the second line has seven syllables,
   // the third line has five syllables.
   public static void haiku() {
      System.out.println("Do you want a game?");
      System.out.println("Let us think a number first!");
      System.out.println("Please type the number!");
      System.out.println();
   }
   
   // produce single game with user's guesses
   // scanner console: the scanner to use for input
   // random rand: the random object used for randomization
   // return the value of guessTime at the end of this method
   public static int oneTimeGame(Scanner console, Random rand) {
      System.out.println("I'm thinking of a number between 1 and " + MAX_VALUE + "...");
      int rightGuess = rand.nextInt(MAX_VALUE)+1;
      int guessTime = 0;
      boolean test = true;
      while (test) {
         System.out.print("Your guess? ");
         int guess = console.nextInt();
         guessTime++;
         if (guess > rightGuess) {
            System.out.println("It's lower.");
         } else if (guess < rightGuess) {
            System.out.println("It's higher.");
         } else if (guessTime == 1) {
            test = false;
         } else {
            test = false;
         }
      }
      if (guessTime == 1) {
         System.out.println("You got it right in 1 guess!");
      } else {
         System.out.println("You got it right in " + guessTime + " guesses!");
      }
      return guessTime;
   }
   
   // produce the the overall statistics, after completing the program
   // int gameTime: the total times of games
   // int totalGuesses: the total times of the whole guesses
   // int minGuesses: the minimum of guesses of all games
   public static void gameResults(int gameTime, int totalGuesses, int minGuesses) {
      System.out.println("Overall results:");
      System.out.println("Total games   = " + gameTime);
      System.out.println("Total guesses = " + totalGuesses);
      System.out.println("Guesses/game  = " + round1(((double)totalGuesses/(double)gameTime)));
      System.out.println("Best game     = " + minGuesses);
   }
   
   // Rounds the given number to 1 decimal places and returns it
   // double num: the number to be rounded
   public static double round1(double num) {
      return Math.round(num * 10.0) / 10.0;
   }
}
