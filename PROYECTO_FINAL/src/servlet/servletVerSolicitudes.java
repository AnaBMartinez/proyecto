package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Metodos;


@WebServlet("/servletVerSolicitudes")
public class servletVerSolicitudes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public servletVerSolicitudes() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dni=request.getParameter("dni");
		
		Metodos.fechasSolicitadas(dni);
		  request.setAttribute("listaSolicitadas", Metodos.fechasSolicitadas(dni));
		  
		RequestDispatcher dis=request.getRequestDispatcher("jsp/index2.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
