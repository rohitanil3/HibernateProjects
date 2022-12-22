import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Myconn {

	

public static void main(String args[]){  
try{  
Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni","hbstudent","hbstudent");  
System.out.println("conn "+con);
con.close();  
}catch(Exception e){ System.out.println(e);}  
}  
}
