import javax.swing.*;

public class ChangePinForm extends JFrame {
    private JPanel changePinPanel;
    private JButton backButton;
    private JButton changeButton;
    private JTextField numberField;
    private JPasswordField currentPinField;
    private JPasswordField newPinField;
    private JLabel lNumber;
    private JLabel lCurrentPin;
    private JLabel lNewPin;

    private UserAuthentication auth = new UserAuthentication();

    public ChangePinForm() {
        setContentPane(changePinPanel); // Replace with your actual root panel name
        setTitle("Change PIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        backButton.addActionListener(e -> {
            new HomeForm();
            dispose();
        });

        changeButton.addActionListener(e -> {

            String number = numberField.getText();
            String currentPin = new String(currentPinField.getPassword());
            String newPin = new String(newPinField.getPassword());

            boolean success = auth.changePin(number, currentPin, newPin);

            if (success) {
                JOptionPane.showMessageDialog(this, "PIN changed successfully!");

                new HomeForm();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to change PIN.");
            }

        });
    }
}
