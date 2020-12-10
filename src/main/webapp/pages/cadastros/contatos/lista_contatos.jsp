<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:admin_template title="Contatos" breadcrumb="Dashboard">
	
	<jsp:attribute name="content">
		
		<section class="content">
		    
           <div class="card shadow mb-4"> 
               <div class="card-header py-3">
               			<h5 class="badge badge-primary">Lista de Contatos</h5>
                 <div style="margin-left: 180px; margin-top: -30px;">
                  <a class="btn btn-outline-success btn-lg btn-block" href="${pageContext.request.contextPath}/pages/cadastros/contatos/cadastro_contatos.jsp">Novo</a>
                 </div>
                 </div>
                 
                 	<c:if test="${not empty sucesso }">
                 	<div class="alert alert-succes" role="alert">${sucesso}</div>
                 	</c:if>
                 	
                 	<c:if test="${not empty contatoExiste }">
                 	<div class="alert alert-danger" role="alert">${contatoExiste }</div>
                 	</c:if>
                 	
                 <div class="card-body">
                 <div class="table-responsive">
                 <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                 	<thead>
                 		<tr>
                 			<th>Nome</th>
                 			<th>Email</th>
                 			<th>Telefone</th>
                 			<th>Status</th>
                 			<th>Desativar / Ecluir / Editar</th>
                 		</tr>
                	</thead>
                 	
                   <tbody> 
                   
                    <c:forEach var="c" items="${contatos}"> 
                    	<input type="hidden" value="${c.id }">
                     	<tr> 
	                    	<td> 
	                    	  <c:out value="${c.nome}"/>	 
	                    	</td>
	                    	<td> 
	                    	  <c:out value="${c.email}"/>	 
	                    	</td> 
	                    	<td> 
	                    	  <c:out value="${c.telefone}"/>
	                    	</td> 
	                    	<td> 
	                    	  <c:out value="${c.ativo ? 'Ativo' : 'Desativado'}"/>
	                    	</td>
	                    	<td>
	                    		<a href="${pageContext.request.contextPath}/contatoControllerServlet?id=${c.id}&ativar=ativo" class="btn btn-outline-success">Desativar</a>
	                    		<a href="${pageContext.request.contextPath}/contatoControllerServlet?id=${c.id}&action=delete" class="btn btn-outline-danger">Excluir</a>
	                    		<a href="${pageContext.request.contextPath}/contatoControllerServlet?id=${c.id}&fuction=editar" class="btn btn-outline-warning">Editar</a>
	                    	</td>
                    	</tr> 
                    </c:forEach> 
                  </tbody> 
                </table> 
                  </div>
                 </div>
              </div> 
     </section>
					
	</jsp:attribute>
	
</mt:admin_template>
