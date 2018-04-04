<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<h1>MATERIALES PÚBLICO</h1>


<ol>
	<c:forEach items="${materiales}" var="material">
	
		<c:if test="${material.precio <= 6.0}">
			<li>${material.nombre} - ${material.precio} &euro; </li>
		</c:if>
		
		<c:if test="${material.precio > 6.0 && material.precio <= 25}">
			<li>${material.nombre} - <span class="text-primary">${material.precio} &euro;</span></li>
		</c:if>
		
		<c:if test="${material.precio > 25.0}">
			<li>${material.nombre} - <span class="text-danger">${material.precio} &euro;</span></li>
		</c:if>
		
	</c:forEach>
	
</ol>

<hr>

<ol>
	<c:forEach items="${materiales}" var="material">
	
	<c:choose>
         
         <c:when test = "${material.precio <= 6.0}">
            <li>${material.nombre} - ${material.precio} &euro; </li>
         </c:when>
         
         <c:when test = "${material.precio > 6.0 && material.precio <= 25}">
            <li>${material.nombre} - <span class="text-primary">${material.precio} &euro;</span></li>
         </c:when>
         
         <c:otherwise>
            <li>${material.nombre} - <span class="text-danger">${material.precio} &euro;</span></li>
         </c:otherwise>
      
      </c:choose>
	
	</c:forEach>
</ol>


<%@include file="/templates/footer.jsp" %>