package model.model;

import model.image.Image;
import model.pixel.Pixel;


/**
 * Determines the calculations for the filters.
 */
public interface ImageFilter {
  /**
   * this will allow us to check that the pixel colors are in the correct range. If the number
   * is greater than 255, then the number returned would be 255 (a color cannot be greater than
   * 255). If the number is less than 0, then the number returned would be 0 (a color cannot be
   * a negative number). If the number is between 0 and 255, then the number is returned as it is.
   *
   * @param number is a color number that will be given
   * @return an int that would represent the color outputted.
   */

  int clamp(int number);


  /**
   * using this method, we will be able to transform the image pixels individually.
   * Multiply by iterating the filter number to each pixel of the image.
   * This is different from the createNewPixel function, as it uses the filter size
   * to iterate and makes the new pixel with the transformed filter.This also returns a double,
   * which will be used to initialize the rbg components of a transformed image.
   *
   * @param pixel  represents the pixel to be changed (consists of the r, g, b components).
   * @param filter creates the filter into a 1d array to multiply individually.
   * @return the double that would represent how much the picture needs to be changed.
   */
  double transform(int[] pixel, double[] filter);


  // FOR KERNAL CALCULATIONS

  /**
   * this will create a new kernel pixel. As the kernel revolves around the picture, this will
   * grow a pixel that has been changed to fit the filter application. The new pixel is made by
   * multiplying each pixel of the kernel to the filter matrix.
   *
   * @param kernel represents the kernel.
   * @param filter represents the filter that we are multiplying the kernel by.
   * @return a Pixel that represents the rgb components to the filter(using kernel).
   */
  Pixel createNewKernelPixel(Pixel[][] kernel, double[][] filter);


  /**
   * this will allow us to calculate the kernel. As the kernel moves around the picture,
   * it will be moved around, so we need to calculate the boundary of the image. This will create a
   * new 2d array of pixels that represent the kernel(this will be calculated according to
   * the size of
   * the image). As the size changes, the kernel can also change as the boundaries will alter.
   *
   * @param row    represents the row of the image.
   * @param column represents the col of the image.
   * @param image  represents the new 2d Pixel array we are aiming to make, with RGB component.
   * @param size   represents the size of the kernel.
   * @return a 2d pixel array that would represent the kernel.
   */
  Pixel[][] getKernel(int row, int column, Pixel[][] image, int size);


  /**
   * this allows us to create a pixel after a change has been made. This method will be used for
   * brighten and darken as it will add or minus to each pixel depending on the command. Once each
   * pixel is changes, we know that the image will also be changed.
   *
   * @param row    represents the row of the pixel.
   * @param col    represents the col of the pixel.
   * @param image  represents the image that will be used.
   * @param filter represents the filter (the number that will be added or subtracted).
   * @param choice uses the enum (MathChoice) to see if the filter will be added or minused.
   * @return a Pixel that has been changed to fit the filter and MathChoice.
   */

  Pixel createNewPixel(int row, int col, Image image,
                       double[] filter, ImageFilterImplementation.MathChoice choice);

  /**
   * this will apply the filter to each pixel of the image so that the image can be
   * completely changed(only for brighten or darken).
   *
   * @param image  represents the image that will be used.
   * @param filter represents the filter that will be used to change the image.
   * @param choice represents whether the image is being darkened or brightened.
   * @return the new Image with the filter applied.
   */

  Image applyFilter(Image image, double[][] filter, ImageFilterImplementation.MathChoice choice);


  /**
   * using this method, we will be able to change the image using a specific filter. This will be
   * used to change every image to greyScale.
   *
   * @param image     represents the image that will be changed.
   * @param greyScale uses the enum GreyScale to check which greyscale needs to be used.
   * @return the filtered image depending on what the user has asked.
   */

  Image greyScale(Image image, ImageFilterImplementation.GreyScale greyScale);

  /**
   * using this function, we wll be able to change the position of every pixel so they can be
   * flipped horizontally.
   *
   * @param image represents the image that will be changed.
   * @return the image that has been flipped horizontally.
   */
  Image flipHorizontal(Image image);

  /**
   * using this function, we wll be able to change the position of every pixel so they can be
   * flipped vertically.
   *
   * @param image represents the image that will be changed.
   * @return the image that has been flipped vertically.
   */

  Image flipVertical(Image image);

  /**
   * Using this function we can find downscale an Image by a given increment, by resizing the
   * image and getting its mapped RGB pixel value using a helper function called calcRGB.
   *
   * @param image     represents the image that will be changed.
   * @param increment the amount by which it will be downscaled.
   * @return the image that has been downsized to scale.
   */
  Image downscaleImage(Image image, double increment);

  /**
   * this will apply the filter to each pixel of the image so that the image can be
   * completely changed(only for brighten or darken).
   *
   * @param maskImage    represents the mask image which will be used to get the black pixels
   *                     and only there will the filter be applied.
   * @param image        represents the image that the filter will be applied on.
   * @param filter       represents the filter that will be used to changed the image.
   * @param filterChoice represents the filter to be applied from the FilterChoice enum.
   * @return the new Image with the filter applied where the mask image applies.
   */
  Image applyFilterMask(Image maskImage, Image image, double[][] filter,
                        ImageFilterImplementation.FilterChoice filterChoice);

  /**
   * this will apply the filter to each pixel of the where the mask applies. This method
   * specifically focuses on the greyscale filters.
   *
   * @param maskImage    represents the mask image which will be used to get the black pixels
   *                     and only there will the filter be applied.
   * @param image        represents the image that the filter will be applied on.
   * @param filterChoice represents the filter to be applied from the FilterChoice enum.
   * @return the new Image with the filter applied where the mask image applies.
   */
  Image greyscaleMask(Image maskImage, Image image,
                      ImageFilterImplementation.FilterChoice filterChoice);

}
