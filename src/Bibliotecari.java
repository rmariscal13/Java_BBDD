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
