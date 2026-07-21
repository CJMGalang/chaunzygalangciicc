import javax.swing.*;

public class HomeForm extends JFrame {
    private JPanel homePanel;
    private JLabel lWelcome;
    private JLabel lBalance;
    private JButton changePinButton;
    private JButton logoutButton;

    public HomeForm() {
        setContentPane(homePanel); // Replace with your panel name
        setTitle("GCash Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        logoutButton.addActionListener(e -> {
            new LoginForm();
            dispose();
        });

        changePinButton.addActionListener(e -> {
            new ChangePinForm();
            dispose();
        });
    }
}
