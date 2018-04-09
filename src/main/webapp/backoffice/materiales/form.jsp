<%@page import="com.ipartek.formacion.nidea.controller.backoffice.BackofficeMaterialesController"%>

<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<h1>Formulario para Crear, modificar o eliminar materiales</h1>



<form action="backoffice/materiales" method="post">
  <div class="form-group row">
  
  	<label class="col-sm-1">ID</label>
    <div>
      	<input type="number" class="form-control col-sm-4" name="id" value="${material.id}" readonly>
    </div>
    
   </div>
    
   <div class="form-group row"> 
    	
    <label class="col-sm-1">Nombre</label>
    <div>
      	<input type="text" class="form-control col-sm-10" name="nombre" value="${material.nombre}">
    </div>
    
    </div>
    
    <div class="form-group row">
    
    <label class="col-sm-1">Precio</label>
    <div>
      	<input type="number" class="form-control col-sm-6" name="precio" value="${material.precio}">
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
		<div class="col-sm-3">
			<input type="hidden" name="op" value="<%=BackofficeMaterialesController.OP_GUARDAR%>"> 	
			<button type="submit" class="btn btn-success btn-lg btn-block">Modificar</button>
		</div>
		<div class="col-sm-3">			      
			<a type="button" class="btn btn-danger btn-lg btn-block" data-toggle="modal" data-target="#exampleModal">Eliminar</a>
		</div>
		
			    <!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  			<div class="modal-dialog" role="document">
    			<div class="modal-content">
      				<div class="modal-header">
        				<h5 class="modal-title" id="exampleModalLabel">Confirmación de eliminación</h5>
        				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          					<span aria-hidden="true">&times;</span>
        				</button>
      				</div>
      				<div class="modal-body">
        				<span>¿Está seguro de que desea eliminar el material ${material.nombre}?</span>
      				</div>
      				<div class="modal-footer">
        				<button type="button" class="btn btn-primary btn-lg btn-block" data-dismiss="modal">Cancelar</button>
        				<a href="backoffice/materiales?id=${material.id}&op=<%=BackofficeMaterialesController.OP_ELIMINAR%>" 
			       			class="btn btn-danger btn-lg btn-block">Eliminar</a>
      				</div>
    			</div>
  			</div>
		</div>
			   
	</div>
  </c:if>
  
 <div class="form-group row">
		<a class="btn btn-outline-dark btn-lg" href="backoffice/materiales">Volver</a>
	</div>
  
</form>


<%@include file="/templates/footer.jsp" %>