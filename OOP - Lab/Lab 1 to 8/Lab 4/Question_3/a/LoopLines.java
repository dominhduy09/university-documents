import javax.swing.JPanel;
import java.awt.Graphics;

public class LoopLines extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int width = getWidth();
        int height = getHeight();
        int steps = 15; // Number of steps
        
        int stepWidth = width / steps;
        int stepHeight = height / steps;
        
        int x2 = 0; // Initialize the x-coordinate of the second endpoint
        
        for (int i = 0; i < steps; i++) {
            int y2 = height - (i * stepHeight); // Calculate the y-coordinate of the second endpoint
            
            g.drawLine(0, 0, x2, y2); // Draw line from (0,0) to (x2,y2)
            
            x2 += stepWidth; // Move to the right one step
        }
    }
}
