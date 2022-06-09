import javax.swing.*;

public class adminBookingOptions {
    private JPanel adminBookingPanel;
    private JButton addBookingButton;
    private JButton removeBookingButton;
    private JButton changeBookingButton;

    adminBookingOptions(){

        JFrame frame = new JFrame("User Options");
        frame.add(adminBookingPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

