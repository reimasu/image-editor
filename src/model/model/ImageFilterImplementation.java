package model.model;


import model.image.ImageImplementation;
import model.image.Image;
import model.pixel.Pixel;
import model.pixel.PixelImplementation;


/**
 * using this class, we will create a filter for the image. In other words, using the
 * functions created in this class, we will be able to change the image (for example,
 * brighten, dark, flip, greyscale).
 */
public class ImageFilterImplementation implements ImageFilter {


  /**
   * this enum will be used to calculate brighten, darken, multiple (kernel multiplication
   * for blur and sharpen), and transform
   * This enum allows to reduce code duplication.
   */

  protected enum MathChoice { ADD, MINUS, MULTIPLY, TRANSFORM }


  /**
   * this enum will be used to different greyscales.
   * This enum allows to reduce code duplication.
   */

  protected enum GreyScale { INTENSITY, VALUE, RED, GREEN, BLUE, LUMA }

  /**
   * Represents all possible filter choices for masked images.
   */
  protected enum FilterChoice {
    SEPIA, GREYSCALE, GREYSCALERED, GREYSCALEGREEN, GREYSCALEBLUE,
    LUMA, VALUE, INTENSITY, SHARPEN, BLUR, DARKEN, BRIGHTEN
  }

  /**
   * this will allow us to check that the pixel colors are in the correct range. If the number
   * is greater than 255, then the number returned would be 255 (a color cannot be greater than
   * 255). If the number is less than 0, then the number returned would be 0 (a color cannot be
   * a negative number). If the number is between 0 and 255, then the number is returned as it is.
   *
   * @param number is a color number that will be given
   * @return an int that would represent the color outputted.
   */
  @Override
  public int clamp(int number) {
    if (number > 255) {
      return 255;
    }
    if (number < 0) {
      return 0;
    }
    return number;
  }

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
  @Override
  public double transform(int[] pixel, double[] filter) {
    double newPixel = 0;
    for (int i = 0; i < filter.length; i++) {
      newPixel += pixel[i] * filter[i];
    }
    return newPixel;
  }


  //  FOR KERNEL CALCULATIONS.

  /**
   * this will create a new kernel pixel. As the kernel revolves around the picture, this will
   * grow a pixel that has been changed to fit the filter application. The new pixel is made by
   * multiplying each pixel of the kernel to the filter matrix.
   *
   * @param kernel represents the kernel.
   * @param filter represents the filter that we are multiplying the kernel by.
   * @return a Pixel that represents the rgb components to the filter(using kernel).
   */
  @Override
  public Pixel createNewKernelPixel(Pixel[][] kernel, double[][] filter) {
    int[] newPixel = new int[3];
    for (int i = 0; i < kernel.length; i++) {
      for (int j = 0; j < kernel.length; j++) {
        newPixel[0] += (int) Math.round((kernel[i][j].getRed() * filter[i][j]));
        newPixel[1] += (int) Math.round((kernel[i][j].getGreen() * filter[i][j]));
        newPixel[2] += (int) Math.round((kernel[i][j].getBlue() * filter[i][j]));
      }
    }
    Pixel pixel =
            new PixelImplementation(clamp(newPixel[0]), clamp(newPixel[1]), clamp(newPixel[2]));
    return pixel;
  }


  /**
   * this will allow us to calculate the kernel. As the kernel moves around the picture,
   * it will be moved around, so we need to calculate the boundary of the image. This will create a
   * new 2d array of pixels that represent the kernel
   * (this will be calculated according to the size of the image).
   * As the size changes, the kernel can also change as the boundaries will alter.
   *
   * @param row    represents the row of the image.
   * @param column represents the col of the image.
   * @param image  represents the new 2d Pixel array we are aiming to make, with RGB component.
   * @param size   represents the size of the kernel.
   * @return a 2d pixel array that would represent the kernel.
   */
  @Override
  public Pixel[][] getKernel(int row, int column, Pixel[][] image, int size) {
    Pixel[][] kernel = new Pixel[size][size];
    int bounds = (int) Math.floor(size / 2.0);
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        try {
          kernel[i][j] =
                  new PixelImplementation((image[i + (row - bounds)]
                          [j + (column - bounds)].getRed()),
                          (image[i + (row - bounds)][j + (column - bounds)].getGreen()),
                          (image[i + (row - bounds)][j + (column - bounds)].getBlue()));

        } catch (IndexOutOfBoundsException e) {
          kernel[i][j] = new PixelImplementation(0, 0, 0);
        }
      }
    }
    return kernel;
  }

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

  @Override
  public Pixel createNewPixel(int row, int col, Image image,
                              double[] filter, MathChoice choice) {
    int r = 0;
    int g = 0;
    int b = 0;

    //creates a pixel array with the r, g, b.
    int[] pixelArray = image.pixel(row, col);
    //for brighten
    if (choice == MathChoice.ADD) {
      r = clamp((int) (filter[0] + pixelArray[0]));
      g = clamp((int) (filter[1] + pixelArray[1]));
      b = clamp((int) (filter[2] + pixelArray[2]));
    } else if (choice == MathChoice.MINUS) {
      r = clamp((int) (pixelArray[0] - filter[0]));
      g = clamp((int) (pixelArray[1] - filter[1]));
      b = clamp((int) (pixelArray[2] - filter[2]));
    }

    //creates a new Pixel.
    Pixel newPixel = new PixelImplementation(r, g, b);

    return newPixel;
  }

  /**
   * this will apply the filter to each pixel of the image so that the image can be
   * completely changed(only for brighten or darken).
   *
   * @param image  represents the image that will be used.
   * @param filter represents the filter that will be used to change the image.
   * @param choice represents whether the image is being darkened or brightened.
   * @return the new Image with the filter applied.
   */
  @Override
  public Image applyFilter(Image image, double[][] filter, MathChoice choice) {
    double[] coefficients = {filter[0][0], filter[0][0], filter[0][0]};

    int width = image.getImageWidth();
    int height = image.getImageHeight();
    Pixel[][] newImage = new Pixel[height][width];
    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        switch (choice) {
          //brightens
          case ADD:
            newImage[row][column] =
                    createNewPixel(row, column, image, coefficients, MathChoice.ADD);
            break;
          //darkens
          case MINUS:
            newImage[row][column] = createNewPixel(row, column,
                    image, coefficients, MathChoice.MINUS);
            break;
          //blur and sharpen(uses kernel helper methods)
          case MULTIPLY:
            newImage[row][column] = createNewKernelPixel(getKernel(row, column, image.getImage(),
                    filter.length), filter);
            break;
          //sepia and greyscale (uses transform helper method)
          case TRANSFORM:
            int[] pixelArray = image.pixel(row, column);
            newImage[row][column] =
                    new PixelImplementation((clamp((int)
                            Math.round(transform(pixelArray, filter[0])))),
                            (clamp((int) Math.round(transform(pixelArray, filter[1])))),
                            (clamp((int) Math.round(transform(pixelArray, filter[2])))));
            break;
          default:
            throw new IllegalStateException("No other filter.");
        }

      }
    }
    return new ImageImplementation(newImage);
  }


  /**
   * using this method, we will be able to change the image using a specific filter. This will be
   * used to change every image to greyScale.
   *
   * @param image     represents the image that will be changed.
   * @param greyScale uses the enum GreyScale to check which greyscale needs to be used.
   * @return the filtered image depending on what the user has asked.
   */
  @Override
  public Image greyScale(Image image, GreyScale greyScale) {
    int width = image.getImageWidth();
    int height = image.getImageHeight();
    int color = 0;
    Pixel[][] newImage = image.getImage();
    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        switch (greyScale) {
          case RED:
            color = newImage[row][column].getRed();
            break;
          case INTENSITY:
            color = (newImage[row][column].getRed()
                    + newImage[row][column].getGreen()
                    + newImage[row][column].getBlue()) / 3;
            break;
          case VALUE:
            int max1 = Math.max(newImage[row][column].getRed(), newImage[row][column].getGreen());
            color = Math.max(max1, newImage[row][column].getBlue());
            break;
          case BLUE:
            color = newImage[row][column].getBlue();
            break;
          case GREEN:
            color = newImage[row][column].getGreen();
            break;
          case LUMA:
            color = (int) ((0.2126 * newImage[row][column].getRed())
                    + (0.7152 * newImage[row][column].getGreen())
                    + (0.0722 * newImage[row][column].getBlue()));
            break;
          default:
            color = newImage[row][column].getRed();
            break;
        }
        newImage[row][column] = new PixelImplementation(color, color, color);

      }
    }
    return new ImageImplementation(newImage);
  }


  /**
   * using this function, we wll be able to change the position of every pixel so they can be
   * flipped horizontally.
   *
   * @param image represents the image that will be changed.
   * @return the image that has been flipped horizontally.
   */
  @Override
  public Image flipHorizontal(Image image) {

    Pixel[][] pixels = image.getImage();
    Image imageFinal = new ImageImplementation(pixels);
    for (int row = 0; row < image.getImageHeight() / 2; row++) {
      for (int col = 0; col < image.getImageWidth(); col++) {

        Pixel temp = image.getImage()[image.getImageHeight() - (row + 1)][col];
        pixels[image.getImageHeight() - (row + 1)][col] = pixels[row][col];
        pixels[row][col] = temp;
      }
    }
    return imageFinal;
  }


  /**
   * using this function, we wll be able to change the position of every pixel so they can be
   * flipped vertically.
   *
   * @param image represents the image that will be changed.
   * @return the image that has been flipped vertically.
   */

  @Override
  public Image flipVertical(Image image) {

    Pixel[][] pixels = image.getImage();
    Image imageFinal = new ImageImplementation(pixels);
    for (int row = 0; row < image.getImageHeight(); row++) {
      for (int col = 0; col < image.getImageWidth() / 2; col++) {

        Pixel temp1 = image.getImage()[row][image.getImageWidth() - col - 1];
        pixels[row][image.getImageWidth() - col - 1] = pixels[row][col];
        pixels[row][col] = temp1;
      }
    }
    return imageFinal;
  }

  /**
   * This method allows us to calculate the RGB component of a pixel in the mapped location,
   * after being changed by the increment size.
   *
   * @param image     represents the image we are retrieving the pixels from.
   * @param row       represents the row position of a pixel.
   * @param column    represents the column position of a pixel.
   * @param increment the amount by which the image will be downscaled.
   * @return a Pixel with new RGB components which would used in the downscaled image.
   */
  private Pixel calcRGB(Image image, int row, int column, double increment) {
    Pixel[][] pixels = image.getImage();
    int height = image.getImageHeight();
    int width = image.getImageWidth();
    double newRow = (row / (height * increment)) * (height - 1);
    double newCol = (column / (width * increment)) * (width - 1);

    int newRowInt = (int) newRow;
    int newColInt = (int) newCol;

    int mRed = (pixels[newRowInt][newColInt].getRed());
    int cRed = clamp((mRed));

    int mGreen = (pixels[newRowInt][newColInt].getGreen());
    int cGreen = clamp((mGreen));

    int mBlue = (pixels[newRowInt][newColInt].getBlue());
    int cBlue = clamp((mBlue));

    return new PixelImplementation(cRed, cGreen, cBlue);
  }

  /**
   * Using this function we can find downscale an Image by a given increment, by resizing the
   * image and getting its mapped RGB pixel value using a helper function called calcRGB.
   *
   * @param image     represents the image that will be changed.
   * @param increment the amount by which it will be downscaled.
   * @return the image that has been downsized to scale.
   */
  @Override
  public Image downscaleImage(Image image, double increment) {
    int newWidth = (int) Math.round(image.getImageWidth() * increment);
    int newHeight = (int) Math.round(image.getImageHeight() * increment);
    Pixel[][] newImage = new Pixel[newHeight][newWidth];
    for (int row = 0; row < newHeight; row++) {
      for (int column = 0; column < newWidth; column++) {
        newImage[row][column] = calcRGB(image, row, column, increment);
      }
    }
    return new ImageImplementation(newImage);
  }

  /**
   * Is the given row, col pixel in the mask image black?.
   *
   * @param maskImage the mask image we will be using to find the black pixels from.
   * @param row       represents the row position of a pixel.
   * @param col       represents the column position of a pixel.
   * @return a boolean whether or not the pixel is black. (true if black)
   */
  private boolean isBlack(Image maskImage, int row, int col) {
    Pixel[][] pixels = maskImage.getImage();
    return (pixels[row][col].getRed() == 0
            && pixels[row][col].getGreen() == 0
            && pixels[row][col].getBlue() == 0);
  }

  /**
   * this will apply the filter to each pixel of the image so that the image can be
   * completely changed(only for brighten or darken).
   *
   * @param image        represents the image that the filter will be applied on.
   * @param maskImage    represents the mask image which will be used to get the black pixels
   *                     and only there will the filter be applied.
   * @param filter       represents the filter that will be used to changed the image.
   * @param filterChoice represents the filter to be applied from the FilterChoice enum.
   * @return the new Image with the filter applied where the mask image applies.
   */
  @Override
  public Image applyFilterMask(Image image, Image maskImage, double[][] filter,
                               FilterChoice filterChoice) {
    double[] coefficients = {filter[0][0], filter[0][0], filter[0][0]};
    int width = image.getImageWidth();
    int height = image.getImageHeight();
    Pixel[][] newImage = new Pixel[height][width];
    for (int row = 0; row < image.getImageHeight(); row++) {
      for (int col = 0; col < image.getImageWidth(); col++) {
        if (isBlack(maskImage, row, col)) {
          int[] pixelArray = image.pixel(row, col);
          switch (filterChoice) {
            case SEPIA:
            case GREYSCALE:
              newImage[row][col] = new PixelImplementation((clamp((int)
                      Math.round(transform(pixelArray, filter[0])))),
                      (clamp((int) Math.round(transform(pixelArray, filter[1])))),
                      (clamp((int) Math.round(transform(pixelArray, filter[2])))));
              break;
            case SHARPEN:
            case BLUR:
              newImage[row][col] = createNewKernelPixel(getKernel(row, col, image.getImage(),
                      filter.length), filter);
              break;
            case DARKEN:
              newImage[row][col] = createNewPixel(row, col, image, coefficients, MathChoice.MINUS);
              break;
            case BRIGHTEN:
              newImage[row][col] = createNewPixel(row, col, image, coefficients, MathChoice.ADD);
              break;
            default:
              throw new IllegalStateException("No other filter.");
          }
        } else {
          newImage[row][col] = new PixelImplementation(image.getImage()[row][col].getRed(),
                  image.getImage()[row][col].getGreen(),
                  image.getImage()[row][col].getBlue());
        }
      }
    }
    return new ImageImplementation(newImage);
  }

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
  @Override
  public Image greyscaleMask(Image image, Image maskImage, FilterChoice filterChoice) {
    int color = 0;
    int width = image.getImageWidth();
    int height = image.getImageHeight();
    Pixel[][] newImage = new Pixel[height][width];
    Pixel[][] orgImage = image.getImage();
    for (int row = 0; row < image.getImageHeight(); row++) {
      for (int col = 0; col < image.getImageWidth(); col++) {
        if (isBlack(maskImage, row, col)) {
          switch (filterChoice) {
            case GREYSCALERED:
              color = image.getImage()[row][col].getRed();
              break;
            case INTENSITY:
              color = (image.getImage()[row][col].getRed()
                      + image.getImage()[row][col].getGreen()
                      + image.getImage()[row][col].getBlue()) / 3;
              break;
            case VALUE:
              int max1 = Math.max(orgImage[row][col].getRed(), orgImage[row][col].getGreen());
              color = Math.max(max1, orgImage[row][col].getBlue());

              break;
            case GREYSCALEBLUE:
              color = orgImage[row][col].getBlue();

              break;
            case GREYSCALEGREEN:
              color = orgImage[row][col].getGreen();

              break;
            case LUMA:
              color = (int) ((0.2126 * orgImage[row][col].getRed())
                      + (0.7152 * orgImage[row][col].getGreen())
                      + (0.0722 * orgImage[row][col].getBlue()));

              break;
            default:
              throw new IllegalStateException("No other filter.");
          }
          newImage[row][col] = new PixelImplementation(color, color, color);
        } else {
          newImage[row][col] = new PixelImplementation(orgImage[row][col].getRed(),
                  orgImage[row][col].getGreen(),
                  orgImage[row][col].getBlue());
        }
      }
    }
    return new ImageImplementation(newImage);
  }

}





















