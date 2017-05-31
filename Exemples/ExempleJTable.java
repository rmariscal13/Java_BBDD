import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

/**
 * Created by rmariscal on 30/05/17.
 */
public class ExempleJTable {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setLayout(new BorderLayout());

        JTable table = new JTable();
        MyTableModel mtb = new MyTableModel();
        table.setModel(mtb);

        //El scroll es per poder fer scroll. Important
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        Button b = new Button("get");
        frame.add(b, BorderLayout.SOUTH);


        frame.setVisible(true);

    }

    //Clase taula s'encarrega de mostrar dades
    //Clase model s'encarrega de tractar les dades
    static class MyTableModel extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return 2;
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return "Res";
        }
    }

}
