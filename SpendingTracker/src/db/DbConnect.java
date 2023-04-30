// creating a database connect class so we dont have to write repetitive code every time from 10-13
package db;
import java.sql.*; //loading jdbc package
import javax.swing.JOptionPane;
public class DbConnect {
    public static Connection c;
    public static Statement st,st1;
    static{ //using static so it can be exited when the class is been called. right now the variable c and st values are null , so static is used to set values in the variable when the class is loaded
        try{ 
            //using a static class driverManager
            c=DriverManager.getConnection(
      "jdbc:mysql://localhost:3306/spendingdb"+"?useSSL=false", //path where connection is being done
                 "root", "root");
            st=c.createStatement(); //st being a statement that will be used everytime
            st1=c.createStatement(); //st being a statement that will be used everytime
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
