import java.sql.SQLException;

/**
 * Created by rmariscal on 14/06/17.
 */
public class Autor {
    private int ID;
    private String nom;
    private String llinatge1;
    private String llinatge2;
    private String dataNaixement;
    private String nacionalitat;
    private String alies;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getNacionalitat() {
        return nacionalitat;
    }

    public void setNacionalitat(String nacionalitat) {
        this.nacionalitat = nacionalitat;
    }

    public String getAlies() {
        return alies;
    }

    public void setAlies(String alies) {
        this.alies = alies;
    }

    public Autor(int ID) throws SQLException {
        String[] dades = Main.database.rebAutor(ID);
        this.ID  = ID;
        this.nom = dades[0];
        this.llinatge1 = dades[1];
        this.llinatge2 = dades[2];
        this.dataNaixement = dades[3];
        this.nacionalitat = dades[4];
        this.alies = dades[5];


    }
}
