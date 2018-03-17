<%-- 
    Document   : cadastrarUsuario
    Created on : 22/11/2017, 14:56:52
    Author     : diogo.felix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Produto</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/menuPrincipal.css">
        <link rel="stylesheet" type="text/css" href="css/cadastrarUsuario.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
<!--        <nav class="navbar navbar-default" style="margin-bottom:2px; ">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Astec</a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="sair"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                </ul>
            </div>
        </nav>
        <nav class="navbar navbar-default sidebar" role="navigation">
            <div class="container-fluid">
                <div class="profile-usertitle">
                    <div class="profile-usertitle-name">
                        ${sessionScope.usuario.nome}
                    </div>
                    <div class="profile-usertitle-job">
                         ${sessionScope.usuario.cargo} - ${sessionScope.usuario.setor}
                    </div>
                </div>
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-sidebar-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="collapse navbar-collapse" id="bs-sidebar-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active format-active"><a href="${pageContext.request.contextPath}/menuPrincipal">Home<span style="font-size:16px;" class="pull-right showopacity glyphicon glyphicon-home"></span></a></li>
                    <c:forEach items="${sessionScope.usuario.modulos}" var="modulo">
                        <c:if test="${modulo.getModuloNome() eq 'funcionario'}">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Usuarios <span class="caret"></span><span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a>
                                <ul class="dropdown-menu forAnimate" role="menu">
                                    <c:forEach items="${modulo.getSubNome()}" var="subNome">
                                        <c:if test="${subNome eq 'cadastro'}">
                                            <li><a href="${pageContext.request.contextPath}/formUsuario">Cadastrar</a></li>
                                        </c:if>
                                        <c:if test="${subNome eq 'consulta'}">
                                            <li><a href="${pageContext.request.contextPath}/listarUsuario">Consultar</a></li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </li>
                        </c:if>
                        <c:if test="${modulo.getModuloNome() eq 'cliente'}">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Clientes <span class="caret"></span><span style="font-size:16px;" class="pull-right showopacity glyphicon glyphicon-list-alt"></span></a>
                                <ul class="dropdown-menu forAnimate" role="menu">
                                    <c:forEach items="${modulo.getSubNome()}" var="subNome">
                                        <c:if test="${subNome eq 'cadastro'}">
                                            <li><a href="${pageContext.request.contextPath}/formCliente">Cadastrar</a></li>
                                        </c:if>
                                        <c:if test="${subNome eq 'consulta'}">
                                            <li><a href="${pageContext.request.contextPath}/listarCliente">Consultar</a></li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </li>
                        </c:if>
                        <c:if test="${modulo.getModuloNome() eq 'produto'}">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Produtos <span class="caret"></span><span style="font-size:16px;" class="pull-right showopacity glyphicon glyphicon-th-list"></span></a>
                                <ul class="dropdown-menu forAnimate" role="menu">
                                    <c:forEach items="${modulo.getSubNome()}" var="subNome">
                                        <c:if test="${subNome eq 'cadastro'}">
                                            <li><a href="${pageContext.request.contextPath}/formProduto">Cadastrar</a></li>
                                        </c:if>
                                        <c:if test="${subNome eq 'consulta'}">
                                            <li><a href="${pageContext.request.contextPath}/listarProduto">Consultar</a></li>
                                        </c:if>         
                                    </c:forEach>
                                </ul>
                            </li>
                        </c:if>
                        <c:if test="${modulo.getModuloNome() eq 'venda'}">
                            <li ><a href="${pageContext.request.contextPath}/SelecioneCliente">Vender Produto<span style="font-size:16px;" class="pull-right showopacity glyphicon glyphicon-tags"></span></a></li>
                        </c:if>
                        <c:if test="${modulo.getModuloNome() eq 'relatorio'}">
                            <li ><a href="${pageContext.request.contextPath}/RelatorioVendas">Relatorio Vendas<span style="font-size:16px;" class="pull-right showopacity glyphicon glyphicon-tags"></span></a></li>
                        </c:if>
                    </c:forEach>
                </ul>
            </div>

            </div>
        </nav>-->
        <main id="page-content-wrapper" role="main">
        <form class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/exibirProduto">
        <fieldset>
        <div class="panel panel-primary">
            <div class="panel-heading">Listar Produto</div>
            <div class="panel-body">
                
            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-2 control-label" for="Nome">Pesquisar Produto </label>  
              <div class="col-md-6">
              <input id="Nome" name="Nome" placeholder="Digite o nome do produto" class="form-control input-md" type="text" autofocus required="">
              </div>
              <div class="col-md-1">
                  <button id="buscar" name="buscar" class="btn btn-info" type="submit">
                    <span class="glyphicon glyphicon-search"></span>
                    Buscar
                  </button>
              </div>
              <div class="col-md-1">
                  <a class="btn btn-info" href="${pageContext.request.contextPath}/listarTodosProdutos">Listar</a>
              </div>
            </div>
            </div> 
            <table class="table table-striped">
                <thead>
                    <tr>
                      <th>ID</th>
                      <th>Nome Produto</th>
                      <th>Descrição</th>
                      <th>Preço de Compra</th>
                      <th>Preço de Venda</th>
                      <th>Quantidade</th>
                      <th>Data de Cadastro</th>
                    </tr>
                </thead>
                 <c:if test="${not empty msgErroBusca}">
                   <h2><c:out value="${msgErroBusca}" /></h2>
                </c:if>
                <tbody> 
                    <c:forEach items="${pesquisa}" var="produto">
                        <tr>
                            <td><c:out value="${produto.getId()}" /></td>
                            <td><c:out value="${produto.getNome()}" /></td>
                            <td><c:out value="${produto.getDescricao()}" /></td>
                            <td><c:out value="${produto.getPrecoCompra()}" /></td>
                            <td><c:out value="${produto.getPrecoVenda()}" /></td>
                            <td><c:out value="${produto.getQuantidade()}" /></td>
                            <td><c:out value="${produto.getDtCadastro()}" /></td>
                        </tr>    
                    </c:forEach>    
                </tbody>    
            </table>
        </div> 
        </fieldset>
        
    </form>        
    
    </main>    
    </body>                        
    <script src="js/cadastrarUsuario.js"></script>
</html>
