import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class SquareSpiral extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSquareSpiral(g);
    }

    private void drawSquareSpiral(Graphics g) {
        int centerX = getWidth() / 2; // Center X-coordinate of the panel
        int centerY = getHeight() / 2; // Center Y-coordinate of the panel

        int length = 10; // Initial length of the line
        int direction = 0; // Initial direction (0 = right, 1 = down, 2 = left, 3 = up)

        int x = centerX; // Initial X-coordinate of the starting point
        int y = centerY; // Initial Y-coordinate of the starting point

        g.setColor(Color.RED); // Set the color to red

        for (int i = 0; i < 100; i++) { // Drawing 100 lines
            switch (direction) {
                case 0: // Right
                    g.drawLine(x, y, x + length, y);
                    x += length;
                    break;
                case 1: // Down
                    g.drawLine(x, y, x, y + length);
                    y += length;
                    break;
                case 2: // Left
                    g.drawLine(x, y, x - length, y);
                    x -= length;
                    break;
                case 3: // Up
                    g.drawLine(x, y, x, y - length);
                    y -= length;
                    break;
            }
            direction = (direction + 1) % 4; // Change direction clockwise
            if (i % 2 == 1) { // Increase length every second line
                length += 10;
            }
        }
    }
}
