import javax.swing.JPanel;
import java.awt.Graphics;

public class ConcentricCircles extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int centerX = getWidth() / 2;  // X-coordinate of the center of the JPanel
        int centerY = getHeight() / 2; // Y-coordinate of the center of the JPanel

        int radius = 10; // Radius of the innermost circle
        int diameter = 2 * radius; // Diameter of each circle

        // Draw 12 concentric circles
        for (int i = 0; i < 12; i++) {
            // Calculate coordinates for the upper-left corner of the bounding rectangle
            int x = centerX - radius;
            int y = centerY - radius;

            // Draw the circle with the calculated coordinates and dimensions
            g.drawOval(x, y, diameter, diameter);

            // Increase the radius for the next circle by 10 pixels
            radius += 10;
            diameter = 2 * radius; // Update diameter accordingly
        }
    }
}