import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class    transferPanel {
    private JPanel transferPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton acceptButton;



    transferPanel(){
        JFrame frame = new JFrame("Transfer Panel");
        frame.add(transferPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        final String[] mIDnhIDohID= new String[3];


        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==acceptButton){
                    mIDnhIDohID[0] = textField1.getText();
                    mIDnhIDohID[1] = textField2.getText();
                    mIDnhIDohID[2] = textField3.getText();
                    Connection c = DatabaseController.getInstance().getConnectionOrNull("jdbc:oracle:thin:@StudiDB.GM.TH-Koeln.de:1521:vlesung");
                    DatabaseController.transfer(c, Integer.parseInt(mIDnhIDohID[0]),Integer.parseInt(mIDnhIDohID[1]),Integer.parseInt(mIDnhIDohID[2]));

                }
            }
        });
    }
}
