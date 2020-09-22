package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import controller.JsonConverter;
import controller.Login;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try{
			ResultSet rs=Login.checkPassword(request.getParameter("username"), request.getParameter("password"));

			if(rs != null){
			ArrayList <JSONObject> obj=JsonConverter.getFormattedResult(rs);
			System.out.println(obj);
			out.println(obj);
			}
			else
			{
				out.println("0");
			}
		}catch(Exception e){System.out.println(e);}
	}

}
