import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class BarChart extends JPanel {

    private int[] numbers;
    private Color[] colors; // Array to store colors for each bar
    private final int barSpacing = 30; // Spacing between bars
    private final int margin = 30; // Margin around the bar chart

    public BarChart(int[] numbers) {
        this.numbers = numbers;

        // Define colors for each bar
        colors = new Color[] { Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE };
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int totalSpacing = (numbers.length - 1) * barSpacing; // Total spacing between bars
        int totalBarHeight = getHeight() - totalSpacing - 2 * margin; // Total height available for bars after
                                                                      // considering margin
        int barHeight = totalBarHeight / numbers.length; // Height of each bar
        int max = getMax(numbers);

        for (int i = 0; i < numbers.length; i++) {
            int width = (int) (((double) numbers[i] / max) * (getWidth() - 2 * margin)); // Width of each bar after
                                                                                         // considering margin

            // Flip the bars from bottom to top
            int y = margin + i * (barHeight + barSpacing);
            g.setColor(colors[i % colors.length]); // Assign color to the bar
            g.fillRect(margin, y, width, barHeight);
        }
    }

    private int getMax(int[] numbers) {
        int max = numbers[0];
        for (int num : numbers) {
            max = Math.max(max, num);
        }
        return max;
    }
}
