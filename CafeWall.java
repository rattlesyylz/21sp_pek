//Cynthia Hong
//4/20/2021 
//CSE142
//TA: Ana Jojic
//Take-home Assessment #3
//
/*This program, named CafeWall, will produces as 
the output of what is known as the Cafe Wall illusion.
It is composed by two rows and four grids.*/

import java.awt.*;

public class CafeWall {

   //to scale the small amount between each row
   public static final int MORTAR = 2;

   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(650, 400);
      panel.setBackground(Color.GRAY);
      Graphics g = panel.getGraphics();
      
      //to print out the row A
      drawRow(g, 0, 0, 4, 20);
      //to print out the row B
      drawRow(g, 50, 70, 5, 30);
      //to print out the grid C
      drawGrid(g, 400, 20, 35, 35, 2);
      //to print out the grid D
      drawGrid(g, 10, 150, 25, 0, 4);
      //to print out the grid E 
      drawGrid(g, 250, 200, 25, 10, 3);
      //to print out the grid F
      drawGrid(g, 425, 180, 20, 10, 5);
   }

   //to print out the two rows
   // Graphics g: the Graphics object to use when drawing
   // int x: the x-coordinate of the top-left corner of the drawn row
   // int y: the y-coordinate of the top-left corner of the drawn row
   // int pair: the number of the pairs of the drawn row
   // int size: the size of the drawn row
   public static void drawRow(Graphics g, int x, int y, int pair, int size) {
      //to repeat pairs and form the row
      for (int i=0; i<pair;i++) {
         //to draw the black box
         g.setColor(Color.BLACK);
         g.fillRect(x+size*i*2, y, size, size);
         
         //to draw the blue "X"
         g.setColor(Color.BLUE);
         g.drawLine(x+size*i*2, y, x+size*(2*i+1), y+size);
         g.drawLine(x+size*(2*i+1), y, x+size*i*2, y+size);
         
         //to draw the white box
         g.setColor(Color.WHITE);
         g.fillRect(x+size*(2*i+1), y, size, size);
      }
   }
   
   //to print out four grids
   // Graphics g: the Graphics object to use when drawing
   // int x: the x-coordinate of the top-left corner of the drawn grid
   // int y: the y-coordinate of the top-left corner of the drawn grid
   // int size: the size of the drawn grid
   // int offset: the offset between each row pf the drawn grid
   // int num: the number of the pairs within a row of the drawn grid
   // and the number of the paired rows of the drwan grid
   public static void drawGrid(Graphics g, int x, int y, int size, int offset, int num) {
      //to repeat paird rows and form the grid
      for (int i=0; i<num; i++) {
         drawRow(g, x, y+size*2*i+MORTAR*2*i, num, size);
         drawRow(g, x+offset, y+size*(2*i+1)+MORTAR*(2*i+1), num, size);
      }
   }
}
