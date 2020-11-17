import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connector {
    Connection c;
    Statement s;
    public Connector(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql:///AtmProject","root","");
            s= c.createStatement();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
