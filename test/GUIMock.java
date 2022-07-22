import java.util.function.Consumer;

import view.GraphicsInterface;
import view.ImageGraphics;
import model.image.Image;
import model.pixel.Pixel;

/**
 * represents the mock class to testthe GUI.
 */
public class GUIMock implements GraphicsInterface {

  /**
   * this will be appended to check if the gui controller works.
   */
  StringBuilder log;

  /**
   * this will represent the view class that will be used.
   * In this case, it will the GUI view.
   */

  private ImageGraphics view;


  /**
   * constructor to append the information.
   *
   * @param log is the StringBuilder that will append.
   */
  public GUIMock(StringBuilder log) {
    this.log = log;

  }


  /**
   * using this function, we will be able to make our panels or labels visible.
   */
  @Override
  public void makeVisible() {
    log.append("made visible");
  }

  /**
   * set the command, so we can see what the command is.
   *
   * @param command represents how the user wants to change the image.
   */

  @Override
  public void setCommand(Consumer<String> command) {
    log.append("Command Worked!");
  }


  /**
   * this displays the error message, when the user takes an action that is incorrect.
   *
   * @param errorMessage represents the error message that will be displayed.
   */
  @Override
  public void displayErrorMessage(String errorMessage) {
    log.append("Error: " + errorMessage);
  }


  /**
   * this displays the image on the panel.
   *
   * @param image represents the image that needs to be displayed.
   */
  @Override
  public void displayImage(Pixel[][] image) {
    log.append("image displayed");
  }


  /**
   * Adds the histogram to a panel, that will then be displayed on the main panel.
   * refreshes the histogram as the image changes.
   *
   * @param image represents the image on the GUI.
   */
  @Override
  public void addHistogram(Image image) {
    log.append("histogram");
  }

  @Override
  public int createTextBox() {
    return 0;
  }


}