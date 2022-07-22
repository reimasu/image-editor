package view;


import java.io.IOException;


/**
 * interface that will represent the view.
 */
public interface IImageView {

  /**
   * represents the String that will be displayed after a command has taken place. In other words,
   * this will let the user know that the image has been changed.
   *
   * @return the string that will let them know that their command has taken place.
   */

  String toString();

  /**
   * represents the String that shows that the command has taken place. Each message is
   * independent to the filter that the user is using.
   *
   * @param message represents the String that will be added to the appendable object.
   * @throws IOException when the command is invalid.
   */
  void renderMessage(String message) throws IOException;


}
