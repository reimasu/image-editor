import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import model.model.ImageModel;
import view.ImageView;

import model.model.ImageModelImplementation;
import controller.ImageControllerImpl;
import view.IImageView;

import static org.junit.Assert.assertEquals;

/**
 * To test the controller.
 */
public class ControllerTest {

  /**
   * string builder for view.
   */
  StringBuilder in = new StringBuilder();

  /**
   * String builder for log.
   */
  StringBuilder log = new StringBuilder();

  /**
   * instantiating image.
   */
  ImageModel game = new MockClass(log);

  /**
   * instantiating view.
   */
  IImageView view = new ImageView(game, in);

  String[] filterNames =
  {"toast.ppm", "saveBlue.ppm", "saveBrightenedImage.ppm", "saveDarkenedImage.ppm",
   "saveGreyscaleGreen.ppm", "saveGreyscaleRed.ppm", "saveGreyscaleImage",
   "saveHorizontalImage.ppm", "saveIntensityImage.ppm", "saveLumaImage.ppm", "saveValueImage.ppm",
   "saveVerticalImage.ppm", "saveBlurImage.ppm", "saveSharpenImage.ppm", "saveSepiaImage.ppm"};

  /**
   * the tests below are for ppm files.
   */

  //to test brighten
  @Test
  public void testBrighten() throws IOException {

    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "brighten 100 loaded brightenImage \n save brightenImage saveBrightenedImage.ppm");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test darken
  @Test
  public void testDarken() throws IOException {

    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "darken 100 loaded darkenImage \n save darkenImage saveDarkenedImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());


  }

  //to test vertical
  @Test
  public void testVertical() throws IOException {

    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "vertical loaded verticalImage \n save verticalImage saveVerticalImage.ppm");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test horizontal

  @Test
  public void testHorizontal() throws IOException {

    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "horizontal loaded horizontalImage \n save horizontalImage saveHorizontalImage.ppm");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test greyscale-red
  @Test
  public void testGreyscaleRed() throws IOException {

    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "greyscale-red loaded greyscaleRedImage \n " +
            "save greyscaleRedImage saveGreyscaleRedImage.ppm");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test greyscale-blue
  @Test
  public void testGreyscaleBlue() throws IOException {

    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "greyscale-blue loaded greyscaleBlueImage \n " +
            "save greyscaleBlueImage saveGreyscaleBlueImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test greyscale-green

  @Test
  public void testGreyscaleGreen() throws IOException {

    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "greyscale-green loaded greyscaleGreenImage \n " +
            "save greyscaleGreenImage saveGreyscaleGreenImage.ppm");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }


  //to test greyscale-intensity
  @Test
  public void testGreyscaleIntensity() throws IOException {

    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "greyscale-intensity loaded greyscaleIntensityImage \n " +
            "save greyscaleIntensityImage saveGreyscaleIntensityImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test greyscale-value
  @Test
  public void testGreyscaleValue() throws IOException {

    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "greyscale-value loaded greyscaleValueImage \n " +
            "save greyscaleValueImage saveGreyscaleValueImage.ppm");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  // to test greyscale luma
  @Test
  public void testGreyscaleLuma() throws IOException {

    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "greyscale-luma loaded greyscaleLumaImage \n " +
            "save greyscaleLumaImage saveGreyscaleLumaImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //greyscale transformation
  @Test
  public void testGreyscaleTransform() throws IOException {

    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "greyscale loaded greyscaleImage \n save greyscaleLumaImage saveGreyscaleImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //sepia transfromation
  @Test
  public void testSepiaTransform() throws IOException {

    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "greyscale-luma loaded greyscaleLumaImage \n " +
            "save greyscaleLumaImage saveGreyscaleLumaImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //blur
  @Test
  public void testBlur() throws IOException {

    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "blur loaded blurImage \n save blurImage saveBlurImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //sharpen
  @Test
  public void testSharpen() throws IOException {

    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "sharpen loaded sharpenImage \n save sharpenImage saveSharpenImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //test load for controller
  @Test
  public void testLoad() throws IOException {

    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "save loaded saveLoadedImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }


  //test save
  @Test
  public void testSave() throws IOException {

    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "save loaded saveLoadedImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //test downscale
  @Test
  public void testDownscale() throws IOException {

    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "downscale 2 loaded downScaledImage\n" +
            "save loaded saveLoadedImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //multiple photos
  @Test
  public void testVerticalMultiplePhotos() throws IOException {
    StringBuilder in = new StringBuilder();
    ImageModelImplementation image = new ImageModelImplementation();
    in.append("load");
    for (int i = 0; i < 30; i++) {
      in.append("vertical");
    }

    Readable readable = new StringReader(in.toString());
    IImageView view = new ImageView(image, in);

    ImageControllerImpl control = new ImageControllerImpl(readable, view, image);

    control.perform();
    assertEquals("", log.toString());


  }


  //perform two different actions
  @Test
  public void testVerticalForTwoActions() throws IOException {
    StringBuilder in = new StringBuilder();
    for (String name : filterNames) {
      in.append("load res/" + name);
      in.append(" vertical");
    }

    Readable readable = new StringReader(in.toString());


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();

    assertEquals("Successfully Completed the command \n", log.toString());


  }

  //multiple photos
  @Test
  public void testHorizontalMultiplePhotos() throws IOException {
    StringBuilder in = new StringBuilder();
    ImageModelImplementation image = new ImageModelImplementation();
    in.append("load");
    for (int i = 0; i < 30; i++) {
      in.append("horizontal");
    }

    Readable readable = new StringReader(in.toString());
    IImageView view = new ImageView(image, in);

    ImageControllerImpl control = new ImageControllerImpl(readable, view, image);

    control.perform();
    assertEquals("", log.toString());

  }

  //perform two actions
  @Test
  public void testHorizontalForTwoActions() throws IOException {
    StringBuilder in = new StringBuilder();
    for (String name : filterNames) {
      in.append("load res/" + name);
      in.append(" horizontal");
    }

    Readable readable = new StringReader(in.toString());


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();

    assertEquals("Successfully Completed the command \n", log.toString());

  }

  //multiple photos
  @Test
  public void testGreyScaleRedMultiplePhotos() throws IOException {
    StringBuilder in = new StringBuilder();
    ImageModelImplementation image = new ImageModelImplementation();
    in.append("load");
    for (int i = 0; i < 30; i++) {
      in.append("greyscale-red");
    }

    Readable readable = new StringReader(in.toString());
    IImageView view = new ImageView(image, in);

    ImageControllerImpl control = new ImageControllerImpl(readable, view, image);

    control.perform();
    assertEquals("", log.toString());


  }

  //perform two actions
  @Test
  public void testGreyScaleRedForTwoActions() throws IOException {
    StringBuilder in = new StringBuilder();
    for (String name : filterNames) {
      in.append("load res/" + name);
      in.append(" greyscale-red");
    }

    Readable readable = new StringReader(in.toString());

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();

    assertEquals("Successfully Completed the command \n", log.toString());

  }

  //multiple photos
  @Test
  public void testGreyScaleBlueMultiplePhotos() throws IOException {
    StringBuilder in = new StringBuilder();
    ImageModelImplementation image = new ImageModelImplementation();
    in.append("load");
    for (int i = 0; i < 30; i++) {
      in.append("greyscale-blue");
    }

    Readable readable = new StringReader(in.toString());
    IImageView view = new ImageView(image, in);

    ImageControllerImpl control = new ImageControllerImpl(readable, view, image);

    control.perform();
    assertEquals("", log.toString());


  }

  //perform two actions
  @Test
  public void testGreyScaleBlueForTwoActions() throws IOException {
    StringBuilder in = new StringBuilder();
    for (String name : filterNames) {
      in.append("load res/" + name);
      in.append(" greyscale-blue");
    }

    Readable readable = new StringReader(in.toString());


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();

    assertEquals("Successfully Completed the command \n", log.toString());


  }

  //multiple photos
  @Test
  public void testGreyScaleGreenMultiplePhotos() throws IOException {
    StringBuilder in = new StringBuilder();
    ImageModelImplementation image = new ImageModelImplementation();
    in.append("load");
    for (int i = 0; i < 30; i++) {
      in.append("greyscale-green");
    }

    Readable readable = new StringReader(in.toString());
    IImageView view = new ImageView(image, in);

    ImageControllerImpl control = new ImageControllerImpl(readable, view, image);

    control.perform();
    assertEquals("", log.toString());


  }

  //perform two actions
  @Test
  public void testGreyScaleGreenForTwoActions() throws IOException {
    StringBuilder in = new StringBuilder();
    for (String name : filterNames) {
      in.append("load res/" + name);
      in.append(" greyscale-green");
    }

    Readable readable = new StringReader(in.toString());


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();

    assertEquals("Successfully Completed the command \n", log.toString());

  }

  //multiple photos
  @Test
  public void testGreyScaleLumaMultiplePhotos() throws IOException {
    StringBuilder in = new StringBuilder();
    ImageModelImplementation image = new ImageModelImplementation();
    in.append("load");
    for (int i = 0; i < 30; i++) {
      in.append("greyscale-luma");
    }

    Readable readable = new StringReader(in.toString());
    IImageView view = new ImageView(image, in);

    ImageControllerImpl control = new ImageControllerImpl(readable, view, image);

    control.perform();

    assertEquals("", log.toString());

  }

  //perform two actions
  @Test
  public void testGreyScaleLumaForTwoActions() throws IOException {
    StringBuilder in = new StringBuilder();
    for (String name : filterNames) {
      in.append("load res/" + name);
      in.append(" greyscale-luma");
    }

    Readable readable = new StringReader(in.toString());


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();

    assertEquals("Successfully Completed the command \n", log.toString());


  }

  //multiple photos
  @Test
  public void testGreyScaleValueMultiplePhotos() throws IOException {
    StringBuilder in = new StringBuilder();
    ImageModelImplementation image = new ImageModelImplementation();
    in.append("load");
    for (int i = 0; i < 30; i++) {
      in.append("greyscale-value");
    }

    Readable readable = new StringReader(in.toString());
    IImageView view = new ImageView(image, in);

    ImageControllerImpl control = new ImageControllerImpl(readable, view, image);

    control.perform();

    assertEquals("", log.toString());

  }

  //perform two actions
  @Test
  public void testGreyScaleValueForTwoActions() throws IOException {
    StringBuilder in = new StringBuilder();
    for (String name : filterNames) {
      in.append("load res/" + name);
      in.append(" greyscale-value");
    }

    Readable readable = new StringReader(in.toString());


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();

    assertEquals("Successfully Completed the command \n", log.toString());


  }

  //multiple photos
  @Test
  public void testGreyScaleIntensityMultiplePhotos() throws IOException {
    StringBuilder in = new StringBuilder();
    ImageModelImplementation image = new ImageModelImplementation();
    in.append("load");
    for (int i = 0; i < 30; i++) {
      in.append("greyscale-intensity");
    }

    Readable readable = new StringReader(in.toString());
    IImageView view = new ImageView(image, in);

    ImageControllerImpl control = new ImageControllerImpl(readable, view, image);

    control.perform();

    assertEquals("", log.toString());

  }

  //perform two actions
  @Test
  public void testGreyScaleIntensityForTwoActions() throws IOException {
    StringBuilder in = new StringBuilder();
    for (String name : filterNames) {
      in.append("load res/" + name);
      in.append(" greyscale-intensity");
    }

    Readable readable = new StringReader(in.toString());


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();

    assertEquals("Successfully Completed the command \n", log.toString());


  }

  //multiple photos
  @Test
  public void testBrightnessMultiplePhotos() throws IOException {
    StringBuilder in = new StringBuilder();
    ImageModelImplementation image = new ImageModelImplementation();
    in.append("load");
    for (int i = 0; i < 30; i++) {
      in.append("brighten 100");
    }

    Readable readable = new StringReader(in.toString());
    IImageView view = new ImageView(image, in);

    ImageControllerImpl control = new ImageControllerImpl(readable, view, image);

    control.perform();
    assertEquals("", log.toString());


  }

  //perform two actions
  @Test
  public void testBrightenForTwoActions() throws IOException {
    StringBuilder in = new StringBuilder();
    for (String name : filterNames) {
      in.append("load res/" + name);
      in.append(" brighten");
      in.append(" 100");
    }

    Readable readable = new StringReader(in.toString());


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();

    assertEquals("Successfully Completed the command \n", log.toString());


  }

  //multiple photos
  @Test
  public void testDarkenMultiplePhotos() throws IOException {
    StringBuilder in = new StringBuilder();
    ImageModelImplementation image = new ImageModelImplementation();
    in.append("load");
    for (int i = 0; i < 30; i++) {
      in.append("darken 50");
    }

    Readable readable = new StringReader(in.toString());
    IImageView view = new ImageView(image, in);

    ImageControllerImpl control = new ImageControllerImpl(readable, view, image);

    control.perform();

    assertEquals("", log.toString());

  }

  //perform two actions
  @Test
  public void testDarkenForTwoActions() throws IOException {
    StringBuilder in = new StringBuilder();
    for (String name : filterNames) {
      in.append("load res/" + name);
      in.append(" darken");
      in.append(" 50");
    }

    Readable readable = new StringReader(in.toString());


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();

    assertEquals("Successfully Completed the command \n", log.toString());


  }


  //multiple photos
  @Test
  public void testBlurMultiplePhotos() throws IOException {
    StringBuilder in = new StringBuilder();
    ImageModelImplementation image = new ImageModelImplementation();
    in.append("load");
    for (int i = 0; i < 30; i++) {
      in.append("blur");
    }

    Readable readable = new StringReader(in.toString());
    IImageView view = new ImageView(image, in);

    ImageControllerImpl control = new ImageControllerImpl(readable, view, image);

    control.perform();

    assertEquals("", log.toString());

  }

  //perform two actions
  @Test
  public void testBlurForTwoActions() throws IOException {
    StringBuilder in = new StringBuilder();
    for (String name : filterNames) {
      in.append("load res/" + name);
      in.append(" blur");
    }

    Readable readable = new StringReader(in.toString());


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();

    assertEquals("Successfully Completed the command \n", log.toString());


  }


  //multiple photos
  @Test
  public void testSharpenMultiplePhotos() throws IOException {
    StringBuilder in = new StringBuilder();
    ImageModelImplementation image = new ImageModelImplementation();
    in.append("load");
    for (int i = 0; i < 30; i++) {
      in.append("sharpen");
    }

    Readable readable = new StringReader(in.toString());
    IImageView view = new ImageView(image, in);

    ImageControllerImpl control = new ImageControllerImpl(readable, view, image);

    control.perform();

    assertEquals("", log.toString());

  }

  //perform two actions
  @Test
  public void testSharpenForTwoActions() throws IOException {
    StringBuilder in = new StringBuilder();
    for (String name : filterNames) {
      in.append("load res/" + name);
      in.append(" sharpen");
    }

    Readable readable = new StringReader(in.toString());


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();

    assertEquals("Successfully Completed the command \n", log.toString());


  }


  //multiple photos
  @Test
  public void testGreyscaleMultiplePhotos() throws IOException {
    StringBuilder in = new StringBuilder();
    ImageModelImplementation image = new ImageModelImplementation();
    in.append("load");
    for (int i = 0; i < 30; i++) {
      in.append("greyscale");
    }

    Readable readable = new StringReader(in.toString());
    IImageView view = new ImageView(image, in);

    ImageControllerImpl control = new ImageControllerImpl(readable, view, image);

    control.perform();

    assertEquals("", log.toString());

  }

  //perform two actions
  @Test
  public void testGreyscaleForTwoActions() throws IOException {
    StringBuilder in = new StringBuilder();
    for (String name : filterNames) {
      in.append("load res/" + name);
      in.append("greyscale");
    }

    Readable readable = new StringReader(in.toString());


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();

    assertEquals("Successfully Completed the command \n", log.toString());


  }


  //multiple photos
  @Test
  public void testSepiaMultiplePhotos() throws IOException {
    StringBuilder in = new StringBuilder();
    ImageModelImplementation image = new ImageModelImplementation();
    in.append("load");
    for (int i = 0; i < 30; i++) {
      in.append("sepia");
    }

    Readable readable = new StringReader(in.toString());
    IImageView view = new ImageView(image, in);

    ImageControllerImpl control = new ImageControllerImpl(readable, view, image);

    control.perform();

    assertEquals("", log.toString());

  }

  //perform two actions
  @Test
  public void testSepiaForTwoActions() throws IOException {
    StringBuilder in = new StringBuilder();
    for (String name : filterNames) {
      in.append("load res/" + name);
      in.append("sepia");
    }

    Readable readable = new StringReader(in.toString());


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();

    assertEquals("Successfully Completed the command \n", log.toString());


  }


  //multiple photos
  @Test
  public void testSaveMultiplePhotos() throws IOException {
    StringBuilder in = new StringBuilder();
    ImageModelImplementation image = new ImageModelImplementation();
    in.append("load");
    for (int i = 0; i < 30; i++) {
      in.append("save");
    }

    Readable readable = new StringReader(in.toString());
    IImageView view = new ImageView(image, in);

    ImageControllerImpl control = new ImageControllerImpl(readable, view, image);

    control.perform();
    assertEquals("", log.toString());


  }

  //perform two actions
  @Test
  public void testSaveForTwoActions() throws IOException {
    StringBuilder in = new StringBuilder();
    for (String name : filterNames) {
      in.append("load res/" + name);
      in.append(" save");
    }

    Readable readable = new StringReader(in.toString());


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();

    assertEquals("Successfully Completed the command \n", log.toString());


  }

  //multiple photos
  @Test
  public void testLoadMultiplePhotos() throws IOException {
    StringBuilder in = new StringBuilder();
    ImageModelImplementation image = new ImageModelImplementation();
    in.append("load");
    for (int i = 0; i < 30; i++) {
      in.append("load");
    }

    Readable readable = new StringReader(in.toString());
    IImageView view = new ImageView(image, in);

    ImageControllerImpl control = new ImageControllerImpl(readable, view, image);

    control.perform();
    assertEquals("", log.toString());

  }


  //perform two actions
  @Test
  public void testLoadForTwoActions() throws IOException {
    StringBuilder in = new StringBuilder();
    for (String name : filterNames) {
      in.append("load res/" + name);
      in.append(" load");
    }

    Readable readable = new StringReader(in.toString());


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();

    assertEquals("Successfully Completed the command \n", log.toString());


  }


  /**
   * the tests below are for jpg files.
   */
  //to test brighten
  @Test
  public void testBrightenJPG() throws IOException {

    Readable readable = new StringReader("load res/reivarsh.jpg loaded \n " +
            "brighten 100 loaded brightenImage \n save brightenImage saveBrightenedImage.jpg");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test darken
  @Test
  public void testDarkenJPG() throws IOException {

    Readable readable = new StringReader("load res/reivarsh.jpg loaded \n " +
            "darken 100 loaded darkenImage \n save darkenImage saveDarkenedImage.jpg");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());


  }

  //to test vertical
  @Test
  public void testVerticalJPG() throws IOException {

    Readable readable = new StringReader("load res/reivarsh.jpg loaded \n " +
            "vertical loaded verticalImage \n save verticalImage saveVerticalImage.jpg");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test horizontal

  @Test
  public void testHorizontalJPG() throws IOException {

    Readable readable = new StringReader("load res/reivarsh.jpg loaded \n " +
            "horizontal loaded horizontalImage \n save horizontalImage saveHorizontalImage.jpg");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test greyscale-red
  @Test
  public void testGreyscaleRedJPG() throws IOException {

    Readable readable = new StringReader("load res/reivarsh.jpg loaded \n " +
            "greyscale-red loaded greyscaleRedImage \n " +
            "save greyscaleRedImage saveGreyscaleRedImage.jpg");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test greyscale-blue
  @Test
  public void testGreyscaleBlueJPG() throws IOException {

    Readable readable = new StringReader("load res/reivarsh.jpg loaded \n " +
            "greyscale-blue loaded greyscaleBlueImage \n " +
            "save greyscaleBlueImage saveGreyscaleBlueImage.jpg");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test greyscale-green

  @Test
  public void testGreyscaleGreenJPG() throws IOException {

    Readable readable = new StringReader("load res/reivarsh.jpg loaded \n " +
            "greyscale-green loaded greyscaleGreenImage \n " +
            "save greyscaleGreenImage saveGreyscaleGreenImage.jpg");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }


  //to test greyscale-intensity
  @Test
  public void testGreyscaleIntensityJPG() throws IOException {

    Readable readable = new StringReader("load res/reivarsh.jpg loaded \n " +
            "greyscale-intensity loaded greyscaleIntensityImage \n " +
            "save greyscaleIntensityImage saveGreyscaleIntensityImage.jpg");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test greyscale-value
  @Test
  public void testGreyscaleValueJPG() throws IOException {

    Readable readable = new StringReader("load res/reivarsh.jpg loaded \n " +
            "greyscale-value loaded greyscaleValueImage \n " +
            "save greyscaleValueImage saveGreyscaleValueImage.jpg");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  // to test greyscale luma
  @Test
  public void testGreyscaleLumaJPG() throws IOException {

    Readable readable = new StringReader("load res/reivarsh.jpg loaded \n " +
            "greyscale-luma loaded greyscaleLumaImage \n " +
            "save greyscaleLumaImage saveGreyscaleLumaImage.jpg");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //greyscale transformation
  @Test
  public void testGreyscaleTransformJPG() throws IOException {

    Readable readable = new StringReader("load res/reivarsh.jpg loaded \n " +
            "greyscale loaded greyscaleImage \n " +
            "save greyscaleLumaImage saveGreyscaleImage.jpg");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //sepia transfromation
  @Test
  public void testSepiaTransformJPG() throws IOException {

    Readable readable = new StringReader("load res/reivarsh.jpg loaded \n " +
            "greyscale-luma loaded greyscaleLumaImage \n " +
            "save greyscaleLumaImage saveGreyscaleLumaImage.jpg");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //blur
  @Test
  public void testBlurJPG() throws IOException {

    Readable readable = new StringReader("load res/reivarsh.jpg loaded \n " +
            "blur loaded blurImage \n save blurImage saveBlurImage.jpg");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //sharpen
  @Test
  public void testSharpenJPG() throws IOException {

    Readable readable = new StringReader("load res/reivarsh.jpg loaded \n " +
            "sharpen loaded sharpenImage \n save sharpenImage saveSharpenImage.jpg");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //test load for controller
  @Test
  public void testLoadJPG() throws IOException {

    Readable readable = new StringReader("load res/reivarsh.jpg loaded \n " +
            "save loaded saveLoadedImage.jpg");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }


  //test save
  @Test
  public void testSaveJPG() throws IOException {

    Readable readable = new StringReader("load res/reivarsh.jpg loaded \n " +
            "save loaded saveLoadedImage.jpg");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  /**
   * below are tests to test for only png files.
   */

  //to test brighten
  @Test
  public void testBrightenPNG() throws IOException {

    Readable readable = new StringReader("load res/flower.png loaded \n " +
            "brighten 100 loaded brightenImage \n save brightenImage saveBrightenedImage.png");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test darken
  @Test
  public void testDarkenPNG() throws IOException {

    Readable readable = new StringReader("load res/flower.png loaded \n " +
            "darken 100 loaded darkenImage \n save darkenImage saveDarkenedImage.png");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());


  }

  //to test vertical
  @Test
  public void testVerticalPNG() throws IOException {

    Readable readable = new StringReader("load res/flower.png loaded \n " +
            "vertical loaded verticalImage \n save verticalImage saveVerticalImage.png");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test horizontal

  @Test
  public void testHorizontalPNG() throws IOException {

    Readable readable = new StringReader("load res/flower.png loaded \n " +
            "horizontal loaded horizontalImage \n save horizontalImage saveHorizontalImage.png");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test greyscale-red
  @Test
  public void testGreyscaleRedPNG() throws IOException {

    Readable readable = new StringReader("load res/flower.png loaded \n " +
            "greyscale-red loaded greyscaleRedImage \n " +
            "save greyscaleRedImage saveGreyscaleRedImage.png");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test greyscale-blue
  @Test
  public void testGreyscaleBluePNG() throws IOException {

    Readable readable = new StringReader("load res/flower.png loaded \n " +
            "greyscale-blue loaded greyscaleBlueImage \n " +
            "save greyscaleBlueImage saveGreyscaleBlueImage.png");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test greyscale-green

  @Test
  public void testGreyscaleGreenPNG() throws IOException {

    Readable readable = new StringReader("load res/flower.png loaded \n " +
            "greyscale-green loaded greyscaleGreenImage \n " +
            "save greyscaleGreenImage saveGreyscaleGreenImage.png");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }


  //to test greyscale-intensity
  @Test
  public void testGreyscaleIntensityPNG() throws IOException {

    Readable readable = new StringReader("load res/flower.png loaded \n " +
            "greyscale-intensity loaded greyscaleIntensityImage \n " +
            "save greyscaleIntensityImage saveGreyscaleIntensityImage.png");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test greyscale-value
  @Test
  public void testGreyscaleValuePNG() throws IOException {

    Readable readable = new StringReader("load res/flower.png loaded \n " +
            "greyscale-value loaded greyscaleValueImage \n " +
            "save greyscaleValueImage saveGreyscaleValueImage.png");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  // to test greyscale luma
  @Test
  public void testGreyscaleLumaPNG() throws IOException {

    Readable readable = new StringReader("load res/flower.png loaded \n " +
            "greyscale-luma loaded greyscaleLumaImage \n " +
            "save greyscaleLumaImage saveGreyscaleLumaImage.png");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //greyscale transformation
  @Test
  public void testGreyscaleTransformPNG() throws IOException {

    Readable readable = new StringReader("load res/flower.png loaded \n " +
            "greyscale loaded greyscaleImage \n save greyscaleLumaImage saveGreyscaleImage.png");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //sepia transfromation
  @Test
  public void testSepiaTransformPNG() throws IOException {

    Readable readable = new StringReader("load res/flower.png loaded \n " +
            "greyscale-luma loaded greyscaleLumaImage \n " +
            "save greyscaleLumaImage saveGreyscaleLumaImage.png");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //blur
  @Test
  public void testBlurPNG() throws IOException {

    Readable readable = new StringReader("load res/flower.png loaded \n " +
            "blur loaded blurImage \n save blurImage saveBlurImage.png");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //sharpen
  @Test
  public void testSharpenPNG() throws IOException {

    Readable readable = new StringReader("load res/flower.png loaded \n " +
            "sharpen loaded sharpenImage \n save sharpenImage saveSharpenImage.png");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //test load for controller
  @Test
  public void testLoadPNG() throws IOException {

    Readable readable = new StringReader("load res/flower.png loaded \n " +
            "save loaded saveLoadedImage.png");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }


  //test save
  @Test
  public void testSavePNG() throws IOException {

    Readable readable = new StringReader("load res/flower.png loaded \n " +
            "save loaded saveLoadedImage.png");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }


  /**
   * below are tests for only bmp.
   */

  @Test
  public void testBrightenBMP() throws IOException {

    Readable readable = new StringReader("load res/pizza.bmp loaded \n " +
            "brighten 100 loaded brightenImage \n save brightenImage saveBrightenedImage.bmp");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test darken
  @Test
  public void testDarkenBMP() throws IOException {

    Readable readable = new StringReader("load res/pizza.bmp loaded \n " +
            "darken 100 loaded darkenImage \n save darkenImage saveDarkenedImage.bmp");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());


  }

  //to test vertical
  @Test
  public void testVerticalBMP() throws IOException {

    Readable readable = new StringReader("load res/pizza.bmp loaded \n " +
            "vertical loaded verticalImage \n save verticalImage saveVerticalImage.bmp");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test horizontal

  @Test
  public void testHorizontalBMP() throws IOException {

    Readable readable = new StringReader("load res/pizza.bmp loaded \n " +
            "horizontal loaded horizontalImage \n save horizontalImage saveHorizontalImage.bmp");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test greyscale-red
  @Test
  public void testGreyscaleRedBMP() throws IOException {

    Readable readable = new StringReader("load res/pizza.bmp loaded \n " +
            "greyscale-red loaded greyscaleRedImage \n " +
            "save greyscaleRedImage saveGreyscaleRedImage.bmp");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test greyscale-blue
  @Test
  public void testGreyscaleBlueBMP() throws IOException {

    Readable readable = new StringReader("load res/pizza.bmp loaded \n " +
            "greyscale-blue loaded greyscaleBlueImage \n " +
            "save greyscaleBlueImage saveGreyscaleBlueImage.bmp");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test greyscale-green

  @Test
  public void testGreyscaleGreenBMP() throws IOException {

    Readable readable = new StringReader("load res/flower.bmp loaded \n " +
            "greyscale-green loaded greyscaleGreenImage \n " +
            "save greyscaleGreenImage saveGreyscaleGreenImage.bmp");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }


  //to test greyscale-intensity
  @Test
  public void testGreyscaleIntensityBMP() throws IOException {

    Readable readable = new StringReader("load res/pizza.bmp loaded \n " +
            "greyscale-intensity loaded greyscaleIntensityImage \n " +
            "save greyscaleIntensityImage saveGreyscaleIntensityImage.bmp");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test greyscale-value
  @Test
  public void testGreyscaleValueBMP() throws IOException {

    Readable readable = new StringReader("load res/pizza.bmp loaded \n " +
            "greyscale-value loaded greyscaleValueImage \n " +
            "save greyscaleValueImage saveGreyscaleValueImage.bmp");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  // to test greyscale luma
  @Test
  public void testGreyscaleLumaBMP() throws IOException {

    Readable readable = new StringReader("load res/pizza.bmp loaded \n " +
            "greyscale-luma loaded greyscaleLumaImage \n " +
            "save greyscaleLumaImage saveGreyscaleLumaImage.bmp");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //greyscale transformation
  @Test
  public void testGreyscaleTransformBMP() throws IOException {

    Readable readable = new StringReader("load res/pizza.bmp loaded \n " +
            "greyscale loaded greyscaleImage \n save greyscaleLumaImage saveGreyscaleImage.bmp");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //sepia transfromation
  @Test
  public void testSepiaTransformBMP() throws IOException {

    Readable readable = new StringReader("load res/pizza.bmp loaded \n " +
            "greyscale-luma loaded greyscaleLumaImage \n " +
            "save greyscaleLumaImage saveGreyscaleLumaImage.bmp");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //blur
  @Test
  public void testBlurBMP() throws IOException {

    Readable readable = new StringReader("load res/pizza.bmp loaded \n " +
            "blur loaded blurImage \n save blurImage saveBlurImage.bmp");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //sharpen
  @Test
  public void testSharpenBMP() throws IOException {

    Readable readable = new StringReader("load res/pizza.bmp loaded \n " +
            "sharpen loaded sharpenImage \n save sharpenImage saveSharpenImage.bmp");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //test load for controller
  @Test
  public void testLoadBMP() throws IOException {

    Readable readable = new StringReader("load res/pizza.bmp loaded \n " +
            "save loaded saveLoadedImage.bmp");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }


  //test save
  @Test
  public void testSaveBMP() throws IOException {

    Readable readable = new StringReader("load res/pizza.bmp loaded \n " +
            "save loaded saveLoadedImage.bmp");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  // png to jpg
  @Test
  public void testPNGToJPG() throws IOException {

    Readable readable = new StringReader("load res/flower.png loaded \n " +
            "save loaded saveLoadedImage.jpg");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  /**
   * png to bmp.
   */
  @Test
  public void testPNGToBMP() throws IOException {

    Readable readable = new StringReader("load res/flower.png loaded \n " +
            "save loaded saveLoadedImage.bmp");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  // png to ppm
  @Test
  public void testPNGToPPM() throws IOException {

    Readable readable = new StringReader("load res/flower.png loaded \n " +
            "save loaded saveLoadedImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  // jpg to png
  @Test
  public void testJPGToPNG() throws IOException {

    Readable readable = new StringReader("load res/reivarsh.jpg loaded \n " +
            "save loaded saveLoadedImage.png");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  // jpg to bmp
  @Test
  public void testJPGToBMP() throws IOException {

    Readable readable = new StringReader("load res/reivarsh.jpg loaded \n " +
            "save loaded saveLoadedImage.bmp");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  // jpg to ppm
  @Test
  public void testJPGToPPM() throws IOException {

    Readable readable = new StringReader("load res/reivarsh.jpg loaded \n " +
            "save loaded saveLoadedImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }


  //bmp to png
  @Test
  public void testBMPToPNG() throws IOException {

    Readable readable = new StringReader("load res/pizza.bmp loaded \n " +
            "save loaded saveLoadedImage.png");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  // bmp to jpg
  @Test
  public void testBMPToJPG() throws IOException {

    Readable readable = new StringReader("load res/pizza.bmp loaded \n " +
            "save loaded saveLoadedImage.jpg");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  // bmp to ppm
  @Test
  public void testBMPToPPM() throws IOException {

    Readable readable = new StringReader("load res/pizza.bmp loaded \n " +
            "save loaded saveLoadedImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }


  // ppm to png
  @Test
  public void testPPMToPNG() throws IOException {

    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "save loaded saveLoadedImage.png");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  // ppm to jpg
  @Test
  public void testPPMtoJPG() throws IOException {

    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "save loaded saveLoadedImage.jpg");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  // ppm to bmp
  @Test
  public void testPPMtoBMP() throws IOException {

    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "save loaded saveLoadedImage.BMP");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }


  // invalid: empty file name
  @Test(expected = IllegalArgumentException.class)
  public void InvalidEmptyFile() throws IOException {

    StringBuilder in = new StringBuilder();
    ImageModel game = new ImageModelImplementation();
    Readable readable = new StringReader("load res/.ppm loaded \n " +
            "save loaded saveLoadedImage.bmp");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Executed: unable to run. \n" +
            "Executed: unable to run. \n", in.toString());


  }

  // invalid extension.
  @Test(expected = IllegalArgumentException.class)
  public void InvalidEmptyNameForSave() throws IOException {

    StringBuilder in = new StringBuilder();
    ImageModel game = new ImageModelImplementation();
    Readable readable = new StringReader("load res/.gth loaded \n " +
            "save loaded .bmp");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Executed: unable to run. \n" +
            "Executed: unable to run. \n", in.toString());


  }

  @Test(expected = IllegalArgumentException.class)
  public void InvalidEmptyNameForLoad() throws IOException {

    StringBuilder in = new StringBuilder();
    ImageModel game = new ImageModelImplementation();
    Readable readable = new StringReader("load res/.gth loaded \n " +
            "save loaded saveImage.bmp");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Executed: unable to run. \n" +
            "Executed: unable to run. \n", in.toString());


  }

  @Test(expected = IllegalArgumentException.class)
  public void InvalidExtentionForLoad() throws IOException {

    StringBuilder in = new StringBuilder();
    ImageModel game = new ImageModelImplementation();
    Readable readable = new StringReader("load res/.gth loaded \n " +
            "save loaded saveLoadedImage.bmp");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Executed: unable to run. \n" +
            "Executed: unable to run. \n", in.toString());


  }

  @Test
  public void InvalidExtentionForSave() throws IOException {

    StringBuilder in = new StringBuilder();
    ImageModel game = new ImageModelImplementation();
    Readable readable = new StringReader("load res/toast.ppm loaded \n " +
            "save loaded saveLoadedImage.blp");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    //nothing is outputted
    assertEquals("", in.toString());

  }

  //empty name for save
  @Test
  public void testErrorWrongCommandNames() throws IOException {
    StringBuilder in = new StringBuilder();
    ImageModel game = new ImageModelImplementation();

    Readable readable = new StringReader("find res/toast.ppm loaded \n " +
            "flip loaded .png");


    IImageView view = new ImageView(game, in);

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();


    assertEquals("Executed: unable to run. \n" +
            "Executed: unable to run. \n", in.toString());


  }


  //error wrong file name
  @Test
  public void testErrorWrongFileNameForLoad() throws IOException {
    StringBuilder in = new StringBuilder();
    ImageModel game = new ImageModelImplementation();

    Readable readable = new StringReader("find res/please.ppm loaded \n " +
            "flip loaded flip.png");


    IImageView view = new ImageView(game, in);

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();


    assertEquals("Executed: unable to run. \n" +
            "Executed: unable to run. \n", in.toString());

  }

  //THIS WILL TEST MASK IMAGE
  //to test brighten
  @Test
  public void testMaskBrighten() throws IOException {

    Readable readable = new StringReader("load res/blackCircle.png loadMask \n " +
            "load res/flower.png " +
            "loaded \n brighten 100 loaded loadMask brightenPartialImage \n " +
            "save brightenPartialImage saveBrightenedPartialImage.ppm");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test darken
  @Test
  public void testMaskDarken() throws IOException {

    Readable readable = new StringReader("load res/blackCircle.png loadMask \n " +
            "load res/flower.png " +
            "loaded \n darken 100 loaded loadMask darkenPartialImage \n " +
            "save darkenPartialImage saveDarkenedPartialImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());


  }


  //to test greyscale-red
  @Test
  public void testMaskGreyscaleRed() throws IOException {

    Readable readable = new StringReader("load res/blackCircle.png loadMask \n " +
            "load res/flower.png " +
            "loaded \n greyscale-red  loaded loadMask greyscaleRedPartialImage \n " +
            "save greyscaleRedPartialImage saveGreyscaleRedPartialImage.ppm");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test greyscale-blue
  @Test
  public void testMaskGreyscaleBlue() throws IOException {

    Readable readable = new StringReader("load res/blackCircle.png loadMask \n " +
            "load res/flower.png loaded \n " +
            "greyscale-blue  loaded loadMask greyscaleBluePartialImage \n " +
            "save greyscaleBluePartialImage saveGreyscaleBluePartialImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test greyscale-green

  @Test
  public void testMaskGreyscaleGreen() throws IOException {

    Readable readable = new StringReader("load res/blackCircle.png loadMask \n " +
            "load res/flower.png loaded \n " +
            "greyscale-green  loaded loadMask greyscaleGreenPartialImage \n " +
            "save greyscaleGreenPartialImage saveGreyscaleGreenPartialImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }


  //to test greyscale-intensity
  @Test
  public void testMaskGreyscaleIntensity() throws IOException {

    Readable readable = new StringReader("load res/blackCircle.png loadMask \n " +
            "load res/flower.png loaded \n " +
            "greyscale-intensity  loaded loadMask greyscaleIntensityPartialImage \n " +
            "save greyscaleIntensityPartialImage saveGreyscaleIntensityPartialImage.ppm");
    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //to test greyscale-value
  @Test
  public void testMaskGreyscaleValue() throws IOException {

    Readable readable = new StringReader("load res/blackCircle.png loadMask \n " +
            "load res/flower.png loaded \n " +
            "greyscale-value  loaded loadMask greyscaleValuePartialImage \n " +
            "save greyscaleValuePartialImage saveGreyscaleValuePartialImage.ppm");


    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  // to test greyscale luma
  @Test
  public void testMaskGreyscaleLuma() throws IOException {

    Readable readable = new StringReader("load res/blackCircle.png loadMask \n " +
            "load res/flower.png loaded \n " +
            "greyscale-luma loaded loadMask greyscaleLumaPartialImage \n " +
            "save greyscaleLumaPartialImage saveGreyscaleLumaPartialImage.ppm");
    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());
  }

  //greyscale transformation
  @Test
  public void testMaskGreyscaleTransform() throws IOException {

    Readable readable = new StringReader("load res/blackCircle.png loadMask \n " +
            "load res/flower.png loaded \n " +
            "greyscale loaded loadMask greyscalePartialImage \n " +
            "save greyscalePartialImage saveGreyscalePartialImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //sepia transfromation
  @Test
  public void testMaskSepiaTransform() throws IOException {

    Readable readable = new StringReader("load res/blackCircle.png loadMask \n " +
            "load res/flower.png loaded \n " +
            "sepia loaded loadMask sepiaPartialImage \n " +
            "save sepiaPartialImage saveSepiaPartialImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //blur
  @Test
  public void testMaskBlur() throws IOException {

    Readable readable = new StringReader("load res/blackCircle.png loadMask \n" +
            "load res/flower.png loaded \n " +
            "blur loaded loadMask blurPartialImage \n " +
            "save blurPartialImage saveBlurPartialImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //sharpen
  @Test
  public void testMaskSharpen() throws IOException {

    Readable readable = new StringReader("load res/blackCircle.png loadMask \n" +
            "load res/flower.png loaded \n " +
            "sharpen loaded loadMask sharpenPartialImage \n " +
            "save sharpenPartialImage saveSharpenPartialImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //test load for controller
  @Test
  public void testMaskLoad() throws IOException {

    Readable readable = new StringReader("load res/blackCircle.png loadMask \n" +
            "load res/flower.png loaded \n " +
            "sepia  loaded loadMask sepiaPartialImage \n");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());
  }


  //test save
  @Test
  public void testMaskSave() throws IOException {

    Readable readable = new StringReader("load res/blackCircle.png loadMask \n " +
            "load res/flower.png loaded \n " +
            "sepia loaded loadMask sepiaPartialImage \n " +
            "save sepiaPartialImage saveSepiaPartialImage.ppm");

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();
    assertEquals("Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n" +
            "Successfully Completed the command \n", log.toString());

  }

  //EXTRA CREDIT: ERROR MESSAGE WITH WRONG DIMENSIONS.
  //empty name for save
  @Test(expected = IllegalArgumentException.class)
  public void testMaskWrongDimensions() throws IOException {
    StringBuilder in = new StringBuilder();
    ImageModel game = new ImageModelImplementation();

    Readable readable = new StringReader("load res/Koala.ppm loaded \n " +
            "load res/blackCircle.png maskImage \n " +
            "blur loaded maskImage blurUsingMask\n" +
            "savee blurUsingMask blurImage.png");


    IImageView view = new ImageView(game, in);

    ImageControllerImpl control = new ImageControllerImpl(readable, view, game);

    control.perform();


    assertEquals("Executed: image loaded \n" +
            "Executed: image loaded \n" +
            "Executed: unable to run.", in.toString());


  }
}
