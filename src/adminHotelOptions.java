import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Objects;

public class adminHotelOptions {
    private JButton removeHotelButton;
    private JButton addHotelButton;
    private JPanel hotelOptionsPanel;
    private JTable table1;
    private JButton refreshButton;
    private JTextField managerIDTextField;
    private JTextField hotelnameTextField;
    private JTextField classTextField;
    private JTextField adressTextField;

    private boolean update = false;

    adminHotelOptions(){

        JFrame frame = new JFrame("Hotel Options");
        frame.add(hotelOptionsPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });
        removeHotelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table1.getSelectedRow();
                if(row != -1){
                    DatabaseController.getInstance().Delete("HOTEL", "HOTEL_ID = " + table1.getModel().getValueAt( row,0));
                }
                refreshTable();
            }

        });
        addHotelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(addHotelButton.getText() == "Add Hotel"){
                    if(!Objects.equals(managerIDTextField.getText(), "")){
                        if(!Objects.equals(hotelnameTextField.getText(), "")){
                            if (!Objects.equals(classTextField.getText(), "")) {
                                if (!Objects.equals(adressTextField.getText(), "")) {
                                    Connection con = DatabaseController.getInstance().getConnectionOrNull();
                                    int id = 0;
                                    try(Statement stmt = con.createStatement()){
                                        ResultSet rs = stmt.executeQuery("SELECT MAX(HOTEL_ID) MAX_ID FROM HOTEL");
                                        if(rs.next()){
                                            id = rs.getInt("MAX_ID") + 1;
                                        }
                                    }catch(Exception ex){
                                        System.out.println(ex);
                                    }
                                    DatabaseController.getInstance().Insert("HOTEL", id, managerIDTextField.getText(), hotelnameTextField.getText(), classTextField.getText(), adressTextField.getText(), null, null);
                                }
                            }
                        }
                    }

                }
                else{
                    int ID = (int) table1.getModel().getValueAt(table1.getSelectedRow(), 0);
                    ArrayList<String> arrayListColumns = new ArrayList<>();
                    ArrayList<Object> arrayListValues = new ArrayList<>();
                    if(!Objects.equals(managerIDTextField.getText(), "")){arrayListColumns.add("NUTZER_ID"); arrayListValues.add(Integer.parseInt(managerIDTextField.getText()));}
                    if(!Objects.equals(hotelnameTextField.getText(), "")){arrayListColumns.add("HOTELNAME"); arrayListValues.add(hotelnameTextField.getText());}
                    if (!Objects.equals(classTextField.getText(), "")) {arrayListColumns.add("KLASSE"); arrayListValues.add(Integer.parseInt(classTextField.getText()));}
                    if (!Objects.equals(adressTextField.getText(), "")) {arrayListColumns.add("ADRESSE"); arrayListValues.add(adressTextField.getText());}
                    DatabaseController.getInstance().Update("HOTEL", "HOTEL_ID = " + ID, arrayListColumns.toArray(new String[0]), arrayListValues.toArray());
                }
                refreshTable();
            }
        });
    }

    private void refreshTable(){
        String[] columnNames = new String[]{
                "Hotel ID",
                "Manager ID",
                "Hotelname",
                "Class",
                "Adress",
                "Average Room Price",
                "Price/Value"
        };

        Object[][] rowData = getTableData();

        table1.setModel(
                new AbstractTableModel() {
                    public String getColumnName(int column) { return columnNames[column].toString(); }
                    public int getRowCount() { return rowData.length; }
                    public int getColumnCount() { return columnNames.length; }
                    public Object getValueAt(int row, int col) { return rowData[row][col]; }
                    public boolean isCellEditable(int row, int column) { return true; }
                    public void setValueAt(Object value, int row, int col) {
                        rowData[row][col] = value;
                        fireTableCellUpdated(row, col);
                    }
                }
        );
        table1.invalidate();
        table1.validate();
        table1.repaint();
    }

    private Object[][] getTableData(){
        DatabaseController.getInstance().retryConnection();
        Connection con = DatabaseController.getInstance().getConnectionOrNull();
        ArrayList<Object[]> arrayList = new ArrayList<>();
        try(Statement statement = con.createStatement()){
            ResultSet rs = statement.executeQuery("SELECT * FROM HOTEL");
            while(rs.next()){
                Object[] entry = new Object[7];
                entry[0] = rs.getInt("HOTEL_ID");
                entry[1] = rs.getInt("NUTZER_ID");
                entry[2] = rs.getString("HOTELNAME");
                entry[3] = rs.getInt("KLASSE");
                entry[4] = rs.getString("ADRESSE");
                entry[5] = rs.getFloat("DURCHSCHNITTSZIMMERPREIS");
                entry[6] = rs.getFloat("PREISLEISTUNG");
                arrayList.add(entry);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        Object[][] array = new Object[arrayList.size()][];
        arrayList.toArray(array);
        return array;
    }

    private void createUIComponents() {
        String[] names = new String[]{
                "Hotel ID",
                "Manager ID",
                "Hotelname",
                "Class",
                "Adress",
                "Average Room Price",
                "Price/Value"
        };
        Object[][] data = getTableData();
        table1 = new JTable(data, names){
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };;
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel selectionModel = table1.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(table1.getSelectedRow() != -1){
                    addHotelButton.setText("Update Hotel");
                }
                else{
                    addHotelButton.setText("Add Hotel");
                }
                addHotelButton.invalidate();
                addHotelButton.validate();
                addHotelButton.repaint();
            }
        });

    }
}
