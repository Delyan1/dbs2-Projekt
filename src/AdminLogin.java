import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;


public class AdminLogin {
    private JTextField welcomeToBookingThTextField;
    private JButton managerOptionsButton;
    private JButton workerOptionsButton;
    private JButton clientOptionsButton;
    private JButton hotelOptionsButton;
    private JButton bookingOptionsButton;
    private JPanel PanelMain;
    private JButton userOptionsButton;
    static Connection con1;

    public AdminLogin() {
        userOptionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==userOptionsButton){
                    adminNutzerOptions adminNutzerOptions1 = new adminNutzerOptions(con1);
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
        JFrame frame = new JFrame("App");
        frame.setContentPane(new AdminLogin().PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
