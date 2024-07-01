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
        
        // Part (a): Drawing lines fanning out from the top-left corner
        drawLines(g, 0, 0, width, height, stepWidth, stepHeight);
        
        // Part (b): Drawing lines fanning out from all four corners
        drawLines(g, 0, height, width, 0, stepWidth, stepHeight); // Bottom-left to top-right
        drawLines(g, width, height, 0, 0, stepWidth, stepHeight); // Bottom-right to top-left
        drawLines(g, width, 0, 0, height, stepWidth, stepHeight); // Top-right to bottom-left
    }
    
    private void drawLines(Graphics g, int x1, int y1, int x2, int y2, int stepWidth, int stepHeight) {
        while (x1 <= getWidth() && y1 <= getHeight()) {
            g.drawLine(x1, y1, x2, y2);
            x1 += stepWidth;
            y1 += stepHeight;
        }
    }
}
