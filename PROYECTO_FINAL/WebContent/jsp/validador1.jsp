<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "clases.Metodos" %>  
<%@ page import = "clases.Validar" %>  
<%@ page import = "java.util.*" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>


     function pendientes(){

    	 
              var valor=document.getElementById("solicitudes").value;

              if(valor!=0){
                  if(document.getElementById("solicitudes").selectedIndex == 1) {
                	  document.getElementById("form1").action = "servletPendientes";
                      }
                  else if(document.getElementById("solicitudes").selectedIndex == 2) {
                	  document.getElementById("form1").action = "servletAprobadas";
                  }

                  else if(document.getElementById("solicitudes").selectedIndex == 3) {
                	  document.getElementById("form1").action = "servletRechazadas";
                  }

                  else if(document.getElementById("solicitudes").selectedIndex == 4) {
                	  document.getElementById("form1").action = "servletTodas";
                  }
                  
            	  document.getElementById("form1").submit();
                }
        } 
     
</script>
</head>
<body>
<%
ArrayList<Validar> listavac;
listavac = (ArrayList<Validar>)request.getAttribute("listavac");
if(listavac == null) {
	listavac = new ArrayList<Validar>();
}
if(!listavac.isEmpty()) {
}

%>


<form name="form1" id="form1" action="" method="post">
<table>
<tr>
    <td></td>
      <td>Solicitudes</td>
      <td>Solicitante</td>
</tr>
<tr>
    <td>Filtrar por:</td>  
    <td><select name="solicitudes" id="solicitudes" size="1" onChange="pendientes()">
            <option value="0" Selected>Seleccionar:</option>
            <option value="1" >Pendientes</option>
            <option value="2" >Aprobadas</option>
            <option value="3" >Rechazadas</option>
            <option value="4" >Todas</option>
       </select>
   </td>
   <td><input type="text"></td>
   
</table>
</form>


<br>
<br>
<%if(!listavac.isEmpty()) {
   Iterator<Validar> it = listavac.iterator();
%> 
<table id="tabla">
<tr>
     <td>Solicitante</td>
     <td>Fecha solicitada</td>
     <td>Tipo</td>
     <td>Comentario</td>
    
     <td><input type="button" name="aprobarTodas" value="Todas"></td>
     <td><input type="button" name="rechazarTodas" value="Todas"></td> 
</tr>
<% while(it.hasNext()) {
  Validar val = new Validar();
  val = it.next();
%>
<tr>
     <td><input type="text" name="solicitante" readonly value= "<%=val.getSolicitante()%>" ></td>
     <td><input type="text" name="fechas_solicitadas" readonly value = "<%=val.getFecha_solicitada()%>" ></td>
     <td><input type="text" name="tipo" readonly value = "<%=val.getTipo()%>"></td>
     <td><textarea name="comentarios" readonly rows="1" cols="30"><%=val.getComentario()%> </textarea></td>
     
     <td><a href = "servletAprobar?id=<%=val.getNumSol()%>"> Aprobar</a></td>
     <td><a href = "servletRechazar?id=<%=val.getNumSol()%>"> Rechazar</a></td>
</tr>
<%}%>
</table>
<%}%>


<%
ArrayList<Validar> listaAprobadas;
listaAprobadas = (ArrayList<Validar>)request.getAttribute("listaAprobadas");
if(listaAprobadas == null) {
	listaAprobadas = new ArrayList<Validar>();
}
%>


<%if(!listaAprobadas.isEmpty()) {
   Iterator<Validar> it2 = listaAprobadas.iterator();
%> 
<table id="tabla">
<tr>
     <td>Solicitante</td>
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
     <td><input type="text" name="solicitante" readonly value= "<%=val.getSolicitante()%>" ></td>
     <td><input type="text" name="fechas_solicitadas" readonly value = "<%=val.getFecha_solicitada()%>" ></td>
     <td><input type="text" name="tipo" readonly value = "<%=val.getTipo()%>"></td>
     <td><textarea name="comentarios" readonly rows="1" cols="30"><%=val.getComentario()%> </textarea></td>
     <td><input type="text" name="estado" readonly value = "<%=val.getEstado()%>"></td>
</tr>
<%}%>
</table>
<%}%>



<%
ArrayList<Validar> listaRechazadas;
listaRechazadas = (ArrayList<Validar>)request.getAttribute("listaRechazadas");
if(listaRechazadas == null) {
	listaRechazadas = new ArrayList<Validar>();
}
%>


<%if(!listaRechazadas.isEmpty()) {
   Iterator<Validar> it3 = listaRechazadas.iterator();
%> 
<table id="tabla">
<tr>
     <td>Solicitante</td>
     <td>Fecha solicitada</td>
     <td>Tipo</td>
     <td>Comentario</td>
     <td>Estado</td>
</tr>
<% while(it3.hasNext()) {
  Validar val = new Validar();
  val = it3.next();
%>
<tr>
     <td><input type="text" name="solicitante" readonly value= "<%=val.getSolicitante()%>" ></td>
     <td><input type="text" name="fechas_solicitadas" readonly value = "<%=val.getFecha_solicitada()%>" ></td>
     <td><input type="text" name="tipo" readonly value = "<%=val.getTipo()%>"></td>
     <td><textarea name="comentarios" readonly rows="1" cols="30"><%=val.getComentario()%> </textarea></td>
     <td><input type="text" name="estado" readonly value = "<%=val.getEstado()%>"></td>
</tr>
<%}%>
</table>
<%}%>



<%
ArrayList<Validar> listaTodas;
listaTodas = (ArrayList<Validar>)request.getAttribute("listaTodas");
if(listaTodas == null) {
	listaTodas = new ArrayList<Validar>();
}
%>


<%if(!listaTodas.isEmpty()) {
   Iterator<Validar> it4 = listaTodas.iterator();
%> 
<table id="tabla">
<tr>
     <td>Solicitante</td>
     <td>Fecha solicitada</td>
     <td>Tipo</td>
     <td>Comentario</td>
     <td>Estado</td>
</tr>
<% while(it4.hasNext()) {
  Validar val = new Validar();
  val = it4.next();
%>
<tr>
     <td><input type="text" name="solicitante" readonly value= "<%=val.getSolicitante()%>" ></td>
     <td><input type="text" name="fechas_solicitadas" readonly value = "<%=val.getFecha_solicitada()%>" ></td>
     <td><input type="text" name="tipo" readonly value = "<%=val.getTipo()%>"></td>
     <td><textarea name="comentarios" readonly rows="1" cols="30"><%=val.getComentario()%> </textarea></td>
     <td><input type="text" name="estado" readonly value = "<%=val.getEstado()%>"></td>
</tr>
<%}%>
</table>
<%}%>



</body>
</html>