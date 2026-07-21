import javax.swing.*;

public class LoginForm extends JFrame {
    private JPanel loginPanel;
    private JLabel lPhoneNumber;
    private JTextField numberField;
    private JLabel lPIN;
    private JPasswordField pinField;
    private JButton loginButton;
    private JButton registerButton;

    private UserAuthentication auth = new UserAuthentication();

    public LoginForm() {
        setContentPane(loginPanel);
        setTitle("GCash Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        loginButton.addActionListener(e -> {
            String number = numberField.getText();
            String pin = new String(pinField.getPassword());

            int userId = auth.login(number, pin);

            if (userId != -1) {
                JOptionPane.showMessageDialog(this, "Login Successful!");

                new HomeForm();
                dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Login Failed!");
            }
        });

        registerButton.addActionListener(e -> {
            new RegisterForm();
            dispose();
        });
    }



}