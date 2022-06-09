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
        getConnectionOrNull("jdbc:oracle:thin:@StudiDB.GM.TH-Koeln.de:1521:vlesung");
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

    public static float averageAge(Connection connection){
        float res = 0f;
        try{
            CallableStatement callableStatement = connection.prepareCall("call AVERAGE_AGE()");
            callableStatement.registerOutParameter(1, Types.FLOAT);
            callableStatement.executeUpdate();
            res = callableStatement.getFloat(1);
        }catch(Exception e){
            System.out.println("\u001B[31m" + e + "\u001B[0m");
        }
        return res;
    }
}
