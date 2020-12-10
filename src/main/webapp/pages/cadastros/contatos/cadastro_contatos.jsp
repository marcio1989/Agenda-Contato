<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>

<mt:admin_template title="Contatos" breadcrumb="Dashboard">

	<jsp:attribute name="content">
		<!-- 
		<section class="content">
			Cadastro contato     	
     	</section>
					 -->
		 <div class="row">
          <div class="col-lg-12">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Novo Contato</h1>
              </div>
              <form action="/agenda-contato/SalvarContatoControllerServlet" method="POST">
				<div class="col-md-12">
				<div class="form-group">
					<label class="badge badge-pill badge-primary">Nome</label>
					<input type="text" class="form-control" name="nome" id="nome"/>
				</div>
				
				<div class="form-group">
					<label class="badge badge-pill badge-success">E-mail</label>
					<input type="email" class="form-control" name="email" id="email"/>
				</div>
				
				<div class="form-group">
					<label class="badge badge-pill badge-warning">Telefone</label>
					<input type="text" class="form-control" name="telefone" id="telefone"/>
				</div>
				
				<div class="form-group">
					<input type="submit" class="btn btn-outline-danger" value="Cadastrar">
				</div>
				</div>

				</form>
                
            </div>
          </div>
        </div>
	</jsp:attribute>

</mt:admin_template>
