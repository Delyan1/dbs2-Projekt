import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class editUserPanel {
    private JTextField textField1;
    private JButton acceptButton;
    private JPanel deleteUserPanel1;
    private JButton addButton;
    final String[] ID= new String[1];


    public editUserPanel() {

        JFrame frame = new JFrame("Modify User");
        frame.add(deleteUserPanel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==acceptButton){
                    ID[0] = textField1.getText();
                    Connection c = DatabaseController.getInstance().getConnectionOrNull("jdbc:oracle:thin:@StudiDB.GM.TH-Koeln.de:1521:vlesung");
                    DatabaseController.Delete(c,"BUCHUNG","NUTZER_ID="+ID[0]);
                    DatabaseController.Delete(c,"NUTZER","NUTZER_ID="+ID[0]);
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==addButton){
                    ID[0] = textField1.getText();
                    Connection c = DatabaseController.getInstance().getConnectionOrNull("jdbc:oracle:thin:@StudiDB.GM.TH-Koeln.de:1521:vlesung");
                    DatabaseController.Insert(c,"NUTZER",Integer.parseInt(ID[0]),null,null,null,null,null);
                }

            }
        });
    }
}

