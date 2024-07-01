package Question_1;

import javax.swing.*;

public class Question_1 {
    public static void main(String[] args) {

        // create a jframe
        JFrame frame = new JFrame("JOptionPane showMessageDialog and showInputDialog");

        String name = JOptionPane.showInputDialog(frame,
                "What is your name?",
                "Input",
                JOptionPane.QUESTION_MESSAGE);

        JOptionPane.showMessageDialog(frame,
                "Welcome, " + name + ", to Java Programming!",
                "Message",
                JOptionPane.INFORMATION_MESSAGE);
    }
}