
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import model.image.Image;
import model.image.ImageImplementation;
import model.model.ImageFilterImplementation;
import model.model.ImageModelImplementation;
import model.pixel.Pixel;
import model.pixel.PixelImplementation;

import static org.junit.Assert.assertEquals;

/**
 * Tests the model implementation class.
 */
public class ModelTest {

  //image
  Image image;

  //pixels to make the image
  Pixel pixel1 = new PixelImplementation(113, 202, 67);
  Pixel pixel2 = new PixelImplementation(88, 189, 254);
  Pixel pixel3 = new PixelImplementation(2, 150, 35);

  //Pixel Arrays that create many 2d arrays
  Pixel[][] pixelArray =
  {{pixel1, pixel2, pixel3}, {pixel3, pixel2, pixel1}, {pixel3, pixel1, pixel2}};
  Pixel[][] pixelArray1 =
  {{pixel1, pixel2, pixel3}, {pixel3, pixel2, pixel1}, {pixel1, pixel3, pixel2}};

  Pixel[][] pixelArray2 =
  {{pixel1, pixel3, pixel2}, {pixel3, pixel2, pixel1}, {pixel2, pixel3, pixel1}};

  //different size than the one above
  Pixel[][] pixelArray3 = {{pixel2, pixel1}, {pixel3, pixel1}};
  Pixel[][] pixelArray4 = {{pixel3, pixel2}, {pixel2, pixel1}};
  Pixel[][] pixelArray5 = {{pixel3, pixel1}, {pixel2, pixel3}};


  //using the first ImageImplementation with maxValue initailized
  Image imagePixelated = new ImageImplementation(pixelArray, 254);
  Image imagePixelated1 = new ImageImplementation(pixelArray1, 254);

  Image imagePixelated2 = new ImageImplementation(pixelArray2, 254);

  Image imagePixelated3 = new ImageImplementation(pixelArray3, 254);
  Image imagePixelated4 = new ImageImplementation(pixelArray4, 254);

  Image imagePixelated5 = new ImageImplementation(pixelArray5, 254);

  //using the second ImageImplementation
  Image imagePixelated6 = new ImageImplementation(pixelArray);
  Image imagePixelated7 = new ImageImplementation(pixelArray1);

  Image imagePixelated8 = new ImageImplementation(pixelArray2);

  Image imagePixelated9 = new ImageImplementation(pixelArray3);
  Image imagePixelated10 = new ImageImplementation(pixelArray4);

  Image imagePixelated11 = new ImageImplementation(pixelArray5);


  //loadSaveImage so we can check if the image is being loaded and save(will be used for testing
  //load and save).
  ImageModelImplementation loadSaveImage = new ImageModelImplementation();

  /**
   * STARTING OFF WITH MODEL IMPLEMENTATION PACKAGE.
   */
  //IMAGE MODEL IMPLEMENTATION
  //testing the constructors
  @Test
  public void testImageModelImplementationConstructorImageParameter() {
    //the image is the image.
    ImageModelImplementation newImage = new ImageModelImplementation(imagePixelated);
    ImageModelImplementation newImage1 = new ImageModelImplementation(imagePixelated1);
    ImageModelImplementation newImage2 = new ImageModelImplementation(imagePixelated2);
    HashMap<String, Image> mapTest = new HashMap<>();
    //to check that the map starts of with 0
    assertEquals(0, mapTest.size());
  }

  @Test
  public void testImageModelImplementationConstructorNoParameter() {
    HashMap<String, Image> mapTest = new HashMap<>();
    assertEquals(0, mapTest.size());

  }

  //TESTS BRIGHTEN (make sure that all are added by the given constant(50))
  @Test
  public void testBrighten() {
    ImageModelImplementation newImage = new ImageModelImplementation(imagePixelated);
    newImage.setImage("newImage", imagePixelated);
    newImage.brighten(50, "newImage", "brightenedNewImage");
    ImageModelImplementation brightenedImage =
            new ImageModelImplementation(newImage.getImage("brightenedNewImage"));


    assertEquals(163, brightenedImage.getRed(0, 0));
    assertEquals(252, brightenedImage.getGreen(0, 0));
    assertEquals(117, brightenedImage.getBlue(0, 0));

    assertEquals(138, brightenedImage.getRed(0, 1));
    assertEquals(239, brightenedImage.getGreen(0, 1));
    assertEquals(255, brightenedImage.getBlue(0, 1));

    assertEquals(52, brightenedImage.getRed(0, 2));
    assertEquals(200, brightenedImage.getGreen(0, 2));
    assertEquals(85, brightenedImage.getBlue(0, 2));

    assertEquals(52, brightenedImage.getRed(1, 0));
    assertEquals(200, brightenedImage.getGreen(1, 0));
    assertEquals(85, brightenedImage.getBlue(1, 0));

    assertEquals(138, brightenedImage.getRed(1, 1));
    assertEquals(239, brightenedImage.getGreen(1, 1));
    assertEquals(255, brightenedImage.getBlue(1, 1));

    assertEquals(163, brightenedImage.getRed(1, 2));
    assertEquals(252, brightenedImage.getGreen(1, 2));
    assertEquals(117, brightenedImage.getBlue(1, 2));

    assertEquals(52, brightenedImage.getRed(2, 0));
    assertEquals(200, brightenedImage.getGreen(2, 0));
    assertEquals(85, brightenedImage.getBlue(2, 0));

    assertEquals(163, brightenedImage.getRed(2, 1));
    assertEquals(252, brightenedImage.getGreen(2, 1));
    assertEquals(117, brightenedImage.getBlue(2, 1));

    assertEquals(138, brightenedImage.getRed(2, 2));
    assertEquals(239, brightenedImage.getGreen(2, 2));
    assertEquals(255, brightenedImage.getBlue(2, 2));

  }


  //TESTS DARKEN (reduces by the  given constant (12))
  @Test
  public void testDarken() {
    ImageModelImplementation newImage = new ImageModelImplementation(imagePixelated);
    newImage.setImage("newImage", imagePixelated);
    newImage.darken(12, "newImage", "darkenedNewImage");
    ImageModelImplementation darkenedNewImage =
            new ImageModelImplementation(newImage.getImage("darkenedNewImage"));


    assertEquals(101, darkenedNewImage.getRed(0, 0));
    assertEquals(190, darkenedNewImage.getGreen(0, 0));
    assertEquals(55, darkenedNewImage.getBlue(0, 0));

    assertEquals(76, darkenedNewImage.getRed(0, 1));
    assertEquals(177, darkenedNewImage.getGreen(0, 1));
    assertEquals(242, darkenedNewImage.getBlue(0, 1));

    assertEquals(0, darkenedNewImage.getRed(0, 2));
    assertEquals(138, darkenedNewImage.getGreen(0, 2));
    assertEquals(23, darkenedNewImage.getBlue(0, 2));

    assertEquals(0, darkenedNewImage.getRed(1, 0));
    assertEquals(138, darkenedNewImage.getGreen(1, 0));
    assertEquals(23, darkenedNewImage.getBlue(1, 0));

    assertEquals(76, darkenedNewImage.getRed(1, 1));
    assertEquals(177, darkenedNewImage.getGreen(1, 1));
    assertEquals(242, darkenedNewImage.getBlue(1, 1));

    assertEquals(101, darkenedNewImage.getRed(1, 2));
    assertEquals(190, darkenedNewImage.getGreen(1, 2));
    assertEquals(55, darkenedNewImage.getBlue(1, 2));

    assertEquals(0, darkenedNewImage.getRed(2, 0));
    assertEquals(138, darkenedNewImage.getGreen(2, 0));
    assertEquals(23, darkenedNewImage.getBlue(2, 0));

    assertEquals(101, darkenedNewImage.getRed(2, 1));
    assertEquals(190, darkenedNewImage.getGreen(2, 1));
    assertEquals(55, darkenedNewImage.getBlue(2, 1));

    assertEquals(76, darkenedNewImage.getRed(2, 2));
    assertEquals(177, darkenedNewImage.getGreen(2, 2));
    assertEquals(242, darkenedNewImage.getBlue(2, 2));
  }


  //tests greyScale-RED  (makes everything the red component)
  @Test
  public void testGreyscaleRed() {
    ImageModelImplementation newImage = new ImageModelImplementation(imagePixelated);
    newImage.setImage("newImage", imagePixelated);
    newImage.greyScaleRed("newImage", "newGrayScaleRedImage");
    ImageModelImplementation grayScaleRedImage =
            new ImageModelImplementation(newImage.getImage("newGrayScaleRedImage"));
    assertEquals(113, grayScaleRedImage.getRed(0, 0));
    assertEquals(113, grayScaleRedImage.getGreen(0, 0));
    assertEquals(113, grayScaleRedImage.getBlue(0, 0));

    assertEquals(88, grayScaleRedImage.getRed(0, 1));
    assertEquals(88, grayScaleRedImage.getGreen(0, 1));
    assertEquals(88, grayScaleRedImage.getBlue(0, 1));

    assertEquals(2, grayScaleRedImage.getRed(0, 2));
    assertEquals(2, grayScaleRedImage.getGreen(0, 2));
    assertEquals(2, grayScaleRedImage.getBlue(0, 2));

    assertEquals(2, grayScaleRedImage.getRed(1, 0));
    assertEquals(2, grayScaleRedImage.getGreen(1, 0));
    assertEquals(2, grayScaleRedImage.getBlue(1, 0));

    assertEquals(88, grayScaleRedImage.getRed(1, 1));
    assertEquals(88, grayScaleRedImage.getGreen(1, 1));
    assertEquals(88, grayScaleRedImage.getBlue(1, 1));

    assertEquals(113, grayScaleRedImage.getRed(1, 2));
    assertEquals(113, grayScaleRedImage.getGreen(1, 2));
    assertEquals(113, grayScaleRedImage.getBlue(1, 2));

    assertEquals(2, grayScaleRedImage.getRed(2, 0));
    assertEquals(2, grayScaleRedImage.getGreen(2, 0));
    assertEquals(2, grayScaleRedImage.getBlue(2, 0));

    assertEquals(113, grayScaleRedImage.getRed(2, 1));
    assertEquals(113, grayScaleRedImage.getGreen(2, 1));
    assertEquals(113, grayScaleRedImage.getBlue(2, 1));

    assertEquals(88, grayScaleRedImage.getRed(2, 2));
    assertEquals(88, grayScaleRedImage.getGreen(2, 2));
    assertEquals(88, grayScaleRedImage.getBlue(2, 2));

  }


  //tests greyScale-GREEN  (makes everything the green component)
  @Test
  public void testGreyscaleGreen() {
    ImageModelImplementation newImage = new ImageModelImplementation(imagePixelated);
    newImage.setImage("newImage", imagePixelated);
    newImage.greyScaleGreen("newImage", "newGrayScaleGreenImage");
    ImageModelImplementation grayScaleGreenImage =
            new ImageModelImplementation(newImage.getImage("newGrayScaleGreenImage"));


    assertEquals(202, grayScaleGreenImage.getRed(0, 0));
    assertEquals(202, grayScaleGreenImage.getGreen(0, 0));
    assertEquals(202, grayScaleGreenImage.getBlue(0, 0));

    assertEquals(189, grayScaleGreenImage.getRed(0, 1));
    assertEquals(189, grayScaleGreenImage.getGreen(0, 1));
    assertEquals(189, grayScaleGreenImage.getBlue(0, 1));

    assertEquals(150, grayScaleGreenImage.getRed(0, 2));
    assertEquals(150, grayScaleGreenImage.getGreen(0, 2));
    assertEquals(150, grayScaleGreenImage.getBlue(0, 2));

    assertEquals(150, grayScaleGreenImage.getRed(1, 0));
    assertEquals(150, grayScaleGreenImage.getGreen(1, 0));
    assertEquals(150, grayScaleGreenImage.getBlue(1, 0));

    assertEquals(189, grayScaleGreenImage.getRed(1, 1));
    assertEquals(189, grayScaleGreenImage.getGreen(1, 1));
    assertEquals(189, grayScaleGreenImage.getBlue(1, 1));

    assertEquals(202, grayScaleGreenImage.getRed(1, 2));
    assertEquals(202, grayScaleGreenImage.getGreen(1, 2));
    assertEquals(202, grayScaleGreenImage.getBlue(1, 2));

    assertEquals(150, grayScaleGreenImage.getRed(2, 0));
    assertEquals(150, grayScaleGreenImage.getGreen(2, 0));
    assertEquals(150, grayScaleGreenImage.getBlue(2, 0));

    assertEquals(202, grayScaleGreenImage.getRed(2, 1));
    assertEquals(202, grayScaleGreenImage.getGreen(2, 1));
    assertEquals(202, grayScaleGreenImage.getBlue(2, 1));

    assertEquals(189, grayScaleGreenImage.getRed(2, 2));
    assertEquals(189, grayScaleGreenImage.getGreen(2, 2));
    assertEquals(189, grayScaleGreenImage.getBlue(2, 2));

  }


  //tests greyScale-BLUE  (makes everything the green component)
  @Test
  public void testGreyscaleBlue() {
    ImageModelImplementation newImage = new ImageModelImplementation(imagePixelated);
    newImage.setImage("newImage", imagePixelated);
    newImage.greyScaleBlue("newImage", "newGrayScaleBlueImage");
    ImageModelImplementation grayScaleBlueImage =
            new ImageModelImplementation(newImage.getImage("newGrayScaleBlueImage"));


    assertEquals(67, grayScaleBlueImage.getRed(0, 0));
    assertEquals(67, grayScaleBlueImage.getGreen(0, 0));
    assertEquals(67, grayScaleBlueImage.getBlue(0, 0));

    assertEquals(254, grayScaleBlueImage.getRed(0, 1));
    assertEquals(254, grayScaleBlueImage.getGreen(0, 1));
    assertEquals(254, grayScaleBlueImage.getBlue(0, 1));

    assertEquals(35, grayScaleBlueImage.getRed(0, 2));
    assertEquals(35, grayScaleBlueImage.getGreen(0, 2));
    assertEquals(35, grayScaleBlueImage.getBlue(0, 2));

    assertEquals(35, grayScaleBlueImage.getRed(1, 0));
    assertEquals(35, grayScaleBlueImage.getGreen(1, 0));
    assertEquals(35, grayScaleBlueImage.getBlue(1, 0));

    assertEquals(254, grayScaleBlueImage.getRed(1, 1));
    assertEquals(254, grayScaleBlueImage.getGreen(1, 1));
    assertEquals(254, grayScaleBlueImage.getBlue(1, 1));

    assertEquals(67, grayScaleBlueImage.getRed(1, 2));
    assertEquals(67, grayScaleBlueImage.getGreen(1, 2));
    assertEquals(67, grayScaleBlueImage.getBlue(1, 2));

    assertEquals(35, grayScaleBlueImage.getRed(2, 0));
    assertEquals(35, grayScaleBlueImage.getGreen(2, 0));
    assertEquals(35, grayScaleBlueImage.getBlue(2, 0));

    assertEquals(67, grayScaleBlueImage.getRed(2, 1));
    assertEquals(67, grayScaleBlueImage.getGreen(2, 1));
    assertEquals(67, grayScaleBlueImage.getBlue(2, 1));

    assertEquals(254, grayScaleBlueImage.getRed(2, 2));
    assertEquals(254, grayScaleBlueImage.getGreen(2, 2));
    assertEquals(254, grayScaleBlueImage.getBlue(2, 2));
  }


  //tests luma (by the given equation)
  @Test
  public void testLuma() {
    ImageModelImplementation newImage = new ImageModelImplementation(imagePixelated);
    newImage.setImage("newImage", imagePixelated);
    newImage.luma("newImage", "newLumaImage");
    ImageModelImplementation grayScaleLumaImage =
            new ImageModelImplementation(newImage.getImage("newLumaImage"));


    assertEquals(173, grayScaleLumaImage.getRed(0, 0));
    assertEquals(173, grayScaleLumaImage.getGreen(0, 0));
    assertEquals(173, grayScaleLumaImage.getBlue(0, 0));

    assertEquals(172, grayScaleLumaImage.getRed(0, 1));
    assertEquals(172, grayScaleLumaImage.getGreen(0, 1));
    assertEquals(172, grayScaleLumaImage.getBlue(0, 1));

    assertEquals(110, grayScaleLumaImage.getRed(0, 2));
    assertEquals(110, grayScaleLumaImage.getGreen(0, 2));
    assertEquals(110, grayScaleLumaImage.getBlue(0, 2));

    assertEquals(110, grayScaleLumaImage.getRed(1, 0));
    assertEquals(110, grayScaleLumaImage.getGreen(1, 0));
    assertEquals(110, grayScaleLumaImage.getBlue(1, 0));

    assertEquals(172, grayScaleLumaImage.getRed(1, 1));
    assertEquals(172, grayScaleLumaImage.getGreen(1, 1));
    assertEquals(172, grayScaleLumaImage.getBlue(1, 1));

    assertEquals(173, grayScaleLumaImage.getRed(1, 2));
    assertEquals(173, grayScaleLumaImage.getGreen(1, 2));
    assertEquals(173, grayScaleLumaImage.getBlue(1, 2));

    assertEquals(110, grayScaleLumaImage.getRed(2, 0));
    assertEquals(110, grayScaleLumaImage.getGreen(2, 0));
    assertEquals(110, grayScaleLumaImage.getBlue(2, 0));

    assertEquals(173, grayScaleLumaImage.getRed(2, 1));
    assertEquals(173, grayScaleLumaImage.getGreen(2, 1));
    assertEquals(173, grayScaleLumaImage.getBlue(2, 1));

    assertEquals(172, grayScaleLumaImage.getRed(2, 2));
    assertEquals(172, grayScaleLumaImage.getGreen(2, 2));
    assertEquals(172, grayScaleLumaImage.getBlue(2, 2));
  }


  //tests intensity
  @Test
  public void testIntensity() {
    ImageModelImplementation newImage = new ImageModelImplementation(imagePixelated);
    newImage.setImage("newImage", imagePixelated);
    newImage.intensity("newImage", "newGrayScaleIntensityImage");
    ImageModelImplementation grayScaleIntensityImage =
            new ImageModelImplementation(newImage.getImage("newGrayScaleIntensityImage"));


    assertEquals(127, grayScaleIntensityImage.getRed(0, 0));
    assertEquals(127, grayScaleIntensityImage.getGreen(0, 0));
    assertEquals(127, grayScaleIntensityImage.getBlue(0, 0));

    assertEquals(177, grayScaleIntensityImage.getRed(0, 1));
    assertEquals(177, grayScaleIntensityImage.getGreen(0, 1));
    assertEquals(177, grayScaleIntensityImage.getBlue(0, 1));

    assertEquals(62, grayScaleIntensityImage.getRed(0, 2));
    assertEquals(62, grayScaleIntensityImage.getGreen(0, 2));
    assertEquals(62, grayScaleIntensityImage.getBlue(0, 2));

    assertEquals(62, grayScaleIntensityImage.getRed(1, 0));
    assertEquals(62, grayScaleIntensityImage.getGreen(1, 0));
    assertEquals(62, grayScaleIntensityImage.getBlue(1, 0));

    assertEquals(177, grayScaleIntensityImage.getRed(1, 1));
    assertEquals(177, grayScaleIntensityImage.getGreen(1, 1));
    assertEquals(177, grayScaleIntensityImage.getBlue(1, 1));

    assertEquals(127, grayScaleIntensityImage.getRed(1, 2));
    assertEquals(127, grayScaleIntensityImage.getGreen(1, 2));
    assertEquals(127, grayScaleIntensityImage.getBlue(1, 2));

    assertEquals(62, grayScaleIntensityImage.getRed(2, 0));
    assertEquals(62, grayScaleIntensityImage.getGreen(2, 0));
    assertEquals(62, grayScaleIntensityImage.getBlue(2, 0));

    assertEquals(127, grayScaleIntensityImage.getRed(2, 1));
    assertEquals(127, grayScaleIntensityImage.getGreen(2, 1));
    assertEquals(127, grayScaleIntensityImage.getBlue(2, 1));

    assertEquals(177, grayScaleIntensityImage.getRed(2, 2));
    assertEquals(177, grayScaleIntensityImage.getGreen(2, 2));
    assertEquals(177, grayScaleIntensityImage.getBlue(2, 2));
  }

  //tests value
  @Test
  public void testValue() {
    ImageModelImplementation newImage = new ImageModelImplementation(imagePixelated);
    newImage.setImage("newImage", imagePixelated);
    newImage.value("newImage", "newGrayScaleValueImage");
    ImageModelImplementation grayScaleValueImage =
            new ImageModelImplementation(newImage.getImage("newGrayScaleValueImage"));


    assertEquals(202, grayScaleValueImage.getRed(0, 0));
    assertEquals(202, grayScaleValueImage.getGreen(0, 0));
    assertEquals(202, grayScaleValueImage.getBlue(0, 0));

    assertEquals(254, grayScaleValueImage.getRed(0, 1));
    assertEquals(254, grayScaleValueImage.getGreen(0, 1));
    assertEquals(254, grayScaleValueImage.getBlue(0, 1));

    assertEquals(150, grayScaleValueImage.getRed(0, 2));
    assertEquals(150, grayScaleValueImage.getGreen(0, 2));
    assertEquals(150, grayScaleValueImage.getBlue(0, 2));

    assertEquals(150, grayScaleValueImage.getRed(1, 0));
    assertEquals(150, grayScaleValueImage.getGreen(1, 0));
    assertEquals(150, grayScaleValueImage.getBlue(1, 0));

    assertEquals(254, grayScaleValueImage.getRed(1, 1));
    assertEquals(254, grayScaleValueImage.getGreen(1, 1));
    assertEquals(254, grayScaleValueImage.getBlue(1, 1));

    assertEquals(202, grayScaleValueImage.getRed(1, 2));
    assertEquals(202, grayScaleValueImage.getGreen(1, 2));
    assertEquals(202, grayScaleValueImage.getBlue(1, 2));

    assertEquals(150, grayScaleValueImage.getRed(2, 0));
    assertEquals(150, grayScaleValueImage.getGreen(2, 0));
    assertEquals(150, grayScaleValueImage.getBlue(2, 0));

    assertEquals(202, grayScaleValueImage.getRed(2, 1));
    assertEquals(202, grayScaleValueImage.getGreen(2, 1));
    assertEquals(202, grayScaleValueImage.getBlue(2, 1));

    assertEquals(254, grayScaleValueImage.getRed(2, 2));
    assertEquals(254, grayScaleValueImage.getGreen(2, 2));
    assertEquals(254, grayScaleValueImage.getBlue(2, 2));


  }

  //tests to check if the image was vertically flipped.
  @Test
  public void testVertical() {
    ImageModelImplementation newImage = new ImageModelImplementation(imagePixelated);
    newImage.setImage("newImage", imagePixelated);
    newImage.flipImageVertical("newImage", "newVerticalImage");
    ImageModelImplementation verticalImage =
            new ImageModelImplementation(newImage.getImage("newVerticalImage"));

    assertEquals(2, verticalImage.getRed(0, 0));
    assertEquals(150, verticalImage.getGreen(0, 0));
    assertEquals(35, verticalImage.getBlue(0, 0));

    assertEquals(88, verticalImage.getRed(0, 1));
    assertEquals(189, verticalImage.getGreen(0, 1));
    assertEquals(254, verticalImage.getBlue(0, 1));

    assertEquals(113, verticalImage.getRed(0, 2));
    assertEquals(202, verticalImage.getGreen(0, 2));
    assertEquals(67, verticalImage.getBlue(0, 2));

    assertEquals(113, verticalImage.getRed(1, 0));
    assertEquals(202, verticalImage.getGreen(1, 0));
    assertEquals(67, verticalImage.getBlue(1, 0));

    assertEquals(88, verticalImage.getRed(1, 1));
    assertEquals(189, verticalImage.getGreen(1, 1));
    assertEquals(254, verticalImage.getBlue(1, 1));

    assertEquals(2, verticalImage.getRed(1, 2));
    assertEquals(150, verticalImage.getGreen(1, 2));
    assertEquals(35, verticalImage.getBlue(1, 2));

    assertEquals(88, verticalImage.getRed(2, 0));
    assertEquals(189, verticalImage.getGreen(2, 0));
    assertEquals(254, verticalImage.getBlue(2, 0));

    assertEquals(113, verticalImage.getRed(2, 1));
    assertEquals(202, verticalImage.getGreen(2, 1));
    assertEquals(67, verticalImage.getBlue(2, 1));

    assertEquals(2, verticalImage.getRed(2, 2));
    assertEquals(150, verticalImage.getGreen(2, 2));
    assertEquals(35, verticalImage.getBlue(2, 2));
  }


  //tests to check if the image was horizontally flipped.
  @Test
  public void testHorizontal() {
    ImageModelImplementation newImage = new ImageModelImplementation(imagePixelated);
    newImage.setImage("newImage", imagePixelated);
    newImage.flipImageHorizontal("newImage", "newHorizontalImage");
    ImageModelImplementation horizontalImage =
            new ImageModelImplementation(newImage.getImage("newHorizontalImage"));

    assertEquals(2, horizontalImage.getRed(0, 0));
    assertEquals(150, horizontalImage.getGreen(0, 0));
    assertEquals(35, horizontalImage.getBlue(0, 0));

    assertEquals(113, horizontalImage.getRed(0, 1));
    assertEquals(202, horizontalImage.getGreen(0, 1));
    assertEquals(67, horizontalImage.getBlue(0, 1));

    assertEquals(88, horizontalImage.getRed(0, 2));
    assertEquals(189, horizontalImage.getGreen(0, 2));
    assertEquals(254, horizontalImage.getBlue(0, 2));

    assertEquals(2, horizontalImage.getRed(1, 0));
    assertEquals(150, horizontalImage.getGreen(1, 0));
    assertEquals(35, horizontalImage.getBlue(1, 0));

    assertEquals(88, horizontalImage.getRed(1, 1));
    assertEquals(189, horizontalImage.getGreen(1, 1));
    assertEquals(254, horizontalImage.getBlue(1, 1));

    assertEquals(113, horizontalImage.getRed(1, 2));
    assertEquals(202, horizontalImage.getGreen(1, 2));
    assertEquals(67, horizontalImage.getBlue(1, 2));

    assertEquals(113, horizontalImage.getRed(2, 0));
    assertEquals(202, horizontalImage.getGreen(2, 0));
    assertEquals(67, horizontalImage.getBlue(2, 0));

    assertEquals(88, horizontalImage.getRed(2, 1));
    assertEquals(189, horizontalImage.getGreen(2, 1));
    assertEquals(254, horizontalImage.getBlue(2, 1));

    assertEquals(2, horizontalImage.getRed(2, 2));
    assertEquals(150, horizontalImage.getGreen(2, 2));
    assertEquals(35, horizontalImage.getBlue(2, 2));


  }


  @Test
  public void blurImage() {
    ImageModelImplementation newImage = new ImageModelImplementation(imagePixelated);
    newImage.setImage("newImage", imagePixelated);
    newImage.blur("newImage", "newBlurImage");
    ImageModelImplementation blurImage =
            new ImageModelImplementation(newImage.getImage("newBlurImage"));

    assertEquals(45, blurImage.getRed(0, 0));
    assertEquals(106, blurImage.getGreen(0, 0));
    assertEquals(69, blurImage.getBlue(0, 0));

    assertEquals(54, blurImage.getRed(0, 1));
    assertEquals(137, blurImage.getGreen(0, 1));
    assertEquals(114, blurImage.getBlue(0, 1));

    assertEquals(32, blurImage.getRed(0, 2));
    assertEquals(99, blurImage.getGreen(0, 2));
    assertEquals(65, blurImage.getBlue(0, 2));

    assertEquals(39, blurImage.getRed(1, 0));
    assertEquals(131, blurImage.getGreen(1, 0));
    assertEquals(73, blurImage.getBlue(1, 0));

    assertEquals(74, blurImage.getRed(1, 1));
    assertEquals(183, blurImage.getGreen(1, 1));
    assertEquals(140, blurImage.getBlue(1, 1));

    assertEquals(63, blurImage.getRed(1, 2));
    assertEquals(143, blurImage.getGreen(1, 2));
    assertEquals(105, blurImage.getBlue(1, 2));

    assertEquals(21, blurImage.getRed(2, 0));
    assertEquals(94, blurImage.getGreen(2, 0));
    assertEquals(37, blurImage.getBlue(2, 0));

    assertEquals(57, blurImage.getRed(2, 1));
    assertEquals(140, blurImage.getGreen(2, 1));
    assertEquals(91, blurImage.getBlue(2, 1));

    assertEquals(56, blurImage.getRed(2, 2));
    assertEquals(109, blurImage.getGreen(2, 2));
    assertEquals(96, blurImage.getBlue(2, 2));
  }

  //sharpen image
  @Test
  public void sharpenImage() {
    ImageModelImplementation newImage = new ImageModelImplementation(imagePixelated);
    newImage.setImage("newImage", imagePixelated);
    newImage.sharpen("newImage", "newSharpenImage");
    ImageModelImplementation sharpenImage =
            new ImageModelImplementation(newImage.getImage("newSharpenImage"));

    assertEquals(119, sharpenImage.getRed(0, 0));
    assertEquals(222, sharpenImage.getGreen(0, 0));
    assertEquals(148, sharpenImage.getBlue(0, 0));

    assertEquals(143, sharpenImage.getRed(0, 1));
    assertEquals(255, sharpenImage.getGreen(0, 1));
    assertEquals(255, sharpenImage.getBlue(0, 1));

    assertEquals(35, sharpenImage.getRed(0, 2));
    assertEquals(183, sharpenImage.getGreen(0, 2));
    assertEquals(124, sharpenImage.getBlue(0, 2));

    assertEquals(78, sharpenImage.getRed(1, 0));
    assertEquals(255, sharpenImage.getGreen(1, 0));
    assertEquals(162, sharpenImage.getBlue(1, 0));

    assertEquals(219, sharpenImage.getRed(1, 1));
    assertEquals(255, sharpenImage.getGreen(1, 1));
    assertEquals(255, sharpenImage.getBlue(1, 1));

    assertEquals(194, sharpenImage.getRed(1, 2));
    assertEquals(255, sharpenImage.getGreen(1, 2));
    assertEquals(255, sharpenImage.getBlue(1, 2));

    assertEquals(3, sharpenImage.getRed(2, 0));
    assertEquals(169, sharpenImage.getGreen(2, 0));
    assertEquals(41, sharpenImage.getBlue(2, 0));

    assertEquals(162, sharpenImage.getRed(2, 1));
    assertEquals(255, sharpenImage.getGreen(2, 1));
    assertEquals(186, sharpenImage.getBlue(2, 1));

    assertEquals(141, sharpenImage.getRed(2, 2));
    assertEquals(232, sharpenImage.getGreen(2, 2));
    assertEquals(255, sharpenImage.getBlue(2, 2));
  }

  //greyscale using transformation
  @Test
  public void greyScaleTransformation() {
    ImageModelImplementation newImage = new ImageModelImplementation(imagePixelated);
    newImage.setImage("newImage", imagePixelated);
    newImage.toGreyscale("newImage", "newGreyscaleImage");
    ImageModelImplementation greyscaleImage =
            new ImageModelImplementation(newImage.getImage("newGreyscaleImage"));

    assertEquals(173, greyscaleImage.getRed(0, 0));
    assertEquals(173, greyscaleImage.getGreen(0, 0));
    assertEquals(173, greyscaleImage.getBlue(0, 0));

    assertEquals(172, greyscaleImage.getRed(0, 1));
    assertEquals(172, greyscaleImage.getGreen(0, 1));
    assertEquals(172, greyscaleImage.getBlue(0, 1));

    assertEquals(110, greyscaleImage.getRed(0, 2));
    assertEquals(110, greyscaleImage.getGreen(0, 2));
    assertEquals(110, greyscaleImage.getBlue(0, 2));

    assertEquals(110, greyscaleImage.getRed(1, 0));
    assertEquals(110, greyscaleImage.getGreen(1, 0));
    assertEquals(110, greyscaleImage.getBlue(1, 0));

    assertEquals(172, greyscaleImage.getRed(1, 1));
    assertEquals(172, greyscaleImage.getGreen(1, 1));
    assertEquals(172, greyscaleImage.getBlue(1, 1));

    assertEquals(173, greyscaleImage.getRed(1, 2));
    assertEquals(173, greyscaleImage.getGreen(1, 2));
    assertEquals(173, greyscaleImage.getBlue(1, 2));

    assertEquals(110, greyscaleImage.getRed(2, 0));
    assertEquals(110, greyscaleImage.getGreen(2, 0));
    assertEquals(110, greyscaleImage.getBlue(2, 0));

    assertEquals(173, greyscaleImage.getRed(2, 1));
    assertEquals(173, greyscaleImage.getGreen(2, 1));
    assertEquals(173, greyscaleImage.getBlue(2, 1));

    assertEquals(172, greyscaleImage.getRed(2, 2));
    assertEquals(172, greyscaleImage.getGreen(2, 2));
    assertEquals(172, greyscaleImage.getBlue(2, 2));
  }

  //add sepia using transform
  @Test
  public void sepiaTransformation() {
    ImageModelImplementation newImage = new ImageModelImplementation(imagePixelated);
    newImage.setImage("newImage", imagePixelated);
    newImage.toSepia("newImage", "newSepiaImage");
    ImageModelImplementation sepiaImage =
            new ImageModelImplementation(newImage.getImage("newSepiaImage"));

    assertEquals(212, sepiaImage.getRed(0, 0));
    assertEquals(189, sepiaImage.getGreen(0, 0));
    assertEquals(147, sepiaImage.getBlue(0, 0));

    assertEquals(228, sepiaImage.getRed(0, 1));
    assertEquals(203, sepiaImage.getGreen(0, 1));
    assertEquals(158, sepiaImage.getBlue(0, 1));

    assertEquals(123, sepiaImage.getRed(0, 2));
    assertEquals(109, sepiaImage.getGreen(0, 2));
    assertEquals(85, sepiaImage.getBlue(0, 2));

    assertEquals(123, sepiaImage.getRed(1, 0));
    assertEquals(109, sepiaImage.getGreen(1, 0));
    assertEquals(85, sepiaImage.getBlue(1, 0));

    assertEquals(228, sepiaImage.getRed(1, 1));
    assertEquals(203, sepiaImage.getGreen(1, 1));
    assertEquals(158, sepiaImage.getBlue(1, 1));

    assertEquals(212, sepiaImage.getRed(1, 2));
    assertEquals(189, sepiaImage.getGreen(1, 2));
    assertEquals(147, sepiaImage.getBlue(1, 2));

    assertEquals(123, sepiaImage.getRed(2, 0));
    assertEquals(109, sepiaImage.getGreen(2, 0));
    assertEquals(85, sepiaImage.getBlue(2, 0));

    assertEquals(212, sepiaImage.getRed(2, 1));
    assertEquals(189, sepiaImage.getGreen(2, 1));
    assertEquals(147, sepiaImage.getBlue(2, 1));

    assertEquals(228, sepiaImage.getRed(2, 2));
    assertEquals(203, sepiaImage.getGreen(2, 2));
    assertEquals(158, sepiaImage.getBlue(2, 2));
  }


  //checks to see if the correct image is loaded
  @Test
  public void loadImage() throws IOException {
    loadSaveImage.loadImage("res/Koala.ppm", "loadedImage");
    ImageModelImplementation loadedImage =
            new ImageModelImplementation(loadSaveImage.getImage("loadedImage"));
    assertEquals(101, loadedImage.getRed(0, 0));
    assertEquals(90, loadedImage.getGreen(0, 0));
    assertEquals(58, loadedImage.getBlue(0, 0));

    assertEquals(100, loadedImage.getRed(5, 5));
    assertEquals(88, loadedImage.getGreen(5, 5));
    assertEquals(64, loadedImage.getBlue(5, 5));

    assertEquals(19, loadedImage.getRed(700, 650));
    assertEquals(20, loadedImage.getGreen(700, 650));
    assertEquals(14, loadedImage.getBlue(700, 650));

    assertEquals(122, loadedImage.getRed(100, 65));
    assertEquals(106, loadedImage.getGreen(100, 65));
    assertEquals(72, loadedImage.getBlue(100, 65));

    assertEquals(85, loadedImage.getRed(320, 332));
    assertEquals(79, loadedImage.getGreen(320, 332));
    assertEquals(67, loadedImage.getBlue(320, 332));

    assertEquals(165, loadedImage.getRed(400, 559));
    assertEquals(152, loadedImage.getGreen(400, 559));
    assertEquals(144, loadedImage.getBlue(400, 559));

  }

  @Test
  public void loadImagePNG() throws IOException {
    loadSaveImage.loadImage("res/flower.png", "loadedImage");
    ImageModelImplementation loadedImage =
            new ImageModelImplementation(loadSaveImage.getImage("loadedImage"));
    assertEquals(109, loadedImage.getRed(0, 0));
    assertEquals(86, loadedImage.getGreen(0, 0));
    assertEquals(120, loadedImage.getBlue(0, 0));

    assertEquals(169, loadedImage.getRed(5, 5));
    assertEquals(148, loadedImage.getGreen(5, 5));
    assertEquals(206, loadedImage.getBlue(5, 5));

    assertEquals(180, loadedImage.getRed(300, 250));
    assertEquals(97, loadedImage.getGreen(300, 250));
    assertEquals(124, loadedImage.getBlue(300, 250));
  }

  @Test
  public void loadImageJPG() throws IOException {
    loadSaveImage.loadImage("res/reivarsh.jpg", "loadedImage");
    ImageModelImplementation loadedImage =
            new ImageModelImplementation(loadSaveImage.getImage("loadedImage"));
    assertEquals(67, loadedImage.getRed(0, 0));
    assertEquals(50, loadedImage.getGreen(0, 0));
    assertEquals(43, loadedImage.getBlue(0, 0));

    assertEquals(59, loadedImage.getRed(5, 5));
    assertEquals(40, loadedImage.getGreen(5, 5));
    assertEquals(34, loadedImage.getBlue(5, 5));


    assertEquals(39, loadedImage.getRed(100, 65));
    assertEquals(28, loadedImage.getGreen(100, 65));
    assertEquals(24, loadedImage.getBlue(100, 65));

  }

  @Test
  public void loadImageBMP() throws IOException {
    loadSaveImage.loadImage("res/pizza.bmp", "loadedImage");
    ImageModelImplementation loadedImage =
            new ImageModelImplementation(loadSaveImage.getImage("loadedImage"));
    assertEquals(243, loadedImage.getRed(0, 0));
    assertEquals(236, loadedImage.getGreen(0, 0));
    assertEquals(209, loadedImage.getBlue(0, 0));

    assertEquals(231, loadedImage.getRed(13, 13));
    assertEquals(219, loadedImage.getGreen(13, 13));
    assertEquals(193, loadedImage.getBlue(13, 13));

    assertEquals(120, loadedImage.getRed(205, 270));
    assertEquals(30, loadedImage.getGreen(205, 270));
    assertEquals(17, loadedImage.getBlue(205, 270));

  }

  //checks to see if the accurate image has been saved.
  @Test
  public void saveImage() throws IOException {
    loadSaveImage.loadImage("res/Koala.ppm", "loadedImage");
    loadSaveImage.luma("loadedImage", "newLumaImage");
    loadSaveImage.flipImageVertical("newLumaImage", "newLumaVerticalImage");
    loadSaveImage.saveImage("newLumaVerticalImage", "saveLumaVerticalImage.ppm");
    ImageModelImplementation saveFilteredImage =
            new ImageModelImplementation(loadSaveImage.getImage("saveLumaVerticalImage.ppm"));

    assertEquals(88, saveFilteredImage.getRed(0, 0));
    assertEquals(88, saveFilteredImage.getBlue(0, 0));
    assertEquals(88, saveFilteredImage.getGreen(0, 0));

    assertEquals(118, saveFilteredImage.getRed(64, 69));
    assertEquals(118, saveFilteredImage.getBlue(64, 69));
    assertEquals(118, saveFilteredImage.getGreen(64, 69));

    assertEquals(111, saveFilteredImage.getRed(94, 26));
    assertEquals(111, saveFilteredImage.getBlue(94, 26));
    assertEquals(111, saveFilteredImage.getGreen(94, 26));

    assertEquals(160, saveFilteredImage.getRed(639, 724));
    assertEquals(160, saveFilteredImage.getBlue(639, 724));
    assertEquals(160, saveFilteredImage.getGreen(639, 724));

    assertEquals(105, saveFilteredImage.getRed(366, 424));
    assertEquals(105, saveFilteredImage.getBlue(366, 424));
    assertEquals(105, saveFilteredImage.getGreen(366, 424));

    assertEquals(211, saveFilteredImage.getRed(765, 1022));
    assertEquals(211, saveFilteredImage.getBlue(765, 1022));
    assertEquals(211, saveFilteredImage.getGreen(765, 1022));

  }

  //checks to see if the accurate image has been saved
  @Test
  public void saveImageVertical() throws IOException {
    loadSaveImage.loadImage("res/Koala.ppm", "loadedImage");
    loadSaveImage.flipImageVertical("loadedImage", "newVerticalImage");
    loadSaveImage.saveImage("newVerticalImage", "saveVerticalImage.ppm");
    ImageModelImplementation saveFilteredImage =
            new ImageModelImplementation(loadSaveImage.getImage("saveVerticalImage.ppm"));

    assertEquals(92, saveFilteredImage.getRed(0, 0));
    assertEquals(60, saveFilteredImage.getBlue(0, 0));
    assertEquals(91, saveFilteredImage.getGreen(0, 0));

    assertEquals(112, saveFilteredImage.getRed(22, 69));
    assertEquals(85, saveFilteredImage.getBlue(22, 69));
    assertEquals(110, saveFilteredImage.getGreen(22, 69));

    assertEquals(235, saveFilteredImage.getRed(100, 103));
    assertEquals(230, saveFilteredImage.getBlue(100, 103));
    assertEquals(231, saveFilteredImage.getGreen(100, 103));

    assertEquals(50, saveFilteredImage.getRed(722, 334));
    assertEquals(34, saveFilteredImage.getBlue(722, 334));
    assertEquals(46, saveFilteredImage.getGreen(722, 334));

    assertEquals(91, saveFilteredImage.getRed(536, 400));
    assertEquals(84, saveFilteredImage.getBlue(536, 400));
    assertEquals(92, saveFilteredImage.getGreen(536, 400));

    assertEquals(132, saveFilteredImage.getRed(339, 1012));
    assertEquals(84, saveFilteredImage.getBlue(339, 1012));
    assertEquals(105, saveFilteredImage.getGreen(339, 1012));

  }


  //tests to get the red component of the given pixel (in the specified row/col).
  @Test
  public void testGetRed() {
    ImageModelImplementation newImage = new ImageModelImplementation(imagePixelated);
    newImage.setImage("newImage", imagePixelated);
    assertEquals(113, newImage.getRed(0, 0));
    assertEquals(88, newImage.getRed(0, 1));
    assertEquals(2, newImage.getRed(0, 2));
    assertEquals(2, newImage.getRed(1, 0));
    assertEquals(88, newImage.getRed(1, 1));
    assertEquals(113, newImage.getRed(1, 2));
    assertEquals(2, newImage.getRed(2, 0));
    assertEquals(113, newImage.getRed(2, 1));
    assertEquals(88, newImage.getRed(2, 2));

  }


  //tests to get the green component of the given pixel (in the specified row/col).
  @Test
  public void testGetGreen() {
    ImageModelImplementation newImage = new ImageModelImplementation(imagePixelated);
    newImage.setImage("newImage", imagePixelated);
    assertEquals(202, newImage.getGreen(0, 0));
    assertEquals(189, newImage.getGreen(0, 1));
    assertEquals(150, newImage.getGreen(0, 2));
    assertEquals(150, newImage.getGreen(1, 0));
    assertEquals(189, newImage.getGreen(1, 1));
    assertEquals(202, newImage.getGreen(1, 2));
    assertEquals(150, newImage.getGreen(2, 0));
    assertEquals(202, newImage.getGreen(2, 1));
    assertEquals(189, newImage.getGreen(2, 2));

  }

  //tests to get the blue component of the given pixel (in the specified row/col).
  @Test
  public void testGetBlue() {
    ImageModelImplementation newImage = new ImageModelImplementation(imagePixelated);
    newImage.setImage("newImage", imagePixelated);
    assertEquals(67, newImage.getBlue(0, 0));
    assertEquals(254, newImage.getBlue(0, 1));
    assertEquals(35, newImage.getBlue(0, 2));
    assertEquals(35, newImage.getBlue(1, 0));
    assertEquals(254, newImage.getBlue(1, 1));
    assertEquals(67, newImage.getBlue(1, 2));
    assertEquals(35, newImage.getBlue(2, 0));
    assertEquals(67, newImage.getBlue(2, 1));
    assertEquals(254, newImage.getBlue(2, 2));

  }


  //tests to check if the setters and getters for the map work
  @Test
  public void testSetGetImage() {

    ImageModelImplementation newImage = new ImageModelImplementation(imagePixelated);
    newImage.setImage("newImage", imagePixelated);
    newImage.setImage("newImageSecond", imagePixelated1);
    newImage.setImage("newImageThird", imagePixelated2);
    assertEquals(imagePixelated, newImage.getImage("newImage"));
    assertEquals(imagePixelated1, newImage.getImage("newImageSecond"));
    assertEquals(imagePixelated2, newImage.getImage("newImageThird"));


  }

  /**
   * tests package IMAGE.
   */

  //IMAGE IMPLEMENTATION
  @Test
  public void testImageImplementationConstructorStringFileName() throws IOException {
    Image imageFile = new ImageImplementation("res/Koala.ppm");
    assertEquals(1024, imageFile.getImageWidth());
    //also represents the pixel length
    assertEquals(768, imageFile.getImageHeight());
    assertEquals(255, imageFile.getMaxValue());

  }

  //checks to check that the image loaded has the correct width, hieght, maxValue
  @Test
  public void testImageImplementationConstructorPixelParameter() {
    assertEquals(3, imagePixelated.getImageWidth());
    assertEquals(3, imagePixelated1.getImageWidth());
    assertEquals(3, imagePixelated2.getImageWidth());
    assertEquals(2, imagePixelated3.getImageWidth());
    assertEquals(2, imagePixelated4.getImageWidth());
    assertEquals(2, imagePixelated5.getImageWidth());

    assertEquals(3, imagePixelated.getImageHeight());
    assertEquals(3, imagePixelated1.getImageHeight());
    assertEquals(3, imagePixelated2.getImageHeight());
    assertEquals(2, imagePixelated3.getImageHeight());
    assertEquals(2, imagePixelated4.getImageHeight());
    assertEquals(2, imagePixelated5.getImageHeight());

    assertEquals(254, imagePixelated.getMaxValue());
    assertEquals(254, imagePixelated1.getMaxValue());
    assertEquals(254, imagePixelated2.getMaxValue());
    assertEquals(254, imagePixelated3.getMaxValue());
    assertEquals(254, imagePixelated4.getMaxValue());
    assertEquals(254, imagePixelated5.getMaxValue());

    assertEquals(pixelArray, imagePixelated.getImage());
    assertEquals(pixelArray1, imagePixelated1.getImage());
    assertEquals(pixelArray2, imagePixelated2.getImage());
    assertEquals(pixelArray3, imagePixelated3.getImage());
    assertEquals(pixelArray4, imagePixelated4.getImage());
    assertEquals(pixelArray5, imagePixelated5.getImage());

  }

  //checks to check that the image loaded has the correct width, hieght, maxValue
  @Test
  public void testImageImplementationConstructorPixelMaxValueParameter() {
    assertEquals(3, imagePixelated6.getImageWidth());
    assertEquals(3, imagePixelated7.getImageWidth());
    assertEquals(3, imagePixelated8.getImageWidth());
    assertEquals(2, imagePixelated9.getImageWidth());
    assertEquals(2, imagePixelated10.getImageWidth());
    assertEquals(2, imagePixelated11.getImageWidth());

    assertEquals(3, imagePixelated6.getImageHeight());
    assertEquals(3, imagePixelated7.getImageHeight());
    assertEquals(3, imagePixelated8.getImageHeight());
    assertEquals(2, imagePixelated9.getImageHeight());
    assertEquals(2, imagePixelated10.getImageHeight());
    assertEquals(2, imagePixelated11.getImageHeight());

    assertEquals(255, imagePixelated6.getMaxValue());
    assertEquals(255, imagePixelated7.getMaxValue());
    assertEquals(255, imagePixelated8.getMaxValue());
    assertEquals(255, imagePixelated9.getMaxValue());
    assertEquals(255, imagePixelated10.getMaxValue());
    assertEquals(255, imagePixelated11.getMaxValue());

    assertEquals(pixelArray, imagePixelated6.getImage());
    assertEquals(pixelArray1, imagePixelated7.getImage());
    assertEquals(pixelArray2, imagePixelated8.getImage());
    assertEquals(pixelArray3, imagePixelated9.getImage());
    assertEquals(pixelArray4, imagePixelated10.getImage());
    assertEquals(pixelArray5, imagePixelated11.getImage());
  }


  //tests if the accurate width is returned.
  @Test
  public void testImageGetWidth() {
    assertEquals(3, imagePixelated.getImageWidth());
    assertEquals(3, imagePixelated1.getImageWidth());
    assertEquals(3, imagePixelated2.getImageWidth());
    assertEquals(2, imagePixelated3.getImageWidth());
    assertEquals(2, imagePixelated4.getImageWidth());
    assertEquals(2, imagePixelated5.getImageWidth());
  }

  //tests if the accurate height  is returned.
  @Test
  public void testImageGetHeight() {
    assertEquals(3, imagePixelated.getImageHeight());
    assertEquals(3, imagePixelated1.getImageHeight());
    assertEquals(3, imagePixelated2.getImageHeight());
    assertEquals(2, imagePixelated3.getImageHeight());
    assertEquals(2, imagePixelated4.getImageHeight());
    assertEquals(2, imagePixelated5.getImageHeight());
  }

  //tests if the correct pixel is returned.
  @Test
  public void testGetImage() {
    assertEquals(pixelArray, imagePixelated.getImage());
    assertEquals(pixelArray1, imagePixelated1.getImage());
    assertEquals(pixelArray2, imagePixelated2.getImage());
    assertEquals(pixelArray3, imagePixelated3.getImage());
    assertEquals(pixelArray4, imagePixelated4.getImage());
    assertEquals(pixelArray5, imagePixelated5.getImage());
  }

  //tests if the correct max value is returned
  @Test
  public void testGetMaxValue() {
    assertEquals(254, imagePixelated.getMaxValue());
    assertEquals(254, imagePixelated1.getMaxValue());
    assertEquals(254, imagePixelated2.getMaxValue());
    assertEquals(254, imagePixelated3.getMaxValue());
    assertEquals(254, imagePixelated4.getMaxValue());
    assertEquals(254, imagePixelated5.getMaxValue());
  }


  /**
   * PIXEL PACKAGE.
   */
  //PIXEL IMPLEMENTATION


  //tests the constructor to get the correct red, green, and blue value
  @Test
  public void testPixelConstructor() {
    assertEquals(113, pixel1.getRed());
    assertEquals(202, pixel1.getGreen());
    assertEquals(67, pixel1.getBlue());

    assertEquals(88, pixel2.getRed());
    assertEquals(189, pixel2.getGreen());
    assertEquals(254, pixel2.getBlue());

    assertEquals(2, pixel3.getRed());
    assertEquals(150, pixel3.getGreen());
    assertEquals(35, pixel3.getBlue());
  }

  //gets the red value of the pixel
  @Test
  public void testPixelRed() {

    assertEquals(113, pixel1.getRed());
    assertEquals(88, pixel2.getRed());
    assertEquals(2, pixel3.getRed());

  }

  //gets the green value of the pixel.
  @Test
  public void testPixelGreen() {


    assertEquals(202, pixel1.getGreen());
    assertEquals(189, pixel2.getGreen());
    assertEquals(150, pixel3.getGreen());

  }


  //gets the blue value of the pixel.
  @Test
  public void testPixelBlue() {


    assertEquals(67, pixel1.getBlue());
    assertEquals(254, pixel2.getBlue());
    assertEquals(35, pixel3.getBlue());

  }


  // IMAGE FILTER IMPLEMENTATION
  // to test transform
  @Test
  public void testTransform() {
    ImageFilterImplementation newImage = new ImageFilterImplementation();

    // int[] pixel
    int[] intPixel1 = {1, 2};
    int[] intPixel2 = {2, 3};

    // double[] filter
    double[] filter1 = {7.9, 8.2};
    double[] filter2 = {2.1, 0.1};

    assertEquals(24.30, newImage.transform(intPixel1, filter1), 0.01);
    assertEquals(40.40, newImage.transform(intPixel2, filter1), 0.01);
    assertEquals(2.30, newImage.transform(intPixel1, filter2), 0.01);
    assertEquals(4.50, newImage.transform(intPixel2, filter2), 0.01);

  }

  // to test createNewKernelPixel
  @Test
  public void testCreateNewKernelPixel() {
    ImageFilterImplementation newImage = new ImageFilterImplementation();

    // Pixel[][] kernel
    Pixel[][] kernel1 = {{pixel1, pixel2}, {pixel2, pixel1}};
    Pixel[][] kernel2 = {{pixel2, pixel3}, {pixel1, pixel2}};

    // double[] filter
    double[][] filter1 = {{0.3, 2.4}, {3.3, 1.6}};


    assertEquals(255, newImage.createNewKernelPixel(kernel1, filter1).getRed());
    assertEquals(255, newImage.createNewKernelPixel(kernel1, filter1).getGreen());
    assertEquals(255, newImage.createNewKernelPixel(kernel1, filter1).getBlue());

    assertEquals(255, newImage.createNewKernelPixel(kernel2, filter1).getRed());
    assertEquals(255, newImage.createNewKernelPixel(kernel2, filter1).getGreen());
    assertEquals(255, newImage.createNewKernelPixel(kernel2, filter1).getBlue());
  }

  // to test getKernel
  @Test
  public void testGetKernel() {
    ImageFilterImplementation newImage = new ImageFilterImplementation();

    assertEquals(88, newImage.getKernel(5, 5, pixelArray, 6)[0][0].getRed());
    assertEquals(189, newImage.getKernel(5, 5, pixelArray, 6)[0][0].getGreen());
    assertEquals(254, newImage.getKernel(5, 5, pixelArray, 6)[0][0].getBlue());

    // index out of bounds exception
    assertEquals(0, newImage.getKernel(3, 7, pixelArray, 4)[3][2].getRed());
    assertEquals(0, newImage.getKernel(3, 7, pixelArray, 4)[3][2].getGreen());
    assertEquals(0, newImage.getKernel(3, 7, pixelArray, 4)[3][2].getBlue());
  }

  // to test flipHorizontal
  @Test
  public void testFlipHorizontal() {
    ImageFilterImplementation newImage = new ImageFilterImplementation();
    assertEquals(2, newImage.flipHorizontal(imagePixelated).getImage()[0][0].getRed());
    assertEquals(67, newImage.flipHorizontal(imagePixelated).getImage()[0][0].getBlue());
    assertEquals(150, newImage.flipHorizontal(imagePixelated).getImage()[0][0].getGreen());

    assertEquals(113, newImage.flipHorizontal(imagePixelated1).getImage()[0][0].getRed());
    assertEquals(67, newImage.flipHorizontal(imagePixelated1).getImage()[0][0].getBlue());
    assertEquals(202, newImage.flipHorizontal(imagePixelated1).getImage()[0][0].getGreen());
  }

  // to test flipVertical
  @Test
  public void testFlipVertical() {
    ImageFilterImplementation newImage = new ImageFilterImplementation();
    assertEquals(2, newImage.flipVertical(imagePixelated).getImage()[2][2].getRed());
    assertEquals(254, newImage.flipVertical(imagePixelated).getImage()[2][2].getBlue());
    assertEquals(150, newImage.flipVertical(imagePixelated).getImage()[2][2].getGreen());

    assertEquals(113, newImage.flipVertical(imagePixelated1).getImage()[2][2].getRed());
    assertEquals(254, newImage.flipVertical(imagePixelated1).getImage()[2][2].getBlue());
    assertEquals(202, newImage.flipVertical(imagePixelated1).getImage()[2][2].getGreen());
  }

  //TESTS DOWNSCALE (downscaled by the given increment (0.5))
  @Test
  public void testDownscale() throws IOException {
    loadSaveImage.loadImage("res/flower.png", "flower");
    loadSaveImage.downscale(0.5, "flower", "downscaleImage");
    loadSaveImage.saveImage("downscaleImage", "saveDownscaleImage.ppm");
    ImageModelImplementation downscaleImage =
            new ImageModelImplementation(loadSaveImage.getImage("saveDownscaleImage.ppm"));
    ImageModelImplementation flower =
            new ImageModelImplementation(loadSaveImage.getImage("flower"));

    assertEquals(400, flower.getImageHeight());
    assertEquals(300, flower.getImageWidth());

    assertEquals(200, downscaleImage.getImageHeight());
    assertEquals(150, downscaleImage.getImageWidth());

    assertEquals(109, flower.getRed(0, 0));
    assertEquals(109, downscaleImage.getRed(0, 0));
    assertEquals(86, flower.getGreen(0, 0));
    assertEquals(86, downscaleImage.getGreen(0, 0));
    assertEquals(120, flower.getBlue(0, 0));
    assertEquals(120, downscaleImage.getBlue(0, 0));

    assertEquals(34, flower.getRed(200, 200));
    assertEquals(33, downscaleImage.getRed(100, 100));
    assertEquals(41, flower.getGreen(200, 200));
    assertEquals(40, downscaleImage.getGreen(100, 100));
    assertEquals(34, flower.getBlue(200, 200));
    assertEquals(31, downscaleImage.getBlue(100, 100));
  }

  //TESTS BRIGHTEN (make sure that all are added by the given constant(50))
  @Test
  public void testBrightenMask() throws IOException {
    loadSaveImage.loadImage("res/flower.png", "flower");
    loadSaveImage.loadImage("res/blackSquare.png", "mask");
    loadSaveImage.brightenMask(50,  "flower", "mask","flowerBrightMask");
    loadSaveImage.saveImage("flowerBrightMask", "saveFlowerBrightMask.ppm");
    ImageModelImplementation brightMaskImage =
            new ImageModelImplementation(loadSaveImage.getImage("saveFlowerBrightMask.ppm"));
    ImageModelImplementation orgImage =
            new ImageModelImplementation(loadSaveImage.getImage("flower"));
    ImageModelImplementation maskImage =
            new ImageModelImplementation(loadSaveImage.getImage("mask"));

    // find black point in maskImage
    assertEquals(0, maskImage.getRed(200, 150));
    assertEquals(0, maskImage.getGreen(200, 150));
    assertEquals(0, maskImage.getBlue(200, 150));

    // find non-black point in maskImage
    assertEquals(255, maskImage.getRed(10, 10));
    assertEquals(255, maskImage.getGreen(10, 10));
    assertEquals(255, maskImage.getBlue(10, 10));

    // check original rgb in place where it will be masked
    assertEquals(7, orgImage.getRed(200, 150));
    assertEquals(9, orgImage.getGreen(200, 150));
    assertEquals(12, orgImage.getBlue(200, 150));

    // check original rgb in place where it will NOT be masked
    assertEquals(99, orgImage.getRed(10, 10));
    assertEquals(68, orgImage.getGreen(10, 10));
    assertEquals(131, orgImage.getBlue(10, 10));

    // check it is brightened only where mask applies
    assertEquals(57, brightMaskImage.getRed(200, 150));
    assertEquals(59, brightMaskImage.getGreen(200, 150));
    assertEquals(62, brightMaskImage.getBlue(200, 150));

    // check it is NOT brightened where mask does not apply
    assertEquals(99, brightMaskImage.getRed(10, 10));
    assertEquals(68, brightMaskImage.getGreen(10, 10));
    assertEquals(131, brightMaskImage.getBlue(10, 10));
  }

  //TESTS DARKENMASK (make sure that all are subtracted by the given constant(50))
  @Test
  public void testDarkenMask() throws IOException {
    loadSaveImage.loadImage("res/flower.png", "flower");
    loadSaveImage.loadImage("res/blackSquare.png", "mask");
    loadSaveImage.darkenMask(50, "flower", "mask","flowerDarkMask");
    loadSaveImage.saveImage("flowerDarkMask", "saveFlowerDarkMask.ppm");
    ImageModelImplementation darkMaskImage =
            new ImageModelImplementation(loadSaveImage.getImage("saveFlowerDarkMask.ppm"));
    ImageModelImplementation orgImage =
            new ImageModelImplementation(loadSaveImage.getImage("flower"));

    // using found black and non-black points from previous test

    // check original rgb in place where it will be masked
    assertEquals(7, orgImage.getRed(200, 150));
    assertEquals(9, orgImage.getGreen(200, 150));
    assertEquals(12, orgImage.getBlue(200, 150));

    // check original rgb in place where it will NOT be masked
    assertEquals(99, orgImage.getRed(10, 10));
    assertEquals(68, orgImage.getGreen(10, 10));
    assertEquals(131, orgImage.getBlue(10, 10));

    // check it is darkened only where mask applies
    assertEquals(0, darkMaskImage.getRed(200, 150));
    assertEquals(0, darkMaskImage.getGreen(200, 150));
    assertEquals(0, darkMaskImage.getBlue(200, 150));

    // check it is NOT brightened where mask does not apply
    assertEquals(99, darkMaskImage.getRed(10, 10));
    assertEquals(68, darkMaskImage.getGreen(10, 10));
    assertEquals(131, darkMaskImage.getBlue(10, 10));
  }

  //TESTS GREYSCALEREDMASK (make sure that all are added by the given constant(50))
  @Test
  public void testGreyscaleRedMask() throws IOException {
    loadSaveImage.loadImage("res/flower.png", "flower");
    loadSaveImage.loadImage("res/blackSquare.png", "mask");
    loadSaveImage.greyscaleRedMask("flower", "mask", "flowerRedMask");
    loadSaveImage.saveImage("flowerRedMask", "saveFlowerRedMask.ppm");
    ImageModelImplementation redMaskImage =
            new ImageModelImplementation(loadSaveImage.getImage("saveFlowerRedMask.ppm"));
    ImageModelImplementation orgImage =
            new ImageModelImplementation(loadSaveImage.getImage("flower"));

    // using found black and non-black points from previous test

    // check original rgb in place where it will be masked
    assertEquals(7, orgImage.getRed(200, 150));
    assertEquals(9, orgImage.getGreen(200, 150));
    assertEquals(12, orgImage.getBlue(200, 150));

    // check original rgb in place where it will NOT be masked
    assertEquals(99, orgImage.getRed(10, 10));
    assertEquals(68, orgImage.getGreen(10, 10));
    assertEquals(131, orgImage.getBlue(10, 10));

    // check that the greyscale-red function only applied where mask applies
    assertEquals(7, redMaskImage.getRed(200, 150));
    assertEquals(7, redMaskImage.getGreen(200, 150));
    assertEquals(7, redMaskImage.getBlue(200, 150));

    // check that the greyscale-red function did NOT apply where mask does not apply
    assertEquals(99, redMaskImage.getRed(10, 10));
    assertEquals(68, redMaskImage.getGreen(10, 10));
    assertEquals(131, redMaskImage.getBlue(10, 10));
  }

  // TESTS GREYSCALEGREENMASK (make sure that all are added by the given constant(50))
  @Test
  public void testGreyscaleGreenMask() throws IOException {
    loadSaveImage.loadImage("res/flower.png", "flower");
    loadSaveImage.loadImage("res/blackSquare.png", "mask");
    loadSaveImage.greyscaleGreenMask("flower", "mask", "flowerGreenMask");
    loadSaveImage.saveImage("flowerGreenMask", "saveFlowerGreenMask.ppm");
    ImageModelImplementation greenMaskImage =
            new ImageModelImplementation(loadSaveImage.getImage("saveFlowerGreenMask.ppm"));
    ImageModelImplementation orgImage =
            new ImageModelImplementation(loadSaveImage.getImage("flower"));

    // using found black and non-black points from previous test

    // check original rgb in place where it will be masked
    assertEquals(7, orgImage.getRed(200, 150));
    assertEquals(9, orgImage.getGreen(200, 150));
    assertEquals(12, orgImage.getBlue(200, 150));

    // check original rgb in place where it will NOT be masked
    assertEquals(99, orgImage.getRed(10, 10));
    assertEquals(68, orgImage.getGreen(10, 10));
    assertEquals(131, orgImage.getBlue(10, 10));

    // check that the greyscale-green function only applied where mask applies
    assertEquals(9, greenMaskImage.getRed(200, 150));
    assertEquals(9, greenMaskImage.getGreen(200, 150));
    assertEquals(9, greenMaskImage.getBlue(200, 150));

    // check that the greyscale-green function did NOT apply where mask does not apply
    assertEquals(99, greenMaskImage.getRed(10, 10));
    assertEquals(68, greenMaskImage.getGreen(10, 10));
    assertEquals(131, greenMaskImage.getBlue(10, 10));
  }

  //  //TESTS GREYSCALEBLUEMASK
  @Test
  public void testGreyscaleBlueMask() throws IOException {
    loadSaveImage.loadImage("res/flower.png", "flower");
    loadSaveImage.loadImage("res/blackSquare.png", "mask");
    loadSaveImage.greyscaleBlueMask("flower", "mask", "flowerBlueMask");
    loadSaveImage.saveImage("flowerBlueMask", "saveFlowerBlueMask.ppm");
    ImageModelImplementation blueMaskImage =
            new ImageModelImplementation(loadSaveImage.getImage("saveFlowerBlueMask.ppm"));
    ImageModelImplementation orgImage =
            new ImageModelImplementation(loadSaveImage.getImage("flower"));

    // using found black and non-black points from previous test

    // check original rgb in place where it will be masked
    assertEquals(7, orgImage.getRed(200, 150));
    assertEquals(9, orgImage.getGreen(200, 150));
    assertEquals(12, orgImage.getBlue(200, 150));

    // check original rgb in place where it will NOT be masked
    assertEquals(99, orgImage.getRed(10, 10));
    assertEquals(68, orgImage.getGreen(10, 10));
    assertEquals(131, orgImage.getBlue(10, 10));

    // check that the greyscale-blue function only applied where mask applies
    assertEquals(12, blueMaskImage.getRed(200, 150));
    assertEquals(12, blueMaskImage.getGreen(200, 150));
    assertEquals(12, blueMaskImage.getBlue(200, 150));

    // check that the greyscale-blue function did NOT apply where mask does not apply
    assertEquals(99, blueMaskImage.getRed(10, 10));
    assertEquals(68, blueMaskImage.getGreen(10, 10));
    assertEquals(131, blueMaskImage.getBlue(10, 10));
  }

  //TESTS LUMAMASK
  @Test
  public void testLumaMask() throws IOException {
    loadSaveImage.loadImage("res/blackSquare.png", "mask");
    loadSaveImage.loadImage("res/flower.png", "flower");
    loadSaveImage.lumaMask("flower", "mask", "flowerLumaMask");
    loadSaveImage.saveImage("flowerLumaMask", "saveFlowerLumaMask.ppm");
    ImageModelImplementation lumaMaskImage =
            new ImageModelImplementation(loadSaveImage.getImage("saveFlowerLumaMask.ppm"));
    ImageModelImplementation orgImage =
            new ImageModelImplementation(loadSaveImage.getImage("flower"));

    // using found black and non-black points from previous test

    // check original rgb in place where it will be masked
    assertEquals(7, orgImage.getRed(200, 150));
    assertEquals(9, orgImage.getGreen(200, 150));
    assertEquals(12, orgImage.getBlue(200, 150));

    // check original rgb in place where it will NOT be masked
    assertEquals(99, orgImage.getRed(10, 10));
    assertEquals(68, orgImage.getGreen(10, 10));
    assertEquals(131, orgImage.getBlue(10, 10));

    // check that the greyscale-luma function only applied where mask applies
    assertEquals(8, lumaMaskImage.getRed(200, 150));
    assertEquals(8, lumaMaskImage.getGreen(200, 150));
    assertEquals(8, lumaMaskImage.getBlue(200, 150));

    // check that the greyscale-luma function did NOT apply where mask does not apply
    assertEquals(99, lumaMaskImage.getRed(10, 10));
    assertEquals(68, lumaMaskImage.getGreen(10, 10));
    assertEquals(131, lumaMaskImage.getBlue(10, 10));
  }

  //TESTS VALUEMASK
  @Test
  public void testValueMask() throws IOException {
    loadSaveImage.loadImage("res/blackSquare.png", "mask");
    loadSaveImage.loadImage("res/flower.png", "flower");
    loadSaveImage.valueMask("flower", "mask", "flowerValueMask");
    loadSaveImage.saveImage("flowerValueMask", "saveFlowerValueMask.ppm");
    ImageModelImplementation valueMaskImage =
            new ImageModelImplementation(loadSaveImage.getImage("saveFlowerValueMask.ppm"));
    ImageModelImplementation orgImage =
            new ImageModelImplementation(loadSaveImage.getImage("flower"));

    // using found black and non-black points from previous test

    // check original rgb in place where it will be masked
    assertEquals(7, orgImage.getRed(200, 150));
    assertEquals(9, orgImage.getGreen(200, 150));
    assertEquals(12, orgImage.getBlue(200, 150));

    // check original rgb in place where it will NOT be masked
    assertEquals(99, orgImage.getRed(10, 10));
    assertEquals(68, orgImage.getGreen(10, 10));
    assertEquals(131, orgImage.getBlue(10, 10));

    // check that the greyscale-value function only applied where mask applies
    assertEquals(12, valueMaskImage.getRed(200, 150));
    assertEquals(12, valueMaskImage.getGreen(200, 150));
    assertEquals(12, valueMaskImage.getBlue(200, 150));

    // check that the greyscale-value function did NOT apply where mask does not apply
    assertEquals(99, valueMaskImage.getRed(10, 10));
    assertEquals(68, valueMaskImage.getGreen(10, 10));
    assertEquals(131, valueMaskImage.getBlue(10, 10));
  }

  //TESTS INTENSITYMASK
  @Test
  public void testIntensityMask() throws IOException {
    loadSaveImage.loadImage("res/blackSquare.png", "mask");
    loadSaveImage.loadImage("res/flower.png", "flower");
    loadSaveImage.intensityMask("flower", "mask", "flowerIntensityMask");
    loadSaveImage.saveImage("flowerIntensityMask", "saveFlowerIntensityMask.ppm");
    ImageModelImplementation intensityMaskImage =
            new ImageModelImplementation(loadSaveImage.getImage("saveFlowerIntensityMask.ppm"));
    ImageModelImplementation orgImage =
            new ImageModelImplementation(loadSaveImage.getImage("flower"));

    // using found black and non-black points from previous test

    // check original rgb in place where it will be masked
    assertEquals(7, orgImage.getRed(200, 150));
    assertEquals(9, orgImage.getGreen(200, 150));
    assertEquals(12, orgImage.getBlue(200, 150));

    // check original rgb in place where it will NOT be masked
    assertEquals(99, orgImage.getRed(10, 10));
    assertEquals(68, orgImage.getGreen(10, 10));
    assertEquals(131, orgImage.getBlue(10, 10));

    // check that the greyscale-intensity function only applied where mask applies
    assertEquals(9, intensityMaskImage.getRed(200, 150));
    assertEquals(9, intensityMaskImage.getGreen(200, 150));
    assertEquals(9, intensityMaskImage.getBlue(200, 150));

    // check that the greyscale-intensity function did NOT apply where mask does not apply
    assertEquals(99, intensityMaskImage.getRed(10, 10));
    assertEquals(68, intensityMaskImage.getGreen(10, 10));
    assertEquals(131, intensityMaskImage.getBlue(10, 10));
  }

  //TESTS BLURMASK
  @Test
  public void testBlurMask() throws IOException {
    loadSaveImage.loadImage("res/blackSquare.png", "mask");
    loadSaveImage.loadImage("res/flower.png", "flower");
    loadSaveImage.blurMask("flower", "mask", "flowerBlurMask");
    loadSaveImage.saveImage("flowerBlurMask", "saveFlowerBlurMask.ppm");
    ImageModelImplementation blurMaskImage =
            new ImageModelImplementation(loadSaveImage.getImage("saveFlowerBlurMask.ppm"));
    ImageModelImplementation orgImage =
            new ImageModelImplementation(loadSaveImage.getImage("flower"));

    // using found black and non-black points from previous test

    // check original rgb in place where it will be masked
    assertEquals(7, orgImage.getRed(200, 150));
    assertEquals(9, orgImage.getGreen(200, 150));
    assertEquals(12, orgImage.getBlue(200, 150));

    // check original rgb in place where it will NOT be masked
    assertEquals(99, orgImage.getRed(10, 10));
    assertEquals(68, orgImage.getGreen(10, 10));
    assertEquals(131, orgImage.getBlue(10, 10));

    // check that the blur function only applied where mask applies
    assertEquals(8, blurMaskImage.getRed(200, 150));
    assertEquals(10, blurMaskImage.getGreen(200, 150));
    assertEquals(15, blurMaskImage.getBlue(200, 150));

    // check that the blur function did NOT apply where mask does not apply
    assertEquals(99, blurMaskImage.getRed(10, 10));
    assertEquals(68, blurMaskImage.getGreen(10, 10));
    assertEquals(131, blurMaskImage.getBlue(10, 10));
  }

  //TESTS SHARPENMASK
  @Test
  public void testSharpenMask() throws IOException {
    loadSaveImage.loadImage("res/blackSquare.png", "mask");
    loadSaveImage.loadImage("res/flower.png", "flower");
    loadSaveImage.sharpenMask("flower", "mask", "flowerSharpenMask");
    loadSaveImage.saveImage("flowerSharpenMask", "saveFlowerSharpenMask.ppm");
    ImageModelImplementation sharpenMaskImage =
            new ImageModelImplementation(loadSaveImage.getImage("saveFlowerSharpenMask.ppm"));
    ImageModelImplementation orgImage =
            new ImageModelImplementation(loadSaveImage.getImage("flower"));

    // using found black and non-black points from previous test

    // check original rgb in place where it will be masked
    assertEquals(7, orgImage.getRed(200, 150));
    assertEquals(9, orgImage.getGreen(200, 150));
    assertEquals(12, orgImage.getBlue(200, 150));

    // check original rgb in place where it will NOT be masked
    assertEquals(99, orgImage.getRed(10, 10));
    assertEquals(68, orgImage.getGreen(10, 10));
    assertEquals(131, orgImage.getBlue(10, 10));

    // check that the sharpen function only applied where mask applies
    assertEquals(7, sharpenMaskImage.getRed(200, 150));
    assertEquals(9, sharpenMaskImage.getGreen(200, 150));
    assertEquals(12, sharpenMaskImage.getBlue(200, 150));

    // check that the sharpen function did NOT apply where mask does not apply
    assertEquals(99, sharpenMaskImage.getRed(10, 10));
    assertEquals(68, sharpenMaskImage.getGreen(10, 10));
    assertEquals(131, sharpenMaskImage.getBlue(10, 10));
  }

  //TESTS GREYSCALEMASK
  @Test
  public void testGreyscaleMask() throws IOException {
    loadSaveImage.loadImage("res/blackSquare.png", "mask");
    loadSaveImage.loadImage("res/flower.png", "flower");
    loadSaveImage.greyscaleMask("flower", "mask", "flowerGreyscaleMask");
    loadSaveImage.saveImage("flowerGreyscaleMask", "saveFlowerGreyscaleMask.ppm");
    ImageModelImplementation greyscaleMaskImage =
            new ImageModelImplementation(loadSaveImage.getImage("saveFlowerGreyscaleMask.ppm"));
    ImageModelImplementation orgImage =
            new ImageModelImplementation(loadSaveImage.getImage("flower"));

    // using found black and non-black points from previous test

    // check original rgb in place where it will be masked
    assertEquals(7, orgImage.getRed(200, 150));
    assertEquals(9, orgImage.getGreen(200, 150));
    assertEquals(12, orgImage.getBlue(200, 150));

    // check original rgb in place where it will NOT be masked
    assertEquals(99, orgImage.getRed(10, 10));
    assertEquals(68, orgImage.getGreen(10, 10));
    assertEquals(131, orgImage.getBlue(10, 10));

    // check that the greyscale function only applied where mask applies
    assertEquals(9, greyscaleMaskImage.getRed(200, 150));
    assertEquals(9, greyscaleMaskImage.getGreen(200, 150));
    assertEquals(9, greyscaleMaskImage.getBlue(200, 150));

    // check that the greyscale function did NOT apply where mask does not apply
    assertEquals(99, greyscaleMaskImage.getRed(10, 10));
    assertEquals(68, greyscaleMaskImage.getGreen(10, 10));
    assertEquals(131, greyscaleMaskImage.getBlue(10, 10));
  }

  //TESTS SEPIAMASK
  @Test
  public void testSepiaMask() throws IOException {
    loadSaveImage.loadImage("res/blackSquare.png", "mask");
    loadSaveImage.loadImage("res/flower.png", "flower");
    loadSaveImage.sepiaMask("flower", "mask", "flowerSepiaMask");
    loadSaveImage.saveImage("flowerSepiaMask", "saveFlowerSepiaMask.ppm");
    ImageModelImplementation sepiaMaskImage =
            new ImageModelImplementation(loadSaveImage.getImage("saveFlowerSepiaMask.ppm"));
    ImageModelImplementation orgImage =
            new ImageModelImplementation(loadSaveImage.getImage("flower"));

    // using found black and non-black points from previous test

    // check original rgb in place where it will be masked
    assertEquals(7, orgImage.getRed(200, 150));
    assertEquals(9, orgImage.getGreen(200, 150));
    assertEquals(12, orgImage.getBlue(200, 150));

    // check original rgb in place where it will NOT be masked
    assertEquals(99, orgImage.getRed(10, 10));
    assertEquals(68, orgImage.getGreen(10, 10));
    assertEquals(131, orgImage.getBlue(10, 10));

    // check that the sepia function only applied where mask applies
    assertEquals(12, sepiaMaskImage.getRed(200, 150));
    assertEquals(11, sepiaMaskImage.getGreen(200, 150));
    assertEquals(8, sepiaMaskImage.getBlue(200, 150));

    // check that the sepia function did NOT apply where mask does not apply
    assertEquals(99, sepiaMaskImage.getRed(10, 10));
    assertEquals(68, sepiaMaskImage.getGreen(10, 10));
    assertEquals(131, sepiaMaskImage.getBlue(10, 10));
  }
}


