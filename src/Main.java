import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.crypto.Data;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Created by rmariscal on 23/05/17.
 */
public class Main {
    static DataBase database;
    static JFrame frame;

    static {
        try {
            database = new DataBase() ;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LoginForm lf = new LoginForm();
        Desktop dt = new Desktop();

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new CardLayout());
        panel.add(lf.getPanel(), "LOGINPANEL");
        panel.add(dt.getPanel(), "DESKTOP");

        frame.setContentPane(panel);
        frame.setVisible(true);

    }

    public static void changeScreen(String screenName) {
        JPanel panel = (JPanel) frame.getContentPane();
        CardLayout cl = (CardLayout) panel.getLayout();
        cl.show(panel, screenName);
    }
}
