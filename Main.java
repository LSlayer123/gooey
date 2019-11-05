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
            System.exit(0);
        }
    }
}
