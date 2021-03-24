<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                                Editar recurso
                            </h1>

                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <i class="fa fa-upload fa-fw"></i> Editar recurso
                                </div>


                                <form:form id="editaRecu" method="POST" modelAttribute="recurso" cssClass="well form-horizontal">
                                    <fieldset>

                                        <!-- Form Name -->
                                        <legend>Edita aquí tu recurso (id = ${recurso.id})</legend>

                                        <!-- Text input-->
                                        <div class="form-group">
                                            <form:label path="nombre" class="col-md-4 control-label">Nombre</form:label>  
                                            <div class="col-md-4 inputGroupContainer">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="glyphicon glyphicon-file"></i></span>
                                                    <form:input path="nombre" placeholder="Nombre recurso" class="form-control"/>
                                                </div>
                                                <form:errors cssClass="label label-warning" path="nombre"/>
                                                <div id="errNombreRecu" class='label label-warning'></div>
                                            </div>
                                        </div>

                                        <!-- Text input-->

                                        <div class="form-group">
                                            <form:label path="tipo" class="col-md-4 control-label">Tipo o categoría</form:label>  
                                            <div class="col-md-4 inputGroupContainer">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="glyphicon glyphicon-book"></i></span>
                                                    <form:input path="tipo" placeholder="Tipo" class="form-control"/>
                                                </div>
                                                <form:errors cssClass="label label-warning" path="nombre"/>
                                                <div id="errTipo" class='label label-warning'></div>
                                            </div>
                                        </div>

                                        <!-- Text area -->

                                        <div class="form-group">
                                            <form:label path="descripcion" class="col-md-4 control-label">Descripción</form:label>
                                            <div class="col-md-4 inputGroupContainer">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
                                                    <form:textarea class="form-control" path="descripcion" placeholder="Descripción recurso"/>
                                                </div>
                                                <form:errors cssClass="label label-warning" path="descripcion"/>
                                                <div id="errDescripcion" class='label label-warning'></div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <form:label path="privacidad" class="col-md-4 control-label">Privacidad</form:label>
                                            <div class="col-md-4 inputGroupContainer">
                                                <div class="input-group">
                                                    <div class="btn-group" data-toggle="buttons">
                                                        <form:label path="privacidad" class="btn btn-primary">
                                                            <form:radiobutton path="privacidad" value="false" id="option1" autocomplete="off"/> Público
                                                        </form:label>
                                                        <form:label path="privacidad" class="btn btn-primary">
                                                            <form:radiobutton path="privacidad" value="true" id="option2" autocomplete="off"/>Privado
                                                        </form:label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-md-4 control-label"></label>
                                            <div class="col-md-4 inputGroupContainer">
                                                <div class="input-group">
                                                    <input id="input-1" type="file" class="file">
                                                </div>
                                            </div>
                                        </div>

                                        <!-- Button -->
                                        <div class="form-group">
                                            <label class="col-md-4 control-label"></label>
                                            <div class="col-md-4">
                                                <button type="submit" class="btn btn-warning" >Subir <span class="glyphicon glyphicon-upload"></span></button>
                                                <div id="confirm" class='label label-success'></div>
                                            </div>
                                        </div>

                                    </fieldset>
                                </form:form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
            <script src="${pageContext.request.contextPath}/js/validation/valida_recu.js"></script>
            <%@include file="/WEB-INF/layout/scripts_pie.jspf" %>
    </body>
</html>
