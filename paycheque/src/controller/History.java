package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class History {
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
	
	public static ResultSet displayAllHistory(String acc) 
	{	try{
		Connection cn = getConnection();
		Statement smt=cn.createStatement();
		String q = "select * from cheque_issue where acc_from = '"+ acc +"' or acc_to= '"+ acc +"' order by id DESC limit 10 " ;

		System.out.println(q);		ResultSet	rs = smt.executeQuery(q);
		return rs;
	}catch(Exception e ){System.out.println(e);}
	return null;
	}
	
	public static String displayBalance(String acc) 
	{	String balance="0";
		try{
		Connection cn = getConnection();
		Statement smt=cn.createStatement();
		ResultSet rs = smt.executeQuery("SELECT balance FROM details where acc='"+acc+"'");
		if(rs.next())
		{
			balance = rs.getString(1);
		}
		return balance;
	}catch(Exception e ){System.out.println(e);}
	return null;
	}
}
