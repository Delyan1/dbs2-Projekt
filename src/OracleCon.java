import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


class OracleCon{

    public static void main(String args[]) {
        //DatabaseController.getInstance().getConnectionOrNull("jdbc:oracle:thin:@StudiDB.GM.TH-Koeln.de:1521:vlesung");

        JFrame frame = new JFrame("App");
        frame.setContentPane(Menu());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //DatabaseController.getInstance().Close();
    }

    static void printStatus(boolean success){
        if(success){
            System.out.println("Operation successful");
        }
        else{
            System.out.println("Operation failed");
        }
    }

    static JPanel Menu(){
        JPanel window = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 0;
        window.add(new Label("Welcome to Booking.TH"), c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.2;
        c.gridx = 0;
        c.gridy = 1;
        window.add(new Button("Client Options"),c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.2;
        c.gridx = 0;
        c.gridy = 2;
        window.add(new Button("Hotel Options"),c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.2;
        c.gridx = 0;
        c.gridy = 3;
        window.add(new Button("Worker Options"),c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.2;
        c.gridx = 0;
        c.gridy = 4;
        window.add(new Button("Manager Options"),c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.2;
        c.gridx = 0;
        c.gridy = 5;
        window.add(new Button("User Options"),c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.2;
        c.gridx = 0;
        c.gridy = 6;
        window.add(new Button("Booking Options"),c);
        return window;
    }
}

