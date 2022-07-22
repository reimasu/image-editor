import java.io.IOException;

import model.image.Image;
import model.model.ImageModel;
import model.pixel.Pixel;


/**
 * Mock class to test the controller.
 */
public class MockClass implements ImageModel {

  private final StringBuilder log;

  private Image image;


  /**
   * constructor to append the information.
   *
   * @param log is the StringBuilder that will append.
   */
  public MockClass(StringBuilder log) {
    this.log = log;

  }

  /**
   * return red.
   *
   * @param row represents the row of the pixel we need.
   * @param col represents the col of the pixel we need.
   * @return 0 (not needed for mock class).
   */
  @Override
  public int getRed(int row, int col) {
    return 0;
  }

  /**
   * return blue.
   *
   * @param row represents the row of the pixel we need.
   * @param col represents the col of the pixel we need.
   * @return 0 (not needed for mock class).
   */
  @Override
  public int getBlue(int row, int col) {
    return 0;
  }

  /**
   * return green.
   *
   * @param row represents the row of the pixel we need.
   * @param col represents the col of the pixel we need.
   * @return 0 (not needed for mock class).
   */
  @Override
  public int getGreen(int row, int col) {
    return 0;
  }


  /**
   * sets the image in the map.
   *
   * @param name  represents the name of the image being placed in the map.
   * @param image represents the image that is being placed in the map.
   */
  @Override
  public void setImage(String name, Image image) {
    log.append("Successfully Completed the command \n ");
  }

  /**
   * gets the image from the map using the name.
   *
   * @param name represents the name of what the image is stored with.
   * @return the image with the given name.
   */
  @Override
  public Image getImage(String name) {
    return image;
  }

  /**
   * loads image. given message for mock to test controller.
   *
   * @param imagePath represents where the image is being collected from.
   * @param imageName represents the name that the loaded image will now be called.
   */
  @Override
  public void loadImage(String imagePath, String imageName) {
    log.append("Successfully Completed the command \n");

  }


  /**
   * save image.  given message for mock to test controller.
   *
   * @param imagePath represents where the image is being collected from.
   * @param imageName represents the name that the saved image will now be called.
   * @throws IOException when unable to save.
   */
  @Override
  public void saveImage(String imagePath, String imageName) throws IOException {
    log.append("Successfully Completed the command \n");
  }


  /**
   * intensity of image. given message for mock to test controller.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void intensity(String imageName, String destImageName) {
    log.append("Successfully Completed the command \n");
  }


  /**
   * value of image. given message for mock to test controller.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void value(String imageName, String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * greyscale-red for image. given message for mock to test controller.
   *
   * @param imageName       represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void greyScaleRed(String imageName, String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * greyscale-green for image. given message for mock to test controller.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void greyScaleGreen(String imageName, String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * greyscale-blue for image. given message for mock to test controller.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void greyScaleBlue(String imageName, String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * greyscale-luma for image. given message for mock to test controller.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void luma(String imageName, String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * brighten image. given message for mock to test controller.
   *
   * @param brightenIncrement brightens by given amount.
   * @param imageName         represents the name of the image being changed.
   * @param destImageName     represents the name of the new filteredImage.
   */
  @Override
  public void brighten(int brightenIncrement, String imageName, String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * darken image. given message for mock to test controller.
   *
   * @param darkenIncrement darken by given amount.
   * @param imageName       represents the name of the image being changed.
   * @param destImageName   represents the name of the new filteredImage.
   */
  @Override
  public void darken(int darkenIncrement, String imageName, String destImageName) {
    log.append("Successfully Completed the command \n");
  }


  /**
   * flips image horizontal . given message for mock to test controller.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void flipImageHorizontal(String imageName, String destImageName) {
    log.append("Successfully Completed the command \n");
  }


  /**
   * flips image vertical. given message for mock to test controller.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void flipImageVertical(String imageName, String destImageName) {
    log.append("Successfully Completed the command \n");
  }


  /**
   * blurs image. given message for mock to test controller.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  @Override
  public void blur(String imageName, String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * sharpens image. given message for mock to test controller.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */

  @Override
  public void sharpen(String imageName, String destImageName) {
    log.append("Successfully Completed the command \n");
  }


  /**
   * transforms image to greyscale. given message for mock to test controller.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void toGreyscale(String imageName, String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * transforms image to sepia. given message for mock to test controller.
   *
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void toSepia(String imageName, String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * gets the pixel 2D array of an image's pixels by iterating through all the row and columns and
   * getting their RGB values.
   *
   * @return a Pixel 2D array
   */
  @Override
  public Pixel[][] getPixelImage() {
    return new Pixel[0][];
  }

  /**
   * Gets the integer value for image's width (how many pixels wide the image is).
   *
   * @return the integer value width of this image.
   */
  @Override
  public int getImageWidth() {
    return 0;
  }

  /**
   * Gets the integer value for image's height (how many pixels height the image is).
   *
   * @return the integer value width of this image.
   */
  @Override
  public int getImageHeight() {
    return 0;
  }

  /**
   * Retrieves the image which is to be shown.
   *
   * @return the image.
   */
  @Override
  public Image getImageToBeShown() {
    return null;
  }

  /**
   * Downscaled image. Given message for mock to test controller.
   *
   * @param increment     the amount by which the image will be downscaled.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void downscale(double increment, String imageName, String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * Applies sepia to mask area. Given message for mock to test controller.
   *
   * @param imageName     represents the name of the image being changed.
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void sepiaMask(String imageName, String maskImage, String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * Applies greyscale to mask area. Given message for mock to test controller.
   *
   * @param imageName     represents the name of the image being changed.
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void greyscaleMask(String imageName, String maskImage, String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * Applies sharpen to mask area. Given message for mock to test controller.
   *
   * @param imageName     represents the name of the image being changed.
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void sharpenMask(String imageName, String maskImage, String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * Applies blur to mask area. Given message for mock to test controller.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void blurMask(String imageName, String maskImage, String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * Applies greyscale-luma to mask area. Given message for mock to test controller.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void lumaMask(String imageName, String maskImage, String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * Applies greyscale-intensity to mask area. Given message for mock to test controller.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      *             will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void intensityMask(String imageName, String maskImage, String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * Applies greyscale-value to mask area. Given message for mock to test controller.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void valueMask(String imageName, String maskImage, String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * Applies greyscale-red to mask area. Given message for mock to test controller.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void greyscaleRedMask(String imageName, String maskImage, String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * Applies greyscale-green to mask area. Given message for mock to test controller.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void greyscaleGreenMask(String imageName, String maskImage, String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * Applies greyscale-blue to mask area. Given message for mock to test controller.
   *
   * @param maskImage     represents the mask image which the black pixel location
   *                      will be calculated from.
   * @param imageName     represents the name of the image being changed.
   * @param destImageName represents the name of the new filteredImage.
   */
  @Override
  public void greyscaleBlueMask(String imageName, String maskImage, String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * Brightens image in mask area. Given message for mock to test controller.
   *
   * @param brightenIncrement the amount by which the image will be brightened.
   * @param maskImage         represents the mask image which the black pixel location
   *                          will be calculated from.
   * @param imageName         represents the name of the image being changed.
   * @param destImageName     represents the name of the new filteredImage.
   */
  @Override
  public void brightenMask(int brightenIncrement, String imageName, String maskImage,
                           String destImageName) {
    log.append("Successfully Completed the command \n");
  }

  /**
   * Darkens image in mask area. Given message for mock to test controller.
   *
   * @param darkenIncrement the amount by which the image will be darkened.
   * @param maskImage       represents the mask image which the black pixel location
   *                        *             will be calculated from.
   * @param imageName       represents the name of the image being changed.
   * @param destImageName   represents the name of the new filteredImage.
   */
  @Override
  public void darkenMask(int darkenIncrement, String imageName, String maskImage,
                         String destImageName) {
    log.append("Successfully Completed the command \n");
  }
}
