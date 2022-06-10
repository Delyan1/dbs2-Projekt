import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class adminNutzerOptions {
    private JPanel useroptionspanel;
    private JButton deleteUserButton;
    private JButton addUserButton;

    adminNutzerOptions(){
        JFrame frame = new JFrame("User Options");
        frame.add(useroptionspanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
    }
}
