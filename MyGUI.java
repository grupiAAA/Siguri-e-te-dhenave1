import javax.swing.*;
import java.awt.*;

public class MyGUI extends JFrame {

    private JTextField textField;
    private JSpinner spinner;
    private static String text;
    private static int number;

    public MyGUI() {
        // Set up the JFrame
        super("My GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Create the input fields
        textField = new JTextField(20);
        spinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));

        // Add the input fields to the JFrame
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Inputs"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        inputPanel.add(new JLabel("Text input:"), gbc);

        gbc.gridx = 1;
        inputPanel.add(textField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Number input:"), gbc);

        gbc.gridx = 1;
        inputPanel.add(spinner, gbc);

        add(inputPanel, BorderLayout.CENTER);

        // Add a button to submit the inputs
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            text = textField.getText();
            number = (int) spinner.getValue();
            onSub();
            // JOptionPane.showMessageDialog(this, "Text: " + text + "\nNumber: " + number, "Submission Result", JOptionPane.INFORMATION_MESSAGE);
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(submitButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Display the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        MyGUI gui = new MyGUI();
        
    }

    public static void onSub(){
        String res = encrypt(text,number).toString();
        JOptionPane.showMessageDialog(null,"Mezashi i enkriptuar me zhvendosje te " + number + " shifrave eshte: " + res,"Mesazhi i enkriptuar", JOptionPane.INFORMATION_MESSAGE);
    }
{}
        
    
    public static StringBuffer encrypt(String text, int s)
    {
        StringBuffer result= new StringBuffer();
 
        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) +
                                  s - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)text.charAt(i) +
                                  s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
}

