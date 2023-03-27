//Cynthia Hong
//4/6/2021
//CSE142
//TA: Ana Jojic
//Take-home Assessment #1
//
//This program will produces as output 
//a cumulative song in which successive verses 
//build on previous verses (as described on Wikipedia).

public class Song {
   public static void main (String[] args) {
      verse1();
      System.out.println();
      verse2();
      System.out.println();
      verse3();
      System.out.println();
      verse4();
      System.out.println();
      verse5();
      System.out.println();
      verse6();
      System.out.println();
      verse7();
   }
   
   //The first verse
   public static void verse1() {
      System.out.println("There was an old woman who swallowed a fly.");
      twoRows();
   }
      
   //The second verse
   public static void verse2() {
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      threeRows();
   }
      
   //The third verse
   public static void verse3() {
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      fourRows();
   }
   
   //The forth verse
   public static void verse4() {
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      fiveRows();
   }
   
   //The fifth verse
   public static void verse5() {
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      sixRows();
   }
   
   //The sixth verse
   public static void verse6() {
      System.out.println("There was an old woman who swallowed a wolf,");
      System.out.println("Very fierce indeed to swallow a wolf.");
      sevenRows();
   }
   
   //The seventh verse
   public static void verse7() {
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }
   
   //The following is to print the ending rows of the verse
   //The last two rows of the following verse
   public static void twoRows() {
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
   }
   
   //The last three rows of the following verse
   public static void threeRows() {
      System.out.println("She swallowed the spider to catch the fly,");
      twoRows();
   }
   
   //The last four rows of the following verse
   public static void fourRows() {
      System.out.println("She swallowed the bird to catch the spider,");
      threeRows();
   }
   
   //The last five rows of the following verse
   public static void fiveRows() {
      System.out.println("She swallowed the cat to catch the bird,");
      fourRows();
   }
   
   //The last six rows of the following verse
   public static void sixRows() {
      System.out.println("She swallowed the dog to catch the cat,");
      fiveRows();
   }
   
   //The last seven rows of the following verse
   public static void sevenRows() {
      System.out.println("She swallowed the wolf to catch the dog,");
      sixRows();
   }
}  

