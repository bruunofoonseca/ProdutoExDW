<%-- 
    Document   : cadastrarUsuario
    Created on : 09/11/2017, 17:57:52
    Author     : diogo.felix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produto</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/menuPrincipal.css">
        <link rel="stylesheet" type="text/css" href="css/cadastrarUsuario.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
    <nav class="navbar">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle format-button-navbar" data-toggle="collapse" data-target="#myNavbar">
            <span class="icon-bar format-icons-button-navbar"></span>
            <span class="icon-bar format-icons-button-navbar"></span>
            <span class="icon-bar format-icons-button-navbar"></span>                        
          </button>
          <a class="navbar-brand" href="${pageContext.request.contextPath}/PaginaInicial">Livraia Astec</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
          <ul class="nav navbar-nav">
            <li class="active"><a href="${pageContext.request.contextPath}/CadastrarProd">Cadastrar Produto</a></li>
            <li><a href="${pageContext.request.contextPath}/ListarProd">Listar Produto</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <main id="page-content-wrapper" role="main">
    <form class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/cadastrarProduto">
        <fieldset>
        <input id="idFunc" name="id" value="${produto.getId()}" type="hidden">
        <div class="panel panel-primary">
            <div class="panel-heading">Cadastro de Produto</div>
            <div class="panel-body">
            
            <div class="form-group">
                <div class="col-md-11 control-label">
                    <p class="help-block"><h11>*</h11> Campo Obrigatório </p>
                </div>
                <div id="newpost">
                    <div class="form-group">
                     <div class="col-md-3 control-label">
                         <h3>Dados cadastrais</h3>
                     </div>
                    </div>
                </div>
            </div>
                
            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-2 control-label" for="Nome">Nome <h11>*</h11></label>  
              <div class="col-md-8">
              <input id="Nome" name="Nome" value="${produto.getNome()}" placeholder="Digite o nome do produto" class="form-control input-md" required="" type="text" autofocus>
              </div>
            </div>

            <div class="form-group">
              <label class="col-md-2 control-label" for="descricao">Descrição<h11>*</h11></label>  
              <div class="col-md-8">
              <input id="descricao" name="descricao" value="${produto.getDescricao()}" placeholder="Digite o nome do fabricante/Editora" class="form-control input-md" required="" type="text">
              </div>
            </div>
        
            <div class="form-group">
              <label class="col-md-2 control-label" for="precoCompra">Preço de Compra<h11>*</h11></label>  
              <div class="col-md-1">
                  <input id="precoCompra" value="${produto.getPrecoCompra()}" name="precoCompra" class="form-control input-md" required="" type="number" placeholder="R$ 0,00">
              </div>
            </div>

            <div class="form-group">
              <label class="col-md-2 control-label" for="precoVenda">Preço de Venda<h11>*</h11></label>  
              <div class="col-md-2">
              <input id="precoVenda" name="precoVenda" value="${produto.getPrecoVenda()}" class="form-control input-md" placeholder="R$ 0,00" required="" type="text">
              </div>
            </div>    

            <div class="form-group">
              <label class="col-md-2 control-label" for="quantidade">Quantidade</label>  
              <div class="col-md-2">
                  <input id="quantidade" name="quantidade" class="form-control input-md" type="text" value="${produto.getQuantidade()}">
              </div>
            </div>

            <div class="form-group">
                <label class="col-md-2 control-label" for="categoria">Categoria</label>
                <div class="col-md-2">
                    <select required id="categoria" name="categoria" class="form-control">
                        <option value=""></option>
                        <c:forEach items="${categorias}" var="categoria">
                            <option value="${categoria.getId()}" ${categoria.getId() == produto.getCategorias().getId() ? 'selected="selected"' : ''}>${categoria.getNome()}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
              <label class="col-md-2 control-label" for="Cadastrar"></label>
              <div class="col-md-8">
                <button id="Cadastrar" name="Cadastrar" class="btn btn-success" type="Submit">Cadastrar</button>
                <button id="Cancelar" name="Cancelar" class="btn btn-danger" type="Reset">Cancelar</button>
              </div>
            </div>
        </div>    
        </div> 
        </fieldset>
    </form>        

    </main>
    </body>
</html>