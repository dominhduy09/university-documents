import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DiamondShapeUI extends JFrame {
    private JTextField sizeField;
    private JButton okButton;
    private JButton cancelButton;

    public DiamondShapeUI() {
        setTitle("Diamond Shape Drawer");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel sizeLabel = new JLabel("Enter size of the diamond:");
        sizeField = new JTextField(10); // 10 columns wide
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        JPanel inputPanel = new JPanel();
        inputPanel.add(sizeLabel);
        inputPanel.add(sizeField);
        inputPanel.add(okButton);
        inputPanel.add(cancelButton);

        okButton.addActionListener(new DrawButtonListener());
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window
            }
        });

        getContentPane().add(inputPanel, BorderLayout.CENTER);
    }

    private class DrawButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String sizeText = sizeField.getText();
            try {
                int size = Integer.parseInt(sizeText);
                if (size % 2 == 0) {
                    JOptionPane.showMessageDialog(DiamondShapeUI.this,
                            "Please enter an odd number for the diamond size.");
                } else {
                    drawDiamond(size);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(DiamondShapeUI.this, "Please enter a valid number.");
            }
        }
    }

    private void drawDiamond(int size) {
        JFrame diamondFrame = new JFrame();
        diamondFrame.setSize(400, 400);
        diamondFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        diamondFrame.setLocationRelativeTo(null);

        JPanel diamondPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int mid = size / 2;
                int count = 1;
                for (int i = 1; i <= size; i++) {
                    for (int j = 1; j <= size; j++) {
                        if (i <= mid) {
                            if (j >= mid - i + 1 && j <= mid + i - 1) {
                                g.drawString("*", j * 15, i * 15);
                            }
                        } else {
                            if (j >= i - mid + 1 && j <= mid + size - i) {
                                g.drawString("*", j * 15, i * 15);
                            }
                        }
                    }
                }
            }
        };

        diamondFrame.add(diamondPanel);
        diamondFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DiamondShapeUI().setVisible(true);
            }
        });
    }
}
