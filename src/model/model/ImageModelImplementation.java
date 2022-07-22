package model.model;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import model.ImageUtil;
import model.image.ImageImplementation;
import model.image.Image;
import model.pixel.Pixel;
import model.pixel.PixelImplementation;

import static model.ImageUtil.saveBufferedImage;


/**
 * represents the model. This will be used to change the image.
 */

public class ImageModelImplementation implements ImageModel {

  /**
   * represents the image that will be changed.
   */
  private Image image;


  /**
   * represents the map that will be used to store the images.
   */
  private Map<String, Image> map;


  /**
   * represents the constructor that will take in the image. The map will be empty.
   *
   * @param image represents the unfiltered image.
   */
  public ImageModelImplementation(Image image) {
    this.image = image;
    this.map = new HashMap<>();
  }

  /**
   * represents constructor that shows that the map is currently empty.
   */
  public ImageModelImplementation() {

    map = new HashMap<>();

  }


  /**
   * using this method, we will be able to get the red component of the specific pixel in the
   * given row and col.
   *
   * @param row represents the row of the pixel we need.
   * @param col represents the col of the pixel we need.
   * @return the int that represents the red component of the given pixel.
   */
  public int getRed(int row, int col) {
    int red = this.image.getImage()[row][col].getRed();
    return red;
  }

  /**
   * using this method, we will be able to get the green component of the specific pixel in the
   * given row and col.
   *
   * @param row represents the row of the pixel we need.
   * @param col represents the col of the pixel we need.
   * @return the int that represents the green component of the given pixel.
   */
  public int getGreen(int row, int col) {
    int green = this.image.getImage()[row][col].getGreen();
    return green;
  }


  /**
   * using this method, we will be able to get the blue component of the specific pixel in the
   * given row and col.
   *
   * @param row represents the row of the pixel we need.
   * @param col represents the col of the pixel we need.
   * @return the int that represents the blue component of the given pixel.
   */
  public int getBlue(int row, int col) {
    int blue = this.image.getImage()[row][col].getBlue();
    return blue;
  }


  /**
   * sets the image by putting the image in the map with the given name.
   *
   * @param name  represents the name of the image being placed in the map.
   * @param image represents the image that is being placed in the map.
   */
  public void setImage(String name, Image image) {
    map.put(name, image);
  }

  /**
   * gets the image that is present in the map.
   *
   * @param name represents the name of what the image is stored with.
   * @return the Image that is stored using the given name.
   */
  public Image getImage(String name) {
    return map.get(name);

  }

  /**
   * using this function, we will be able to load the image.
   *
   * @param imagePath represents where the image is being collected from.
   * @param imageName represents the name that the loaded image will now be called.
   */
  public void loadImage(String imagePath, String imageName) throws IOException {
    //loads the image, depending on the extension of imagePath.
    this.image = new ImageImplementation(imagePath);
    map.put(imageName, image);
  }

  /**
   * This function gets the pixel 2D array of an image's pixels by iterating through all the
   * row and columns and getting their RGB values.
   *
   * @return a pixel 2D array.
   */
  public Pixel[][] getPixelImage() {
    Pixel[][] pixels = new Pixel[this.image.getImageHeight()][this.image.getImageWidth()];
    for (int i = 0; i < this.image.getImageHeight(); i++) {
      for (int j = 0; j < this.image.getImageWidth(); j++) {
        pixels[i][j] = new PixelImplementation(this.image.getImage()[i][j].getRed(),
                this.image.getImage()[i][j].getGreen(),
                this.image.getImage()[i][j].getBlue());
      }
    }
    return pixels;
  }

  /**
   * This method gets the integer value for this image's width (how many pixels wide the image is).
   *
   * @return the integer value width of this image.
   */
  public int getImageWidth() {
    return this.image.getImageWidth();
  }

  /**
   * This method gets the integer value for this image's height (how many pixels tall the image
   * is).
   *
   * @return the integer value height of this image.
   */
  public int getImageHeight() {
    return this.image.getImageHeight();
  }

  /**
   * using this function, we will be able to save the image. This uses the save
   * private class we have made.
   *
   * @param imagePath represents where the image is being collected from.
   * @param imageName represents the name that the saved image will now be called.
   */

  //how do we let them choose between what they want to export it as
  public void saveImage(String imagePath, String imageName) throws IOException {
    //saves the image.
    //looks at the type of extension in the imageName
    String[] arr = imageName.split("\\.");
    //use BufferedImage
    String[] arrayFileName = {"png", "jpg", "bmp"};

    if (arr[1].equals("ppm")) {
      //ppm file ->use function from Assignment 4
      new ImageUtil.Save(imagePath, imageName, map.get(imagePath)).apply();
      this.map.put(imageName, this.image);
    } else {
      for (String fileName : arrayFileName) {
        //if the file is png, jpg, or bmp, it will make a BufferedImage
        if (arr[1].equals(fileName)) {
          saveBufferedImage(map.get(imagePath).getImage(), image.getImageWidth(),
                  image.getImageHeight(), imageName);
        }
      }
    }
    //need a valid name for save image to work.
    if (arr[0].equals("")) {
      throw new IllegalArgumentException("need a valid FileName");
    }
  }

  /**
   * Retrieves the image which is to be shown.
   *
   * @return the Image
   */
  public Image getImageToBeShown() {
    return this.image;
  }


  /**
   * represents the image that will be using the intensity function.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  public void intensity(String imageName, String destImageName) {

    this.image = new ImageFilterImplementation().greyScale(map.get(imageName),
            ImageFilterImplementation.GreyScale.INTENSITY);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the intensity function with the mask filter.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      *             will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  public void intensityMask(String imageName, String maskImage, String destImageName) {
    this.image = new ImageFilterImplementation().greyscaleMask(map.get(imageName),
            map.get(maskImage), ImageFilterImplementation.FilterChoice.INTENSITY);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the value function.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  public void value(String imageName, String destImageName) {
    this.image = new ImageFilterImplementation().greyScale(map.get(imageName),
            ImageFilterImplementation.GreyScale.VALUE);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the value function with masking.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  public void valueMask(String imageName, String maskImage, String destImageName) {
    this.image = new ImageFilterImplementation().greyscaleMask(map.get(imageName),
            map.get(maskImage), ImageFilterImplementation.FilterChoice.VALUE);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the greyscale(red) function.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  public void greyScaleRed(String imageName, String destImageName) {

    this.image = new ImageFilterImplementation().greyScale(map.get(imageName),
            ImageFilterImplementation.GreyScale.RED);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the greyscale red function with masking.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  public void greyscaleRedMask(String imageName, String maskImage, String destImageName) {
    this.image = new ImageFilterImplementation().greyscaleMask(map.get(imageName),
            map.get(maskImage), ImageFilterImplementation.FilterChoice.GREYSCALERED);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the greyscale(green) function.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  public void greyScaleGreen(String imageName, String destImageName) {

    this.image = new ImageFilterImplementation().greyScale(map.get(imageName),
            ImageFilterImplementation.GreyScale.GREEN);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the greyscale green function with masking.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  public void greyscaleGreenMask(String imageName, String maskImage, String destImageName) {
    this.image = new ImageFilterImplementation().greyscaleMask(map.get(imageName),
            map.get(maskImage), ImageFilterImplementation.FilterChoice.GREYSCALEGREEN);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the greyscale(blue) function.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  public void greyScaleBlue(String imageName, String destImageName) {
    this.image = new ImageFilterImplementation().greyScale(map.get(imageName),
            ImageFilterImplementation.GreyScale.BLUE);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the greyscale blue function with masking.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  public void greyscaleBlueMask(String imageName, String maskImage, String destImageName) {
    this.image = new ImageFilterImplementation().greyscaleMask(map.get(imageName),
            map.get(maskImage), ImageFilterImplementation.FilterChoice.GREYSCALEBLUE);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the luma function.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  public void luma(String imageName, String destImageName) {
    this.image = new ImageFilterImplementation().greyScale(map.get(imageName),
            ImageFilterImplementation.GreyScale.LUMA);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the luma function with masking.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  public void lumaMask(String imageName, String maskImage, String destImageName) {
    this.image = new ImageFilterImplementation().greyscaleMask(map.get(imageName),
            map.get(maskImage), ImageFilterImplementation.FilterChoice.LUMA);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the brighten function.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  public void brighten(int brightenIncrement, String imageName, String destImageName) {

    this.image = new ImageFilterImplementation().applyFilter(map.get(imageName),
            filterDarkenBrighten(brightenIncrement),
            ImageFilterImplementation.MathChoice.ADD);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the brighten function with masking.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  public void brightenMask(int brightenIncrement,String imageName, String maskImage,
                           String destImageName) {

    this.image = new ImageFilterImplementation().applyFilterMask(map.get(imageName),
            map.get(maskImage), filterDarkenBrighten(brightenIncrement),
            ImageFilterImplementation.FilterChoice.BRIGHTEN);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the darken function.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  public void darken(int darkenIncrement, String imageName, String destImageName) {

    this.image = new ImageFilterImplementation().applyFilter(map.get(imageName),
            filterDarkenBrighten(darkenIncrement),
            ImageFilterImplementation.MathChoice.MINUS);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the darken function with masking.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  public void darkenMask(int darkenIncrement, String imageName, String maskImage,
                         String destImageName) {

    this.image = new ImageFilterImplementation().applyFilterMask(map.get(imageName),
            map.get(maskImage), filterDarkenBrighten(darkenIncrement),
            ImageFilterImplementation.FilterChoice.DARKEN);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the fipHorizontal function.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  public void flipImageHorizontal(String imageName, String destImageName) {
    this.image = new ImageFilterImplementation().flipHorizontal(map.get(imageName));
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the flipVertical function.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  public void flipImageVertical(String imageName, String destImageName) {
    this.image = new ImageFilterImplementation().flipVertical(map.get(imageName));
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the blur function using the blur filter.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  public void blur(String imageName, String destImageName) {
    double[][] blurFilter = {
            {0.0625, 0.125, 0.0625},
            {0.125, 0.25, 0.125},
            {0.0625, 0.125, 0.0625}};

    this.image = new ImageFilterImplementation().applyFilter(map.get(imageName), blurFilter,
            ImageFilterImplementation.MathChoice.MULTIPLY);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the blur function with masking.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  public void blurMask(String imageName,String maskImage, String destImageName) {
    double[][] blurFilter = {
            {0.0625, 0.125, 0.0625},
            {0.125, 0.25, 0.125},
            {0.0625, 0.125, 0.0625}};

    this.image = new ImageFilterImplementation().applyFilterMask(map.get(imageName),
            map.get(maskImage), blurFilter, ImageFilterImplementation.FilterChoice.SHARPEN);
    map.put(destImageName, image);
  }

  /**
   * represents the image changed after being sharpened using sharpen filter.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  public void sharpen(String imageName, String destImageName) {
    double[][] sharpenFilter = {
            {-0.125, -0.125, -0.125, -0.125, -0.125},
            {-0.125, 0.25, 0.25, 0.25, -0.125},
            {-0.125, 0.25, 1, 0.25, -0.125},
            {-0.125, 0.25, 0.25, 0.25, -0.125},
            {-0.125, -0.125, -0.125, -0.125, -0.125}};

    this.image = new ImageFilterImplementation().applyFilter(map.get(imageName), sharpenFilter,
            ImageFilterImplementation.MathChoice.MULTIPLY);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the sharpen function with masking.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  public void sharpenMask(String imageName, String maskImage, String destImageName) {
    double[][] sharpenFilter = {
            {-0.125, -0.125, -0.125, -0.125, -0.125},
            {-0.125, 0.25, 0.25, 0.25, -0.125},
            {-0.125, 0.25, 1, 0.25, -0.125},
            {-0.125, 0.25, 0.25, 0.25, -0.125},
            {-0.125, -0.125, -0.125, -0.125, -0.125}};

    this.image = new ImageFilterImplementation().applyFilterMask(map.get(imageName),
            map.get(maskImage), sharpenFilter, ImageFilterImplementation.FilterChoice.SHARPEN);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be greyscaled using greyscale filter.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  @Override
  public void toGreyscale(String imageName, String destImageName) {
    double[][] greyscale = {{0.2126, 0.7152, 0.0722}, {0.2126, 0.7152, 0.0722}, {0.2126,
            0.7152, 0.0722}};

    this.image = new ImageFilterImplementation().applyFilter(map.get(imageName), greyscale,
            ImageFilterImplementation.MathChoice.TRANSFORM);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the greyscale function with masking.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  public void greyscaleMask(String imageName, String maskImage, String destImageName) {
    double[][] greyscale = {{0.2126, 0.7152, 0.0722}, {0.2126, 0.7152, 0.0722}, {0.2126,
            0.7152, 0.0722}};

    this.image = new ImageFilterImplementation().applyFilterMask(map.get(imageName),
            map.get(maskImage), greyscale, ImageFilterImplementation.FilterChoice.GREYSCALE);
    map.put(destImageName, image);
  }

  /**
   * This method applies the sepia filter to a given image by transforming each individual pixel's
   * color channels.This uses the given sepia image.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void toSepia(String imageName, String destImageName) {
    double[][] sepia = {{0.393, 0.769, 0.189}, {0.349, 0.686, 0.168}, {0.272, 0.534, 0.131}};

    this.image = new ImageFilterImplementation().applyFilter(map.get(imageName), sepia,
            ImageFilterImplementation.MathChoice.TRANSFORM);
    map.put(destImageName, image);
  }

  /**
   * represents the image that will be using the sepia function with masking.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  public void sepiaMask(String imageName, String maskImage, String destImageName) {
    double[][] sepia = {{0.393, 0.769, 0.189}, {0.349, 0.686, 0.168}, {0.272, 0.534, 0.131}};

    this.image = new ImageFilterImplementation().applyFilterMask(map.get(imageName),
            map.get(maskImage), sepia, ImageFilterImplementation.FilterChoice.SEPIA);

    map.put(destImageName, image);
  }

  /**
   * this method will create a filter for darken and brighten. This will be placed in the
   * 2nd parameter of the applyFilter function.
   *
   * @param increment represents the amount that the image will be brightened or darkened.
   * @return the 2d array that will represent the brighten or darken filter.
   */
  private double[][] filterDarkenBrighten(int increment) {
    double[][] filter = new double[image.getImageHeight()][image.getImageWidth()];
    for (int i = 0; i < image.getImageHeight(); i++) {
      for (int j = 0; j < image.getImageWidth(); j++) {
        filter[i][j] = increment;
      }
    }
    return filter;
  }

  /**
   * This method downscales an Image by a given increment to scale.
   *
   * @param increment     the amount by which the image will be downscaled.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  public void downscale(double increment, String imageName, String destImageName) {
    this.image = new ImageFilterImplementation().downscaleImage(map.get(imageName), increment);
    map.put(destImageName, image);
  }
}
