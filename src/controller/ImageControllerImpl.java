package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.image.Image;
import model.model.ImageModel;
import view.IImageView;


/**
 * represents the ImageController implementation that would allow the user to write their commands,
 * so the specific functions can be used.
 */

public class ImageControllerImpl implements ImageController {

  /**
   * this readable input will be used to understand what the user inputs.
   */
  private final Readable input;

  /**
   * the command will represent all the commands that the user will input.
   */
  private String[] commands;


  /**
   * represents the model that will be used. This model consists of all the functions that can be
   * used to change the image.
   */
  private ImageModel model;

  /**
   * represents the image.
   */
  private Image image;

  /**
   * this includes all the functions that can be used by the user. These functions are tied to
   * a function that changes the image as asked by the user.
   */
  private Map<String, Runnable> functions;

  /**
   * this will represent the view, that will let the user know if their command was performed.
   */
  private IImageView view;

  /**
   * constructs the Image Controller so we can call the controller.
   *
   * @param input represents what the user will input.
   * @param view  represents what the user will view.
   * @param model is able to call the image, and call all the different functions.
   */
  public ImageControllerImpl(Readable input, IImageView view, ImageModel model) {
    this.input = input;
    this.model = model;
    this.view = view;
    this.commands = new String[100];
    this.functions = new HashMap<>();
    functions.put("load", new Load());
    functions.put("brighten", new Brighten());
    functions.put("darken", new Darken());
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
    functions.put("downscale", new Downscale());

  }

  /**
   * this function allows us to perform the controller. Once this function is called,
   * we are able to change the image as asked by the user.
   *
   * @throws IOException when the command asked is unable to run.
   */
  public void perform() throws IOException {
    int counter;
    Scanner scan = new Scanner(input);
    while (scan.hasNextLine()) {
      counter = 0;
      this.commands = new String[100];

      Scanner scannedCommand = new Scanner(scan.nextLine());

      while (scannedCommand.hasNext()) {
        this.commands[counter] = scannedCommand.next();
        counter++;
      }
      if (functions.containsKey(this.commands[0])) {
        this.functions.get(this.commands[0]).run();
      } else {
        try {
          view.renderMessage("unable to run. \n");
        } catch (IOException e) {
          throw new IOException("unable to run.\n");
        }
      }
    }
  }


  /**
   * This uses the builtIn Runnable interface, that will allow us to load the image.
   */

  private class Load implements Runnable {
    public void run() {
      try {

        model.loadImage(commands[1], commands[2]);


      } catch (IOException e) {
        throw new IllegalArgumentException("the image could not be loaded. ");
      }
      messageDisplayed("image loaded ");
    }
  }

  /**
   * This uses the builtIn Runnable interface, that will allow us to save the image.
   */
  private class Save implements Runnable {
    public void run() {


      try {
        model.saveImage(commands[1], commands[2]);
      } catch (IOException e) {
        throw new IllegalArgumentException("the image could not be saved. ");
      }
      messageDisplayed("image saved \n");
    }
  }

  /**
   * This uses the builtIn Runnable interface, that will allow us to brighten the image by a given
   * number.
   */
  private class Brighten implements Runnable {
    public void run() {
      if (commands[4] != null) {
        try {
          model.brightenMask(Integer.parseInt(commands[1]), commands[2], commands[3], commands[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
          wrongDimensionMask();
        }
      } else {
        model.brighten(Integer.parseInt(commands[1]), commands[2], commands[3]);
      }
      messageDisplayed("brightened image ");
    }
  }

  /**
   * This uses the builtIn Runnable interface, that will allow us to darken the image by a given
   * number.
   */
  private class Darken implements Runnable {
    public void run() {
      if (commands[4] != null) {
        try {
          model.darkenMask(Integer.parseInt(commands[1]), commands[2], commands[3], commands[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
          wrongDimensionMask();
        }
      } else {
        model.darken(Integer.parseInt(commands[1]), commands[2], commands[3]);
      }
      messageDisplayed("darkened image ");
    }
  }

  /**
   * This uses the builtIn Runnable interface, that will allow us to greyscale by only using the red
   * color of the pixel.
   */
  private class GreyscaleRed implements Runnable {
    public void run() {
      if (commands[3] != null) {
        try {
          model.greyscaleRedMask(commands[1], commands[2], commands[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
          wrongDimensionMask();
        }
      } else {
        model.greyScaleRed(commands[1], commands[2]);
      }
      messageDisplayed("greyscale-red image ");
    }
  }

  /**
   * This uses the builtIn Runnable interface, that will allow us to greyscale by only using the
   * green color of the pixel.
   */

  private class GreyscaleGreen implements Runnable {
    public void run() {
      if (commands[3] != null) {
        try {
          model.greyscaleGreenMask(commands[1], commands[2], commands[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
          wrongDimensionMask();
        }
      } else {
        model.greyScaleGreen(commands[1], commands[2]);
      }
      messageDisplayed("greyscale-green image ");
    }
  }

  /**
   * This uses the builtIn Runnable interface, that will allow
   * us to greyscale by only using the blue color of the pixel.
   */
  private class GreyscaleBlue implements Runnable {

    public void run() {
      if (commands[3] != null) {
        try {
          model.greyscaleBlueMask(commands[1], commands[2], commands[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
          wrongDimensionMask();
        }
      } else {
        model.greyScaleBlue(commands[1], commands[2]);
      }
      messageDisplayed("greyscale-blue image ");
    }
  }

  /**
   * This uses the builtIn Runnable interface, that will allow us to greyscale by only using the
   * Luma function.
   */
  private class Luma implements Runnable {
    public void run() {
      if (commands[3] != null) {
        try {
          model.lumaMask(commands[1], commands[2], commands[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
          wrongDimensionMask();
        }
      } else {
        model.luma(commands[1], commands[2]);

      }
      messageDisplayed("luma image ");
    }
  }

  /**
   * This uses the builtIn Runnable interface, that will allow us to greyscale by only using the
   * value function.
   */
  private class Value implements Runnable {
    public void run() {
      if (commands[3] != null) {
        try {
          model.valueMask(commands[1], commands[2], commands[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
          wrongDimensionMask();
        }
      } else {
        model.value(commands[1], commands[2]);

      }
      messageDisplayed("value image ");
    }
  }

  /**
   * This uses the builtIn Runnable interface, that will allow us to greyscale by only using the
   * intensity function.
   */
  private class Intensity implements Runnable {
    public void run() {
      if (commands[3] != null) {
        try {
          model.intensityMask(commands[1], commands[2], commands[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
          wrongDimensionMask();
        }
      } else {
        model.intensity(commands[1], commands[2]);

      }
      messageDisplayed("intensity image ");
    }
  }

  /**
   * This uses the builtIn Runnable interface, that will allow us to flip the image vertically.
   */
  private class Vertical implements Runnable {
    public void run() {
      model.flipImageVertical(commands[1], commands[2]);
      messageDisplayed("flipped vertically ");
    }
  }

  /**
   * This uses the builtIn Runnable interface, that will allow us to flip the image horizontally.
   */
  private class Horizontal implements Runnable {
    public void run() {
      model.flipImageHorizontal(commands[1], commands[2]);
      messageDisplayed("flipped horizontally");
    }
  }

  /**
   * This uses the builtIn Runnable interface, that will blur.
   */
  private class Blur implements Runnable {
    public void run() {
      if (commands[3] != null) {
        try {
          model.blurMask(commands[1], commands[2], commands[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
          wrongDimensionMask();
        }
      } else {
        model.blur(commands[1], commands[2]);
      }
      messageDisplayed("blurred image ");
    }
  }


  /**
   * This uses the builtIn Runnable interface, that will sharpen.
   */
  private class Sharpen implements Runnable {
    public void run() {
      if (commands[3] != null) {
        try {
          model.sharpenMask(commands[1], commands[2], commands[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
          wrongDimensionMask();
        }
      } else {
        model.sharpen(commands[1], commands[2]);
      }
      messageDisplayed("sharpened image ");
    }
  }

  /**
   * This uses the builtIn Runnable interface, that will sepia.
   */
  private class Sepia implements Runnable {
    public void run() {
      if (commands[3] != null) {
        try {
          model.sepiaMask(commands[1], commands[2], commands[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
          wrongDimensionMask();
        }
      } else {
        model.toSepia(commands[1], commands[2]);
      }
      messageDisplayed("sepia image ");
    }
  }


  /**
   * This uses the builtIn Runnable interface, that will greyscale the image.
   */
  private class GreyScale implements Runnable {
    public void run() {
      if (commands[3] != null) {
        try {
          model.greyscaleMask(commands[1], commands[2], commands[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
          wrongDimensionMask();
        }
      } else {
        model.toGreyscale(commands[1], commands[2]);
      }
      messageDisplayed("greyscaled image ");
    }
  }

  /**
   * This uses the builtIn Runnable interface, to downscale the image.
   */
  private class Downscale implements Runnable {
    public void run() {
      model.downscale(Double.parseDouble(commands[1]), commands[2], commands[3]);
      messageDisplayed("downscaled image ");
    }
  }


  /**
   * to limit code duplication, this method will repeat the render message function in all methods
   * this helper method if called.
   *
   * @param message will depend on the command, but will show if the given command was executed.
   */
  private void messageDisplayed(String message) {
    try {
      view.renderMessage(message + "\n");
    } catch (IOException e) {
      throw new IllegalArgumentException("unfortunately, the command was not executed");
    }
  }


  private void wrongDimensionMask() {
    try {
      view.renderMessage("the dimension for the original image and mask image must be the same!");
    } catch (IOException e) {
      throw new ArrayIndexOutOfBoundsException("the dimension for the original image" +
              " and mask image must be the same!");
    }
  }
}




