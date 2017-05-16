package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Metodos;

@WebServlet("/servletRechazadas")
public class servletRechazadas extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public servletRechazadas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String rechazada=request.getParameter("trampa3");
		

		Metodos.rechazadas(rechazada);
	    request.setAttribute("listaRechazadas", Metodos.rechazadas(rechazada));
		
	    RequestDispatcher dis=request.getRequestDispatcher("jsp/validador1.jsp");
		dis.forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
