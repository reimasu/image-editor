package view;

//AWT imports

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

//IO imports.
import java.io.File;
import java.io.IOException;

//Until import.
import java.util.function.Consumer;

//Image file ending import.

//JSwing imports.
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

//ImageUtil import.
import model.image.ImageImplementation;

import model.pixel.Pixel;

import model.image.Image;


/**
 * This represents the GUI view, this creates the panel so we can create a user-friendly
 * GUI that allows them to change an image however they wish.
 */
public class ImageGraphics extends JFrame implements GraphicsInterface {

  /**
   * Using this field, we will be able to see the histogram. This will call the Histogram class,
   * that extends a JLabel.
   */
  private Histogram histogramSave;

  /**
   * This field calls any image; this will be used to instantiate the Histogram  constructor.
   */
  private Image imageToCall;


  /**
   * This creates the panel where the histogram will be visible.
   */

  private JPanel histogramPanel;


  /**
   * this creates the menu bar so the user can choose how they want to change the image.
   */
  private JMenuBar menu = new JMenuBar();


  /**
   * This imageLabel will be used to place the image, so we can see it on the panel.
   */
  private JLabel imageLabel;


  /**
   * This allows us to call the save, so we can see the save display.
   */
  private JLabel fileSaveDisplay;


  /**
   * This variable is used to send commands.
   */
  private Consumer<String> commands;


  /**
   * This constructor will be called to display the GUI so that the user can interact with the
   * image editor.
   */
  public ImageGraphics() {

    super();
    JPanel featurePanel;
    featurePanel = new JPanel();
    fileSaveDisplay = new JLabel();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());

    //creates a histogram and adds it to the jPanel.
    this.histogramSave = new Histogram(imageToCall);
    this.add(histogramSave);
    histogramPanel = new JPanel();
    //add Histogram
    addHistogram(imageToCall);
    this.add(histogramPanel, BorderLayout.EAST);

    //builds the menu bar and image display
    buildMenuBar();
    buildImageDisplay();
    //add the save function to the panel
    featurePanel.add(fileSaveDisplay);
    commands = null;
    this.pack();

  }


  /**
   * this represents the menu bar, so that the user can interact with the image editor.
   */
  private void buildMenuBar() {
    buildFileSubmenu();
    buildFilterSubmenu();
    buildFlipSubmenu();


  }


  /**
   * Adds the histogram to a panel, that will then be displayed on the main panel.
   * refreshes the histogram as the image changes.
   *
   * @param image represents the image on the GUI.
   */
  public void addHistogram(Image image) {
    histogramPanel.add(histogramSave);
    histogramSave.replaceImage(image);
    histogramPanel.setSize(1000, 4000);
    histogramPanel.revalidate();
    histogramSave.revalidate();
    histogramSave.repaint();
    histogramPanel.repaint();
    requestFocus();
    this.pack();

  }

  /**
   * This method creates the File submenu for this view. It contains options to load and save.
   * For load and save, it will allow the user to choose (from their device) where they want
   * to load from and save to.
   */
  private void buildFileSubmenu() {
    //File for Load
    JMenu fileSubmenu = new JMenu("File");
    JMenuItem load = new JMenuItem("Load Picture");
    final JFileChooser loader =
            new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    load.addActionListener((ActionEvent e) -> {
      FileFilter image = new FileNameExtensionFilter("PPM, JPG, PNG, BMP",
              "png", "jpg", "ppm", "bmp");
      loader.setFileFilter(image);
      int returnValue = loader.showOpenDialog(null);
      if (commands != null && returnValue == JFileChooser.APPROVE_OPTION) {
        File selectedFile = loader.getSelectedFile();
        commands.accept("load " + selectedFile.toString());
      }

    });
    fileSubmenu.add(load);

    //file for save
    JMenuItem save = new JMenuItem("Save Picture");
    save.addActionListener((ActionEvent e) -> {
      final JFileChooser saver = new JFileChooser("");
      int returnValue = saver.showSaveDialog(ImageGraphics.this);
      if (commands != null && returnValue == JFileChooser.APPROVE_OPTION) {
        File imageToSave = saver.getSelectedFile();
        commands.accept("save " + imageToSave.toString());
        fileSaveDisplay.setText(imageToSave.getAbsolutePath());
      }
    });
    fileSubmenu.add(save);
    menu.add(fileSubmenu);
  }

  /**
   * This method creates the FLip submenu for this view. It contains options to flip the image
   * horizontally or vertically.
   * For load and save, it will allow the user to choose (from their device) where they want
   * to load from and save to.
   */
  private void buildFlipSubmenu() {
    //flips horizontally
    JMenu filterSubmenu = new JMenu("Flip");
    JMenuItem horizontal = new JMenuItem("Horizontal");
    horizontal.addActionListener((ActionEvent e) -> {
      if (commands != null) {
        commands.accept("horizontal");
      }
    });
    filterSubmenu.add(horizontal);

    //flips vertically
    JMenuItem vertical = new JMenuItem("Vertical");
    vertical.addActionListener((ActionEvent e) -> {
      if (commands != null) {
        commands.accept("vertical");
      }
    });
    filterSubmenu.add(vertical);
    menu.add(filterSubmenu);
    this.setJMenuBar(menu);

  }

  /**
   * This method creates the Filter submenu for this view. It contains all the filters, so the user
   * can choose how they want to change the image.
   */
  private void buildFilterSubmenu() {
    //blur
    JMenu filterSubmenu = new JMenu("Filter");
    JMenuItem blur = new JMenuItem("Blur");
    blur.addActionListener((ActionEvent e) -> {
      if (commands != null) {
        commands.accept("blur");
      }
    });
    filterSubmenu.add(blur);
    //sharpen
    JMenuItem sharpen = new JMenuItem("Sharpen");
    sharpen.addActionListener((ActionEvent e) -> {
      if (commands != null) {
        commands.accept("sharpen");
      }
    });
    filterSubmenu.add(sharpen);
    //greyscale-red
    JMenuItem greyscaleRed = new JMenuItem("Greyscale-Red");
    greyscaleRed.addActionListener((ActionEvent e) -> {
      if (commands != null) {
        commands.accept("greyscale-red");
      }
    });
    filterSubmenu.add(greyscaleRed);
    //greyscale-blue
    JMenuItem greyscaleBlue = new JMenuItem("Greyscale-Blue");
    greyscaleBlue.addActionListener((ActionEvent e) -> {
      if (commands != null) {
        commands.accept("greyscale-blue");
      }
    });
    filterSubmenu.add(greyscaleBlue);
    //greyscale-green
    JMenuItem greyscaleGreen = new JMenuItem("Greyscale-Green");
    greyscaleGreen.addActionListener((ActionEvent e) -> {
      if (commands != null) {
        commands.accept("greyscale-green");
      }
    });
    filterSubmenu.add(greyscaleGreen);
    //greyscale-luma
    JMenuItem greyscaleLuma = new JMenuItem("Greyscale-Luma");
    greyscaleLuma.addActionListener((ActionEvent e) -> {
      if (commands != null) {
        commands.accept("greyscale-luma");
      }
    });
    filterSubmenu.add(greyscaleLuma);
    //greyscale-value
    JMenuItem greyscaleValue = new JMenuItem("Greyscale-Value");
    greyscaleValue.addActionListener((ActionEvent e) -> {
      if (commands != null) {
        commands.accept("greyscale-value");
      }
    });
    filterSubmenu.add(greyscaleValue);
    //greyscale-intensity
    JMenuItem greyscaleIntensity = new JMenuItem("Greyscale-Intensity");
    greyscaleIntensity.addActionListener((ActionEvent e) -> {
      if (commands != null) {
        commands.accept("greyscale-intensity");
      }
    });
    filterSubmenu.add(greyscaleIntensity);
    //greyscale-transform
    JMenuItem greyscale = new JMenuItem("Greyscale");
    greyscale.addActionListener((ActionEvent e) -> {
      if (commands != null) {
        commands.accept("greyscale");
      }
    });
    filterSubmenu.add(greyscale);
    //sepia
    JMenuItem sepia = new JMenuItem("Sepia");
    sepia.addActionListener((ActionEvent e) -> {
      if (commands != null) {
        commands.accept("sepia");
      }
    });
    filterSubmenu.add(sepia);
    //brighten
    JMenuItem brighten = new JMenuItem("Brighten");
    brighten.addActionListener((ActionEvent e) -> {

      if (commands != null) {

        commands.accept("brighten");
      }
    });
    filterSubmenu.add(brighten);
    //darken
    JMenuItem darken = new JMenuItem("Darken");
    darken.addActionListener((ActionEvent e) -> {

      if (commands != null) {

        commands.accept("darken");
      }
    });
    filterSubmenu.add(darken);
    //downscale
    JMenuItem downscale = new JMenuItem("Downscale");
    downscale.addActionListener((ActionEvent e) -> {

      if (commands != null) {

        commands.accept("downscale");
      }
    });
    filterSubmenu.add(downscale);
    menu.add(filterSubmenu);
    this.setJMenuBar(menu);
  }


  /**
   * this will create a text box, so the user can enter a number and can choose by how much
   * they want to change the image.
   *
   * @return an int to represent how much the user will change the photo by.
   */
  @Override
  public int createTextBox() {
    JFrame jFrame = new JFrame();
    String getMessage = JOptionPane.showInputDialog(jFrame, "Enter your number!");
    JOptionPane.showMessageDialog(jFrame, "Your Number: " + getMessage);
    return Integer.parseInt(getMessage);
  }

  public double createTextBoxDouble() {
    JFrame jFrame = new JFrame();
    String getMessage = JOptionPane.showInputDialog(jFrame, "Enter your number!");
    JOptionPane.showMessageDialog(jFrame, "Your Number: " + getMessage);
    return Double.parseDouble(getMessage);
  }

  /**
   * this builds the display of the image.
   * This adds the dimension, location, and ability for the panel to scroll.
   */
  private void buildImageDisplay() {
    JScrollPane scrollPane;
    imageLabel = new JLabel();
    imageLabel.setMinimumSize(new Dimension(10, 10));
    scrollPane = new JScrollPane(imageLabel);
    scrollPane.setPreferredSize(new Dimension(600, 600));
    this.add(scrollPane, BorderLayout.CENTER);
  }


  /**
   * using this function, we will be able to make our panels or labels visible.
   */
  @Override
  public void makeVisible() {
    this.setVisible(true);
  }


  /**
   * set the command, so we can see what the command is.
   *
   * @param command represents how the user wants to change the image.
   */
  @Override
  public void setCommand(Consumer<String> command) {
    commands = command;
  }


  /**
   * this displays the image on the panel.
   *
   * @param image represents the image that needs to be displayed.
   */
  @Override
  public void displayImage(Pixel[][] image) {
    try {
      BufferedImage bufferedImage = ImageImplementation.showBufferedImage(image);
      imageLabel.setIcon(new ImageIcon(bufferedImage));
    } catch (IOException e) {
      this.displayErrorMessage(e.toString());
    }
  }

  /**
   * this displays the error message, when the user takes an action that is incorrect.
   *
   * @param errorMessage represents the error message that will be displayed.
   */
  @Override
  public void displayErrorMessage(String errorMessage) {
    JOptionPane.showMessageDialog(this, errorMessage, "ERROR",
            JOptionPane.ERROR_MESSAGE);
  }
}
