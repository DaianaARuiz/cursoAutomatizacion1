package pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.testng.annotations.Test;

public class AccesoBaseDeDatos {
	
	@Test
	public void testBaseDeDatos() throws ClassNotFoundException, SQLException{
		//Connection URL Syntax
		String dbURL = "jdbc:mysql://";
		//Database Username
		String username = "root";
		//Database Password
		String password = "";
		//Query to execute
		String query = "select count(1) from clientes";
		//Load mysql jdbc driver
		Class.forName("com.mysql.jdbc.Driver");
		//Create Connection to DB
		Connection con = DriverManager.getConnection(dbURL,username,password);
		//Create Statement Object
		Statement stmt = con.createStatement();
		//Execute the SQL Query.  Store results in ResultSet
		ResultSet rs = stmt.executeQuery(query);
		int count = 0;
		
		while(rs.next()) {
			count = rs.getInt(1);
			
			//Select nombre, edad. fechaNacimiento from Clientes;
			//nombre= rs.getString(1);
			//edad= rs.getInt(2);
			//fechaNacimiento = rs.getDate(3);
			//(los (n) son correlativos al nro de la columna)
		}
		
		System.out.println("Resultado de la consulta: " + count);
		Assert.assertTrue(count>0);	
	}

}
