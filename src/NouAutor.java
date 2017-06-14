import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by rmariscal on 14/06/17.
 */
public class NouAutor {
    private JPanel panel1;
    private JTextField nomField;
    private JTextField llinatge1Field;
    private JTextField llinatge2Field;
    private JTextField dataNaixementField;
    private JTextField nacionalitatField;
    private JTextField aliesField;
    private JButton afegeixButton;
    private JLabel nomLabel;
    private JLabel llinatge1Label;
    private JLabel lliantge2Label;
    private JLabel dataNaixementLabel;
    private JLabel nacionalitatLabel;
    private JLabel aliesLabel;

    public JPanel getPanel() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JTextField getNomField() {
        return nomField;
    }

    public void setNomField(JTextField nomField) {
        this.nomField = nomField;
    }

    public JTextField getLlinatge1Field() {
        return llinatge1Field;
    }

    public void setLlinatge1Field(JTextField llinatge1Field) {
        this.llinatge1Field = llinatge1Field;
    }

    public JTextField getLlinatge2Field() {
        return llinatge2Field;
    }

    public void setLlinatge2Field(JTextField llinatge2Field) {
        this.llinatge2Field = llinatge2Field;
    }

    public JTextField getDataNaixementField() {
        return dataNaixementField;
    }

    public void setDataNaixementField(JTextField dataNaixementField) {
        this.dataNaixementField = dataNaixementField;
    }

    public JTextField getNacionalitatField() {
        return nacionalitatField;
    }

    public void setNacionalitatField(JTextField nacionalitatField) {
        this.nacionalitatField = nacionalitatField;
    }

    public JTextField getAliesField() {
        return aliesField;
    }

    public void setAliesField(JTextField aliesField) {
        this.aliesField = aliesField;
    }

    public JButton getAfegeixButton() {
        return afegeixButton;
    }

    public void setAfegeixButton(JButton afegeixButton) {
        this.afegeixButton = afegeixButton;
    }

    public JLabel getNomLabel() {
        return nomLabel;
    }

    public void setNomLabel(JLabel nomLabel) {
        this.nomLabel = nomLabel;
    }

    public JLabel getLlinatge1Label() {
        return llinatge1Label;
    }

    public void setLlinatge1Label(JLabel llinatge1Label) {
        this.llinatge1Label = llinatge1Label;
    }

    public JLabel getLliantge2Label() {
        return lliantge2Label;
    }

    public void setLliantge2Label(JLabel lliantge2Label) {
        this.lliantge2Label = lliantge2Label;
    }

    public JLabel getDataNaixementLabel() {
        return dataNaixementLabel;
    }

    public void setDataNaixementLabel(JLabel dataNaixementLabel) {
        this.dataNaixementLabel = dataNaixementLabel;
    }

    public JLabel getNacionalitatLabel() {
        return nacionalitatLabel;
    }

    public void setNacionalitatLabel(JLabel nacionalitatLabel) {
        this.nacionalitatLabel = nacionalitatLabel;
    }

    public JLabel getAliesLabel() {
        return aliesLabel;
    }

    public void setAliesLabel(JLabel aliesLabel) {
        this.aliesLabel = aliesLabel;
    }



    public NouAutor(){
        afegeixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = nomField.getText();
                String llinatge1 = llinatge1Field.getText();
                String llinatge2 = llinatge2Field.getText();
                String dataNaixement = dataNaixementField.getText();
                String nacionalitat = nacionalitatField.getText();
                String alies = aliesField.getText();

                try {
                    Main.database.afegeixAutor(nacionalitat, alies, nom, llinatge1, llinatge2, dataNaixement);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

}
