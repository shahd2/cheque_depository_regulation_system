package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import model.PayCheque;

public class Paycheque {

	
	public static boolean transaction(String sender, int amount, String phone){
		try{ 
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url="jdbc:mysql://localhost:3306/paycheque";
			String user="root";
			String pass="123";
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection(url,user,pass);
			
			Statement smt=cn.createStatement();
			
			String q = "update details set balance=balance - "+amount+" where acc='"+sender+"'";	
			smt.executeUpdate(q);
			System.out.print("1");
			
			q = "update details set balance=balance + "+amount+" where phone="+phone;	
			smt.executeUpdate(q);
			System.out.print("2");
			
			ResultSet rs = smt.executeQuery("select acc from details where phone = "+phone);
			String acc="";
			if(rs.next()){
				acc = rs.getString(1);
				System.out.print(acc);
			}else{
				System.out.print(acc);
			return false;
			}
			
			q="insert into cheque_issue(acc_from,acc_to,amount) values('"+sender+"','"+acc+"',"+amount+")";
			smt.executeUpdate(q);
			cn.close();
			return true;
		}
		catch (Exception e){
			System.out.print(e);
			return false;
		}
		
		
	}
	
}
