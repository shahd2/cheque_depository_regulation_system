package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import controller.Paycheque;
import model.PayCheque;

/**
 * Servlet implementation class paycheque
 */
@WebServlet("/paycheque")
public class paycheque extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public paycheque() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			PrintWriter out=response.getWriter();
	
			PayCheque P = new PayCheque();
			P.setAcc_from(request.getParameter("acc_from"));
			P.setAcc_to(request.getParameter("acc_to"));
			P.setAmount(request.getParameter("amount"));
			P.setCheque_id(request.getParameter("cheque_id"));
			P.setImage(request.getParameter("image"));
			P.setImage_name(request.getParameter("cheque_id")+".jpg");
			P.setQr("dsfadf");
			String result = Paycheque.check_in(P);
			if(result.equals("-2")){out.println("-2");}
			else if(result.equals("1")){out.println("1");}
			Part part=request.getPart("image");
			String savepath="D:/workspace/paycheque/WebContent/images";
			FileUpload F=new FileUpload(part,savepath);
		}catch(Exception e){System.out.println(e);}
		
	}

}
