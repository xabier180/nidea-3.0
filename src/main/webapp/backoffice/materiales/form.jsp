<%@page import="com.ipartek.formacion.nidea.controller.backoffice.BackofficeMaterialesController"%>

<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<h1>Formulario para Crear, modificar o eliminar materiales</h1>



<form>
  <div class="form-group row">
  
  	<label class="col-sm-1">ID</label>
    <div>
      	<input type="number" class="form-control col-sm-4" id="id" value="${id_material}">
    </div>
    
   </div>
    
   <div class="form-group row"> 
    	
    <label class="col-sm-1">Nombre</label>
    <div>
      	<input type="text" class="form-control col-sm-10" id="nombre" value="${nombre_material}">
    </div>
    
    </div>
    
    <div class="form-group row">
    
    <label class="col-sm-1">Precio</label>
    <div>
      	<input type="number" class="form-control col-sm-6" id="precio" value="${precio_material}">
    </div>
  
  </div>
  
  <div class="form-group">
  	<button type="button" class="btn btn-success col-sm-4">Crear</button>
  </div>
  <div class="form-group">
  	<button type="button" class="btn btn-primary col-sm-2">Modificar</button>
  	  	<button type="button" class="btn btn-danger col-sm-2">Eliminar</button>
  	
  </div>
  <div class="form-group">
  	<a href="backoffice/materiales?op=-21" class="btn btn-info">Volver</a>  	
  </div>
  
</form>


<%@include file="/templates/footer.jsp" %>