<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

    <%@include file="WEB-INF/layout/cabecera.jspf" %>

    <body>

        <div id="wrapper">
            <%@include file="WEB-INF/layout/navegacion.jspf" %>
            <div id="page-wrapper">
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                Configuración
                            </h1>
                            <ol class="breadcrumb">
                                <li class="active">
                                    <i class="fa fa-gear"></i> Configuración general
                                </li>
                            </ol>
                            <h5 class="fa fa-2x fa-lock"> Estamos trabajando en ello.</h5>
                        </div>
                    </div>

                </div>
            </div>
            
            <%@include file="WEB-INF/layout/scripts_pie.jspf" %>
    </body>
</html>
