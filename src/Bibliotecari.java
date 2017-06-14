import java.sql.SQLException;

/**
 * Created by rmariscal on 7/06/17.
 */
public class Bibliotecari {
    int ID;
    String nom;
    String llinatge1;
    String llinatge2;
    String dataNaixement;
    String DNI;

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

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }


    Bibliotecari(int ID) throws SQLException {
        String[] dades = Main.database.rebBibliotecari(ID);
        this.ID  = ID;
        this.nom = dades[0];
        this.llinatge1 = dades[1];
        this.llinatge2 = dades[2];
        this.dataNaixement = dades[3];
        this.DNI = dades[4];
    }

    public String toString(){
        return this.DNI + " " + this.nom + " " + this.llinatge1;
    }
}
