import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rmariscal on 23/05/17.
 */
public class MainForm {
    public JPanel getPanel() {
        return panel;
    }

    private JPanel panel;
    private JTextField user;
    private JButton login;
    private JPasswordField password;
    private String userValue;
    private String passwordValue;

    public MainForm() {
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userValue = user.getText();
                passwordValue = String.valueOf(password.getPassword());


            }
        });
    }
}
