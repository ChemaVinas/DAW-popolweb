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
                        <div class="col-md-8"><h1>${usuario.usuario}</h1></div>
                        <div class="col-md-4 buttons right">
                            <div class="separador"></div>
                            <a href="#"><button type="button" title="Seguir" class="btn btn-circle btn-lg downloads"><i class="glyphicon glyphicon-user"></i></button></a>
                            <a href="#"><button type="button" title="Compartir" class="btn btn-circle btn-lg share"><i class="glyphicon glyphicon-share-alt"></i></button></a>
                            <a href="#"><button type="button" title="Reportar" class="btn btn-circle btn-lg report"><i class="glyphicon glyphicon-flag"></i></button></a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-3">
                            <img class="img-responsive imgperfil" src="${imgUrl}/user.png" alt="${usuario.usuario}">
                            <div class="usuario">
                                <h3> Creado por </h3>
                                <div class="ec-stars-wrapper">
                                    <a href="#" data-value="1" title="Votar con 1 estrellas">&#9733;</a>
                                    <a href="#" data-value="2" title="Votar con 2 estrellas">&#9733;</a>
                                    <a href="#" data-value="3" title="Votar con 3 estrellas">&#9733;</a>
                                    <a href="#" data-value="4" title="Votar con 4 estrellas">&#9733;</a>
                                    <a href="#" data-value="5" title="Votar con 5 estrellas">&#9733;</a>
                                </div>
                            </div>
                            <div class="fecha">
                                <h3> Usuario desde </h3>
                                <p> ${usuario.fecha_crea} </p>
                            </div>
                        </div>
                        <div class="col-md-8 desc">
                            <h3>${usuario.nombre} ${usuario.apellidos}</h3>
                            <hr>
                            <h4>${usuario.ciudad}, ${usuario.pais}</h4>
                            <p><a href='${usuario.web}'>${usuario.web}</a></p> 
                            <h4>Hobbies:</h4>
                            <div id="descripcion">
                                <p>${usuario.hobbies}</p>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <%@include file="/WEB-INF/layout/scripts_pie.jspf" %>
    </body>
</html>
