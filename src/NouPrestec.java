import sun.awt.image.ImageWatched;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

/**
 * Created by rmariscal on 7/06/17.
 */
public class NouPrestec {
    private JPanel panel;
    private JComboBox comboBox1;
    private JTextField cercaSociLlibreField;
    private JTable sociTable;
    private JTable llibreTable;
    private JRadioButton sociRadioButton;
    private JRadioButton llibreRadioButton;
    private JLabel sociLabel;
    private JLabel bibliotecariLabel;
    private JLabel llibreLabel;
    private JButton cercaButton;
    private JButton afegeixButton;

    public Component getPanel() {
        return panel;
    }

    public NouPrestec() throws SQLException {
        //Treu la llista dels bibliotecaris dins un ComboBox
        LinkedList<Integer> IDBibliotecaris = new LinkedList<>();
        int[] llistaIDBibliotecaris = Main.database.IDDeBibliotecaris();

        for (int i = 0; i < llistaIDBibliotecaris.length; i++) {
            comboBox1.addItem(new Bibliotecari(llistaIDBibliotecaris[i]));
        }


        //Botons, si la cerca es de socis o de llibres
        ButtonGroup sociLlibre = new ButtonGroup();
        sociLlibre.add(sociRadioButton);
        sociLlibre.add(llibreRadioButton);
        sociRadioButton.setSelected(true);

        sociRadioButton.setActionCommand("SOCI");
        llibreRadioButton.setActionCommand("LLIBRE");




        cercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = sociTable.getSelectedRow();
                int col = sociTable.getSelectedColumn();
                System.out.println("Selected row " + row);

                String tipusCerca = sociLlibre.getSelection().getActionCommand();
                String cerca = cercaSociLlibreField.getText();


                if(tipusCerca == "SOCI"){
                    //Llista de socis
                    LinkedList<Soci> llistaSocis = new LinkedList<>();
                    int[] llistaIDSoci = new int[0];
                    try {
                        llistaIDSoci = Main.database.IDDeSocis(cerca);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    for (int i = 0; i < llistaIDSoci.length; i++) {
                        try {
                            llistaSocis.add(new Soci(llistaIDSoci[i]));
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }

                    TableModel modelTaula = new AbstractTableModel() {
                        @Override
                        public int getRowCount() {
                            return llistaSocis.size();
                        }

                        @Override
                        public String getColumnName(int col) {
                            switch(col) {
                                case 0:
                                    return "ID";
                                case 1:
                                    return "DNI";
                                case 2:
                                    return "Nom";
                                case 3:
                                    return "Primer Llinatge";
                                case 4:
                                    return "Segon Llinatge";
                            }
                            throw new RuntimeException("Impossible");
                        }

                        @Override
                        public int getColumnCount() {
                            return 5;
                        }

                        @Override
                        public Object getValueAt(int i, int i1) {
                            Soci s = llistaSocis.get(i);
                            switch(i1) {
                                case 0:
                                    return s.getID();
                                case 1:
                                    return s.getDNI();
                                case 2:
                                    return s.getNom();
                                case 3:
                                    return s.getLlinatge1();
                                case 4:
                                    return s.getLlinatge2();
                            }
                            throw new RuntimeException("Impossible");
                        }
                    };
                    sociTable.setModel(modelTaula);

                }else if(tipusCerca == "LLIBRE"){

                    //Llista de llibres
                    LinkedList<Llibre> llistaLlibres = new LinkedList<>();
                    int[] llistaIDLlibre = new int[0];
                    try {
                        llistaIDLlibre = Main.database.IDDeLlibres(cerca);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    for (int i = 0; i < llistaIDLlibre.length; i++) {
                        try {
                            llistaLlibres.add(new Llibre(llistaIDLlibre[i]));
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }

                    TableModel modelTaula = new AbstractTableModel() {
                        @Override
                        public int getRowCount() {
                            return llistaLlibres.size();
                        }

                        @Override
                        public String getColumnName(int col) {
                            switch(col) {
                                case 0:
                                    return "ID";
                                case 1:
                                    return "ISBN";
                                case 2:
                                    return "Titol";
                                case 3:
                                    return "Portada";
                                case 4:
                                    return "N pàgines";
                                case 5:
                                    return "Editorial";
                                case 6:
                                    return "Autor";
                            }
                            throw new RuntimeException("Impossible");
                        }

                        @Override
                        public int getColumnCount() {
                            return 5;
                        }

                        @Override
                        public Object getValueAt(int i, int i1) {
                            Llibre l = llistaLlibres.get(i);
                            switch(i1) {
                                case 0:
                                    return l.getID();
                                case 1:
                                    return l.getISBN();
                                case 2:
                                    return l.getTitol();
                                case 3:
                                    return l.getPortada();
                                case 4:
                                    return l.getNumPagines();
                                case 5:
                                    return l.getEditorial();
                                case 6:
                                    return l.getAutor();
                            }
                            throw new RuntimeException("Impossible");
                        }
                    };
                    llibreTable.setModel(modelTaula);
                }










            }
        });






    }
}
