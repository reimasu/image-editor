import org.junit.Test;

import java.util.function.Consumer;


import model.model.ImageModel;


import controller.InteractiveController;

import static org.junit.Assert.assertEquals;


import view.GraphicsInterface;

/**
 * To test the GUI.
 */
public class InteractiveControllerTest {


  @Test
  public void runSharpen() {

    StringBuilder log = new StringBuilder();
    StringBuilder in = new StringBuilder();
    ImageModel game = new MockClass(in);

    GraphicsInterface mock = new GUIMock(log);

    InteractiveController control = new InteractiveController(mock, game);
    mock.setCommand(new Consumer<String>() {
      @Override
      public void accept(String s) {
        s = "sharpen";
      }
    });
    assertEquals("Command Worked!", log.toString());


  }

  @Test
  public void runBlur() {

    StringBuilder log = new StringBuilder();
    StringBuilder in = new StringBuilder();
    ImageModel game = new MockClass(in);

    GraphicsInterface mock = new GUIMock(log);

    InteractiveController control = new InteractiveController(mock, game);
    mock.setCommand(new Consumer<String>() {
      @Override
      public void accept(String s) {
        s = "blur";
      }
    });
    assertEquals("Command Worked!", log.toString());

  }

  @Test
  public void runLoad() {

    StringBuilder log = new StringBuilder();
    StringBuilder in = new StringBuilder();
    ImageModel game = new MockClass(in);

    GraphicsInterface mock = new GUIMock(log);

    InteractiveController control = new InteractiveController(mock, game);
    mock.setCommand(new Consumer<String>() {
      @Override
      public void accept(String s) {
        s = "load";
      }
    });
    assertEquals("Command Worked!", log.toString());

  }

  @Test
  public void runSave() {

    StringBuilder log = new StringBuilder();
    StringBuilder in = new StringBuilder();
    ImageModel game = new MockClass(in);

    GraphicsInterface mock = new GUIMock(log);

    InteractiveController control = new InteractiveController(mock, game);
    mock.setCommand(new Consumer<String>() {
      @Override
      public void accept(String s) {
        s = "save";
      }
    });
    assertEquals("Command Worked!", log.toString());

  }


  @Test
  public void runGreyscaleRed() {

    StringBuilder log = new StringBuilder();
    StringBuilder in = new StringBuilder();
    ImageModel game = new MockClass(in);

    GraphicsInterface mock = new GUIMock(log);

    InteractiveController control = new InteractiveController(mock, game);
    mock.setCommand(new Consumer<String>() {
      @Override
      public void accept(String s) {
        s = "greyscale-red";
      }
    });
    assertEquals("Command Worked!", log.toString());

  }

  @Test
  public void runGreyscaleBlue() {

    StringBuilder log = new StringBuilder();
    StringBuilder in = new StringBuilder();
    ImageModel game = new MockClass(in);

    GraphicsInterface mock = new GUIMock(log);

    InteractiveController control = new InteractiveController(mock, game);
    mock.setCommand(new Consumer<String>() {
      @Override
      public void accept(String s) {
        s = "greyscale-b";
      }
    });
    assertEquals("Command Worked!", log.toString());

  }

  @Test
  public void runGreyscaleGreen() {

    StringBuilder log = new StringBuilder();
    StringBuilder in = new StringBuilder();
    ImageModel game = new MockClass(in);

    GraphicsInterface mock = new GUIMock(log);

    InteractiveController control = new InteractiveController(mock, game);
    mock.setCommand(new Consumer<String>() {
      @Override
      public void accept(String s) {
        s = "greyscale-green";
      }
    });
    assertEquals("Command Worked!", log.toString());

  }

  @Test
  public void runGreyscaleValue() {

    StringBuilder log = new StringBuilder();
    StringBuilder in = new StringBuilder();
    ImageModel game = new MockClass(in);

    GraphicsInterface mock = new GUIMock(log);

    InteractiveController control = new InteractiveController(mock, game);
    mock.setCommand(new Consumer<String>() {
      @Override
      public void accept(String s) {
        s = "greyscale-value";
      }
    });
    assertEquals("Command Worked!", log.toString());

  }


  @Test
  public void runGreyscaleIntensity() {

    StringBuilder log = new StringBuilder();
    StringBuilder in = new StringBuilder();
    ImageModel game = new MockClass(in);

    GraphicsInterface mock = new GUIMock(log);

    InteractiveController control = new InteractiveController(mock, game);
    mock.setCommand(new Consumer<String>() {
      @Override
      public void accept(String s) {
        s = "greyscale-intensity";
      }
    });
    assertEquals("Command Worked!", log.toString());

  }


  @Test
  public void runGreyscaleLuma() {

    StringBuilder log = new StringBuilder();
    StringBuilder in = new StringBuilder();
    ImageModel game = new MockClass(in);

    GraphicsInterface mock = new GUIMock(log);

    InteractiveController control = new InteractiveController(mock, game);
    mock.setCommand(new Consumer<String>() {
      @Override
      public void accept(String s) {
        s = "greyscale-luma";
      }
    });
    assertEquals("Command Worked!", log.toString());

  }


  @Test
  public void runHorizontal() {

    StringBuilder log = new StringBuilder();
    StringBuilder in = new StringBuilder();
    ImageModel game = new MockClass(in);

    GraphicsInterface mock = new GUIMock(log);

    InteractiveController control = new InteractiveController(mock, game);
    mock.setCommand(new Consumer<String>() {
      @Override
      public void accept(String s) {
        s = "horizontal";
      }
    });
    assertEquals("Command Worked!", log.toString());

  }


  @Test
  public void runVertical() {

    StringBuilder log = new StringBuilder();
    StringBuilder in = new StringBuilder();
    ImageModel game = new MockClass(in);

    GraphicsInterface mock = new GUIMock(log);

    InteractiveController control = new InteractiveController(mock, game);
    mock.setCommand(new Consumer<String>() {
      @Override
      public void accept(String s) {
        s = "vertical";
      }
    });
    assertEquals("Command Worked!", log.toString());

  }


  @Test
  public void runGreyscale() {

    StringBuilder log = new StringBuilder();
    StringBuilder in = new StringBuilder();
    ImageModel game = new MockClass(in);

    GraphicsInterface mock = new GUIMock(log);

    InteractiveController control = new InteractiveController(mock, game);
    mock.setCommand(new Consumer<String>() {
      @Override
      public void accept(String s) {
        s = "greyscale";
      }
    });
    assertEquals("Command Worked!", log.toString());

  }


  @Test
  public void runSepia() {

    StringBuilder log = new StringBuilder();
    StringBuilder in = new StringBuilder();
    ImageModel game = new MockClass(in);

    GraphicsInterface mock = new GUIMock(log);

    InteractiveController control = new InteractiveController(mock, game);
    mock.setCommand(new Consumer<String>() {
      @Override
      public void accept(String s) {
        s = "vertical";
      }
    });
    assertEquals("Command Worked!", log.toString());

  }


  @Test
  public void runDarken() {

    StringBuilder log = new StringBuilder();
    StringBuilder in = new StringBuilder();
    ImageModel game = new MockClass(in);

    GraphicsInterface mock = new GUIMock(log);

    InteractiveController control = new InteractiveController(mock, game);
    mock.setCommand(new Consumer<String>() {
      @Override
      public void accept(String s) {
        s = "darken";
      }
    });
    assertEquals("Command Worked!", log.toString());

  }


  @Test
  public void runBrighten() {

    StringBuilder log = new StringBuilder();
    StringBuilder in = new StringBuilder();
    ImageModel game = new MockClass(in);

    GraphicsInterface mock = new GUIMock(log);

    InteractiveController control = new InteractiveController(mock, game);
    mock.setCommand(new Consumer<String>() {
      @Override
      public void accept(String s) {
        s = "brighten";
      }
    });
    assertEquals("Command Worked!", log.toString());

  }


  @Test
  public void errorMessage() {

    StringBuilder log = new StringBuilder();
    StringBuilder in = new StringBuilder();
    ImageModel game = new MockClass(in);

    GraphicsInterface mock = new GUIMock(log);

    InteractiveController control = new InteractiveController(mock, game);
    mock.displayErrorMessage("wrong input");

    assertEquals("Error: wrong input", log.toString());

  }
}

