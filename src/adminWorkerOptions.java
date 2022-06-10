import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
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

public class adminWorkerOptions {
    private JButton transferWorkerButton;
    private JButton removeWorkerButton;
    private JButton addWorkerButton;
    private JPanel workersPanel;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private String myString;




    adminWorkerOptions(){

        JFrame frame = new JFrame("Worker Options");
        frame.add(workersPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        transferWorkerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == transferWorkerButton) {
                        transferPanel transferPanel1 = new transferPanel();
                    }


            }
        });
    }
}