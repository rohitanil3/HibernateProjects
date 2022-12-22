import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Myconn {

	

public static void main(String args[]){  
try{  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/hb_student_tracker","hbstudent","hbstudent");  
//here sonoo is database name, root is username and password  
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from student");  
System.out.println(rs.next());
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
con.close();  
}catch(Exception e){ System.out.println(e);}  
}  
}
