package Question_2;

import javax.swing.JPanel;
import java.awt.Graphics;

public class Question_2 extends JPanel {
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    int width = getWidth();
    int height = getHeight();

    // draw a line from the upper-left to the lower-right
    g.drawLine(0, 0, width, height);

    // draw a line from the lower-left to the upper-right
    g.drawLine(0, height, width, 0);

    // Draw a line from upper to lower edge in the middle
    g.drawLine(0, height / 2, width, height / 2);

    // Draw a line from left to right edge in the middle
    g.drawLine(width / 2, 0, width / 2, height);

  }
}
