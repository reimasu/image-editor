package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import model.ImageUtil;
import model.model.ImageModel;
import view.GraphicsInterface;
import view.ImageGraphics;

import static model.ImageUtil.saveBufferedImage;


/**
 * The Interactive controller will be used inn the ImageGraphics Class. (This controller
 * will be used for GUI purposes).
 */
public class InteractiveController implements ImageController {

  /**
   * the view takes in the GraphicsInterface, which represents the GUI.
   */

  private GraphicsInterface view;


  /**
   * this represents the commands the user will output.
   */
  private static String[] commands;


  /**
   * this represents the model inteface, that will allow us to call all the image filter functions.
   */
  private ImageModel model;

  /**
   * This hashmap represents the filters that the user will be allowed to use. This will call the
   * respective filter methods from the model class.
   */
  private HashMap<String, Runnable> functions;


  /**
   * Using this constructor, we will be able to initialize the hashmap, and call the respective
   * filter functions. This will be visible in the GUI.
   *
   * @param view  represents the changes in GUI.
   * @param model represents the model class that will filter the images.
   */
  public InteractiveController(GraphicsInterface view, ImageModel model) {
    this.view = view;
    this.model = model;
    commands = new String[100];
    this.functions = new HashMap<>();
    functions.put("load", new Load());
    functions.put("save", new Save());
    functions.put("greyscale-red", new GreyscaleRed());
    functions.put("greyscale-blue", new GreyscaleBlue());
    functions.put("greyscale-green", new GreyscaleGreen());
    functions.put("greyscale-value", new Value());
    functions.put("greyscale-intensity", new Intensity());
    functions.put("greyscale-luma", new Luma());
    functions.put("horizontal", new Horizontal());
    functions.put("vertical", new Vertical());
    functions.put("blur", new Blur());
    functions.put("sharpen", new Sharpen());
    functions.put("sepia", new Sepia());
    functions.put("greyscale", new GreyScale());
    functions.put("brighten", new Brighten());
    functions.put("darken", new Darken());
    functions.put("downscale", new Downscale());

  }


  /**
   * this function allows us to perform the controller. Once this function is called,
   * we are able to change the image as asked by the user.
   */
  @Override
  public void perform() {
    this.view.setCommand(this::accept);
    this.view.makeVisible();
  }


  /**
   * Using this function, we will be able to process what the command is, so we know how to alter
   * the image.
   *
   * @param input represents the command that the user wants to use.
   * @throws IOException when we are unable to run the command.
   */

  private void processCommand(String input) throws IOException {
    Scanner scan = new Scanner(input);
    int counter;
    while (scan.hasNextLine()) {
      counter = 0;
      commands = new String[100];

      Scanner scannedLine = new Scanner(scan.nextLine());

      while (scannedLine.hasNext()) {
        commands[counter] = scannedLine.next();
        counter++;

      }
    }
    if (functions.containsKey(commands[0])) {
      this.functions.get(commands[0]).run();
    } else {
      throw new IOException("unable to run.\n");
    }

  }


  /**
   * This will accept the input. In this input, we will use the keyword from the functions hashmap.
   * Using this accept function, it will be able to call the respective model filter function.
   *
   * @param input represents what input from the hashmap is being used.
   */
  public void accept(String input) {


    try {

      processCommand(input);


    } catch (Exception exception) {

      view.displayErrorMessage(exception.getMessage());

    }


    if (!(commands[0].equals("save"))) {
      view.displayImage(model.getImage(commands[2]).getImage());
      view.addHistogram(model.getImage(commands[2]));
    }


  }


  /**
   * This class implements the Runnable interface. It has one method, run, that calls the loadImage
   * method on the model.
   */
  private class Load implements Runnable {
    public void run() {

      try {

        model.loadImage(commands[1], commands[2]);
      } catch (IOException e) {
        e.getMessage();
      }
    }
  }


  /**
   * This class implements the Runnable interface. It has one method, run, that calls the saveImage
   * method on the model.
   */
  private class Save implements Runnable {
    public void run() {
      try {

        String arr = commands[1].substring(commands[1].length() - 3);
        if (arr.equals("jpg") || arr.equals("png")) {

          saveBufferedImage(model.getPixelImage(), model.getImageWidth(),
                  model.getImageHeight(), commands[1]);
        } else {
          new ImageUtil.Save(commands[1], model.getImageToBeShown()).apply();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }


  /**
   * This uses the builtIn Runnable interface, that will allow us to greyscale by only using the red
   * color of the pixel.
   */
  private class GreyscaleRed implements Runnable {
    public void run() {
      model.greyScaleRed(commands[1], commands[2]);
    }
  }

  /**
   * This uses the builtIn Runnable interface, that will allow
   * us to greyscale by only using the blue color of the pixel.
   */
  private class GreyscaleBlue implements Runnable {

    public void run() {
      model.greyScaleBlue(commands[1], commands[2]);

    }
  }

  /**
   * This uses the builtIn Runnable interface, that will allow us to greyscale by only using the
   * green color of the pixel.
   */

  private class GreyscaleGreen implements Runnable {
    public void run() {
      model.greyScaleGreen(commands[1], commands[2]);

    }
  }

  /**
   * This uses the builtIn Runnable interface, that will allow us to greyscale by only using the
   * Luma function.
   */
  private class Luma implements Runnable {
    public void run() {
      model.luma(commands[1], commands[2]);

    }
  }

  /**
   * This uses the builtIn Runnable interface, that will allow us to greyscale by only using the
   * value function.
   */
  private class Value implements Runnable {
    public void run() {
      model.value(commands[1], commands[2]);

    }
  }

  /**
   * This uses the builtIn Runnable interface, that will allow us to greyscale by only using the
   * intensity function.
   */
  private class Intensity implements Runnable {
    public void run() {
      model.intensity(commands[1], commands[2]);

    }

  }


  /**
   * This uses the builtIn Runnable interface, that will allow us to flip the image vertically.
   */
  private class Vertical implements Runnable {
    public void run() {
      model.flipImageVertical(commands[1], commands[2]);

    }
  }

  /**
   * This uses the builtIn Runnable interface, that will allow us to flip the image horizontally.
   */
  private class Horizontal implements Runnable {
    public void run() {
      model.flipImageHorizontal(commands[1], commands[2]);

    }
  }

  /**
   * This uses the builtIn Runnable interface, that will blur.
   */
  private class Blur implements Runnable {
    public void run() {
      model.blur(commands[1], commands[2]);

    }

  }


  /**
   * This uses the builtIn Runnable interface, that will sharpen.
   */
  private class Sharpen implements Runnable {
    public void run() {
      model.sharpen(commands[1], commands[2]);


    }

  }

  /**
   * This uses the builtIn Runnable interface, that will sepia.
   */
  private class Sepia implements Runnable {
    public void run() {
      model.toSepia(commands[1], commands[2]);

    }

  }


  /**
   * This uses the builtIn Runnable interface, that will greyscale the image.
   */
  private class GreyScale implements Runnable {
    public void run() {
      model.toGreyscale(commands[1], commands[2]);

    }
  }

  /**
   * This uses the builtIn Runnable interface, that will brighten the image.
   */
  private class Brighten implements Runnable {
    public void run() {
      model.brighten(new ImageGraphics().createTextBox(), commands[1], commands[2]);

    }
  }

  /**
   * This uses the builtIn Runnable interface, that will darken the image.
   */
  private class Darken implements Runnable {
    public void run() {
      model.darken(new ImageGraphics().createTextBox(), commands[1], commands[2]);

    }
  }

  /**
   * This uses the builtIn Runnable interface, that will downscale the image by an increment.
   */
  private class Downscale implements Runnable {
    public void run() {
      model.downscale(new ImageGraphics().createTextBoxDouble(), commands[1], commands[2]);

    }
  }
}



