import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class DatabaseController {
    public Connection getConnectionOrNull(String URL) {
        Connection con;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection( URL,"inf1300", "wirbestehen195");
        } catch (Exception e) {
            System.out.println("\u001B[31m" + e + "\u001B[0m");
            con = null;
        }
        return con;
    }

    public boolean Delete(Connection connection, String Tablename, String Condition){
        try{
            PreparedStatement st = connection.prepareStatement("DELETE FROM " + Tablename + " WHERE " + Condition);
            st.executeUpdate();
        }catch(Exception e){
            System.out.println("\u001B[31m" + e + "\u001B[0m");
            return false;
        }
        return true;
    }

    public boolean Insert(Connection connection, String Tablename, Object... values) {
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO " + Tablename + " " + createValueString(values));
            st.executeUpdate();
        }catch(Exception e){
            System.out.println("\u001B[31m" + e + "\u001B[0m");
            return false;
        }
        return true;
    }

    public String createValueString(Object... values){
        StringBuilder valuestring = new StringBuilder("VALUES(");
        for(Object a: Arrays.stream(values).toArray()){
            if(a instanceof String) {
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
}
