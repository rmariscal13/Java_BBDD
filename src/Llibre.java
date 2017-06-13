import java.sql.SQLException;

/**
 * Created by rmariscal on 13/06/17.
 */
public class Llibre {
    private int ID;
    private int ISBN;
    private String titol;
    private String portada;
    private int numPagines;
    private String editorial;
    private String autor;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public int getNumPagines() {
        return numPagines;
    }

    public void setNumPagines(int numPagines) {
        this.numPagines = numPagines;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Llibre(int ID) throws SQLException {
        String[] dades = Main.database.rebLlibre(ID);
        this.ID = ID;
        this.ISBN = Integer.parseInt(dades[0]);
        this.titol = dades[1];
        this.portada = dades[2];
        this.numPagines = Integer.parseInt(dades[3]);
        this.editorial = dades[4];
        this.autor = dades[5];
    }
}
