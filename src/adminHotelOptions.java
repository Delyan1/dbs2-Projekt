import javax.swing.*;

public class adminHotelOptions {
    private JButton removeHotelButton;
    private JButton addHotelButton;
    private JButton changeHotelManagerButton;
    private JPanel hotelOptionsPanel;

    adminHotelOptions(){

        JFrame frame = new JFrame("Hotel Options");
        frame.add(hotelOptionsPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
