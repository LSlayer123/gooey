import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GuiTesting{
    public static void main (String[] args){
        JFrame frame = new JFrame("test");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        JPanel panel = new JPanel();
        frame.add(panel);
        JButton button = new JButton("Click here");
        panel.add(button);
        button.addActionListener(new Action());
    }
    static class Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            JFrame frame2 = new JFrame("clicked");
            frame2.setVisible(true);
            frame2.setSize(300,300);
            JPanel panel2 = new JPanel();
            JLabel label = new JLabel("You clicked me!");
            frame2.add(panel2);
            panel2.add(label);
        }
    }
}
