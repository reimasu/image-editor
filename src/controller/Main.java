package controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import model.model.ImageModel;
import model.model.ImageModelImplementation;
import view.ImageGraphics;
import view.ImageView;

/**
 * This class allows the user to access the console and change the images.
 */
public class Main {

  /**
   * main function that will allow the user to run the program.
   *
   * @param args that the user will input.
   * @throws IOException if the function and commands put are invalid.
   */
  public static void main(String[] args) throws IOException {


    if (args.length == 0) {
      ImageModel model = new ImageModelImplementation();
      ImageGraphics view = new ImageGraphics();
      InteractiveController controller = new InteractiveController(view, model);
      controller.perform();
    } else {
      if (args[0].equals("-file")) {
        Reader input = new FileReader(args[1]);
        ImageModelImplementation model = new ImageModelImplementation();
        Appendable app = System.out;
        ImageView view = new ImageView(app);
        ImageController controller = new ImageControllerImpl(input, view, model);
        controller.perform();
      } else if (args[0].equals("-text")) {
        Readable readable = new InputStreamReader(System.in);
        Appendable app = System.out;
        ImageModelImplementation model = new ImageModelImplementation();
        ImageView view = new ImageView(app);
        ImageControllerImpl controller = new ImageControllerImpl(readable, view, model);
        controller.perform();
      }
    }
  }
}
