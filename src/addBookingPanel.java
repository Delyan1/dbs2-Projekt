import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.sql.ResultSet;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class addBookingPanel {
    private JPanel Booking;
    private JTextField textField1;
    private JTextField textField2;
    private JButton acceptButton;
    private JTextArea textArea1;
    private JSpinner ADSpinner;
    private JSpinner AMSpinner;
    private JSpinner AYSpinner;
    private JSpinner DDSpinner;
    private JSpinner DMSpinner;
    private JSpinner DYSpinner;

    private static String DateFormat = "DD/MM/YYYY";
    private static String[] Months = {
      "JAN",
      "FEB",
      "MAR",
      "APR",
      "MAY",
      "JUN",
      "JUL",
      "AUG",
      "SEP",
      "OCT",
      "NOV",
      "DEC"
    };

    addBookingPanel() {
        JFrame frame = new JFrame("Add booking Panel");
        frame.setMinimumSize(new Dimension(300, 350));
        frame.add(Booking);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        final String[] mIDnhIDohID= new String[4];


        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==acceptButton){
                    Connection c = DatabaseController.getInstance().getConnectionOrNull("jdbc:oracle:thin:@StudiDB.GM.TH-Koeln.de:1521:vlesung");
                    DatabaseController.Insert(c,"BUCHUNG",Integer.parseInt(textField1.getText()),Integer.parseInt(textField2.getText()),SpinnerToString()[0],SpinnerToString()[1]);
                    try {
                        Statement stmt=c.createStatement();
                        ResultSet rs=stmt.executeQuery("select * from KUNDE WHERE NUTZER_ID = "+ textField2.getText());
                        while(rs.next())
                        textArea1.setText(textArea1.getText() + "Kunde " + rs.getInt("NUTZER_ID")+" hat nun "+ rs.getInt(7)+" Treuepunkte\n");
                    }
                    catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });
    }

    private void createUIComponents() {
        ADSpinner = new JSpinner(new SpinnerNumberModel(1,1,31,1));
        DDSpinner = new JSpinner(new SpinnerNumberModel(1,1,31,1));
        AMSpinner = new JSpinner(new SpinnerListModel(Months));
        DMSpinner = new JSpinner(new SpinnerListModel(Months));
        AYSpinner = new JSpinner(new SpinnerNumberModel(Calendar.getInstance().get(Calendar.YEAR), 1980,null,1));
        DYSpinner = new JSpinner(new SpinnerNumberModel(Calendar.getInstance().get(Calendar.YEAR),1980,null,1));
        AYSpinner.setEditor(new JSpinner.NumberEditor(AYSpinner, "#"));
        DYSpinner.setEditor(new JSpinner.NumberEditor(DYSpinner, "#"));

    }

    private String[] SpinnerToString(){
        String dates[] = new String[2];
        dates[0] = "TO_DATE('" + String.format("%02d",(int)ADSpinner.getValue()) + AMSpinner.getValue().toString() + AYSpinner.getValue().toString() + "', 'DDMONYYYY')";
        dates[1] = "TO_DATE('" + String.format("%02d",(int)DDSpinner.getValue()) + DMSpinner.getValue().toString() + DYSpinner.getValue().toString() + "', 'DDMONYYYY')";
        return dates;
    }
}




