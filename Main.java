import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GuiTesting{

    private JFrame frame;
    private JFrame window;
    private JButton I;
    private JButton V;
    private JButton X;
    private JButton L;
    private JButton C;
    private JButton D;
    private JButton M;
    private JButton additionButton;
    private JButton subtractionButton;
    private JButton calculateButton;
    private JButton clearButton;
    private JButton period;
    private JLabel title;
    private JLabel arabicLabel;
    private JLabel romanLabel;
    private JTextField input;
    private JTextField outputRoman;
    private JTextField outputArabic;

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

    //ActionListener Class
    class Action implements ActionListener{
        public  void actionPerformed (ActionEvent e){
            if (e.getSource() == I){
                JOptionPane.showMessageDialog(window, "HOORAY", "title", JOptionPane.ERROR_MESSAGE);
            }
            else{
                System.exit(0);
            }
        }
    }

    //Main class
    public static void main (String[] args){
        
        GuiTesting Test = new GuiTesting();

        //Creating the main frame for the application
        Test.frame = new JFrame("Roman Numeral Calc.");
        Test.frame.setVisible(true);
        Test.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Test.frame.setSize(600,400);

        //Instantiating all frame elements
        Test.additionButton = new JButton("+");
        Test.additionButton.setPreferredSize(new Dimension(50, 40));
        Test.subtractionButton = new JButton("-");
        Test.subtractionButton.setPreferredSize(new Dimension(50, 40));
        Test.calculateButton = new JButton("Calculate");
        Test.calculateButton.setPreferredSize(new Dimension(100, 40));
        Test.clearButton = new JButton("Clear");
        Test.clearButton.setPreferredSize(new Dimension(100, 40));
        Test.I = new JButton("I");
        Test.I.setPreferredSize(new Dimension(50, 40));
        Test.V = new JButton("V");
        Test.V.setPreferredSize(new Dimension(50, 40));
        Test.X = new JButton("X");
        Test.X.setPreferredSize(new Dimension(50, 40));
        Test.L = new JButton("L");
        Test.L.setPreferredSize(new Dimension(50, 40));
        Test.C = new JButton("C");
        Test.C.setPreferredSize(new Dimension(50, 40));
        Test.D = new JButton("D");
        Test.D.setPreferredSize(new Dimension(50, 40));
        Test.M = new JButton("M");
        Test.M.setPreferredSize(new Dimension(50, 40));
        Test.period = new JButton(".");
        Test.period.setPreferredSize(new Dimension(50,40));
        Test.title = new JLabel("Roman Numeral Calculator");
        Test.title.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        Test.romanLabel = new JLabel("Roman Total");
        Test.romanLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        Test.arabicLabel = new JLabel("Arabic Total");
        Test.arabicLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        Test.input = new JTextField(10);
        Test.input.setEditable(false);
        Test.outputRoman = new JTextField(10);
        Test.outputRoman.setEditable(false);
        Test.outputArabic = new JTextField(10);
        Test.outputArabic.setEditable(false);

        //Creating the panel for the frame and setting basic constraints
        JPanel panel = new JPanel(new GridBagLayout());
        Test.frame.add(panel, BorderLayout.NORTH);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(1,1,1,1);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        //Adding all buttons and fields to the panel using GridBagLayout to organise them all

        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(Test.title, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(Test.input, constraints);
        
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.ipadx = 50;

        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.gridwidth = 0;
        constraints.fill = GridBagConstraints.VERTICAL;

        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(Test.I, constraints);

        constraints.weightx = 0.;
        constraints.gridx = 2;
        constraints.gridy = 4;
        panel.add(Test.V, constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(Test.X, constraints);

        constraints.gridx = 2;
        constraints.gridy = 5;
        panel.add(Test.L, constraints);

        constraints.gridx = 1;
        constraints.gridy = 6;
        panel.add(Test.C, constraints);

        constraints.gridx = 2;
        constraints.gridy = 6;
        panel.add(Test.D, constraints);

        constraints.gridx = 1;
        constraints.gridy = 7;
        panel.add(Test.M, constraints);

        constraints.gridx = 2;
        constraints.gridy = 7;
        panel.add(Test.period, constraints);

        constraints.gridx = 1;
        constraints.gridy = 8;
        panel.add(Test.additionButton, constraints);

        constraints.gridx = 2;
        constraints.gridy = 8;
        panel.add(Test.subtractionButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 9;
        panel.add(Test.calculateButton, constraints);

        constraints.gridx = 2;
        constraints.gridy = 9;
        panel.add(Test.clearButton, constraints);

        Action inputHandler = (Test.new Action());
        Test.I.addActionListener(inputHandler);
        Test.V.addActionListener(inputHandler);
        Test.X.addActionListener(inputHandler);
        Test.L.addActionListener(inputHandler);
        Test.C.addActionListener(inputHandler);
        Test.D.addActionListener(inputHandler);
        Test.M.addActionListener(inputHandler);
        Test.period.addActionListener(inputHandler);
        Test.additionButton.addActionListener(inputHandler);
        Test.subtractionButton.addActionListener(inputHandler);
        Test.calculateButton.addActionListener(inputHandler);
        Test.clearButton.addActionListener(inputHandler);
        
    }
}