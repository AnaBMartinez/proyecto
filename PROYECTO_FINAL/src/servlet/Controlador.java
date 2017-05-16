package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Empleados;
import clases.Login;
import clases.Metodos;


public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public Controlador() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario=request.getParameter("usuario");
		String clave=request.getParameter("clave");
		
		Login log = Metodos.metodoLogin(usuario, clave);
		
		if(log==null){
			
			PrintWriter salida=response.getWriter();
			salida.println("Usuario inexistente");
		}
		else if(log.getIdlogin().equals("AMS")||log.getIdlogin().equals("PCO")||log.getIdlogin().equals("HRM")) {
			
			
			
			//Empleados user = ConexionBBDD.consultaBD(usuario, clave);
			RequestDispatcher dis=request.getRequestDispatcher("jsp/validador1.jsp");
			//request.setAttribute("user", user);
			dis.forward(request, response);

			}
		else{
							
		//Empleados user = ConexionBBDD.consultaBD(usuario, clave);
		RequestDispatcher dis=request.getRequestDispatcher("jsp/index2.jsp");
		//request.setAttribute("user", user);
		dis.forward(request, response);

		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
