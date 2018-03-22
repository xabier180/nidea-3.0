<%@page import="com.ipartek.formacion.nidea.pojo.Mesa"%>

<jsp:include page="templates/head.jsp"></jsp:include>
<jsp:include page="templates/navbar.jsp"></jsp:include>

<%
	// recoger atributo del controlador, si es que existe
	Mesa mesa = (Mesa)request.getAttribute("mesa");
	
%>

<p>Precio: <%=mesa.getPrecio()%> &euro;</p> 


<form action="generar-mesa" method="post">


	<label for="patas">Numero de patas:</label>
	<input type="number" name="patas" value="4" required>

	<input type="submit" value="Calcular Precio">
	
</form>



<jsp:include page="templates/footer.jsp"></jsp:include>