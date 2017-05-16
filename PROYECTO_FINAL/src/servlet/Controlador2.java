package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Metodos;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

@WebServlet("/Controlador2")
public class Controlador2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Controlador2() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter salida=response.getWriter();

		String fecha0=request.getParameter("texto0");
		String fecha1=request.getParameter("texto1");
		String fecha2=request.getParameter("texto2");
		String fecha3=request.getParameter("texto3");
		String fecha4=request.getParameter("texto4");
		String fecha5=request.getParameter("texto5");
		String fecha6=request.getParameter("texto6");
		String fecha7=request.getParameter("texto7");
		String fecha8=request.getParameter("texto8");
		String fecha9=request.getParameter("texto9");
		String fecha10=request.getParameter("texto10");
		String fecha11=request.getParameter("texto11");
		String fecha12=request.getParameter("texto12");
		String fecha13=request.getParameter("texto13");
		String fecha14=request.getParameter("texto14");
		String fecha15=request.getParameter("texto15");
		String fecha16=request.getParameter("texto16");
		String fecha17=request.getParameter("texto17");
		String fecha18=request.getParameter("texto18");
		String fecha19=request.getParameter("texto19");
		String fecha20=request.getParameter("texto20");
		
		String tipo0=request.getParameter("mySelect0");
		String tipo1=request.getParameter("mySelect1");
		String tipo2=request.getParameter("mySelect2");
		String tipo3=request.getParameter("mySelect3");
		String tipo4=request.getParameter("mySelect");
		String tipo5=request.getParameter("mySelect5");
		String tipo6=request.getParameter("mySelect6");
		String tipo7=request.getParameter("mySelect7");
		String tipo8=request.getParameter("mySelect8");
		String tipo9=request.getParameter("mySelect9");
		String tipo10=request.getParameter("mySelect10");
		String tipo11=request.getParameter("mySelect11");
		String tipo12=request.getParameter("mySelect12");
		String tipo13=request.getParameter("mySelect13");
		String tipo14=request.getParameter("mySelect14");
		String tipo15=request.getParameter("mySelect15");
		String tipo16=request.getParameter("mySelect16");
		String tipo17=request.getParameter("mySelect17");
		String tipo18=request.getParameter("mySelect18");
		String tipo19=request.getParameter("mySelect19");
		String tipo20=request.getParameter("mySelect20");
		
		String solicitante=request.getParameter("nombre");	
		String comentarios=request.getParameter("comentarios");
		
		String dni=request.getParameter("dni");
		double dias= Double.parseDouble(request.getParameter("dias"));
		System.out.println(dias);

	

		if(fecha0!=null ){
			Metodos.insertarBD(solicitante, fecha0, tipo0, comentarios,dni);
			Metodos.agregarDiasSolicitados(dni, dias);
			// Recipient's email ID needs to be mentioned.
		      String to = "paschalogbogu@gmail.com";
		 
		      // Sender's email ID needs to be mentioned
		      String from = "validador1234@gmail.com";
		 
		      // Assuming you are sending email from localhost
		      String host = "localhost";
		 
		      // Get system properties
		      Properties properties = System.getProperties();
		 
		      // Setup mail server
		      properties.setProperty("mail.smtp.host", host);
		 
		      // Get the default Session object.
		      Session session = Session.getDefaultInstance(properties);
		      
			  // Set response content type
		      response.setContentType("text/html");
		      PrintWriter out = response.getWriter();

		      try{
		         // Create a default MimeMessage object.
		         MimeMessage message = new MimeMessage(session);
		         // Set From: header field of the header.
		         message.setFrom(new InternetAddress(from));
		         // Set To: header field of the header.
		         message.addRecipient(Message.RecipientType.TO,
		                                  new InternetAddress(to));
		         // Set Subject: header field
		         message.setSubject("This is the Subject Line!");
		         // Now set the actual message
		         message.setText("This is actual message");
		         // Send message
		         Transport.send(message);
		         String title = "Send Email";
		         String res = "Sent message successfully....";
		         String docType =
		         "<!doctype html public \"-//w3c//dtd html 4.0 " +
		         "transitional//en\">\n";
		         out.println(docType +
		         "<html>\n" +
		         "<head><title>" + title + "</title></head>\n" +
		         "<body bgcolor=\"#f0f0f0\">\n" +
		         "<h1 align=\"center\">" + title + "</h1>\n" +
		         "<p align=\"center\">" + res + "</p>\n" +
		         "</body></html>");
		      }catch (MessagingException mex) {
		         mex.printStackTrace();
		      }
		}
		if(fecha1!=null ){
			Metodos.insertarBD(solicitante, fecha1, tipo1, comentarios,dni);
			Metodos.agregarDiasSolicitados(dni, dias);

		}
		if(fecha2!=null ){
			Metodos.insertarBD(solicitante, fecha2, tipo2, comentarios,dni);
			Metodos.agregarDiasSolicitados(dni, dias);

			}
		if(fecha3!=null){
			Metodos.insertarBD(solicitante, fecha3, tipo3, comentarios,dni);
			Metodos.agregarDiasSolicitados(dni, dias);

			}
		if(fecha4!=null){
			Metodos.insertarBD(solicitante, fecha4, tipo4, comentarios,dni);
			Metodos.agregarDiasSolicitados(dni, dias);

			}
		if(fecha5!=null ){
			Metodos.insertarBD(solicitante, fecha5, tipo5, comentarios,dni);
			Metodos.agregarDiasSolicitados(dni, dias);

			}
		if(fecha6!=null ){
			Metodos.insertarBD(solicitante, fecha6, tipo6, comentarios,dni);
			Metodos.agregarDiasSolicitados(dni, dias);

			}
		if(fecha7!=null ){
			Metodos.insertarBD(solicitante, fecha7, tipo7, comentarios,dni);	
			Metodos.agregarDiasSolicitados(dni, dias);

			}
	    if(fecha8!=null){
			Metodos.insertarBD(solicitante, fecha8, tipo8, comentarios,dni);
			Metodos.agregarDiasSolicitados(dni, dias);

				}
		if(fecha9!=null ){
			Metodos.insertarBD(solicitante, fecha9, tipo9, comentarios,dni);
			Metodos.agregarDiasSolicitados(dni, dias);

				}
		if(fecha10!=null ){
			Metodos.insertarBD(solicitante, fecha10, tipo10, comentarios,dni);	
			Metodos.agregarDiasSolicitados(dni, dias);

				}
		if(fecha11!=null ){
			Metodos.insertarBD(solicitante, fecha11, tipo11, comentarios,dni);	
			Metodos.agregarDiasSolicitados(dni, dias);

			}

		if(fecha12!=null ){
			Metodos.insertarBD(solicitante, fecha12, tipo12, comentarios,dni);	
			Metodos.agregarDiasSolicitados(dni, dias);

			}

		if(fecha13!=null ){
			Metodos.insertarBD(solicitante, fecha13, tipo13, comentarios,dni);	
			Metodos.agregarDiasSolicitados(dni, dias);

			}
		if(fecha14!=null ){
			Metodos.insertarBD(solicitante, fecha14, tipo14, comentarios,dni);	
			Metodos.agregarDiasSolicitados(dni, dias);

			}
		if(fecha15!=null){
			Metodos.insertarBD(solicitante, fecha15, tipo15, comentarios,dni);	
			Metodos.agregarDiasSolicitados(dni, dias);

			}
		if(fecha16!=null ){
			Metodos.insertarBD(solicitante, fecha16, tipo16, comentarios,dni);	
			Metodos.agregarDiasSolicitados(dni, dias);

			}
		if(fecha17!=null ){
			Metodos.insertarBD(solicitante, fecha17, tipo17, comentarios,dni);
			Metodos.agregarDiasSolicitados(dni, dias);

			}
		if(fecha18!=null ){
			Metodos.insertarBD(solicitante, fecha18, tipo18, comentarios,dni);	
			Metodos.agregarDiasSolicitados(dni, dias);

			}
		if(fecha19!=null ){
			Metodos.insertarBD(solicitante, fecha19, tipo19, comentarios,dni);	
			Metodos.agregarDiasSolicitados(dni, dias);

			}
		if(fecha20!=null ){
			Metodos.insertarBD(solicitante, fecha20, tipo20, comentarios,dni);
			Metodos.agregarDiasSolicitados(dni, dias);

			}
		
	
		salida.println("Solicitud enviada, Gracias");
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
