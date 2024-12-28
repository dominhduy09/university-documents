import javax.swing.*;
import java.awt.*;

public class SierpinskiTriangle extends JPanel {

    // Function to draw the Sierpinski triangle
    public void drawSierpinski(Graphics g, int depth, int x1, int y1, int x2, int y2, int x3, int y3) {
        if (depth == 0) {
            // Base case: Draw the triangle
            g.fillPolygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);
        } else {
            // Recursive case: Divide the triangle into three smaller triangles
            int midX1 = (x1 + x2) / 2;
            int midY1 = (y1 + y2) / 2;
            int midX2 = (x2 + x3) / 2;
            int midY2 = (y2 + y3) / 2;
            int midX3 = (x3 + x1) / 2;
            int midY3 = (y3 + y1) / 2;

            // Recursively draw the three smaller triangles
            drawSierpinski(g, depth - 1, x1, y1, midX1, midY1, midX3, midY3);
            drawSierpinski(g, depth - 1, midX1, midY1, x2, y2, midX2, midY2);
            drawSierpinski(g, depth - 1, midX3, midY3, midX2, midY2, x3, y3);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int depth = 5; // You can change the depth for more/less detail
        int width = getWidth();
        int height = getHeight();

        // Define the points of the main triangle (equilateral)
        int x1 = width / 2;
        int y1 = 50;
        int x2 = 50;
        int y2 = height - 50;
        int x3 = width - 50;
        int y3 = height - 50;

        // Draw the Sierpinski triangle
        drawSierpinski(g, depth, x1, y1, x2, y2, x3, y3);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        SierpinskiTriangle panel = new SierpinskiTriangle();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(panel);
        frame.setVisible(true);
    }
}
