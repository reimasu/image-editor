import org.junit.Test;

import java.io.IOException;

import model.image.Image;
import model.image.ImageImplementation;
import model.model.ImageModelImplementation;
import model.pixel.Pixel;
import model.pixel.PixelImplementation;
import view.IImageView;
import view.ImageView;

import static org.junit.Assert.assertEquals;


/**
 * this allows us to test the view class.
 */
public class ViewTest {

  //appendable
  Appendable app = new StringBuilder();

  //appendable made using the mock class
  Appendable appIlegal = new AppendableMock();
  //image
  ImageModelImplementation image = new ImageModelImplementation();

  //create pixels so we can make an image
  Pixel pixel1 = new PixelImplementation(113, 202, 67);
  Pixel pixel2 = new PixelImplementation(88, 189, 254);
  Pixel pixel3 = new PixelImplementation(2, 150, 35);

  //pixel-array
  Pixel[][] pixelArray1 =
  {{pixel1, pixel2, pixel3}, {pixel3, pixel2, pixel1}, {pixel1, pixel3, pixel2}};


  //different ImageImplementation constructors
  Image imagePixelated = new ImageImplementation(pixelArray1, 254);
  Image imagePixelated1 = new ImageImplementation(pixelArray1);

  //imageModelImplementation
  ImageModelImplementation image1 = new ImageModelImplementation(imagePixelated);
  ImageModelImplementation image2 = new ImageModelImplementation(imagePixelated1);


  //testing view
  IImageView viewTest = new ImageView(image, app);
  IImageView viewTest1 = new ImageView(image1, app);
  IImageView viewTest2 = new ImageView(image2, app);

  //illegal view (app is null)
  IImageView viewIllegal = new ImageView(image, appIlegal);


  /**
   * the appendable is null (Illegal Argument exception).
   */
  @Test(expected = IllegalArgumentException.class)
  public void viewConstructorAppIsNullIllegal() {
    Appendable appNull = null;
    IImageView viewIllegalAppIsNull = new ImageView(image, appNull);
    viewIllegalAppIsNull.toString();

  }

  /**
   * the image is null (Illegal Argument exception).
   */
  @Test(expected = IllegalArgumentException.class)
  public void viewConstructorImageIsNullIllegal() {
    ImageModelImplementation imageNull = null;
    IImageView viewIllegalImageIsNull = new ImageView(imageNull, app);
    viewIllegalImageIsNull.toString();


  }


  @Test(expected = IllegalArgumentException.class)
  public void viewConstructorImageAndAppIsNullIllegal() {
    ImageModelImplementation imageNull = null;
    Appendable appNull = null;
    IImageView viewIllegalImageIsNull = new ImageView(imageNull, appNull);
    viewIllegalImageIsNull.toString();
  }


  /**
   * to check that the ToString makes sure that the correct output is displayed to the viewer.
   */

  @Test
  public void testToString() {
    assertEquals("Executed: ", viewTest.toString());
    assertEquals("Executed: ", viewTest1.toString());
    assertEquals("Executed: ", viewTest2.toString());
  }

  /**
   * checks the IOException when an illegal appendable is passed.
   *
   * @throws IOException when an illegal appendable is passed.
   */

  @Test(expected = IOException.class)
  public void testRenderMessageException() throws IOException {
    viewIllegal.renderMessage("unable to compute");

  }


}
