<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">

    <%@include file="/WEB-INF/layout/cabecera.jspf" %>

    <body>

        <div id="wrapper">
            <%@include file="/WEB-INF/layout/navegacion.jspf" %>
            <!-- *****Contenido de la página***** -->
            <div id="page-wrapper">

                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                               Popol Web <small>Novedades</small>
                            </h1>
                            <ol class="breadcrumb">
                                <li class="active">
                                    <i class="fa fa-home"></i> Inicio
                                </li>
                            </ol>
                        </div>
                    </div>

                    <c:if test="${not empty recursos}">
                        <c:forEach var="r" items="${recursos}">
                            <c:set var="recuid" value="?id=${r.id}"/>
                            <div class="row noticia">
                                <div class="col-md-2 col-sm-12">
                                    <a href="${srvUrl}/visualizar${recuid}"><div><img class="img-responsive minrec" src="${imgUrl}/resource100.jpg" alt=""></div></a>
                                    <div>
                                        <table class="misrecLD">
                                            <tr>
                                                <td><a href="${srvUrl}/descargar_ini${recuid}"><button type="button" class="btn btn-circle btn-lg downloads"><i class="glyphicon glyphicon-download"></i></button></a></td>
                                                <td><a href="${srvUrl}/like_ini${recuid}"><button type="button" class="btn btn-circle btn-lg like"><i class="glyphicon glyphicon-heart"></i></button></a></td>
                                            </tr> 
                                            <tr class="centered">
                                                <td id="green">${r.descargas}</td>
                                                <td id="red">${r.likes}</td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                                <div class="col-md-7 col-sm-12">
                                    <h3>${r.nombre}</h3>
                                    <h4>${r.tipo}</h4>
                                    <p>${r.descripcion}</p>
                                </div>
                                <div class="col-md-3 col-sm-12 detalles">
                                    <img class="media-object media-middle img-rounded" style="width: 50px;" src="${imgUrl}/user.png" alt="fulanito">
                                    <div class="ec-stars-wrapper">
                                        <a href="#" data-value="1" title="Votar con 1 estrellas">&#9733;</a>
                                        <a href="#" data-value="2" title="Votar con 2 estrellas">&#9733;</a>
                                        <a href="#" data-value="3" title="Votar con 3 estrellas">&#9733;</a>
                                        <a href="#" data-value="4" title="Votar con 4 estrellas">&#9733;</a>
                                        <a href="#" data-value="5" title="Votar con 5 estrellas">&#9733;</a>
                                    </div>
                                    <p> Por <a href="<c:url value='/main/usuarios/visualizar?usuario=${r.usuario}'/>">${r.usuario}</a></p>
                                    <p> ${r.ult_modific}</p>
                                    <a class="btn btn-primary btn-detail bottom" href="${srvUrl}/visualizar${recuid}">Ver Más<span class="glyphicon glyphicon-chevron-right"></span></a>
                                </div>

                            </div>
                            <!-- /.row -->

                            <hr>

                        </c:forEach>
                    </c:if>

                </div>
            </div>
        </div>

        <%@include file="/WEB-INF/layout/scripts_pie.jspf" %>

    </body>

</html>
