package view;

import java.io.IOException;

import model.model.ImageModel;


/**
 * represents the view of the controller to show what the user will see when they
 * compute commands.
 */
public class ImageView implements IImageView {

  /**
   * this will represent the string that will be displayed to the user.
   */
  private Appendable appObject;

  /**
   * this will represent the image.
   */

  private ImageModel image;


  /**
   * constructor that checks that the appObject is not null so the view can be displayed.
   *
   * @param appObject represents the appendable String that will be displayed ot the user.
   * @throws IllegalArgumentException if the appendable object is null.
   */
  public ImageView(Appendable appObject) throws
          IllegalArgumentException {
    if (appObject == null) {
      throw new IllegalArgumentException("The appendable object cannot be null");
    } else {
      this.appObject = appObject;
    }

  }

  /**
   * constructor that checks that the appObject or the image is not null so the view
   * can be displayed.
   *
   * @param appObject represents the appendable String that will be displayed ot the user.
   * @param image     represents that the image can be found.
   * @throws IllegalArgumentException if the appendable object or image is null.
   */
  public ImageView(ImageModel image, Appendable appObject) throws
          IllegalArgumentException {
    if (appObject == null || image == null) {
      throw new IllegalArgumentException("The model or the appendable object cannot be null");
    } else {
      this.appObject = appObject;
    }

  }

  /**
   * represents the String that will be displayed after a command has taken place. In other words,
   * this will let the user know that the image has been changed.
   *
   * @return the string that will let them know that their command has taken place.
   */

  @Override
  public String toString() {
    StringBuilder answer = new StringBuilder();
    answer.append("Executed: ");
    return answer.toString();

  }


  /**
   * represents the String that shows that the command has taken place. Each message is
   * independent to the filter that the user is using.
   *
   * @param message represents the String that will be added to the appendable object.
   * @throws IOException when the command is invalid.
   */
  public void renderMessage(String message) throws IOException {
    appObject.append(this + message);
  }


}

