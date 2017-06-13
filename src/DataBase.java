import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.LinkedList;

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
        String persona = "insert into practica7.PERSONA values (DEFAULT, '" + nom + "','" + llinatge1 + "','" + llinatge2 + "','" + dataNaixement + "')";
        String soci = "insert into practica7.SOCI values (LAST_INSERT_ID(), '" + DNI + "')";
        afegeixUsuariStmt.executeUpdate(persona);
        afegeixUsuariStmt.executeUpdate(soci);
    }

    void afefeixPrestec(int ID_Bibliotecari, int ID_Soci, int ID_Copia) throws SQLException {
        Connection conn = this.conn;
        Statement afegeixPrestecStmt = conn.createStatement();
        String prestec = "insert into practica7.PRESTEC values (DEFAULT, " + ID_Bibliotecari + ", " + ID_Soci + ", " + ID_Copia + ", now(), NULL)";
        afegeixPrestecStmt.executeUpdate(prestec);
    }

    String[] rebBibliotecari(int ID) throws SQLException {
        String[] dadesBibliotecari = new String[5];

        Connection conn = this.conn;
        Statement rebBibliotecariStmt = conn.createStatement();
        String persona = "select * from practica7.PERSONA where ID = " + ID + ";";
        ResultSet rs = rebBibliotecariStmt.executeQuery(persona);
        while(rs.next()){
            dadesBibliotecari[0] = rs.getString("Nom");
            dadesBibliotecari[1] = rs.getString("Llinatge1");
            dadesBibliotecari[2] = rs.getString("Llinatge2");
            dadesBibliotecari[3] = rs.getString("Data_Naixement");
        }
        rs.close();

        String bibliotecari = "select * from practica7.BIBLIOTECARI where ID = " + ID + ";";
        ResultSet rs2 = rebBibliotecariStmt.executeQuery(bibliotecari);
        while(rs2.next()){
            dadesBibliotecari[4] = rs2.getString("DNI");
        }
        rs2.close();

        return dadesBibliotecari;
    }

    int[] IDDeBibliotecaris() throws SQLException {
        LinkedList<Integer> IDBibliotecaris = new LinkedList<>();

        Connection conn = this.conn;
        Statement bibliotecarisStmt = conn.createStatement();
        String bibliotecaris = "select * from practica7.BIBLIOTECARI;";

        boolean results = bibliotecarisStmt.execute(bibliotecaris);
        int rsCount = 0;

        while (results) {
            ResultSet rs = bibliotecarisStmt.getResultSet();
            while (rs.next()) {
                IDBibliotecaris.add(rs.getInt("ID"));
            }
            rs.close();

            results = bibliotecarisStmt.getMoreResults();
        }
        bibliotecarisStmt.close();

        int[] ID = new int[IDBibliotecaris.size()];
        for (int i = 0; i < ID.length; i++) {
            ID[i] = IDBibliotecaris.poll();
        }
        return ID;
    }

    String[] rebSoci(int ID) throws SQLException {
        String[] dadesSoci = new String[5];

        Connection conn = this.conn;
        Statement rebSociStmt = conn.createStatement();
        String persona = "select * from practica7.PERSONA where ID = " + ID + ";";
        ResultSet rs = rebSociStmt.executeQuery(persona);
        while(rs.next()){
            dadesSoci[0] = rs.getString("Nom");
            dadesSoci[1] = rs.getString("Llinatge1");
            dadesSoci[2] = rs.getString("Llinatge2");
            dadesSoci[3] = rs.getString("Data_Naixement");
        }
        rs.close();

        String soci = "select * from practica7.SOCI where ID = " + ID + ";";
        ResultSet rs2 = rebSociStmt.executeQuery(soci);
        while(rs2.next()){
            dadesSoci[4] = rs2.getString("DNI");
        }
        rs2.close();

        return dadesSoci;
    }

    int[] IDDeSocis(String llinatge) throws SQLException {
        LinkedList<Integer> IDSocis = new LinkedList<>();

        Connection conn = this.conn;
        Statement socisStmt = conn.createStatement();
        String socis = "select * from practica7.SOCI, practica7.PERSONA WHERE practica7.SOCI.ID = practica7.PERSONA.ID AND practica7.PERSONA.Llinatge1 LIKE '%" + llinatge + "%';";

        boolean results = socisStmt.execute(socis);
        int rsCount = 0;

        while (results) {
            ResultSet rs = socisStmt.getResultSet();
            while (rs.next()) {
                IDSocis.add(rs.getInt("ID"));
            }
            rs.close();

            results = socisStmt.getMoreResults();
        }
        socisStmt.close();

        int[] ID = new int[IDSocis.size()];
        for (int i = 0; i < ID.length; i++) {
            ID[i] = IDSocis.poll();
        }
        return ID;
    }

    String[] rebLlibre(int ID) throws SQLException {
        String[] dadesLlibre = new String[6];

        Connection conn = this.conn;
        Statement rebSociStmt = conn.createStatement();
        String llibre = "select * from practica7.LLIBRE where ID = " + ID + ";";
        ResultSet rs = rebSociStmt.executeQuery(llibre);
        while(rs.next()){
            dadesLlibre[0] = rs.getString("ISBN");
            dadesLlibre[1] = rs.getString("Titol");
            dadesLlibre[2] = rs.getString("Portada");
            dadesLlibre[3] = rs.getString("Num_Pag");
            dadesLlibre[4] = rs.getString("Editorial");
            dadesLlibre[5] = rs.getString("Autor_FK");
        }
        rs.close();

        String autor = "select * from practica7.AUTOR where ID = " + dadesLlibre[5] + ";";
        ResultSet rs2 = rebSociStmt.executeQuery(autor);
        while(rs2.next()){
            dadesLlibre[5] = rs2.getString("Alies");
        }
        rs2.close();

        return dadesLlibre;
    }

    int[] IDDeLlibres(String titol) throws SQLException {
        LinkedList<Integer> IDLlibres = new LinkedList<>();

        Connection conn = this.conn;
        Statement llibresStmt = conn.createStatement();
        String llibres = "select * from practica7.LLIBRE WHERE practica7.LLIBRE.Titol LIKE '%" + titol + "%';";

        boolean results = llibresStmt.execute(llibres);
        int rsCount = 0;

        while (results) {
            ResultSet rs = llibresStmt.getResultSet();
            while (rs.next()) {
                IDLlibres.add(rs.getInt("ID"));
            }
            rs.close();

            results = llibresStmt.getMoreResults();
        }
        llibresStmt.close();

        int[] ID = new int[IDLlibres.size()];
        for (int i = 0; i < ID.length; i++) {
            ID[i] = IDLlibres.poll();
        }
        return ID;
    }

}
