import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GuiTesting{
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
    static class Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            System.exit(0);
        }
    }
    
    //Main class
    public static void main (String[] args){
        
        //Creating the main frame for the application
        JFrame frame = new JFrame("Roman Numeral Calc.");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);

        //Creating the panel for the frame
        JPanel panel = new JPanel(new GridBagLayout());
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10,10,10,10);

        //instantiating buttons, attaching actionlisteners and adding them to to the panel
        JButton additionButton = new JButton("+");
        JButton subtractionButton = new JButton("-");
        JButton calculateButton = new JButton("Calculate");
        JButton clearButton = new JButton("Clear");

        panel.add(additionButton);
        panel.add(subtractionButton);
        panel.add(calculateButton);
        panel.add(clearButton);

        additionButton.addActionListener(new Action());
        subtractionButton.addActionListener(new Action());
        calculateButton.addActionListener(new Action());
        clearButton.addActionListener(new Action());

    }
}
