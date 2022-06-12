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
                    editUserPanel editUserPanel1 = new editUserPanel();
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

    public JPanel getPanelMain(){
        return PanelMain;
    }
}
