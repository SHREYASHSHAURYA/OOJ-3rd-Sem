import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntegerDivisionApp {

    public static void main(String[] args) {        JFrame frame = new JFrame("Integer Division");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(4, 2, 5, 5));
        JLabel label1 = new JLabel("Enter Num1: ");
        JTextField textField1 = new JTextField();
        JLabel label2 = new JLabel("Enter Num2: ");
        JTextField textField2 = new JTextField();
        JButton divideButton = new JButton("Divide");
        JLabel resultLabel = new JLabel("Result: ");
        JTextField resultField = new JTextField();
        resultField.setEditable(false); // Make result field read-only
        frame.add(label1);
        frame.add(textField1);
        frame.add(label2);
        frame.add(textField2);
        frame.add(divideButton);
        frame.add(resultLabel);
        frame.add(resultField);

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                          int num1 = Integer.parseInt(textField1.getText());
                    int num2 = Integer.parseInt(textField2.getText());

                    int result = num1 / num2;
                    resultField.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, 
                            "Invalid input! Please enter integers only.", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ArithmeticException ex) {
                                        JOptionPane.showMessageDialog(frame, 
                            "Cannot divide by zero!", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}
