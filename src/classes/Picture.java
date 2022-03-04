package classes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////

  private enum RGB {
    RED, GREEN, BLUE
  }

  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }

  public void boxBlur(int number) {
    Pixel[][] pixels = this.getPixels2D();
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < pixels[row].length; col++)
      {
        pixels[row][col].setColor(new Color(
                averageColor(pixels, row, col, RGB.RED, number),
                averageColor(pixels, row, col, RGB.GREEN, number),
                averageColor(pixels, row, col, RGB.BLUE, number))
        );
      }
    }
  }

  public void smartBokeh(ArrayList[] list, int number) {
    Pixel[][] pixels = this.getPixels2D();
    Pixel[][] pixelsCopy = this.getPixels2D();
    int rowMin = (int) Double.MAX_VALUE;
    int rowMax = 0;
    int colMin = (int) Double.MAX_VALUE;
    int colMax = 0;
    for (int i = 0; i < list[0].size(); i++) {
      rowMax = Math.max((int)list[0].get(i), rowMax);
      rowMin = Math.min((int)list[0].get(i), rowMin);
    }
    for (int i = 0; i < list[1].size(); i++) {
      colMax = Math.max((int)list[1].get(i), colMax);
      colMin = Math.min((int)list[1].get(i), colMin);
    }
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < pixels[row].length; col++)
      {
        if (row > rowMin && row < rowMax && col > colMin && col < colMax) {
          if (pixelsCopy[row][col].getRed() + pixelsCopy[row][col].getBlue() + pixelsCopy[row][col].getGreen() >= 300) {
            continue;
          }
        }
        pixels[row][col].setColor(new Color(
                averageColor(pixelsCopy, row, col, RGB.RED, number),
                averageColor(pixelsCopy, row, col, RGB.GREEN, number),
                averageColor(pixelsCopy, row, col, RGB.BLUE, number)));
      }
    }
  }

  public void bokehSquare(ArrayList[] list, int number) {
    Pixel[][] pixels = this.getPixels2D();
    Pixel[][] pixelsCopy = this.getPixels2D();
    int rowMin = (int) Double.MAX_VALUE;
    int rowMax = 0;
    int colMin = (int) Double.MAX_VALUE;
    int colMax = 0;
    for (int i = 0; i < list[0].size(); i++) {
      rowMax = Math.max((int)list[0].get(i), rowMax);
      rowMin = Math.min((int)list[0].get(i), rowMin);
    }
    for (int i = 0; i < list[1].size(); i++) {
      colMax = Math.max((int)list[1].get(i), colMax);
      colMin = Math.min((int)list[1].get(i), colMin);
    }
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < pixels[row].length; col++)
      {
        if (row > rowMin && row < rowMax && col > colMin && col < colMax) {
          continue;
        }
        pixels[row][col].setColor(new Color(
                averageColor(pixelsCopy, row, col, RGB.RED, number),
                averageColor(pixelsCopy, row, col, RGB.GREEN, number),
                averageColor(pixelsCopy, row, col, RGB.BLUE, number)));
      }
    }
  }

  public void bokehBezier(ArrayList[] list, int number) {
    Pixel[][] pixels = this.getPixels2D();
    Pixel[][] pixelsCopy = this.getPixels2D();
    int rowMin = (int) Double.MAX_VALUE;
    int rowMax = 0;
    int colMin = (int) Double.MAX_VALUE;
    int colMax = 0;
    for (int i = 0; i < list[0].size(); i++) {
      rowMax = Math.max((int)list[0].get(i), rowMax);
      rowMin = Math.min((int)list[0].get(i), rowMin);
    }
    for (int i = 0; i < list[1].size(); i++) {
      colMax = Math.max((int)list[1].get(i), colMax);
      colMin = Math.min((int)list[1].get(i), colMin);
    }
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < pixels[row].length; col++)
      {
        if (row > rowMin && row < rowMax && col > colMin && col < colMax) {
          continue;
        }
        pixels[row][col].setColor(new Color(averageColor(pixelsCopy, row, col, RGB.RED, number), averageColor(pixelsCopy, row, col, RGB.GREEN, number), averageColor(pixelsCopy, row, col, RGB.BLUE, number)));
      }
    }
  }

  public int averageColor(Pixel[][] pixels, int row, int col, RGB color, int number) {
    int sum = 0;
    int startingRow = Math.negateExact(number);
    int startingCol = Math.negateExact(number);
    int endingRow = number;
    int endingCol = number;
    if (row < number) {
      startingRow = 0;
    }
    if (col < number) {
      startingCol = 0;
    }
    if (row + number + 1 > pixels.length) {
      endingRow = pixels.length - (row + 1);
    }
    if (col + number + 1 > pixels[row].length) {
      endingCol = pixels[row].length - (col + 1);
    }
    for (int rowNum = startingRow; rowNum <= endingRow; rowNum++) {
      for (int colNum = startingCol; colNum <= endingCol; colNum++) {
        int colorNum = 0;
        switch (color) {
          case RED -> colorNum = pixels[row + rowNum][col + colNum].getRed();
          case BLUE -> colorNum = pixels[row + rowNum][col + colNum].getBlue();
          case GREEN -> colorNum = pixels[row + rowNum][col + colNum].getGreen();
          default -> {
          }
        }
        if (!((sum/((rowNum-startingRow+1)*(colNum-startingCol+1))) > colorNum) || sum == 0) {
          sum += colorNum;
        }
      }
    }
    return sum/((endingRow-startingRow+1)*(endingCol-startingCol+1));
  }

  public void removeColor(int red, int green, int blue)
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setColor(new Color(Math.max(pixelObj.getRed() - red, 0),Math.max(pixelObj.getGreen()- green,0),Math.max(pixelObj.getBlue()- blue,0)));
      }
    }
  }

  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setColor(new Color(255-pixelObj.getRed(), 255-pixelObj.getBlue(), 255-pixelObj.getGreen()));
      }
    }
  }


  public void brighten()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        try {
          pixelObj.getColor().brighter();
          pixelObj.getColor().brighter();
          pixelObj.getColor().brighter();
        }
        catch (Exception e) {
          throw(new UrStupidException());
        }
      }
    }
  }


  public void greyscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setColor(new Color((int)pixelObj.getAverage(), (int)pixelObj.getAverage(), (int)pixelObj.getAverage()));
      }
    }
  }

  public void zeroColor(boolean red, boolean green, boolean blue)
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(!blue ? 0 : pixelObj.getBlue());
        pixelObj.setRed(!red ? 0 : pixelObj.getRed());
        pixelObj.setGreen(!green ? 0 : pixelObj.getGreen());
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

  /** Method that mirrors the picture around a
   * vertical mirror in the center of the picture
   * from left to right */
  public void mirrorRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = width/2; col < width; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }

  /** Method that mirrors the picture around a
   * vertical mirror in the center of the picture
   * from left to right */
  public void mirrorDiag()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int number = pixels[0].length;
    for (int row = 0; row < number; row++)
    {
      for (int col = 0; col < number; col++)
      {
        leftPixel = pixels[number-1-row][col];
        rightPixel = pixels[col][number-1-row];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }

  /** Method that mirrors the picture around a
   * vertical mirror in the center of the picture
   * from left to right */
  public void mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[pixels.length - 1 - row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
  }

  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        count++;
        leftPixel = pixels[row][col];
        rightPixel = pixels[row]
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    System.out.println(count);
  }

  public void mirrorSnow() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int width = pixels[0].length;
    for (int row = 160; row < 190; row++)
    {
      for (int col = 0; col < width; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[190 - row + 190][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  public void copyBetter(Picture fromPic,
                   int startRow, int startCol, int endRow, int endCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = startRow, toRow = endRow;
         fromRow < fromPixels.length &&
                 toRow < toPixels.length;
         fromRow++, toRow++)
    {
      for (int fromCol = startCol, toCol = endCol;
           fromCol < fromPixels[0].length &&
                   toCol < toPixels[0].length;
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }

  public void createBird() {
    Picture seagull = new Picture("seagull.jpg");
    Picture pig = new Picture("pig.jpg");
    Picture swan = new Picture("swan.jpg");
    Picture koala = new Picture("koala.jpg");
    this.copyBetter(seagull, 230, 230, 0, 240);
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this