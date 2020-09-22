package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Paycheque;

/**
 * Servlet implementation class Transaction
 */
@WebServlet("/Transaction")
public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String sender = request.getParameter("sender");
		int amount = Integer.parseInt(request.getParameter("amt"));
		String phone = request.getParameter("phone");
		
		boolean status = Paycheque.transaction(sender, amount, phone);
		if(status){
			out.println("<h1>Successful</h1>");
		}else{
			out.println("<h1>Failed</h1>");
		}
		out.flush();
	}

}
