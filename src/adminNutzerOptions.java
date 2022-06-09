import javax.swing.*;

public class adminNutzerOptions {
    private JPanel useroptionspanel;
    private JButton deleteUserButton;
    private JButton addUserButton;


    adminNutzerOptions(){

        JFrame frame = new JFrame("User Options");
        frame.add(useroptionspanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
