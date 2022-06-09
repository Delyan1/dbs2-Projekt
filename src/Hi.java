import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
class OracleCon{
    public static void main(String args[]){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection( "jdbc:oracle:thin:@StudiDB.GM.TH-Koeln.de:1521:vlesung","inf1300", "wirbestehen195");

            Statement stmt=con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO kunde VALUES(?, ?)");

           //Ausgeben
            ResultSet rs=stmt.executeQuery("select * from nutzer");

           while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)       );

            ResultSet rs2=stmt.executeQuery("select * from kunde");
            while(rs2.next())
                System.out.println(rs2.getInt(1)+"  "+rs2.getString(2)+"  "+rs2.getString(3)+"  "+rs2.getString(4)+"  "+rs2.getString(5)+"  "+rs2.getString(6)+"  "+rs2.getString(7)       );

            con.close();

        }
        catch(Exception e){ System.out.println(e);}


    }
}

