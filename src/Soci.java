import java.sql.SQLException;

/**
 * Created by rmariscal on 6/06/17.
 */
public class Soci {
    private int ID;
    private String DNI;
    private String nom;
    private String llinatge1;
    private String llinatge2;
    private String dataNaixement;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLlinatge1() {
        return llinatge1;
    }

    public void setLlinatge1(String llinatge1) {
        this.llinatge1 = llinatge1;
    }

    public String getLlinatge2() {
        return llinatge2;
    }

    public void setLlinatge2(String llinatge2) {
        this.llinatge2 = llinatge2;
    }

    public String getDataNaixement() {
        return dataNaixement;
    }

    public void setDataNaixement(String dataNaixement) {
        this.dataNaixement = dataNaixement;
    }

    public Soci(int ID) throws SQLException {
        String[] dades = Main.database.rebSoci(ID);
        this.ID  = ID;
        this.nom = dades[0];
        this.llinatge1 = dades[1];
        this.llinatge2 = dades[2];
        this.dataNaixement = dades[3];
        this.DNI = dades[4];


    }

}
