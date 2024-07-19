package DDT;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class InsertDataToDataBase {

	public static void main(String[] args) throws Throwable {
		Driver driverRef = new Driver();
	    DriverManager.registerDriver(driverRef);
	
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/surabhi", "root", "tiger");
	    Statement stat = connection.createStatement();
	    String query = "insert into student(first_name,last_name,address)values('shobha','rani','goa')";
	    int result = stat.executeUpdate(query);
	
	    if(result==1)
	    {
	    	System.out.println("data updated");
	    }
	    else
	    {
	    	System.out.println("not updated");
	    }
	}
}


	
	



	


