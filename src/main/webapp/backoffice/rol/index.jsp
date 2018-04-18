<%@page import="com.ipartek.formacion.nidea.controller.backoffice.BackofficeRolController"%>
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<h1>ROLES DEL BACKOFFICE</h1>

<div class="form-group">
  <a class="btn btn-outline-primary col-sm-4" href="backoffice/rol?op=<%=BackofficeRolController.OP_MOSTRAR_FORMULARIO%>">Crear nuevo</a>
</div>

Buscador
<form action = "backoffice/rol" method="get">
	
	<input type="hidden" name="op" value="<%=BackofficeRolController.OP_BUSQUEDA%>">
	<input type="text" name="search" required placeholder="Nombre del rol">
	<input type="submit" value="buscar">

</form>

<br>

<table id="datatable" class="tabla table table-striped table-bordered" style="width:100%">
	
	<thead>
		<th>ID</th>
		<th>Nombre</th>
	</thead>

	<tbody>
	<c:forEach items="${roles}" var="rol">
 		
 			<tr>
				<td>${rol.id} </td>
				<td><a href="backoffice/rol?id=${rol.id}&op=<%=BackofficeRolController.OP_MOSTRAR_FORMULARIO%>">
				${rol.nombre}</span>
			</a> </td>
			</tr>
			
		
	</c:forEach>
	</tbody>
	
</ol>

</table>


<%@include file="/templates/footer.jsp" %>