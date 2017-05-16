<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "clases.Empleados" %>   
<%@ page import = "clases.Metodos" %>  
<%@ page import = "java.sql.*" %>  
<%@ page import = "java.util.*" %>  
<%@ page import = "clases.Validar" %>  


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ficha Usuario</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/User.css">   

<script type="text/javascript" src="js/jquery.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>


function nover(){

$("#dni").hide();
	}


$(document).ready(function(){

	   var d= parseInt(document.getElementById("dias").value);

	   if(d==0){
	        $("#boton1").hide();
	        }
	    
	   var cont=0;
	    
	       $("#boton1").click(function(){
	    
	      var x=document.getElementById("fecha").value;

	      var z=document.createElement("TR");
	      z.setAttribute("name","texto"+cont);
	      z.setAttribute("id","texto"+cont);

	       var terx = document.createTextNode(x);
		   z.appendChild(terx);
	       document.getElementById("p1").appendChild(z);
	        
	       var a = document.createElement("SELECT");
	       a.setAttribute("id", "mySelect"+cont);
	       a.setAttribute("name", "mySelect"+cont);
	       document.getElementById("texto"+cont).appendChild(a);

	       var tipo = document.createElement("option");
	       tipo.setAttribute("value", "Seleccionar tipo");
	       var t4 = document.createTextNode("Seleccionar tipo");
	       tipo.appendChild(t4);
	       document.getElementById("mySelect"+cont).appendChild(tipo);
	        
	         var ent = document.createElement("option");
	          ent.setAttribute("value", "Jornada completa");
	          var t1 = document.createTextNode("Jornada completa");
	          ent.appendChild(t1);
	          document.getElementById("mySelect"+cont).appendChild(ent);

	        var med = document.createElement("option");
	          med.setAttribute("value", "Jornada parcial");
	          var t2 = document.createTextNode("Jornada parcial");
	          med.appendChild(t2);
	          document.getElementById("mySelect"+cont).appendChild(med);

	        var tarde = document.createElement("option");
	          tarde.setAttribute("value", "Mañana/Tarde");
	          var t3 = document.createTextNode("Mañana/Tarde");
	          tarde.appendChild(t3);
	          document.getElementById("mySelect"+cont).appendChild(tarde);
	          document.getElementById("mySelect"+cont).addEventListener('change', function() {

	              if(document.getElementById("mySelect"+cont).value=="Jornada completa"){
	               d=d-1;
	               document.getElementById("dias").value=d;
	                }
	                
	              else if(document.getElementById("mySelect"+cont).value=="Jornada parcial"){                
	                    d=d-0.5;
	                    document.getElementById("dias").value=d;
	                    }
	                
	              else if(document.getElementById("mySelect"+cont).value=="Mañana/Tarde"){
	                    d=d-0.3;
	                    document.getElementById("dias").value=d;
	                    }
	                if(d==0){
	                    $("#boton1").hide();
	                    }
	                  cont++;        
	         });  
	       });        
	  });
	  
</script>
</head>

<body onLoad="nover()"> 

<h1>Ficha Usuario</h1>
<form name = "formc" action= "Controlador2" method="post">

<div class="wrapper">
<table class="table1">
<tbody>

<jsp:useBean id="user1" class= "clases.Empleados" scope="request"></jsp:useBean>

<tr>
<th><b>Nombre</b></th>
<th><b>Primer Apellido</b></th>
<th><b>Segundo Apellido</b></th>
<th><b>email</b></th>
</tr>

<tr>
<td><input class="ficha" type="text" readonly name="nombre" value = "<%=Metodos.consultaBD(request.getParameter("clave")).getNombre()%>"></td>
<td><input class="ficha" type="text" readonly name="ape1" value = "<%=Metodos.consultaBD(request.getParameter("clave")).getApellido1()%>"></td>
<td><input class="ficha" type="text" readonly name="ape2" value = "<%=Metodos.consultaBD(request.getParameter("clave")).getApellido2()%>"></td>
<td><input class="ficha" type="text" readonly name="email" value = "<%=Metodos.consultaBD(request.getParameter("clave")).getEmail()%>"></td>
<td id="dni"><input class="ficha" type="text" readonly name="dni"  id="dni" value = "<%=Metodos.consultaBD(request.getParameter("clave")).getDni()%>"></td>
</tr>
</tbody>
</table>

<table class="table2">
<tbody>
<tr>
<th><b>Fecha de inicio</b></th>
<th><b>Departamento</b></th>
<th><b>Horario</b></th>
<th><b>Jornada</b></th>
</tr>

<tr>
<td><input class="ficha" type="text" readonly name="fecha_inicio" value = "<%=Metodos.consultaBD(request.getParameter("clave")).getFecha_inicio()%>"></td>
<td><input class="ficha" type="text" readonly name="departamento" value = "<%=Metodos.consultaBD(request.getParameter("clave")).getDepartamento()%>"></td>
<td><input class="ficha" type="text" readonly name="horario" value = "<%=Metodos.consultaBD(request.getParameter("clave")).getHorario()%>"></td>
<td><input class="ficha" type="text" readonly name="jornada" value = "<%=Metodos.consultaBD(request.getParameter("clave")).getJornada()%>"></td>
</tr>
</tbody>
</table>

<br><br>

<table class="table3">
  <tr>
    <th colspan="3">
    Solicitar días de vacaciones
    </th>
  </tr>
  
  <tr>
    <td>Días disponible</td>
    <td>Validador</td>
    <td>Comentarios</td>
  </tr>
  
  <tr>
    <td><input class="solicitud" type="text" readonly id="dias" name="dias" value="<%=Metodos.calculoDias().getDias_disponibles()%>"></td>
  	<td><select class="validador" name="validador" id="validador" size="1">
		<option value="1" Selected>Seleccionar validador</option>
		<option value="Ana Martínez Sans">Ana Martínez Sans</option>
		<option value="Paschal Chukwudum Ogbogu" >Paschal Chukwudum Ogbogu</option>
		<option value="Francisco Núñez Rambaúd" >Francisco Núñez Rambaúd</option>
		</select>
	</td>
 	<td rowspan="3">
 	<textarea class="txtarea" name="comentarios" rows="5" cols="52"></textarea>
 	</td>

  </tr>
  
<tr>
  <td colspan="2">Días solicitados</td>    
</tr> 
  <tr>
    <td colspan="2">
    <input class="solicitud" type="date" id="fecha" name="fecha"  value="2017-06-08"/>				
	<input class="solicitud" type="button" id="boton1" value="Agregar"/>
	</td>
  </tr>
 </table>
 
<table class="table4" id="p1">
<tbody>
</tbody>
</table>
 
 <br><br>
  
<input class="solicitar" type="submit" value="Solicitar">
<a href = "servletVerSolicitudes?dni=<%=request.getParameter("clave")%>"> Ver días solicitados</a>

<%
ArrayList<Validar> listaSolicitadas;
listaSolicitadas = (ArrayList<Validar>)request.getAttribute("listaSolicitadas");
if(listaSolicitadas == null) {
	listaSolicitadas = new ArrayList<Validar>();
}
%>


<%if(listaSolicitadas.isEmpty()) {
}

else{
   Iterator<Validar> it2 = listaSolicitadas.iterator();
%> 

<table id="tabla">
<tr>
     <td>Fecha solicitada</td>
     <td>Tipo</td>
     <td>Comentario</td>
     <td>Estado</td>
</tr>
<% while(it2.hasNext()) {
  Validar val = new Validar();
  val = it2.next();
%>
<tr>
     <td><input type="text" name="fechas_solicitadas" readonly value = "<%=val.getFecha_solicitada()%>" ></td>
     <td><input type="text" name="tipo" readonly value = "<%=val.getTipo()%>"></td>
     <td><textarea name="comentarios" readonly rows="1" cols="30"><%=val.getComentario()%> </textarea></td>
     <td><input type="text" name="estado" readonly value = "<%=val.getEstado()%>"></td>
</tr>
<%}%>
</table>
<%}%>


<%
if(Metodos.consultaBD(request.getParameter("clave")).getDias_disponibles()==0.0){
	Metodos.calculoDias();
	Metodos.agregarDias();
}

%>

</div>
</form>




</body>
</html>