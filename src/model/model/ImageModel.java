package model.model;

import java.io.IOException;

import model.image.Image;
import model.pixel.Pixel;

/**
 * Represents the model that will be used to change the images.
 */
public interface ImageModel {

  /**
   * using this method, we will be able to get the red component of the specific pixel in the
   * given row and col.
   *
   * @param row represents the row of the pixel we need.
   * @param col represents the col of the pixel we need.
   * @return the int that represents the red component of the given pixel.
   */
  int getRed(int row, int col);


  /**
   * using this method, we will be able to get the green component of the specific pixel in the
   * given row and col.
   *
   * @param row represents the row of the pixel we need.
   * @param col represents the col of the pixel we need.
   * @return the int that represents the blue component of the given pixel.
   */
  int getGreen(int row, int col);


  /**
   * using this method, we will be able to get the blue component of the specific pixel in the
   * given row and col.
   *
   * @param row represents the row of the pixel we need.
   * @param col represents the col of the pixel we need.
   * @return the int that represents the green component of the given pixel.
   */
  int getBlue(int row, int col);

  /**
   * sets the image by putting the image in the map with the given name.
   *
   * @param name  represents the name of the image being placed in the map.
   * @param image represents the image that is being placed in the map.
   */
  void setImage(String name, Image image);

  /**
   * gets the image that is present in the map.
   *
   * @param name represents the name of what the image is stored with.
   * @return the Image that is stored using the given name.
   */

  Image getImage(String name);

  /**
   * using this function, we will be able to load the image.
   *
   * @param imagePath represents where the image is being collected from.
   * @param imageName represents the name that the loaded image will now be called.
   */
  void loadImage(String imagePath, String imageName) throws IOException;



  /**
   * using this function, we will be able to save the image. This uses the save
   * private class we have made.
   *
   * @param imagePath represents where the image is being collected from.
   * @param imageName represents the name that the saved image will now be called.
   */
  void saveImage(String imagePath, String imageName) throws IOException;

  /**
   * This function gets the pixel 2D array of an image's pixels by iterating through all the
   * row and columns and getting their RGB values.
   *
   * @return a pixel 2D array.
   */
  Pixel[][] getPixelImage();

  /**
   * This method gets the integer value for this image's width (how many pixels wide the image is).
   *
   * @return the integer value width of this image.
   */
  int getImageWidth();

  /**
   * This method gets the integer value for this image's height (how many pixels tall the image
   * is).
   *
   * @return the integer value height of this image.
   */
  int getImageHeight();


  /**
   * Retrieves the image which is to be shown.
   *
   * @return the Image
   */
  Image getImageToBeShown();

  /**
   * represents the image that will be using the intensity function.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  void intensity(String imageName, String destImageName);

  /**
   * represents the image that will be using the intensity function with the mask filter.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      *             will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  void intensityMask(String imageName, String maskImage, String destImageName);

  /**
   * represents the image that will be using the value function.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  void value(String imageName, String destImageName);

  /**
   * represents the image that will be using the value function with masking.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  void valueMask(String imageName, String maskImage, String destImageName);

  /**
   * represents the image that will be using the greyscale(red) function.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  void greyScaleRed(String imageName, String destImageName);

  /**
   * represents the image that will be using the greyscale red function with masking.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  void greyscaleRedMask(String imageName, String maskImage, String destImageName);

  /**
   * represents the image that will be using the greyscale(green) function.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  void greyScaleGreen(String imageName, String destImageName);

  /**
   * represents the image that will be using the greyscale green function with masking.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  void greyscaleGreenMask(String imageName, String maskImage, String destImageName);

  /**
   * represents the image that will be using the greyscale(blue) function.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  void greyScaleBlue(String imageName, String destImageName);

  /**
   * represents the image that will be using the greyscale blue function with masking.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  void greyscaleBlueMask(String imageName, String maskImage, String destImageName);

  /**
   * represents the image that will be using the luma function.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  void luma(String imageName, String destImageName);

  /**
   * represents the image that will be using the luma function with masking.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  void lumaMask(String imageName, String maskImage, String destImageName);

  /**
   * represents the image that will be using the brighten function.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  void brighten(int brightenIncrement, String imageName, String destImageName);

  /**
   * represents the image that will be using the brighten function with masking.
   *
   * @param brightenIncrement the amount by which the image will be brightened.
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  void brightenMask(int brightenIncrement,String imageName, String maskImage, String destImageName);

  /**
   * represents the image that will be using the darken function.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  void darken(int darkenIncrement, String imageName, String destImageName);


  /**
   * represents the image that will be using the darken function with masking.
   * @param darkenIncrement the amount by which the image will be darkened.
   * @param maskImage represents the mask image which the black pixel location
   *                  will be calculated from.
   * @param imageName represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  void darkenMask(int darkenIncrement, String imageName, String maskImage, String destImageName);

  /**
   * represents the image that will be using the fipHorizontal function.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  void flipImageHorizontal(String imageName, String destImageName);

  /**
   * represents the image that will be using the flipVertical function.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  void flipImageVertical(String imageName, String destImageName);


  /**
   * represents the image that will be using the blur function.This uses the kernel helper function
   * to calculate how each pixel will be blurred.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  void blur(String imageName, String destImageName);

  /**
   * represents the image that will be using the blur function with masking.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  void blurMask(String imageName, String maskImage, String destImageName);

  /**
   * represents the image that will be using the sharpen function.
   * This uses the kernel helper function to calculate how each pixel will be sharpened.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  void sharpen(String imageName, String destImageName);

  /**
   * represents the image that will be using the sharpen function with masking.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  void sharpenMask(String maskImage, String imageName, String destImageName);

  /**
   * represents the image that will be using the greyscale function(calculated using the transform
   * helper function).
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  void toGreyscale(String imageName, String destImageName);

  /**
   * represents the image that will be using the greyscale function with masking.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  void greyscaleMask(String maskImage, String imageName, String destImageName);

  /**
   * represents the image that will be using the sepia function(calculated using the transform
   * helper function).
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  void toSepia(String imageName, String destImageName);

  /**
   * represents the image that will be using the sepia function with masking.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  void sepiaMask(String maskImage, String imageName, String destImageName);

  /**
   * This method downscales an Image by a given increment to scale.
   *
   * @param increment     the amount by which the image will be downscaled.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  void downscale(double increment, String imageName, String destImageName);


}