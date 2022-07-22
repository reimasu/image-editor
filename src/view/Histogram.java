package view;

import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.util.Arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;

import model.image.Image;
import model.pixel.Pixel;


/**
 * represents the histogram that will be displayed on the main panel.
 */
public class Histogram extends JLabel {

  /**
   * represents the red components in the image.
   */
  private Map<Integer, Integer> red;

  /**
   * represents the green components in the image.
   */
  private Map<Integer, Integer> green;
  /**
   * represents the blue components in the image.
   */
  private Map<Integer, Integer> blue;
  /**
   * represents the blue components in the image.
   */
  private Map<Integer, Integer> intensity;

  /**
   * represents the image that will be used to create an histogram.
   */
  private Image image;

  /**
   * this constructor will be allowed to see what image will be used to create the histogram.
   *
   * @param image represents the image that will be used to create an histogram.
   */
  public Histogram(Image image) {
    this.image = image;
  }


  /**
   * this method will be used to change the histogram as the image changes.
   *
   * @param newImage represents the newImage after the image has been changed.
   */
  public void replaceImage(Image newImage) {
    this.image = newImage;
  }


  /**
   * this will update the histogram data, as it will check the amount of red, green, blue, intensity
   * components in the image.
   *
   * @throws IllegalArgumentException when the image is wrong.
   */
  private void getColorHistogram() throws IllegalArgumentException {

    this.red = new HashMap<>();
    this.blue = new HashMap<>();
    this.green = new HashMap<>();
    this.intensity = new HashMap<>();


    for (int i = 0; i < this.image.getImageHeight(); i++) {
      for (int j = 0; j < this.image.getImageWidth(); j++) {
        int intensity = (this.image.getImage()[i][j].getRed() +
                this.image.getImage()[i][j].getGreen() + this.image.getImage()[i][j].getBlue()) / 3;
        Pixel pixel = this.image.getImage()[i][j];
        red.put(pixel.getRed(), red.getOrDefault(pixel.getRed(), 0) + 1);
        blue.put(pixel.getBlue(), blue.getOrDefault(pixel.getBlue(), 0) + 1);
        green.put(pixel.getGreen(), green.getOrDefault(pixel.getGreen(), 0) + 1);
        this.intensity.put(intensity, this.intensity.getOrDefault(intensity, 0) + 1);

      }

    }
  }

  /**
   * uses an inbuilt function to paint the histogram.
   *
   * @param g the <code>Graphics</code> represents how the histogram will be drawn.
   */
  public void paintComponent(Graphics g) {
    if (image != null) {
      getColorHistogram();
      super.paintComponent(g);

      //scale the image
      int scale = findMaxValue();
      //draws the histogram
      Graphics2D graphics2D = (Graphics2D) g.create();
      //makes sure that it is rotated correctly.
      graphics2D.rotate(270 * Math.PI / 180, 300, 300);

      //FOR TRANSPARENCY.
      for (int i = 1; i <= 10; i++) {
        float alpha = i * 0.1f;
        AlphaComposite alcom = AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, alpha);
        graphics2D.setComposite(alcom);
      }


      //draws the red data.
      for (int key : red.keySet()) {
        graphics2D.setPaint(Color.RED);
        graphics2D.drawLine(red.get(key) / scale, key, 0, key);
        float alpha = 0.5f;
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

      }

      //draws the green data.
      for (int key : green.keySet()) {
        graphics2D.setPaint(Color.GREEN);
        graphics2D.drawLine(green.get(key) / scale, key, 0, key);
        float alpha = 0.5f;
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

      }

      //draws the blue data.
      for (int key : blue.keySet()) {
        graphics2D.setPaint(Color.BLUE);
        graphics2D.drawLine(blue.get(key) / scale, key, 0, key);
        float alpha = 0.5f;
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

      }

      //draws the intensity data.
      for (int key : intensity.keySet()) {
        graphics2D.setPaint(Color.GRAY);
        graphics2D.drawLine(intensity.get(key) / scale, key, 0, key);
        float alpha = 0.5f;
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

      }

      graphics2D.dispose();
    }
  }

  /**
   * gets the max value of a map. This allows us to scale the histogram.
   *
   * @param map represents a map that measures a color component.
   * @return the int that is the maxValue for that map.
   */
  private int getMaxValue(Map<Integer, Integer> map) {
    Map.Entry<Integer, Integer> maxEntry = null;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
        maxEntry = entry;
      }
    }
    return maxEntry.getValue();
  }

  /**
   * compares the max value for all 4 color maps.
   *
   * @return the max value from the 4 color maps.
   */
  private int findMaxValue() {
    int redMax = getMaxValue(red);
    int greenMax = getMaxValue(green);
    int blueMax = getMaxValue(blue);
    int intensityMax = getMaxValue(intensity);
    List<Integer> list = Arrays.asList(redMax, greenMax, blueMax, intensityMax);
    int max = Collections.max(list) / 600;
    return max;
  }

  /**
   * Override getPreferredSize.
   * creates a new size to display the histogram.
   */
  public Dimension getPreferredSize() {
    return new Dimension(600, 600);
  }
}


