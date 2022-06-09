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

public class transferPanel {
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
        String mitarbeiterId = textField1.getText();
        String newhotelID = textField2.getText();
        String oldhotelID = textField3.getText();


        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==acceptButton){
                    try{
                        Class.forName("oracle.jdbc.driver.OracleDriver");

                        Connection con = DriverManager.getConnection( "jdbc:oracle:thin:@StudiDB.GM.TH-Koeln.de:1521:vlesung","inf1300", "wirbestehen195");
                        con.close();

                    }
                    catch(Exception a){ System.out.println(e);}



                }
            }
        });
    }
}
