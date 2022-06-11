import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminBookingOptions {
    private JPanel adminBookingPanel;
    private JButton addBookingButton;
    private JButton removeBookingButton;
    private JButton changeBookingButton;

    adminBookingOptions(){

        JFrame frame = new JFrame("User Options");
        frame.add(adminBookingPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        addBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==addBookingButton){{
                    addBookingPanel addBookingPanel1 = new addBookingPanel();
                }}
            }
        });
    }
}

