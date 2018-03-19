<%-- 
    Document   : cadastrarUsuario
    Created on : 19/11/2017, 19:14:52
    Author     : diogo.felix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Cliente</title>
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
          <a class="navbar-brand" href="#">Livraia Astec</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
          <ul class="nav navbar-nav">
            <li class="active"><a href="${pageContext.request.contextPath}/CadastrarProd">Cadastrar Produto</a></li>
            <li><a href="${pageContext.request.contextPath}/ListarProd">Listar Produto</a></li>
          </ul>
        </div>
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
                            <li ><a href="#">Vender Produto<span style="font-size:16px;" class="pull-right showopacity glyphicon glyphicon-tags"></span></a></li>
                        </c:if>
                        <c:if test="${modulo.getModuloNome() eq 'relatorio'}">
                            <li ><a href="#">Relatorio Vendas<span style="font-size:16px;" class="pull-right showopacity glyphicon glyphicon-tags"></span></a></li>
                        </c:if>
                    </c:forEach>
                </ul>
            </div>

        </div>
    </nav>
    <main id="page-content-wrapper" role="main">
        <div class="container">
            <div class="jumbotron">
              <div class="alert alert-success">
                  <strong>Cadastrado realizado com sucesso!</strong>
              </div>     
            </div>
        </div>
       
    </main>
    </body>
    <script src="js/cadastrarUsuario.js"></script>
</html>
