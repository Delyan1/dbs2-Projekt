import javax.swing.*;

public class adminHotelManagerOptions {
    private JButton addClientButton;
    private JButton changePasswordButton;
    private JButton removeClientButton;
    private JPanel clientPanel;

    adminHotelManagerOptions(){

        JFrame frame = new JFrame("Client Options");
        frame.add(clientPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
