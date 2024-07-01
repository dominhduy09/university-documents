import javax.swing.JFrame;

public class SquareSpiralTest {
    public static void main(String[] args) {
        
        //create a panel that contains our drawing
        SquareSpiral panel = new SquareSpiral();

        //create a new frame to hold the panel
        JFrame application = new JFrame();

        //set the frame to exit when it is closed
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        application.add(panel); //add the panel to the frame
        application.setSize(300, 300);
        application.setVisible(true);
    }
}
