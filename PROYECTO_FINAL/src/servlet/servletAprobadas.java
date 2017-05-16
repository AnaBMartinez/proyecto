package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Metodos;


@WebServlet("/servletAprobadas")
public class servletAprobadas extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public servletAprobadas() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		
	
		Metodos.aprobadas();
        request.setAttribute("listaAprobadas", Metodos.aprobadas());
		
        RequestDispatcher dis=request.getRequestDispatcher("jsp/validador1.jsp");
		dis.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
