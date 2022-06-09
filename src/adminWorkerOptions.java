import javax.swing.*;

public class adminWorkerOptions {
    private JButton transferWorkerButton;
    private JButton removeWorkerButton;
    private JButton addWorkerButton;
    private JPanel workersPanel;


    adminWorkerOptions(){

        JFrame frame = new JFrame("User Options");
        frame.add(workersPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}