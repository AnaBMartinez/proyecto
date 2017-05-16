package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Metodos;

@WebServlet("/servletTodas")
public class servletTodas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public servletTodas() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		String todas=request.getParameter("trampa4");
		
	
		Metodos.todas(todas);
        request.setAttribute("listaTodas", Metodos.todas(todas));
		
        RequestDispatcher dis=request.getRequestDispatcher("jsp/validador1.jsp");
		dis.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
