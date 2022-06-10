import javax.swing.*;

public class hotelManagerOptions {
    private JButton removeHotelManagerRightsButton;
    private JPanel hotelManagerPAnel;
    private JButton GIveWorkerHotelManagerButton;

    hotelManagerOptions(){

        JFrame frame = new JFrame("Hotel Manager Options");
        frame.add(hotelManagerPAnel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
