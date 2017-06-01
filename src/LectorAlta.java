import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by rmariscal on 1/06/17.
 */
public class LectorAlta {
    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel1) {
        this.panel = panel1;
    }

    public JLabel getDNILabel() {
        return DNILabel;
    }

    public void setDNILabel(JLabel DNILabel) {
        this.DNILabel = DNILabel;
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

    public JLabel getLlinatge2Label() {
        return llinatge2Label;
    }

    public void setLlinatge2Label(JLabel llinatge2Label) {
        this.llinatge2Label = llinatge2Label;
    }

    public JLabel getDataNaixementLabel() {
        return dataNaixementLabel;
    }

    public void setDataNaixementLabel(JLabel dataNaixementLabel) {
        this.dataNaixementLabel = dataNaixementLabel;
    }

    public JLabel getUsuariLabel() {
        return usuariLabel;
    }

    public void setUsuariLabel(JLabel usuariLabel) {
        this.usuariLabel = usuariLabel;
    }

    public JTextField getDNIField() {
        return DNIField;
    }

    public void setDNIField(JTextField DNIField) {
        this.DNIField = DNIField;
    }

    public JLabel getContrasenyaLabel() {
        return contrasenyaLabel;
    }

    public void setContrasenyaLabel(JLabel contrasenyaLabel) {
        this.contrasenyaLabel = contrasenyaLabel;
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

    public JTextField getDataNaiexementField() {
        return dataNaiexementField;
    }

    public void setDataNaiexementField(JTextField dataNaiexementField) {
        this.dataNaiexementField = dataNaiexementField;
    }



    private JPanel panel;
    private JLabel DNILabel;
    private JLabel nomLabel;
    private JLabel llinatge1Label;
    private JLabel llinatge2Label;
    private JLabel dataNaixementLabel;
    private JLabel usuariLabel;
    private JTextField DNIField;
    private JLabel contrasenyaLabel;
    private JTextField nomField;
    private JTextField llinatge1Field;
    private JTextField llinatge2Field;
    private JTextField dataNaiexementField;
    private JButton creaUsuariButton;

    public LectorAlta() {
        creaUsuariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String DNI = DNIField.getText();
                String nom = nomField.getText();
                String llinatge1 = llinatge1Field.getText();
                String llinatge2 = llinatge2Field.getText();
                String dataNaixement = dataNaiexementField.getText();

                try {
                    Main.database.afegeixSoci(DNI, nom, llinatge1, llinatge2, dataNaixement);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
