<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>




<%
	float resul = (Float)request.getAttribute("resultado");	
%>		

<h1>Resultado de  la Operaci�n <span class="badge badge-primary"><%=resul%></span> </h1>




<jsp:include page="/templates/footer.jsp"></jsp:include>