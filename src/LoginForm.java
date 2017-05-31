import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by rmariscal on 23/05/17.
 */
public class LoginForm {
    public JPanel getPanel() {
        return panel;
    }

    private JPanel panel;
    private JTextField user;
    private JButton login;
    private JPasswordField password;

    public String getUserValue() {
        return userValue;
    }

    public void setUserValue(String userValue) {
        this.userValue = userValue;
    }

    public String getPasswordValue() {
        return passwordValue;
    }

    public void setPasswordValue(String passwordValue) {
        this.passwordValue = passwordValue;
    }

    private String userValue;
    private String passwordValue;


    public LoginForm() {
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userValue = user.getText();
                passwordValue = String.valueOf(password.getPassword());
                try {
                    if (Main.database.userAutorized(userValue, passwordValue)) {
                        //OK
                        Main.changeScreen("DESKTOP");

                    } else {
                        // Password no correcte
                        System.out.println("incorrecte");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });
    }

}
