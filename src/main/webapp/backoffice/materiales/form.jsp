<%@page import="com.ipartek.formacion.nidea.controller.backoffice.BackofficeMaterialesController"%>

<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<h1>Formulario para Crear, modificar o eliminar materiales</h1>



<form action="backoffice/materiales" method="post">
  <div class="form-group row">
  
  	<label class="col-sm-1">ID</label>
    <div>
      	<input type="number" class="form-control col-sm-4" name="id" value="${material.id}">
    </div>
    
   </div>
    
   <div class="form-group row"> 
    	
    <label class="col-sm-1">Nombre</label>
    <div>
      	<input type="text" class="form-control col-sm-10" name="nombre" value="${nombre_material}">
    </div>
    
    </div>
    
    <div class="form-group row">
    
    <label class="col-sm-1">Precio</label>
    <div>
      	<input type="number" class="form-control col-sm-6" name="precio" value="${precio_material}">
    </div>
  
  </div>
  <c:if test="${material.id == -1 }">
  	 <div class="form-group row">
			   <div class="col-sm-12">
			   	  <input type="hidden" name="op" value="<%=BackofficeMaterialesController.OP_GUARDAR%>"> 	
			      <button type="submit" class="btn btn-primary btn-lg btn-block">Crear</button>
			  </div>
		  </div>
  </c:if>
  
  <c:if test="${material.id > -1 }">
  	 <div class="form-group row">
			    <div class="col-sm-6">
			      <input type="hidden" name="op" value="<%=BackofficeMaterialesController.OP_GUARDAR%>"> 	
			      <button type="submit" class="btn btn-success btn-lg btn-block">Modificar</button>
			    </div>
			    <div class="col-sm-6">			      
			      <a href="backoffice/materiales?id=${material.id}&op=<%=BackofficeMaterialesController.OP_ELIMINAR%>" 
			       class="btn btn-danger btn-lg btn-block">Eliminar</a>
			    </div>
			  </div>
  </c:if>
  
 <div class="form-group row">
		<a class="btn btn-outline-dark btn-lg" href="backoffice/materiales">Volver</a>
	</div>
  
</form>


<%@include file="/templates/footer.jsp" %>