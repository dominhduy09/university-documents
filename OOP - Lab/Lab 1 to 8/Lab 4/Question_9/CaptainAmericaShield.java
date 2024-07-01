import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class CaptainAmericaShield extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        // Draw red and white interleaved circles with increased size
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.WHITE);
            }
            // Increase the size of the circles
            g.fillOval(25 + 30 * i, 25 + 30 * i, width - 50 - 60 * i, height - 50 - 60 * i);
        }

        // Draw blue inner circle
        g.setColor(Color.BLUE);
        g.fillOval(width / 2 - 75, height / 2 - 75, 150, 150);

        // Draw white star
        g.setColor(Color.WHITE);
        int[] starX = { width / 2, width / 2 + 15, width / 2 + 50, width / 2 + 20, width / 2 + 35, width / 2,
                width / 2 - 35, width / 2 - 20, width / 2 - 50, width / 2 - 15 };
        int[] starY = { height / 2 - 50, height / 2 - 15, height / 2 - 15, height / 2, height / 2 + 35, height / 2 + 15,
                height / 2 + 35, height / 2, height / 2 - 15, height / 2 - 15 };
        g.fillPolygon(starX, starY, 10);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Captain America Shield");
        CaptainAmericaShield panel = new CaptainAmericaShield();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
