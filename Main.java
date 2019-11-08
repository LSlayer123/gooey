import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GuiTesting{
    
    JButton I;
    JButton V;
    JButton X;
    JButton L;
    JButton C;
    JButton D;
    JButton M;
    JButton additionButton;
    JButton subtractionButton;
    JButton calculateButton;
    JButton clearButton;
    JLabel title;
    JTextField input;

    //Function for converting Roman Number into Arabic Number
    public double romanToArab(String romanNumber){
        
        double tempTotal = 0;
        double total = 0;
        char currentCharacter;
        
        //Substituting each letter in the Roman numeral to its respective value and adding it to a running total
        for (int i=1; i<=romanNumber.length(); i++){
            currentCharacter = romanNumber.charAt(i);
            if (currentCharacter == 'I'){
                total = total + 1;
            }
            else if (currentCharacter == 'V'){
                total = total + 5;
            }
            else if (currentCharacter == 'X'){
                total = total + 10;
            }
            else if (currentCharacter == 'L'){
                total = total + 50;
            }
            else if (currentCharacter == 'C'){
                total = total + 100;
            }
            else if (currentCharacter == 'D'){
                total = total + 500;
            }
            else if (currentCharacter == 'M'){
                total = total + 1000;
            }
            else if (currentCharacter == '.'){
                tempTotal = total;
                total = 0;
            }
        }
        
        //Special case if the number is a decimal
        if (tempTotal > 0){
            total = tempTotal + (total / 100);
        }
        
        return total;
    }
    
    //Function for converting Arabic Number into Roman Number
    public String arabToRoman(double arabicNumber){

        String total = "";
        double[] numbers = {1000,500,100,50,10,5,1};
        String letters = "MDCLXVI";
        
        //Special case for if the number has a decimal
        if (String.valueOf(arabicNumber).contains(".")){
            double integer = arabicNumber;
            double decimal = Math.round((arabicNumber - integer) * 100);
            String romanInt = arabToRoman(integer);
            String romanDec = arabToRoman(decimal);

            return romanInt + "." + romanDec;
        }

        //Generic algorithm for converting Arabic to Roman by sequentially subtracting from the original value
        for (int i = 0; i < 7; i++){
            double amount = Math.floor(arabicNumber / numbers[i]);
            for (int j = 0; j < amount; j++){
                total = total + letters.charAt(i);
            }
            if (amount > 0){
                arabicNumber = arabicNumber - (numbers[i] * amount);
            }
        }
        return total;
    }
    
    //Function for validating the inputted numbers
    public boolean validation(String firstPart, String lastPart, JFrame window){
        boolean suitable = false;
        String predictedOutput1;
        String predictedOutput2;

        //Validating First number
        predictedOutput1 = arabToRoman(romanToArab(firstPart));
        predictedOutput2 = arabToRoman(romanToArab(lastPart));
        if (predictedOutput1 != firstPart){
            JOptionPane.showMessageDialog(window, "Your first Roman Numeral was not entered properly", "Error!", JOptionPane.ERROR_MESSAGE);
            if (predictedOutput1.length() != firstPart.length()){
                JOptionPane.showMessageDialog(window, "You didn't follow the additive rule, the Roman numeral should've been written as " + predictedOutput1, "Error!", JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(window, "Your Roman Numeral was not written in descending order per standard practice. It shouldve been written as " + predictedOutput1, "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
        //Validating Second Number
        else if (predictedOutput2 != lastPart){
            JOptionPane.showMessageDialog(window, "Your second Roman Numeral was not entered properly", "Error!", JOptionPane.ERROR_MESSAGE);
            if (predictedOutput2.length() != lastPart.length()){
                JOptionPane.showMessageDialog(window, "You didn't follow the additive rule, the Roman numeral should've been written as " + predictedOutput2, "Error!", JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(window, "Your Roman Numeral was not written in descending order per standard practice. It shouldve been written as " + predictedOutput2, "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            suitable = true;
        }

        return suitable;

    }

    //Main class
    public static void main (String[] args){
        
        //Creating the main frame for the application
        JFrame frame = new JFrame("Roman Numeral Calc.");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);

        //Instantiating all frame elements
        JButton additionButton = new JButton("+");
        JButton subtractionButton = new JButton("-");
        JButton calculateButton = new JButton("Calculate");
        JButton clearButton = new JButton("Clear");
        JButton I = new JButton("I");
        I.setPreferredSize(new Dimension(50, 50));
        JButton V = new JButton("V");
        V.setPreferredSize(new Dimension(50, 50));
        JButton X = new JButton("X");
        X.setPreferredSize(new Dimension(50, 50));
        JButton L = new JButton("L");
        L.setPreferredSize(new Dimension(50, 50));
        JButton C = new JButton("C");
        C.setPreferredSize(new Dimension(50, 50));
        JButton D = new JButton("D");
        D.setPreferredSize(new Dimension(50, 50));
        JButton M = new JButton("M");
        M.setPreferredSize(new Dimension(50, 50));
        JLabel title = new JLabel("Roman Numeral Calculator");
        title.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        JTextField input = new JTextField(10);
        input.setEditable(false);

        //Creating the panel for the frame and setting basic constraints
        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel, BorderLayout.NORTH);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0,0,0,0);
        constraints.fill = GridBagConstraints.NONE;
        
        //Adding all buttons and fields to the panel using GridBagLayout to organise them all
        constraints.weightx = 0.9;
        constraints.weighty = 0.9;

        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(title, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        panel.add(input, constraints);
        
        constraints.anchor = GridBagConstraints.LINE_START;
    
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.gridwidth = 0;
        constraints.fill = GridBagConstraints.NONE;

        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(I, constraints);

        constraints.gridx = 2;
        constraints.gridy = 4;
        panel.add(V, constraints);

        constraints.gridx = 3;
        constraints.gridy = 4;
        panel.add(X, constraints);

        constraints.gridx = 4;
        constraints.gridy = 4;
        panel.add(L, constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(C, constraints);

        constraints.gridx = 2;
        constraints.gridy = 5;
        panel.add(D, constraints);

        constraints.gridx = 3;
        constraints.gridy = 5;
        panel.add(M, constraints);

        Action inputHandler = new Action();
        additionButton.addActionListener(inputHandler);
        subtractionButton.addActionListener(inputHandler);
        calculateButton.addActionListener(inputHandler);
        clearButton.addActionListener(inputHandler);
        input.addActionListener(inputHandler);
        
    }
    
    //ActionListener Class
    static class Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            System.exit(0);
        }
    }
    
}