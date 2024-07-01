package Question_2;

import javax.swing.JFrame;

public class Test {
    public static void main(String[] args) {
        Question_2 panel = new Question_2();

        JFrame app = new JFrame();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(panel);
        app.setSize(500, 500);
        app.setVisible(true);

    }
}
