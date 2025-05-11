import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener {
    // Create a frame
    JFrame frame = new JFrame("Calculator");

    // Create a textfield
    JTextField textfield = new JTextField();

    // Store operator and operands
    String operator = "";
    double num1, num2, result;

    // Constructor to set up the GUI
    public Calculator() {
        // Set frame layout and components
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 600);

        textfield.setEditable(false);
        frame.add(textfield, BorderLayout.NORTH);

        // Add buttons for digits and operations
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String[] buttonText = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "C", "0", "=", "+"};

        for (String text : buttonText) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            panel.add(button);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // Handle button click events
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) == 'C') {
            textfield.setText("");
            operator = "";
            num1 = num2 = result = 0;
        } else if (command.charAt(0) == '=') {
            num2 = Double.parseDouble(textfield.getText());
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            operator = "";
        } else {
            textfield.setText(textfield.getText() + command);
            if (operator.isEmpty()) {
                num1 = Double.parseDouble(textfield.getText());
            }
        }
    }

    // Main method to run the calculator
    public static void main(String[] args) {
        new Calculator();
    }
}
