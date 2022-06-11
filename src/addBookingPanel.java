import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class addBookingPanel {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel addBookingPanel1;
    private JTextField textField4;
    private JButton acceptButton;

    addBookingPanel() {
        JFrame frame = new JFrame("Add booking Panel");
        frame.add(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        final String[] mIDnhIDohID= new String[4];


        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==acceptButton){
                    mIDnhIDohID[0] = textField1.getText();
                    mIDnhIDohID[1] = textField2.getText();
                    mIDnhIDohID[2] = textField3.getText();
                    mIDnhIDohID[3]= textField4.getText();
                    Connection c = DatabaseController.getInstance().getConnectionOrNull("jdbc:oracle:thin:@StudiDB.GM.TH-Koeln.de:1521:vlesung");
                    DatabaseController.Insert(c,"BUCHUNG",Integer.parseInt(mIDnhIDohID[0]),Integer.parseInt(mIDnhIDohID[1]),mIDnhIDohID[2],mIDnhIDohID[3]);


            }
            }
        });
    }
}




