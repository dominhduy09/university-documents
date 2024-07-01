import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BarChartTest {
    public static void main(String[] args) {
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            String input = JOptionPane.showInputDialog("Enter an integer:");
            numbers[i] = Integer.parseInt(input);
        }

        JFrame frame = new JFrame("Bar Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        BarChart chart = new BarChart(numbers);
        frame.add(chart);

        frame.setVisible(true);
    }
}
