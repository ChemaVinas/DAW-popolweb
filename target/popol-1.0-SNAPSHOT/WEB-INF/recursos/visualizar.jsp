<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">

    <%@include file="/WEB-INF/layout/cabecera.jspf"%>

    <body>

        <div id="wrapper">
            <%@include file="/WEB-INF/layout/navegacion.jspf" %>
            <!-- *****Contenido de la página***** -->
            <div id="page-wrapper">

                <div class="container-fluid recurso">

                    <div class="row titulorecurso">
                        <div class="col-md-8"><h1>${recurso.nombre}</h1></div>
                        <div class="col-md-4 buttons right">
                            <c:set var = "usu_log" value = "<%=request.getRemoteUser()%>"/>
                            <c:set var = "usu_recu" value = "${recurso.usuario}"/>
                            <c:if test="${usu_log==usu_recu}">
                                <a href="${srvUrl}/eliminar?id=${recurso.id}"><button type="button" title="Eliminar" class="btn btn-circle btn-lg erase"><i class="glyphicon glyphicon-erase"></i></button></a>
                                <a href="${srvUrl}/editar?id=${recurso.id}"><button type="button" title="Editar" class="btn btn-circle btn-lg edit"><i class="glyphicon glyphicon-edit"></i></button></a>
                                <div class="separador"></div>
                            </c:if>
                            <a href="${srvUrl}/descargar?id=${recurso.id}"><button type="button" title="Descargar" class="btn btn-circle btn-lg downloads"><i class="glyphicon glyphicon-download"></i></button></a>
                            <c:if test="${usu_log!=usu_recu}">    
                                <a href="${srvUrl}/like?id=${recurso.id}"><button type="button" title="Me gusta" class="btn btn-circle btn-lg like"><i class="glyphicon glyphicon-heart"></i></button></a>
                            </c:if>
                            <a href="#"><button type="button" title="Compartir" class="btn btn-circle btn-lg share"><i class="glyphicon glyphicon-share-alt"></i></button></a>
                            <a href="#"><button type="button" title="Reportar" class="btn btn-circle btn-lg report"><i class="glyphicon glyphicon-flag"></i></button></a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-3">
                            <img class="img-responsive" src="${imgUrl}/resource.jpg" alt="">
                            <div class="usuario">
                                <h3> Creado por </h3>
                                <img class="img-rounded" style="width: 30%" src="${imgUrl}/user.png" alt="fulanito">
                                <div class="username">
                                    <a href="<c:url value='/main/usuarios/visualizar?usuario=${recurso.usuario}'/>">${recurso.usuario}</a>
                                    <div class="ec-stars-wrapper">
                                        <a href="#" data-value="1" title="Votar con 1 estrellas">&#9733;</a>
                                        <a href="#" data-value="2" title="Votar con 2 estrellas">&#9733;</a>
                                        <a href="#" data-value="3" title="Votar con 3 estrellas">&#9733;</a>
                                        <a href="#" data-value="4" title="Votar con 4 estrellas">&#9733;</a>
                                        <a href="#" data-value="5" title="Votar con 5 estrellas">&#9733;</a>
                                    </div>
                                </div>
                                <div class="followbtn">
                                    <a href="#" class="btn btn-sm btn-detail">SEGUIR  <span class="glyphicon glyphicon-ok-circle"></span></a>
                                    <a class="btn btn-sm btn-detail" href="recurso.jsp">VER MÁS<span class="glyphicon glyphicon-chevron-right"></span></a>
                                </div>
                            </div>
                            <div class="fecha">
                                <h3> Última modificación </h3>
                                <p> ${recurso.ult_modific} </p>
                            </div>
                        </div>
                        <div class="col-md-8 desc">
                            <h3>Tipo o categoría:</h3>
                            <p>${recurso.tipo}</p>
                            <hr>
                            <h4>Descripción:</h4>
                            <div id="descripcion">
                                <p>${recurso.descripcion}</p>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <%@include file="/WEB-INF/layout/scripts_pie.jspf" %>
    </body>
</html>
