import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;


public class AdminLogin {
    private JButton managerOptionsButton;
    private JButton workerOptionsButton;
    private JButton clientOptionsButton;
    private JButton hotelOptionsButton;
    private JButton bookingOptionsButton;
    private JPanel PanelMain;
    private JButton userOptionsButton;

    public AdminLogin(JFrame frame) {
        userOptionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==userOptionsButton){
                    adminNutzerOptions adminNutzerOptions1 = new adminNutzerOptions();
                }
            }
        });
        workerOptionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==workerOptionsButton){
                    adminWorkerOptions adminWorkerOptions1 = new adminWorkerOptions();
                }
            }
        });
        hotelOptionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== hotelOptionsButton){
                    adminHotelOptions adminHotelOptions1 = new adminHotelOptions();
                }
            }
        });
        clientOptionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==clientOptionsButton){
                    adminHotelManagerOptions clientAdminOptions1 = new adminHotelManagerOptions();
                }
            }
        });
        managerOptionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== managerOptionsButton){
                    hotelManagerOptions hotelManagerOptions1= new hotelManagerOptions();
                }
            }
        });
        bookingOptionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==bookingOptionsButton){
                    adminBookingOptions adminBookingOptions1 = new adminBookingOptions();
                }
            }
        });
    }

    public static void main(String[] args) {
        DatabaseController.getInstance().getConnectionOrNull("jdbc:oracle:thin:@StudiDB.GM.TH-Koeln.de:1521:vlesung");
        JFrame frame = new JFrame("App");
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }
            @Override
            public void windowClosing(WindowEvent e) {

            }
            @Override
            public void windowClosed(WindowEvent e) {
                DatabaseController.getInstance().Close();
            }
            @Override
            public void windowIconified(WindowEvent e) {

            }
            @Override
            public void windowDeiconified(WindowEvent e) {

            }
            @Override
            public void windowActivated(WindowEvent e) {

            }
            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        frame.setContentPane(new AdminLogin(frame).PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setMinimumSize(new Dimension(300,300));
        frame.setVisible(true);

    }
}
