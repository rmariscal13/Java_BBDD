import com.mysql.jdbc.NotUpdatable;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by rmariscal on 14/06/17.
 */
public class NouLlibre {
    private JPanel panel;
    private JTextField ISBNField;
    private JTextField titolField;
    private JTextField portadaField;
    private JTextField numPaginesField;
    private JTextField editorialField;
    private JTable autorTable;
    private JTextField autorField;
    private JButton cercaButton;
    private JButton afegeixButton;
    private JLabel ISBNLabel;
    private JLabel titolLabel;
    private JLabel portadaLabel;
    private JLabel nPaginesLabel;
    private JLabel editorialLabel;
    private JLabel autorLabel;

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JTextField getISBNField() {
        return ISBNField;
    }

    public void setISBNField(JTextField ISBNField) {
        this.ISBNField = ISBNField;
    }

    public JTextField getTitolField() {
        return titolField;
    }

    public void setTitolField(JTextField titolField) {
        this.titolField = titolField;
    }

    public JTextField getPortadaField() {
        return portadaField;
    }

    public void setPortadaField(JTextField portadaField) {
        this.portadaField = portadaField;
    }

    public JTextField getNumPaginesField() {
        return numPaginesField;
    }

    public void setNumPaginesField(JTextField numPaginesField) {
        this.numPaginesField = numPaginesField;
    }

    public JTextField getEditorialField() {
        return editorialField;
    }

    public void setEditorialField(JTextField editorialField) {
        this.editorialField = editorialField;
    }

    public JTable getAutorTable() {
        return autorTable;
    }

    public void setAutorTable(JTable autorTable) {
        this.autorTable = autorTable;
    }

    public JTextField getAutorField() {
        return autorField;
    }

    public void setAutorField(JTextField autorField) {
        this.autorField = autorField;
    }

    public JButton getCercaButton() {
        return cercaButton;
    }

    public void setCercaButton(JButton cercaButton) {
        this.cercaButton = cercaButton;
    }

    public JButton getAfegeixButton() {
        return afegeixButton;
    }

    public void setAfegeixButton(JButton afegeixButton) {
        this.afegeixButton = afegeixButton;
    }

    public JLabel getISBNLabel() {
        return ISBNLabel;
    }

    public void setISBNLabel(JLabel ISBNLabel) {
        this.ISBNLabel = ISBNLabel;
    }

    public JLabel getTitolLabel() {
        return titolLabel;
    }

    public void setTitolLabel(JLabel titolLabel) {
        this.titolLabel = titolLabel;
    }

    public JLabel getPortadaLabel() {
        return portadaLabel;
    }

    public void setPortadaLabel(JLabel portadaLabel) {
        this.portadaLabel = portadaLabel;
    }

    public JLabel getnPaginesLabel() {
        return nPaginesLabel;
    }

    public void setnPaginesLabel(JLabel nPaginesLabel) {
        this.nPaginesLabel = nPaginesLabel;
    }

    public JLabel getEditorialLabel() {
        return editorialLabel;
    }

    public void setEditorialLabel(JLabel editorialLabel) {
        this.editorialLabel = editorialLabel;
    }

    public JLabel getAutorLabel() {
        return autorLabel;
    }

    public void setAutorLabel(JLabel autorLabel) {
        this.autorLabel = autorLabel;
    }

    public NouLlibre(){
        cercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cerca = autorField.getText();

                //Llista de autors
                LinkedList<Autor> llistaAutors = new LinkedList<>();
                int[] llistaIDAutor = new int[0];
                try {
                    llistaIDAutor = Main.database.IDDeAutors(cerca);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                for (int i = 0; i < llistaIDAutor.length; i++) {
                    try {
                        llistaAutors.add(new Autor(llistaIDAutor[i]));
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }


                TableModel modelTaula = new AbstractTableModel() {
                    @Override
                    public int getRowCount() {
                        return llistaAutors.size();
                    }

                    @Override
                    public String getColumnName(int col) {
                        switch(col) {
                            case 0:
                                return "ID";
                            case 1:
                                return "Nom";
                            case 2:
                                return "Primer Llinatge";
                            case 3:
                                return "Segon Llinatge";
                            case 4:
                                return "Alies";
                        }
                        throw new RuntimeException("Impossible");
                    }

                    @Override
                    public int getColumnCount() {
                        return 5;
                    }

                    @Override
                    public Object getValueAt(int i, int i1) {
                        Autor a = llistaAutors.get(i);
                        switch(i1) {
                            case 0:
                                return a.getID();
                            case 1:
                                return a.getNom();
                            case 2:
                                return a.getLlinatge1();
                            case 3:
                                return a.getLlinatge2();
                            case 4:
                                return a.getAlies();
                        }
                        throw new RuntimeException("Impossible");
                    }
                };
                autorTable.setModel(modelTaula);



            }
        });

        afegeixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ISBN = Integer.parseInt(ISBNField.getText());
                String titol = titolField.getText();
                String portada = portadaField.getText();
                int numPagines = Integer.parseInt(numPaginesField.getText());
                String editorial = editorialField.getText();
                int autor = (int)autorTable.getValueAt(autorTable.getSelectedRow(), 0);


                try {
                    Main.database.afegeixLlibre(ISBN, titol, portada, numPagines, editorial, autor);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }

}
