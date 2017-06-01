import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.awt.*;
import java.io.*;
import java.sql.*;

/**
 * Created by rmariscal on 25/05/17.
 */

public class DataBase {
    Connection conn;

    DataBase() throws ParserConfigurationException, IOException, SAXException, SQLException {
        String serverIP;
        String userBBDD;
        String passBBDD;
        String port;

        //Llegeix fitxer xml
        File inputFile = new File("/home/rmariscal/Documentos/CFGS/Programacio/06-01-17 Practica 7/configuracio.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(inputFile);
        doc.getDocumentElement().normalize();

        Node node = doc.getElementsByTagName("data").item(0);
        Element eElement = (Element) node;

        serverIP = eElement.getElementsByTagName("server").item(0).getTextContent();
        userBBDD = eElement.getElementsByTagName("username").item(0).getTextContent();
        passBBDD = eElement.getElementsByTagName("password").item(0).getTextContent();
        port = eElement.getElementsByTagName("port").item(0).getTextContent();

        //Realitza connexió
        Connection conexion = DriverManager.getConnection ("jdbc:mysql://" + serverIP + ":" + port + "/",userBBDD, passBBDD);
        this.conn = conexion;




    }

    boolean userAutorized(String userValue, String passwordValue) throws SQLException {
        // Consultar a la base de dades si existeix aquest usuari
        Connection conn = this.conn;
        Statement cercaUsuariStmt = conn.createStatement();
        ResultSet rs = cercaUsuariStmt.executeQuery("select * from practica7.BIBLIOTECARI;\n");

        while (rs.next()) {
            String user = rs.getString("Usuari");
            if (user.equals(userValue)) {
                String password = rs.getString("Contrasenya");
                if (password.equals(passwordValue)){
                    return true;
                }
            }
        }
        return false;
    }

    void afegeixSoci(String DNI, String nom, String llinatge1, String llinatge2, String dataNaixement) throws SQLException {
        Connection conn = this.conn;
        Statement afegeixUsuariStmt = conn.createStatement();
        String sql = "insert into practica7.SOCI values ('" + DNI + "','" + nom + "','" + llinatge1 + "','" + llinatge2 + "','" + dataNaixement + "')";
        afegeixUsuariStmt.executeUpdate(sql);
    }
}
