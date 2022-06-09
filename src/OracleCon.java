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
        DatabaseController dbc = new DatabaseController();
        Connection con = dbc.getConnectionOrNull("jdbc:oracle:thin:@StudiDB.GM.TH-Koeln.de:1521:vlesung");
        if(con == null){
            System.out.println("connection failed");
            return;
        }
        //printStatus(dbc.Delete(con, "KUNDE", "NUTZER_ID = 55"));
        //printStatus(dbc.Delete(con, "NUTZER", "NUTZER_ID = 55"));
        printStatus(dbc.Insert(con, "nutzer(NUTZER_ID)", 55));
        printStatus(dbc.Insert(con, "KUNDE", 55, "password1", "testmann@gmail.com", "Manuel", "Testmann", "TO_DATE('1996/07/09', 'yyyy/mm/dd'),1 )"));
        printStatus(dbc.Delete(con,"BUCHUNG", "NUTZER_ID = 55"));
        printStatus(dbc.Insert(con,"BUCHUNG", 4, 55, "TO_DATE('2014/08/14', 'yyyy/mm/dd')", "TO_DATE('2014/09/04', 'yyyy/mm/dd')"));


        try{
            Statement stmt=con.createStatement();
           //Ausgeben
            ResultSet rs=stmt.executeQuery("SELECT * FROM nutzer");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));

        /* //Löschen
            PreparedStatement st = con.prepareStatement("DELETE FROM nutzer WHERE NUTZER_ID= 13");
            st.executeUpdate();
        */

        /*   //Inserten 1 NUTZER
            PreparedStatement inserten1 = con.prepareStatement("INSERT INTO nutzer(NUTZER_ID)" + "VALUES(55)");
            inserten1.executeUpdate();
        */

            //INSERT into KUNDE NUTZER 55
        /*
            PreparedStatement inserten1 = con.prepareStatement("INSERT INTO KUNDE VALUES(55,'password1', 'testmann@gmail.com','Manuel', 'Testmann',TO_DATE('1996/07/09', 'yyyy/mm/dd'),1 )");
            inserten1.executeUpdate();
        */


        /*  //UPDATE
            PreparedStatement update1 = con.prepareStatement("UPDATE Kunde SET passwort='Newpasswort00' where NUTZER_ID = 55");
            update1.executeUpdate();
        */

        /*  BONUS_POINTS TRIGGER TEST
            PreparedStatement inserten4 = con.prepareStatement("INSERT INTO BUCHUNG VALUES(4,55,TO_DATE('2014/08/14', 'yyyy/mm/dd'), TO_DATE('2014/09/04', 'yyyy/mm/dd'))");
            inserten4.executeUpdate();
        */

        /*  FUNKTION TRANSFER TEST
            CallableStatement cstmt = con.prepareCall("call transfer(11,30,20)");
            cstmt.executeUpdate();
        */

            ResultSet rs2=stmt.executeQuery("select * from kunde");
            while(rs2.next())
                System.out.println(rs2.getInt(1)+" "+rs2.getString(2)+" "+rs2.getString(3)+" "+rs2.getString(4)+" "+rs2.getString(5)+" "+rs2.getString(6)+" "+rs2.getString(7));

            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
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

