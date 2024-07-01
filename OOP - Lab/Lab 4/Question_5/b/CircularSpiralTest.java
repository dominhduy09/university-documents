import javax.swing.JFrame;

public class CircularSpiralTest {
    public static void main(String[] args) {
        
        //create a panel that contains our drawing
        CircularSpiral Circularpanel = new CircularSpiral();

        //create a new frame to hold the panel
        JFrame application = new JFrame();

        //set the frame to exit when it is closed
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        application.add(Circularpanel); //add the panel to the frame
        application.setSize(400, 400);
        application.setVisible(true);
    }
}
