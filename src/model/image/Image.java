package model.image;

import model.pixel.Pixel;


/**
 * represents the Image interface that will be used in the Image Implementation class.
 */
public interface Image {

  /**
   * using this method, we are able to retrieve the pixel components of an Image.
   *
   * @return the 2d pixel array that create an image.
   */
  Pixel[][] getImage();


  /**
   * represents the width of the image.
   *
   * @return the int width of the image.
   */
  int getImageWidth();

  /**
   * represents the height of the image.
   *
   * @return the int height of the image.
   */
  int getImageHeight();

  /**
   * using this method, we will be able to get the red, green, or blue components of a
   * pixel in the specific row or col.
   *
   * @param row represents the row of the given image.
   * @param col represents the col of the given image.
   * @return the 1d array that represents the red, green, and blue component of the given pixel.
   */
  int[] pixel(int row, int col);

  /**
   * represents the maxValue of the image (the highest color component (r, g, or b)) in the image.
   *
   * @return the int maxValue of the image.
   */
  int getMaxValue();




}
