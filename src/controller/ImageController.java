package controller;

import java.io.IOException;

/**
 * interface to represents the functions within the controller.
 */
public interface ImageController {


  /**
   * this function allows us to perform the controller. Once this function is called,
   * we are able to change the image as asked by the user.
   *
   * @throws IOException when the command asked is unable to run.
   */
  void perform() throws IOException;


}
