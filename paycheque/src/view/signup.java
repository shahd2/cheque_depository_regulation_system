package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SignUp;
import model.Signup;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			Signup S = new Signup();
			S.setAcc(request.getParameter("acc"));
			S.setName(request.getParameter("name"));
			S.setBal(request.getParameter("bal"));
			S.setEmail(request.getParameter("email"));
			S.setPassword(request.getParameter("password"));
			S.setPhone(request.getParameter("phone"));
			String result = SignUp.addRecord(S);
			PrintWriter out= response.getWriter();
			out.println(result);
		}catch(Exception e){System.out.println(e);}
		
	}

}
