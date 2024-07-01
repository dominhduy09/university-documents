import java.awt.*;
import javax.swing.*;

public class DrawLines extends JPanel {
    private int numIncrements = 15;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int xIncrement = width / numIncrements;
        int yIncrement = height / numIncrements;

        // Drawing lines from top-left to bottom-right
        for (int i = 0; i < numIncrements; i++) {
            int x1 = 0;
            int y1 = i * yIncrement;
            int x2 = (i + 1) * xIncrement;
            int y2 = height;
            g.drawLine(x1, y1, x2, y2);
        }

        // Drawing lines from top-right to bottom-left
        for (int i = 0; i < numIncrements; i++) {
            int x1 = width;
            int y1 = i * yIncrement;
            int x2 = width - (i + 1) * xIncrement;
            int y2 = height;
            g.drawLine(x1, y1, x2, y2);
        }

        // Drawing lines from bottom-left to top-right
        for (int i = 0; i < numIncrements; i++) {
            int x1 = i * xIncrement;
            int y1 = 0;
            int x2 = width;
            int y2 = (i + 1) * yIncrement;
            g.drawLine(x1, y1, x2, y2);
        }

        // Drawing lines from bottom-right to top-left
        for (int i = 0; i < numIncrements; i++) {
            int x1 = width - i * xIncrement;
            int y1 = 0;
            int x2 = 0;
            int y2 = (i + 1) * yIncrement;
            g.drawLine(x1, y1, x2, y2);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Lines");
        DrawLines lines = new DrawLines();
        frame.add(lines);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
