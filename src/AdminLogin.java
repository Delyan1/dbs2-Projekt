import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin {
    private JTextField welcomeToBookingThTextField;
    private JButton managerOptionsButton;
    private JButton workerOptionsButton;
    private JButton clientOptionsButton;
    private JButton hotelOptionsButton;
    private JButton bookingOptionsButton;
    private JPanel PanelMain;
    private JButton userOptionsButton;

    public AdminLogin() {
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
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new AdminLogin().PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
