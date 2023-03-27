// Cynthia Hong
// 5/25/2021 
// CSE142
// TA: Ana Jojic
// Take-home Assessment #7
//
/* This program, named Personality, will process an input,
which contains the results of a personality test for a number of people
and determine each person's Keirsey personality type. It will also return
an output file to show personality types.*/

import java.util.*;
import java.io.*;

public class Personality {

   // represents the number of demensions
   public static final int ARRAY_SIZE = 4;

   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
    
      giveIntro();
      // reads the input file
      System.out.print("input file name? ");
      Scanner input = new Scanner(new File(console.nextLine()));
      // gives the name of output file
      System.out.print("output file name? ");
      PrintStream output = new PrintStream(new File(console.nextLine()));
      
      // processes the responses to the personality test
      // and prints the results to the specified output file
      while (input.hasNextLine()) {
         // uses my file format guarantees
         // prints out the name
         String nameLine = input.nextLine();
         String answerLine = input.nextLine();
         output.print(nameLine + ": ");
         // counts and prints of the answer 
         int[] answerCountsA = new int[ARRAY_SIZE]; 
         int[] answerCountsB = new int[ARRAY_SIZE];
         int[] percentageB = new int[ARRAY_SIZE];
         getCounts(answerLine, answerCountsA, answerCountsB);
         getAnswer(answerCountsA, answerCountsB, percentageB);
         output.print(Arrays.toString(percentageB) + " = ");
         // processes and prints the result types
         getResult(percentageB, output);
      }
   }

   // prints out a short introduction as the beginning 
   // explains the purpose of the program
   public static void giveIntro() {
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter. It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();
   }
   
   // Processes a line of answers and 
   // populates the given arrays with each dimension
   // of the answer counts(a/A&b/B).
   // 
   // String answerLine - the String of answer for each person
   // who did the personality test
   // int[] answerCountsA - array for answer A counts of each dimension
   // int[] answerCountsB - array for answer B counts of each dimension
   public static void getCounts(String answerLine, int[] answerCountsA, int[] answerCountsB) {
      for (int i = 0; i < answerLine.length(); i++) {
         char answer = answerLine.charAt(i);
         if (answer == 'a' || answer == 'A') {
            answerCountsA[((i % 7 + 1) / 2)]++;
         } else if (answer == 'b' || answer == 'B') {
            answerCountsB[((i % 7 + 1) / 2)]++;
         }
      }
   }
   
   // populates the given array with each dimension
   // of the percetage of answer B counts and all the counts.
   // 
   // int[] answerCountsA - array for answer A counts of each dimension
   // int[] answerCountsB - array for answer B counts of each dimension
   // int[] percentageB - array for percentage B counts and all the counts of each dimension
   public static void getAnswer(int[] answerCountsA, int[] answerCountsB, int[] percentageB) {
      int totalAnswer = 0;
      for (int i = 0; i < percentageB.length; i++) {
         totalAnswer = answerCountsA[i] + answerCountsB[i];
         percentageB[i] = (int)Math.round((double)answerCountsB[i] / totalAnswer * 100);
      }
   }

   // populates the result of the personality test
   // with different types for each deminsion
   //
   // int[] percentageB - array for percentage B counts 
   // and all the counts of each dimension
   // PrintStream output - where to direct output
   public static void getResult(int[] percentageB, PrintStream output) {
      char[] resultArray = {'E', 'I', 'S', 'N', 'T', 'F', 'J', 'P', 'X'};
      String result = "";         
      for (int i = 0; i < ARRAY_SIZE; i++) {
         if (percentageB[i] < 50) {
            result += resultArray[2 * i];
         } else if (percentageB[i] > 50) {
            result += resultArray[2 * i + 1];
         } else {//percentageB[i]=50
            result += resultArray[resultArray.length - 1];
         }
      }
      output.println(result); 
   }
}

