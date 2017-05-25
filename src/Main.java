import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Created by rmariscal on 23/05/17.
 */
public class Main {
    static DataBase database;

    static {
        try {
            database = new DataBase();
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
        LoginForm mf = new LoginForm();
        Prueba p = new Prueba();

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
//        panel.add(mf.getPanel(), "LOGINPANEL");
//        panel.add(p.getPanel(), "PRUEBA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mf.getPanel());
        frame.setSize(500, 500);
        frame.setVisible(true);



    }
}
