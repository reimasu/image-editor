package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.image.Image;
import model.pixel.Pixel;

/**
 * Using this util class, we will be able to save a PPM/PNG/ JPG/ BMP file. This will be using
 * the inbuilt-classes like ImageIO.
 */
public class ImageUtil {


  /**
   * This will be saving the BufferedImage. As the TextEdit of a BufferedImage is very different,
   * the inbuilt ImageIO will be saving this image.
   *
   * @param rgb      receive the red, green, and blue component of the image
   * @param width    represents the width of the image.
   * @param height   represents the height of the image.
   * @param filename represents the file name.
   * @throws IOException when it is an invalid file.
   */
  public static void saveBufferedImage(Pixel[][] rgb, int width, int height, String
          filename)
          throws IOException {

    BufferedImage output = new BufferedImage(
            width,
            height,
            BufferedImage.TYPE_INT_RGB);

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = rgb[i][j].getRed();
        int g = rgb[i][j].getGreen();
        int b = rgb[i][j].getBlue();

        //  bit-shifting << as below
        int color = (r << 16) + (g << 8) + b;
        output.setRGB(j, i, color);
      }
    }
    String extension = filename.substring(filename.indexOf(".") + 1);
    ImageIO.write(output, extension, new File(filename));

  }


  /**
   * SaveImage class to save the image.
   */

  public static class Save {
    /**
     * fileName that will be used to save the savedImage using a name.
     */
    String fileName;
    /**
     * this represents the name of the image that will be saved.
     */
    String imageToBeSaved;

    /**
     * represents the image to be saved.
     */
    model.image.Image imageSaved;

    /**
     * constructor that will be used to save the image.
     *
     * @param imageToBeSaved is the image that will be saved
     * @param fileName       is the name of the savedImage.
     */

    public Save(String imageToBeSaved, String fileName, Image imageSaved) {
      this.fileName = fileName;
      this.imageToBeSaved = imageToBeSaved;
      this.imageSaved = imageSaved;
    }

    /**
     * Constructor that will be used to save the image.
     * @param fileName is the name of the savedImage.
     * @param imageSaved image that was saved.
     */
    public Save(String fileName, Image imageSaved) {
      this.fileName = fileName;
      this.imageSaved = imageSaved;

    }


    /**
     * this apply method will create a ppm file with the accurate r, g, b of the pixels.
     *
     * @return the String that represents the contents of the image (pixel information).
     * @throws IOException if the image cannot be saved or invalid input.
     */
    public String apply() throws IOException {
      StringBuilder build = new StringBuilder();
      build.append("P3" + "\n");
      build.append(this.imageSaved.getImageWidth() + "  ");
      build.append(this.imageSaved.getImageHeight() + "\n");
      build.append(this.imageSaved.getMaxValue() + "\n");
      build.append("\n");

      for (int row = 0; row < this.imageSaved.getImageHeight(); row++) {
        for (int column = 0; column < this.imageSaved.getImageWidth(); column++) {
          build.append(this.imageSaved.getImage()[row][column].getRed());
          build.append("\n");
          build.append(this.imageSaved.getImage()[row][column].getGreen());
          build.append("\n");
          build.append(this.imageSaved.getImage()[row][column].getBlue());
          build.append("\n");
        }
      }

      FileOutputStream fileOut = new FileOutputStream(fileName);
      byte[] b = build.toString().getBytes();
      fileOut.write(b);
      fileOut.close();

      return imageToBeSaved;

    }


  }
}