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

    public static void main(String args[]) {
        Connection con = DatabaseController.getInstance().getConnectionOrNull("jdbc:oracle:thin:@StudiDB.GM.TH-Koeln.de:1521:vlesung");
        if(con == null){
            System.out.println("connection failed");
            return;
        }

        try{
            Statement stmt=con.createStatement();
            ResultSet rs2=stmt.executeQuery("select * from HOTELMITARBEITER");
            while(rs2.next())
                System.out.println(rs2.getInt(1)+" "+rs2.getString(2)+" "+rs2.getString(3)+" "+rs2.getString(4)+" "+rs2.getString(5)+" "+rs2.getString(6)+" "+rs2.getString(7));

        }catch (Exception e){}

        printStatus(DatabaseController.Delete(con,"BUCHUNG", "NUTZER_ID = 55"));
        printStatus(DatabaseController.Delete(con, "KUNDE", "NUTZER_ID = 55"));
        printStatus(DatabaseController.Delete(con, "NUTZER", "NUTZER_ID = 55"));
        printStatus(DatabaseController.Insert(con, "NUTZER(NUTZER_ID)", 55));
        printStatus(DatabaseController.Insert(con, "KUNDE", 55, "password1", "testmann@gmail.com", "Manuel", "Testmann", "TO_DATE('1996/07/09', 'yyyy/mm/dd')", 1));
        printStatus(DatabaseController.Insert(con,"BUCHUNG", 4, 55, "TO_DATE('2014/08/14', 'yyyy/mm/dd')", "TO_DATE('2014/09/04', 'yyyy/mm/dd')"));
        System.out.println(DatabaseController.currentClients(con));
        System.out.println(DatabaseController.averageAge(con));

        try{
            Statement stmt=con.createStatement();
            ResultSet rs2=stmt.executeQuery("select * from HOTELMITARBEITER");
            while(rs2.next())
                System.out.println(rs2.getInt(1)+" "+rs2.getString(2)+" "+rs2.getString(3)+" "+rs2.getString(4)+" "+rs2.getString(5)+" "+rs2.getString(6)+" "+rs2.getString(7));

        }catch (Exception e){}

        DatabaseController.getInstance().Close();
    }

    static void printStatus(boolean success){
        if(success){
            System.out.println("Operation successful");
        }
        else{
            System.out.println("Operation failed");
        }
    }
}

