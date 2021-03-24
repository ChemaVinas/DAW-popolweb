<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">

    <%@include file="/WEB-INF/layout/cabecera.jspf" %>

    <body>

        <div id="wrapper">
            <%@include file="/WEB-INF/layout/navegacion.jspf" %>
            <div id="page-wrapper">
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                Recursos subidos
                            </h1>
                            <ol class="breadcrumb">
                                <li class="active">
                                    <i class="fa fa-home"></i> Mis recursos
                                </li>
                            </ol>
                        </div>
                    </div>

                    <c:if test="${not empty recursos}">
                        <c:forEach var="r" items="${recursos}">
                            <c:set var="recuid" value="?id=${r.id}"/>
                            <div class="row noticia">
                                <div class="col-md-2">
                                    <div><img class="img-responsive minrec" src="${imgUrl}/resource100.jpg" alt=""></div>
                                </div>
                                <div class="col-md-8">
                                    <h3>${r.nombre}</h3>
                                    <h4>${r.tipo}</h4>
                                    <p>${r.descripcion}</p>
                                </div>
                                <div class="col-md-2">
                                    <table class="misrecLD">
                                        <tr>
                                            <td><button type="button" class="btn btn-circle btn-lg downloads"><i class="glyphicon glyphicon-download"></i></button></td>
                                            <td><button type="button" class="btn btn-circle btn-lg like"><i class="glyphicon glyphicon-heart"></i></button></td>
                                        </tr> 
                                        <tr class="centered">
                                            <td id="green">${r.descargas}</td>
                                            <td id="red">${r.likes}</td>
                                        </tr>
                                    </table>
                                        <a class="btn btn-primary btn-detail" href="${srvUrl}/visualizar${recuid}">Detalles<span class="glyphicon glyphicon-chevron-right"></span></a>
                                </div>
                            </div>
                            <hr>
                        </c:forEach>
                    </c:if>

                    <!-- /#wrapper -->
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/layout/scripts_pie.jspf" %>
    </body>
</html>
