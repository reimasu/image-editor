package model.pixel;



/**
 * represents the context of the pixel.
 */
public class PixelImplementation  implements Pixel {

  /**
   * represents the red component of the pixel.
   */

  private int red;
  /**
   * represents the blue component of the pixel.
   */
  private int blue;

  /**
   * represents the green component of the pixel.
   */
  private int green;


  /**
   * creates the pixel with red, green, and blue component.
   *
   * @param red   represents the red component of the pixel.
   * @param green represents the green component of the pixel.
   * @param blue  represents the blue component of the pixel.
   */

  public PixelImplementation(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * represents the red component of the pixel.
   *
   * @return the int that represents the red of the pixel.
   */
  public int getRed() {
    return red;
  }

  /**
   * represents the green component of the pixel.
   *
   * @return the int that represents the green of the pixel.
   */
  public int getGreen() {
    return green;
  }

  /**
   * represents the blue component of the pixel.
   *
   * @return the int that represents the blue of the pixel.
   */
  public int getBlue() {
    return blue;
  }











}
