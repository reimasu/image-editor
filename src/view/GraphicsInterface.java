package view;

import java.util.function.Consumer;

import model.image.Image;
import model.pixel.Pixel;


/**
 * the interface will represent the GUI class, that will show the GUI to the users.
 */
public interface GraphicsInterface {


  /**
   * using this function, we will be able to make our panels or labels visible.
   */
  void makeVisible();


  /**
   * set the command, so we can see what the command is.
   *
   * @param command represents how the user wants to change the image.
   */


  void setCommand(Consumer<String> command);


  /**
   * this displays the error message, when the user takes an action that is incorrect.
   *
   * @param errorMessage represents the error message that will be displayed.
   */

  void displayErrorMessage(String errorMessage);


  /**
   * this displays the image on the panel.
   *
   * @param image represents the image that needs to be displayed.
   */
  void displayImage(Pixel[][] image);

  /**
   * Adds the histogram to a panel, that will then be displayed on the main panel.
   * refreshes the histogram as the image changes.
   *
   * @param image represents the image on the GUI.
   */

  void addHistogram(Image image);

  /**
   * this will create a text box, so the user can enter a number and can choose by how much
   * they want to change the image.
   *
   * @return an int to represent how much the user will change the photo by.
   */
  int createTextBox();
}
