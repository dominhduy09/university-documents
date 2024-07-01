import javax.swing.JFrame;

public class LoopLinesTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Line Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new LoopLines());
        frame.setVisible(true);
    }
}
