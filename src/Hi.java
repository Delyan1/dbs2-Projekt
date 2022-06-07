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
           /* //Löschen
            PreparedStatement st = con.prepareStatement("DELETE FROM nutzer WHERE NUTZER_ID= 13");
            st.executeUpdate();*/

         /*   //Inserten 1 NUTZER
            PreparedStatement inserten1 = con.prepareStatement("INSERT INTO nutzer(NUTZER_ID)" + "VALUES(55)");
            inserten1.executeUpdate();*/

            //INSERT into KUNDE NUTZER 55
          /*  PreparedStatement inserten1 = con.prepareStatement("INSERT INTO KUNDE VALUES(55,'password1', 'testmann@gmail.com','Manuel', 'Testmann',TO_DATE('1996/07/09', 'yyyy/mm/dd'),1 )");
            inserten1.executeUpdate();*/

            /*update
            PreparedStatement update1 = con.prepareStatement("UPDATE Kunde SET passwort='Newpasswort00' where NUTZER_ID = 55");
            update1.executeUpdate();
             */

            /*BONUS_POINTS TRIGGER TEST
            PreparedStatement inserten4 = con.prepareStatement("INSERT INTO BUCHUNG VALUES(4,55,TO_DATE('2014/08/14', 'yyyy/mm/dd'), TO_DATE('2014/09/04', 'yyyy/mm/dd'))");
            inserten4.executeUpdate();
            */

            /* FUNKTION TRANSFER TEST
            CallableStatement cstmt = con.prepareCall("call transfer(11,30,20)");
            cstmt.executeUpdate();
            */
            ResultSet rs2=stmt.executeQuery("select * from kunde");
            while(rs2.next())
                System.out.println(rs2.getInt(1)+"  "+rs2.getString(2)+"  "+rs2.getString(3)+"  "+rs2.getString(4)+"  "+rs2.getString(5)+"  "+rs2.getString(6)+"  "+rs2.getString(7)       );

            con.close();






        }
        catch(Exception e){ System.out.println(e);}


    }
}

