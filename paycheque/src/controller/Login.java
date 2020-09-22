package controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Login {

	public static Statement getConnection() throws Exception
	{
		try{ 
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url="jdbc:mysql://localhost:3306/paycheque";
			String user="root";
			String pass="123";
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection(url,user,pass);
			Statement smt=cn.createStatement();
			return smt;}
		catch (Exception e){System.out.print(e);}
		System.out.print("Error in Connection");
		return null;
	}
	
	public static ResultSet checkPassword(String acc, String password) throws Exception
	{
		Statement smt=getConnection();
		String q="Select * from login where acc='"+acc+"' and password ='"+password+"'";
		System.out.println(q);
		ResultSet rs=smt.executeQuery(q);
		if(rs.next())
		{
			ResultSet rss = smt.executeQuery("select * from details where id="+rs.getString(1));
			return rss;
		}
		return null;
		
	}

	
}
