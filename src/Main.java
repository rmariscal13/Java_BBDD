import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Created by rmariscal on 23/05/17.
 */
public class Main {
    static DataBase database;
    static JFrame frame;
    static JMenuBar jmb;

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

    public static void main(String[] args) throws SQLException {
        LoginForm lf = new LoginForm();
        Desktop dt = new Desktop();
        LectorAlta la = new LectorAlta();
        NouPrestec np = new NouPrestec();
        NouAutor nouAutor = new NouAutor();
        NouLlibre nouLlibre = new NouLlibre();


        //Crea frame
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);


        //Crea panel i afegim tots els formularis
        JPanel panel = new JPanel();
        panel.setLayout(new CardLayout());
        panel.add(lf.getPanel(), "LOGINPANEL");
        panel.add(dt.getPanel(), "DESKTOP");
        panel.add(la.getPanel(), "LECTORALTA");
        panel.add(np.getPanel(), "NOUPRESTEC");
        panel.add(nouAutor.getPanel(), "NOUAUTOR");
        panel.add(nouLlibre.getPanel(), "NOULLIBRE");

        //Establim un panel
        frame.setContentPane(panel);
        frame.setVisible(true);

        //Cream el menu
        creaMenu();

    }

    private static void creaMenu() {
        JMenuBar jmb = new JMenuBar();
        frame.setJMenuBar(jmb);

        JMenu lector = new JMenu("Lector");
        JMenu llibre = new JMenu("Llibre");
        JMenu autor = new JMenu("Autor");
        JMenu sancio = new JMenu("Sancio");
        JMenu prestec = new JMenu("Prestec");

        jmb.add(lector);
        jmb.add(llibre);
        jmb.add(autor);
        jmb.add(sancio);
        jmb.add(prestec);

        JMenuItem lectorAlta = new JMenuItem("Alta");
        JMenuItem lectorBaixa = new JMenuItem("Baixa");
        JMenuItem lectorModificacio = new JMenuItem("Modifica");
        lector.add(lectorAlta);
        lector.add(lectorBaixa);
        lector.add(lectorModificacio);

        lectorAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen("LECTORALTA");
            }
        });

        lectorBaixa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen("LECTORBAIXA");
            }
        });


        JMenuItem llibreAfegeix = new JMenuItem("Afegeix");
        JMenuItem llibreElimina = new JMenuItem("Elimina");
        JMenuItem llibreModificacio = new JMenuItem("Modifica");
        llibre.add(llibreAfegeix);
        llibre.add(llibreElimina);
        llibre.add(llibreModificacio);

        llibreAfegeix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen("NOULLIBRE");
            }
        });

        JMenuItem autorAfegeix = new JMenuItem("Afegeix");
        JMenuItem autorElimina = new JMenuItem("Elimina");
        JMenuItem autorModifica = new JMenuItem("Modifica");
        autor.add(autorAfegeix);
        autor.add(autorElimina);
        autor.add(autorModifica);

        autorAfegeix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen("NOUAUTOR");
            }
        });


        JMenuItem sancioAfegeix = new JMenuItem("Afegeix");
        JMenuItem sancioElimina = new JMenuItem("Elimina");
        JMenuItem sancioModifica = new JMenuItem("Modifica");
        sancio.add(sancioAfegeix);
        sancio.add(sancioElimina);
        sancio.add(sancioModifica);

        JMenuItem prestecAfegeix = new JMenuItem("Nou");
        JMenuItem prestecElimina = new JMenuItem("Elimina");
        JMenuItem prestecModifica = new JMenuItem("Modifica");
        prestec.add(prestecAfegeix);
        prestec.add(prestecElimina);
        prestec.add(prestecModifica);

        prestecAfegeix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen("NOUPRESTEC");
            }
        });
        
    }

    public static void changeScreen(String screenName) {
        JPanel panel = (JPanel) frame.getContentPane();
        CardLayout cl = (CardLayout) panel.getLayout();
        cl.show(panel, screenName);
    }
}
