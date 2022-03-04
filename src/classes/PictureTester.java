package classes;

import java.util.concurrent.TimeUnit;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{

  private static Picture beach = new Picture("beach.jpg");
  private static Picture water = new Picture("water.jpg");

  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  public static void testKeepOnlyBlue()
  {
    beach.explore();
    beach.zeroColor(false,false,true);
    beach.explore();
  }

  public static void testNegate() {
    beach.explore();
    beach.negate();
    beach.explore();
  }

  public static void testGrayscale() {
    beach.explore();
    beach.greyscale();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }

  /** Method to test mirrorVertical */
  public static void testMirrorRightToLeft()
  {
    Picture caterpillar = new Picture("beach.jpg");
    caterpillar.explore();
    caterpillar.mirrorRightToLeft();
    caterpillar.explore();
  }


  /** Method to test mirrorVertical */
  public static void mirrorRightToLeft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }

  public static void testMirrorHorizontal() {
    Picture caterpillar = new Picture("HEXAGON.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontal();
    caterpillar.explore();
  }

  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }

  public static void testDiag()
  {
    Picture temple = new Picture("Image.jpeg");
    temple.explore();
    temple.mirrorDiag();
    temple.explore();
  }

  /** Method to test the collage method */
  public static void testCollage()
  {
//    Picture seagull = new Picture("seagull.jpg");
//    Picture pig = new Picture("pig.jpg");
//    Picture swan = new Picture("swan.jpg");
//    Picture koala = new Picture("koala.jpg");
//    seagull.explore();
//    pig.explore();
//    swan.explore();
//    koala.explore();
    Picture canvas = new Picture("640x480.jpg");
    canvas.createBird();
    canvas.explore();
  }

  public static void testMirrorArms() {
    Picture snowman = new Picture("snowman.jpg");
    snowman.explore();
    snowman.mirrorSnow();
    snowman.explore();
  }

  public static void testMirrorGull() {
    Picture gull = new Picture("seagull.jpg");
    gull.explore();
    gull.mirrorVertical();
    gull.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }

  public static void testFixUnderwater() {
    water.explore();
    water.removeColor(10,130,120);
    water.removeColor(-30,-30,-30);
    water.brighten();
    water.explore();
  }

  public static void testBlur(Picture picture, int blur)  {
    picture.explore();
    picture.boxBlur(blur);
    picture.explore();
  }

  public static void testBokeh(Picture picture, int blur) throws InterruptedException {
    picture.explore();
    TimeUnit.SECONDS.sleep(10);
    System.out.println("Blurring");
    picture.bokehSquare(picture.getArray(), blur);
//    picture.smartBokeh(picture.getArray(), blur);
    picture.explore();
    System.out.println("Blurred");
  }

  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args) throws InterruptedException {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
//    testZeroBlue();
//    testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
//    testNegate();
//    testGrayscale();
//    testFixUnderwater();
//    testMirrorVertical();
//    testMirrorHorizontal();
//    testMirrorTemple();
//    testMirrorRightToLeft();
//    testDiag();
//    testMirrorArms();
//    testMirrorGull();
    //testMirrorDiagonal();
//    testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
//    testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
//    testBlur(new Picture("koala.jpg"), 10);
//    testBokeh(new Picture("koala.jpg"), 2);
    testBokeh(new Picture("whiteflower.jpg"), 4);
//    testBokeh(new Picture("swan.jpg"), 4);
//    testBokeh(new Picture("melon.jpg"), 10);
//    testBokeh(new Picture("glove.jpg"), 2);

  }
}