package clases;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

import com.mysql.jdbc.Statement;

public class Metodos {
	

	public static Connection conexionBD(){
		 Connection con=null;


		try{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto?"+"user=root&password=Olivermypopsi.123" + "&useSSL=false");

			}catch(ClassNotFoundException e){
				e.printStackTrace();
				System.out.println("No se encuentra la clase del driver");
				
			}catch(SQLException e){
				e.printStackTrace();
				System.out.println("Error");
				e.getMessage();
			
				e.getSQLState();
			}
		
		System.out.println("Conexión establecida con éxito");
		
		
		return con;
		
	}
	
public  static Login metodoLogin(String usuario, String clave){
		
		ResultSet result=null;
		PreparedStatement pstmnt=null;


		Connection conexion=Metodos.conexionBD();

		Login user=new Login();
		String consulta="select * from login where idlogin=? and password=?";

		try {
			pstmnt=conexion.prepareStatement(consulta);
			pstmnt.setString(1,usuario);
			pstmnt.setString(2, clave);
			
		    result=pstmnt.executeQuery();

		    
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido ejecutar la consulta");
		}

			try {
				while(result.next()){
					user.setIdlogin(result.getString(1));
					user.setPassword(result.getString(2));	
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("No se ha podido recuperar los datos");
			}
			
			try {
				pstmnt.close();
				result.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return user;
		
	
	}

static Empleados empleado=new Empleados();



public  static Empleados consultaBD(String clave){
		
		ResultSet result=null;
		PreparedStatement pstmnt=null;


		Connection conexion=Metodos.conexionBD();

		String consulta="select * from departamento1 where dni=?";

		try {
			pstmnt=conexion.prepareStatement(consulta);
			pstmnt.setString(1, clave);
			
		    result=pstmnt.executeQuery();
		    
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido ejecutar la consulta");
		}

			try {
				while(result.next()){
					empleado.setNombre(result.getString(1));
					empleado.setApellido1(result.getString(3));
					empleado.setApellido2(result.getString(4));
					empleado.setDni(result.getString(2));
					empleado.setFecha_inicio(result.getDate(5));
					empleado.setDepartamento(result.getInt(6));
					empleado.setHorario(result.getString(7));
					empleado.setJornada(result.getString(8));
					empleado.setDias_disponibles(result.getFloat(9));
					empleado.setEmail(result.getString(10));
					

				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("No se ha podido recuperar los datos");
			}
				

			try {
				pstmnt.close();
				result.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return empleado;
		
	
	}
	
	
public  static Validar insertarBD(String solicitante, String fecha_solicitada, String tipo, String comentarios, String dni){
		
		ResultSet result=null;
		PreparedStatement pstmnt=null;

		Connection conexion=Metodos.conexionBD();

		Validar solicitud=new Validar();
		String consulta="insert into validador1(Solicitante,Fechas_solicitadas,Tipo,Comentarios,Estado,Dni) values(?,?,?,?,?,?)";

		try {
           pstmnt=conexion.prepareStatement(consulta);
			
			pstmnt.setString(1, solicitante);
			pstmnt.setString(2, fecha_solicitada);
			pstmnt.setString(3, tipo);
			pstmnt.setString(4, comentarios);
			pstmnt.setString(5, "pendiente");
			pstmnt.setString(6, dni);

			pstmnt.executeUpdate();

		    
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido ejecutar la consulta");
		}

		
		try {
			pstmnt.close();
			result.close();
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return solicitud;
		
	}



public  static  ArrayList<Validar>  consultaBDV1(){
	
	ResultSet result=null;
	PreparedStatement pstmnt=null;

	Connection conexion=Metodos.conexionBD();

	Validar val;
	
   ArrayList<Validar> listavac = new ArrayList<Validar>();

	
	String consulta="select * from validador1 where Estado=?";

	try {
		pstmnt=conexion.prepareStatement(consulta);
		pstmnt.setString(1, "pendiente");
		
	    result=pstmnt.executeQuery();
	    
	} catch (SQLException e) {
		e.printStackTrace();
	}

		try {
			while(result.next()){
				val=new Validar();
				
				val.setNumSol(result.getString(1));
				val.setSolicitante(result.getString(2));
				val.setFecha_solicitada(result.getString(3));
				val.setTipo(result.getString(4));
				val.setComentario(result.getString(5));
				val.setEstado(result.getString(6));

				listavac.add(val);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido recuperar los datos");
		}
		try {
			pstmnt.close();
			result.close();
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listavac;		
}



public  static  ArrayList<Validar>  aprobadas(){
	
	ResultSet result=null;
	PreparedStatement pstmnt=null;

	Connection conexion=Metodos.conexionBD();

	Validar val;
	
   ArrayList<Validar> listaAprobadas = new ArrayList<Validar>();

	
	String consulta="select * from validador1 where Estado=?";

	try {
		pstmnt=conexion.prepareStatement(consulta);
		pstmnt.setString(1, "aprobada");
		
	    result=pstmnt.executeQuery();
	    
	} catch (SQLException e) {
		e.printStackTrace();
	}

		try {
			while(result.next()){
				val=new Validar();
				
				val.setNumSol(result.getString(1));
				val.setSolicitante(result.getString(2));
				val.setFecha_solicitada(result.getString(3));
				val.setTipo(result.getString(4));
				val.setComentario(result.getString(5));
				val.setEstado(result.getString(6));

				listaAprobadas.add(val);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido recuperar los datos");
		}
		try {
			pstmnt.close();
			result.close();
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaAprobadas;		
}



public static Validar consultaBDV2(int id){
	
	PreparedStatement pstmnt=null;

	Connection conexion=Metodos.conexionBD();

	Validar val=new Validar();

	String consulta="update validador1 set Estado=? where NumSol = ?";

	try {
        pstmnt=conexion.prepareStatement(consulta);
        pstmnt.setString(1, "aprobada");
		pstmnt.setInt(2, id);
		pstmnt.executeUpdate();

	    
	} catch (SQLException e) {
		e.printStackTrace();
	}
	try {
		pstmnt.close();
		conexion.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return val;
	
}

public static Validar rechazar(int id){
	
	PreparedStatement pstmnt=null;

	Connection conexion=Metodos.conexionBD();

	Validar val=new Validar();

	String consulta="update validador1 set Estado=? where NumSol = ?";

	try {
        pstmnt=conexion.prepareStatement(consulta);
        pstmnt.setString(1, "rechazada");
		pstmnt.setInt(2, id);
		pstmnt.executeUpdate();

	    
	} catch (SQLException e) {
		e.printStackTrace();
	}
	try {
		pstmnt.close();
		conexion.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return val;
	
}


public  static  ArrayList<Validar>  rechazadas(String estado){
	
	ResultSet result=null;
	PreparedStatement pstmnt=null;

	Connection conexion=Metodos.conexionBD();

	Validar val;
	
   ArrayList<Validar> listaRechazadas = new ArrayList<Validar>();

	
	String consulta="select * from validador1 where Estado=?";

	try {
		pstmnt=conexion.prepareStatement(consulta);
		pstmnt.setString(1, "rechazada");
		
	    result=pstmnt.executeQuery();
	    
	} catch (SQLException e) {
		e.printStackTrace();
	}

		try {
			while(result.next()){
				val=new Validar();
				
				val.setNumSol(result.getString(1));
				val.setSolicitante(result.getString(2));
				val.setFecha_solicitada(result.getString(3));
				val.setTipo(result.getString(4));
				val.setComentario(result.getString(5));
				val.setEstado(result.getString(6));

				listaRechazadas.add(val);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido recuperar los datos");
		}
		try {
			pstmnt.close();
			result.close();
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaRechazadas;		
}


public  static  ArrayList<Validar>  fechasSolicitadas(String dni){
	
	ResultSet result=null;
	PreparedStatement pstmnt=null;

	Connection conexion=Metodos.conexionBD();

	Validar val;
	
   ArrayList<Validar> listaSolicitadas = new ArrayList<Validar>();

	
	String consulta="select * from validador1 where Dni=?";

	try {
		pstmnt=conexion.prepareStatement(consulta);
		pstmnt.setString(1, dni);
		
	    result=pstmnt.executeQuery();
	    
	} catch (SQLException e) {
		e.printStackTrace();
	}

		try {
			while(result.next()){
				val=new Validar();
				
				val.setNumSol(result.getString(1));
				val.setSolicitante(result.getString(2));
				val.setFecha_solicitada(result.getString(3));
				val.setTipo(result.getString(4));
				val.setComentario(result.getString(5));
				val.setEstado(result.getString(6));

				listaSolicitadas.add(val);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido recuperar los datos");
		}
		try {
			pstmnt.close();
			result.close();
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaSolicitadas;		
}




public  static  ArrayList<Validar>  todas(String estado){
	
	ResultSet result=null;
	java.sql.Statement stmnt=null;

	Connection conexion=Metodos.conexionBD();

	Validar val;
	
   ArrayList<Validar> listaTodas = new ArrayList<Validar>();

	
	String consulta="select * from validador1 order by Estado";

	try {
		stmnt=conexion.createStatement();
				
	    result=stmnt.executeQuery(consulta);
	    
	} catch (SQLException e) {
		e.printStackTrace();
	}

		try {
			while(result.next()){
				val=new Validar();
				
				val.setNumSol(result.getString(1));
				val.setSolicitante(result.getString(2));
				val.setFecha_solicitada(result.getString(3));
				val.setTipo(result.getString(4));
				val.setComentario(result.getString(5));
				val.setEstado(result.getString(6));

				listaTodas.add(val);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido recuperar los datos");
		}
		try {
			stmnt.close();
			result.close();
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaTodas;		
}

static int dinit;

public  static Empleados calculoDias(){
	
	Date fecha_ini=empleado.getFecha_inicio();
    fecha_ini = new java.util.Date(fecha_ini.getTime());    
    

    String fechaIni=String.valueOf(fecha_ini);

    String pattern = "dd-MM-yyyy";
    String dateInString =new SimpleDateFormat(pattern).format(new Date());

    String dateInString2 =new SimpleDateFormat(pattern).format(fecha_ini);
        
    SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

        Date d1 = null;
        try {
            d1 = f.parse(dateInString2);
            System.out.println(d1);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        long fechaI = d1.getTime();

        Date d2 = null;
        try {
            d2 = f.parse(dateInString);
            System.out.println(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long fechaH = d2.getTime();
        
        long diff = Math.abs(fechaH-fechaI);
        long definitivo = diff / (24 * 60 * 60 * 1000);
        
        int defini=(int) definitivo;
	System.out.println("Defini :"+defini);
	
	
	Date fecha_inicio= new java.util.Date(empleado.getFecha_inicio().getTime());
	Calendar cal = new GregorianCalendar();
	cal.setTime(fecha_inicio);
	
	int anoInicio=cal.get(Calendar.YEAR);
	
	LocalDate now= LocalDate.now();
	
	int anoHoy= now.getYear();
	
	if(anoInicio==anoHoy){
		       		
	    int difa= 22*defini;
	    
	    dinit=(difa/365);	
	    
	empleado.setDias_disponibles(dinit);
	
	System.out.println("Denit guardado: "+empleado.getDias_disponibles());
	}
	
	else{
		empleado.setDias_disponibles(22.0F);
		
	}
		
	return empleado;	
}


public static void agregarDias(){
	
	PreparedStatement pstmnt=null;

	Connection conexion=Metodos.conexionBD();


	String consulta="update departamento1 set dias_disponibles=? where dni = ?";

	try {
        pstmnt=conexion.prepareStatement(consulta);
        pstmnt.setDouble(1,empleado.getDias_disponibles());
		pstmnt.setString(2, empleado.getDni());
		pstmnt.executeUpdate();

	    
	} catch (SQLException e) {
		e.printStackTrace();
	}
	try {
		pstmnt.close();
		conexion.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public static void agregarDiasSolicitados(String dni, double dias){
	
	PreparedStatement pstmnt=null;

	Connection conexion=Metodos.conexionBD();


	String consulta="update departamento1 set dias_disponibles=? where dni = ?";

	try {
        pstmnt=conexion.prepareStatement(consulta);
        pstmnt.setDouble(1, dias);
		pstmnt.setString(2, dni);
		pstmnt.executeUpdate();

	    
	} catch (SQLException e) {
		e.printStackTrace();
	}
	try {
		pstmnt.close();
		conexion.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public static void envioCorreo(){
	 //La direccion de envio (to)
	 String para = "paschalogbogu@gmail.com";
	 
	 //La direccion de la cuenta de envio (from)
	 String de = "beds.telefonica@gmail.com";
	 
	 //El servidor (host). En este caso usaremos localhost
	 //Usaremos la configuración de google gmail
	 
	 //Obtenemos la propiedad del sistema
	 Properties propiedades = System.getProperties();
	 
	 //Configuracion del servidor de correo
	 propiedades.put("mail.smtp.auth", "true");
	 propiedades.put("mail.smtp.starttls.enable", "true");
	 propiedades.put("mail.smtp.host", "smtp.gmail.com");		 
	 propiedades.put("mail.smtp.port","587");
	 propiedades.put("mail.smtp.mail.sender", para);		 
	 System.out.println("Cargo las propiedades");
	 //Obtenemos la sesión por defecto		 
	 Session sesion = Session.getInstance(propiedades,
			  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("beds.telefonica", "beds1234");
			}
		  });
	 System.out.println("Correo de BedsTelefonica");
	 try{
		 
		 //Creamos el objeto mensaje tipo MimeMenssage por defecto
		 MimeMessage mensaje = new MimeMessage(sesion);
		 
		 //Asignamos el "de/from" al header del correo
		 mensaje.setFrom(new InternetAddress(de));
					 
		 //Asignamos el "para/to" al header del correo
		 mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(para));
		 			 
		 mensaje.setSubject("Nueva Oferta Intento 2");
		 
		 //Asignamos el asunto
		 mensaje.setText("Se ha creado una nueva oferta de empleo ");
		 
		 //Enviamos el correo
		 System.out.println("Va a enviar el correo");
		// Transport.send(mensaje);
		 Transport t = sesion.getTransport("smtp");
		 	t.connect((String)propiedades.get("mail.smtp.user"), "beds1234");
			t.sendMessage(mensaje, mensaje.getAllRecipients());
		//	t.close();
		 
		 System.out.println("Mensaje Enviado");
	 }catch(MessagingException e){
		 e.printStackTrace();
	 }
	 
}







}
