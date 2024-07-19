package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.jdbc.Driver;
import java.sql.SQLException;

public class FetchDataFromDataBase {

	public static void main(String[] args) throws Throwable {
		//Step1:- Register/ load the mysql database
		//Step1:- Register/ load the mysql database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step2:-get connection to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_details","tiger" ,"tiger");

		//step3:- create Sql statement
		Statement state = conn.createStatement();
		String query = "select * from student";
		
		//step4:- execute statement/query
		ResultSet result = state.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		//step5:- close the connection.
		conn.close();
		}
	}
