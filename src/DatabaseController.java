import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Locale;

public class DatabaseController {
    private static final DatabaseController dbc = new DatabaseController();
    private Connection con = null;

    private DatabaseController(){
    }

    public static DatabaseController getInstance(){
        return dbc;
    }

    public Connection getConnectionOrNull(String URL) {
        if(con == null){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection( URL,"inf1300", "wirbestehen195");
                con.setAutoCommit(true);
            } catch (Exception e) {
                System.out.println("\u001B[31m" + e + "\u001B[0m");
                con = null;
            }
        }
        return con;
    }
    public Connection getConnectionOrNull() {
        return con;
    }

    public static boolean Delete(Connection connection, String Tablename, String Condition){
        try{
            PreparedStatement st = connection.prepareStatement("DELETE FROM " + Tablename + " WHERE " + Condition);
            st.executeUpdate();
        }catch(Exception e){
            System.out.println("\u001B[31m" + e + "\u001B[0m");
            return false;
        }
        return true;
    }
    public boolean Delete(String Tablename, String Condition){
        return Delete(con, Tablename, Condition);
    }

    public static boolean Insert(Connection connection, String Tablename, Object... values) {
        String valueString = createValueString(values);
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO " + Tablename + " " + valueString);
            st.executeUpdate();
        }catch(Exception e){
            System.out.println("\u001B[31m" + e + "\u001B[0m");
            return false;
        }
        return true;
    }

    public boolean Insert(String Tablename, Object... values) {
        return Insert(con, Tablename, values);
    }

    public static String createValueString(Object... values){
        StringBuilder valuestring = new StringBuilder("VALUES(");
        for(Object a: Arrays.stream(values).toArray()){
            if(a instanceof String && !((String) a).startsWith("TO_DATE")) {
                valuestring.append("'" + a + "'");
            }
            else{
                valuestring.append(a);
            }
            valuestring.append(", ");
        }
        valuestring.delete(valuestring.length()-2, valuestring.length()-1);
        valuestring.append(")");
        return valuestring.toString();
    }

    public static String currentClients(Connection connection){
        String output = "";
        try{
            CallableStatement callableStatement = connection.prepareCall("call KUNDEANREISE(?)");
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.executeUpdate();
            output = callableStatement.getString(1);
        }catch(Exception e){
            System.out.println("\u001B[31m" + e + "\u001B[0m");
        }
        return output;
    }

    public String currentClients(){
        return currentClients(con);
    }

    public static void transfer(Connection connection, int User_ID, int Hotel_ID_from, int Hotel_ID_to){
        try{
            CallableStatement callableStatement = connection.prepareCall("call TRANSFER(?, ?, ?)");
            callableStatement.setInt(1,User_ID);
            callableStatement.setInt(2, Hotel_ID_to);
            callableStatement.setInt(3, Hotel_ID_from);
            callableStatement.executeUpdate();
        }catch(Exception e){
            System.out.println("\u001B[31m" + e + "\u001B[0m");
        }
    }
    public void transfer( int User_ID, int Hotel_ID_from, int Hotel_ID_to){
        transfer(con, User_ID, Hotel_ID_from, Hotel_ID_to);
    }

    public static float averageAge(Connection connection){
        float res = 0f;
        try{
            CallableStatement callableStatement = connection.prepareCall("{? = call AVERAGE_AGE()}");
            callableStatement.registerOutParameter(1, Types.FLOAT);
            callableStatement.executeUpdate();
            res = callableStatement.getFloat(1);
        }catch(Exception e){
            System.out.println("\u001B[31m" + e + "\u001B[0m");
        }
        return res;
    }

    public float averageAge(){
        return averageAge(con);
    }

    public static float income(Connection connection, int Hotel_ID){
        float res = 0f;
        try{
            CallableStatement callableStatement = connection.prepareCall("{? = call EINNAHME()}");
            callableStatement.registerOutParameter(1, Types.NUMERIC);
            callableStatement.executeUpdate();
            res = callableStatement.getFloat(1);
        }catch(Exception e){
            System.out.println("\u001B[31m" + e + "\u001B[0m");
        }
        return res;
    }
    public float income(int Hotel_ID){
        return income(con, Hotel_ID);
    }



    public void Close(){
        try{
            con.close();
        }catch(Exception e){
            System.out.println("\u001B[31m" + e + "\u001B[0m");
        }
        con = null;
    }
}
