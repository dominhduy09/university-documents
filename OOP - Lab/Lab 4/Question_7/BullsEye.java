import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BullsEye extends JPanel {

    private final int NUM_RINGS = 10; // Number of rings in the bull's-eye
    private final int RING_WIDTH = 20; // Width of each ring

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int maxRadius = Math.min(centerX, centerY); // Radius of the outermost ring

        Random random = new Random();

        for (int i = NUM_RINGS; i >= 1; i--) {
            int radius = i * RING_WIDTH;

            // Generate random colors for each ring
            int r1 = random.nextInt(256);
            int g1 = random.nextInt(256);
            int b1 = random.nextInt(256);
            int r2 = random.nextInt(256);
            int g2 = random.nextInt(256);
            int b2 = random.nextInt(256);
            Color color1 = new Color(r1, g1, b1);
            Color color2 = new Color(r2, g2, b2);

            if (i % 2 == 0) {
                g.setColor(color1);
            } else {
                g.setColor(color2);
            }

            g.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bull's-Eye"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        BullsEye panel = new BullsEye(); // Corrected class name here
        frame.add(panel);

        frame.setVisible(true);
    }
}