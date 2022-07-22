package model.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import model.pixel.Pixel;
import model.pixel.PixelImplementation;


/**
 * using this class, we are able to represent an image(clarifies the pixels and its
 * r, g, b components).
 */
public class ImageImplementation  implements Image {



  /**
   * represents the pixels that are used to create image.
   */
  private Pixel[][] pixels;

  /**
   * represents the width of the image.
   */
  private int width;

  /**
   * represents the height of the image.
   */
  private int height;


  /**
   * represents the max color value of the image.
   */

  private int maxValue;





  /**
   * this constructors uses the extension of the fileName to decide what type of image is
   * being loaded. If it is a PPM, it has a very specific format. For a PNG, JPG, or BMP,
   * we use the functions that use BufferedImage to load the image.
   * @param filename represents the name of the file that will be loaded.
   * @throws IOException when it is an invalid file.
   */

  public ImageImplementation(String filename) throws IOException {
    String[] arr = filename.split("\\.");
    String[]arrayFileName = {"png", "jpg", "bmp"};

    if (arr[1].equals("ppm")) {
      Scanner sc;

      try {
        sc = new Scanner(new FileInputStream(filename));
      } catch (FileNotFoundException e) {
        System.out.println("File " + filename + " not found!");
        return;
      }
      StringBuilder builder = new StringBuilder();
      //read the file line by line, and populate a string. This will throw away any comment lines
      while (sc.hasNextLine()) {
        String s = sc.nextLine();
        if (s.charAt(0) != '#') {
          builder.append(s + System.lineSeparator());
        }
      }

      //now set up the scanner to read from the string we just built
      sc = new Scanner(builder.toString());

      String token;

      token = sc.next();
      if (!token.equals("P3")) {
        System.out.println("Invalid PPM file: plain RAW file should begin with P3");
      }
      this.width = sc.nextInt();
      System.out.println("Width of image: " + width);
      this.height = sc.nextInt();
      System.out.println("Height of image: " + height);
      this.maxValue = sc.nextInt();
      System.out.println("Maximum value of a color in this file (usually 255): " + maxValue);

      //creates the pixel of the image
      pixels = new Pixel[height][width];
      StringBuilder string = new StringBuilder();
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          int r = sc.nextInt();
          int g = sc.nextInt();
          int b = sc.nextInt();
          string.append(r + "\n" + g + "\n" + b);
          Pixel px = new PixelImplementation(r, g, b);
          //returns all the pixel in order
          pixels[i][j] = px;

        }
      }
    }

    //for BufferedImage
    else {
      for (String fileName : arrayFileName) {
        if (arr[1].equals(fileName) ) {
          try {
            this.pixels = loadBufferedImage(filename);
            this.width = getWidth(filename);
            this.height = getHeight(filename);
            this.maxValue = 255;
            System.out.println("Width of image: " + width);
            System.out.println("Height of image: " + height);
            System.out.println("Maximum value of a color in this file (usually 255): " + maxValue);

          } catch (IOException e) {
            throw new IOException("Error: could not load image from file");
          }
        }

      }
    }


  }


  /**
   * gets the width of the BufferedImage.
   * @param filename represents the name of the file.
   * @return the width of the bufferedImage.
   * @throws IOException when it is an invalid file.
   */
  public  int getWidth(String filename) throws IOException {
    BufferedImage input;

    input = ImageIO.read(new FileInputStream(filename));

    return input.getWidth();
  }


  /**
   * gets the height of the BufferedImage.
   * @param filename represents the name of the file.
   * @return the height of the bufferedImage.
   * @throws IOException when it is an invalid file.
   */
  private int getHeight(String filename) throws IOException {
    BufferedImage input;

    input = ImageIO.read(new FileInputStream(filename));

    return input.getHeight();
  }


  /**
   * this method will be able to load a buffered image, by creating a pixel for every r, g, b
   * component.
   * @param filename represents the name of the file.
   * @return a 2D pixel array, representing each pixel of the image with a rgb component.
   * @throws IOException when it is an invalid file.
   */

  public Pixel[][] loadBufferedImage(String filename) throws IOException {
    FileInputStream file = new FileInputStream(filename);
    BufferedImage input = ImageIO.read(file);

    Pixel[][] result = new Pixel[input.getHeight()][input.getWidth()];

    for (int i = 0; i < input.getHeight(); i++) {
      for (int j = 0; j < input.getWidth(); j++) {
        int color = input.getRGB(j, i);
        Color c = new Color(color);
        result[i][j] = new PixelImplementation(c.getRed(), c.getGreen(), c.getBlue() );

      }
    }

    return result;
  }

  /**
   * Displays the buffered image.
   * @param rgb the RGB components of the image.
   * @return the buffered image.
   * @throws IOException when transmissions fails.
   */
  public static BufferedImage showBufferedImage(Pixel[][] rgb) throws IOException {
    BufferedImage output = new BufferedImage(rgb[0].length, rgb.length, BufferedImage.TYPE_INT_RGB);
    for (int i = 0; i < rgb.length; i++) {
      for (int j = 0; j < rgb[0].length; j++) {
        int r = rgb[i][j].getRed();
        int g = rgb[i][j].getGreen();
        int b = rgb[i][j].getBlue();
        int color = (r << 16) + (g << 8) + b;
        output.setRGB(j, i, color);
      }
    }
    return output;
  }


  /**
   * this constructor will record the length, width, and maxValue of the image.
   *
   * @param image    represents an image that is made out of the 2d array of pixels.
   * @param maxValue represents the highest color of an image (compares the pixels).
   */
  public ImageImplementation(Pixel[][] image, int maxValue) {
    this.pixels = image;
    this.width = image[0].length;
    this.height = image.length;
    this.maxValue = maxValue;

  }


  /**
   * this constructor will take in an image, and initialize the maxValue as 255. This uses the
   * previous constructor to initialize its width, maxValue, and height.
   *
   * @param image represents an image that is made out of the 2d array of pixels.
   */
  public ImageImplementation(Pixel[][] image) {
    this(image, 255);

  }



  /**
   * using this method, we are able to retrieve the pixel components of an Image.
   *
   * @return the 2d pixel array that create an image.
   */
  public Pixel[][] getImage() {
    return this.pixels;
  }


  /**
   * represents the width of the image(PIXEL 2d).
   *
   * @return the int width of the image.
   */
  public int getImageWidth() {
    return this.width;
  }

  /**
   * represents the maxValue of the image (the highest color component (r, g, or b)) in the image.
   * (PIXEL 2d).
   *
   * @return the int maxValue of the image.
   */
  public int getMaxValue() {
    return this.maxValue;
  }


  /**
   * represents the height of the image (PIXEL 2d).
   *
   * @return the int height of the image.
   */

  public int getImageHeight() {
    return this.height;
  }


  /**
   * using this method, we will be able to get the red, green, or blue components of a
   * pixel in the specific row and col.
   *
   * @param row represents the row of the given image.
   * @param col represents the col of the given image.
   * @return the 1d array that represents the red, green, and blue component of the given pixel.
   */
  public int[] pixel(int row, int col) {
    int[] pixel = new int[3];
    pixel[0] = pixels[row][col].getRed();
    pixel[1] = pixels[row][col].getGreen();
    pixel[2] = pixels[row][col].getBlue();
    return pixel;
  }
}
