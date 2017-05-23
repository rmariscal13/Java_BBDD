import javax.swing.*;

/**
 * Created by rmariscal on 23/05/17.
 */
public class Main {
    public static void main(String[] args) {
        MainForm mf = new MainForm();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mf.getPanel());
        frame.setSize(500, 500);
        frame.setVisible(true);


    }

}
