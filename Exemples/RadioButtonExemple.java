
import javax.swing.*;
import java.awt.*;

/**
 * Created by rmariscal on 30/05/17.
 */
public class RadioButtonExemple {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setLayout(new FlowLayout());


        JRadioButton jr1 = new JRadioButton("Groc");
        jr1.setActionCommand("Groc");
        //Queda seleccionat per defecte
        jr1.setSelected(true);

        JRadioButton jr2 = new JRadioButton("verd");
        jr1.setActionCommand("Verd");
        JRadioButton jr3 = new JRadioButton("vermell");
        jr1.setActionCommand("Vermell");

        frame.add(jr1);
        frame.add(jr2);
        frame.add(jr3);

        ButtonGroup bg = new ButtonGroup();
        bg.add(jr1);
        bg.add(jr2);
        bg.add(jr3);

        //agafa el button. Retorna un action command, que es algo que has d'afegir
        bg.getSelection().getActionCommand();

        frame.setVisible(true);



    }
}
