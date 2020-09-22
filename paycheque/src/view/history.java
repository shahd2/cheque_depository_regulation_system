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

import controller.History;
import controller.JsonConverter;

/**
 * Servlet implementation class History
 */
@WebServlet("/History")


public class history extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public history() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			System.out.println("hello");
			String acc = request.getParameter("acc");
			ResultSet rs = History.displayAllHistory(acc);
			String balance = History.displayBalance(acc);
			ArrayList <JSONObject> obj=JsonConverter.getFormattedResult(rs);
			PrintWriter out = response.getWriter();
			out.print(balance+"``%f%``");
			out.print(obj);
		}catch(Exception e){System.out.println(e);}
	}

}
