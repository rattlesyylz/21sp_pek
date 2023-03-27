//Cynthia Hong
//4/13/2021
//CSE142
//TA: Ana Jojic
//Take-home Assessment #2
//
//This program will produces as 
//the output of the SpaceNeedle.

public class SpaceNeedle {

//class constant used to scale the output
   public static final int SIZE=4;

//I devide the output to six parts,
//depending on its shape.
   public static void main(String[] args) {
      drawNeedle();
      drawTriangle();
      drawInvertedTriangle();
      drawNeedle();
      drawPillar();
      drawTriangle();
   }
   
//Prints out the needle of the SpaceNeedle
   public static void drawNeedle() {
      for(int line=1; line<=SIZE; line++) {
         for(int space=1; space<=3*SIZE; space++) {
            System.out.print(" ");
         }
         System.out.println("||");
      }
   }
   
//Prints out the Triangle of the SpaceNeedle
   public static void drawTriangle() {
      for(int line=1; line<=SIZE; line++) {
         for(int space=1; space<=-3*line+3*SIZE; space++) {
            System.out.print(" ");
         }
         System.out.print("__/");
         for(int colon=1; colon<=3*line-3; colon++) {
            System.out.print(":");
         }
         System.out.print("||");
         for(int colon=1; colon<=3*line-3; colon++) {
            System.out.print(":");
         }
         System.out.println("\\__");
      }
      System.out.print("|");
      for(int quote=1; quote<=SIZE*6; quote++) {
         System.out.print("\"");
      }
      System.out.println("|");
   }
   
//Prints out the InvertedTriangle of the SpaceNeedle
   public static void drawInvertedTriangle() {
      for(int line=1; line<=SIZE; line++) {
      
         for(int space=1; space<=2*line-2; space++) {
            System.out.print(" ");
         }
         System.out.print("\\_");
         for(int cusp=1; cusp<=-2*line+SIZE*3+1; cusp++) {
            System.out.print("/\\");
         }
         System.out.println("_/");
      }
   }
   
//Prints out the pillar of the SpaceNeedle
   public static void drawPillar() {
      for(int line=1; line<=SIZE*SIZE; line++) {
         for(int space=1; space<=2*SIZE+1; space++) {
            System.out.print(" ");
         }
         System.out.print("|");
         for(int percent=1; percent<=SIZE-2; percent++) {
            System.out.print("%");
         }
         System.out.print("||");
         for(int percent=1; percent<=SIZE-2; percent++) {
            System.out.print("%");
         }
         System.out.println("|");
      }
   }
}

