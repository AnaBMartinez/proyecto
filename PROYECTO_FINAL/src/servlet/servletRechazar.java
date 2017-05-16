package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Metodos;

@WebServlet("/servletRechazar")
public class servletRechazar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public servletRechazar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		


		Metodos.rechazar(id);
	 //   request.setAttribute("val",Metodos.consultaBDV2(id));
		

		Metodos.consultaBDV1();
	    request.setAttribute("listavac",Metodos.consultaBDV1());
		
	    RequestDispatcher dis=request.getRequestDispatcher("jsp/validador1.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
