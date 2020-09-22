package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import model.Signup;



public class SignUp {
	public static Connection getConnection() throws Exception
	{
		try{ 
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url="jdbc:mysql://localhost:3306/paycheque";
			String user="root";
			String pass="123";
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection(url,user,pass);
			return cn;}
		catch (Exception e){System.out.print(e);}
		System.out.print("Error in Connection");
		return null;
	}
	
	public static String addRecord(Signup S) 
	{	try{
		Connection cn = getConnection();
		Statement smt=cn.createStatement();
		String query="INSERT INTO `details`(`acc`, `name`,  `email`, `balance`, `phone`) VALUES ('"+S.getAcc()+"','"+S.getName()+"','"+S.getEmail()+"','"+S.getBal()+"','"+S.getPhone()+"')";
		System.out.println(query);		
		smt.executeUpdate(query);
		query="INSERT INTO `login`(`acc`, `password`) VALUES ('"+S.getAcc()+"','"+S.getPassword()+"')";
		System.out.println(query);
		smt.executeUpdate(query);
		cn.close();
		return "1";
	}catch(Exception e){System.out.println(e);}
	return "0";
	}
	
	
}
