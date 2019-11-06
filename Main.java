import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GuiTesting{
    public static void main (String[] args){
        JFrame frame = new JFrame("test");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        JPanel panel = new JPanel(new GridBagLayout());
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        GridBagConstraints constraints = new GridBagConstraints();
        JLabel label1 = new JLabel("Test1");
        JLabel label2 = new JLabel("Test2");
        JLabel label3 = new JLabel("Test3");
        JLabel label4 = new JLabel("Test4");
        JLabel label5 = new JLabel("Test5");
        JButton button = new JButton("Click here");
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridx = 5;
        constraints.gridy = 5;
        panel.add(label1, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(label2, constraints);
        constraints.gridx = 2;
        constraints.gridy = 2;
        panel.add(label3, constraints);
        constraints.gridx = 3;
        constraints.gridy = 3;
        panel.add(label4, constraints);
        constraints.gridx = 4;
        constraints.gridy = 4;
        panel.add(label5, constraints);
        constraints.gridx = 8;
        constraints.gridy = 5;
        panel.add(button, constraints);
        button.addActionListener(new Action());
    }
    static class Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            System.exit(0);
        }
    }
}
