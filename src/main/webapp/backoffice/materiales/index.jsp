<%@page import="com.ipartek.formacion.nidea.controller.backoffice.BackofficeMaterialesController"%>
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<h1>MATERIALES DEL BACKOFFICE</h1>

Buscador
<form action = "backoffice/materiales" method="get">
	
	<input type="hidden" name="op" value="<%=BackofficeMaterialesController.OP_BUSQUEDA%>">
	<input type="text" name="search" required placeholder="Nombre del material">
	<input type="submit" value="buscar">

</form>

<br>

<table id="datatable" class="table table-striped table-bordered" style="width:100%">
	
	<thead>
		<th>ID</th>
		<th>Nombre</th>
		<th>Precio</th>
	</thead>

	<tbody>
	<c:forEach items="${materiales}" var="material">
	
 		<c:if test="${material.precio <= 6.0}">
 		
 			<tr>
				<td>${material.id} </td>
				<td><a href="backoffice/materiales?id=${material.id}&op=<%=BackofficeMaterialesController.OP_MOSTRAR_FORMULARIO%>">
				${material.nombre}</span>
			</a> </td>
				<td>${material.precio} &euro; </td>
			</tr>
			
		</c:if>

		<c:if test="${material.precio > 6.0 && material.precio <= 25}">
	
			<tr>
				<td>${material.id} </td>
				<td><a href="backoffice/materiales?id=${material.id}&op=<%=BackofficeMaterialesController.OP_MOSTRAR_FORMULARIO%>">
				${material.nombre}</span>
			</a>  </td>
				<td><span class="text-primary">${material.precio} &euro;</span></td>
			</tr>
		
		</c:if>
		
		<c:if test="${material.precio > 25.0}">
			
			<tr>
				<td>${material.id} </td>
				<td><a href="backoffice/materiales?id=${material.id}&op=<%=BackofficeMaterialesController.OP_MOSTRAR_FORMULARIO%>">
				${material.nombre}</span>
			</a>  </td>
				<td><span class="text-danger">${material.precio} &euro;</span></td>
			</tr>
			
		</c:if>
		
	</c:forEach>
	</tbody>
	
</ol>

</table>


<%@include file="/templates/footer.jsp" %>