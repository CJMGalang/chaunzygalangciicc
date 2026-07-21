import javax.swing.*;

public class RegisterForm extends JFrame {
    private JTextField usernameField;
    private JButton registerButton;
    private JButton backButton;
    private JTextField emailField;
    private JTextField numberField;
    private JPasswordField pinField;
    private JLabel lUser;
    private JLabel lEmail;
    private JLabel lNumber;
    private JLabel lPIN;
    private JPanel registerPanel;

    private UserAuthentication auth = new UserAuthentication();

    public RegisterForm() {
        setContentPane(registerPanel); // Replace with your root panel name
        setTitle("Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        registerButton.addActionListener(e -> {

            String username = usernameField.getText();
            String email = emailField.getText();
            String number = numberField.getText();
            String pin = new String(pinField.getPassword());

            boolean success = auth.registerUser(username, email, number, pin);

            if (success) {
                JOptionPane.showMessageDialog(this, "Registration Successful!");
                new LoginForm();
                dispose();
            }

        });

        backButton.addActionListener(e -> {
            new LoginForm();
            dispose();
        });
    }
}
