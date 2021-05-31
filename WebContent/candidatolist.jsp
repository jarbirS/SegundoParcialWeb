<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Gestion de candidatos</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
			<div>
                <a href="#" class="navbar-brand"> Gestión de Candidatos </a>
            </div>
            
            <ul class="navbar-nav">
            	<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Candidatos</a></li>
            </ul>
		
		</nav>
	</header>
	<br/>
	
	<div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Listado de Candidatos</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Agregar Nuevo Candidato</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Documento</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Numero</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="candidato" items="${listCandidatos}">

                                <tr>
                                    <td>
                                        <c:out value="${candidato.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${candidato.documento}" />
                                    </td>
                                    <td>
                                        <c:out value="${candidato.nombre}" />
                                    </td>
                                    <td>
                                        <c:out value="${candidato.apellido}" />
                                    </td>
                                    <td>
                                        <c:out value="${candidato.numero}" />
                                    </td>
                                    <td><a href="edit?id=<c:out value='${candidato.id}' />">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${candidato.id}' />">Eliminar</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>

</body>
</html>