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
                                Perfil
                            </h1>
                            <!--<ol class="breadcrumb">
                                <li class="active">
                                    <i class="fa fa-user"></i> Mi Perfil
                                </li>
                            </ol>-->


                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <i class="fa fa-user fa-fw"></i> Cuenta
                                </div>

                                <form:form id="perfilUsu" method="POST" modelAttribute="usuario" cssClass="well form-horizontal">
                                    <fieldset>

                                        <!-- Form Name -->
                                        <legend>Modifica tu cuenta (id = ${usuario.id})</legend>

                                        <!-- Text input-->

                                        <div class="form-group">
                                            <form:label path="usuario" class="col-md-4 control-label">Usuario (único)</form:label>  
                                                <div class="col-md-4 inputGroupContainer">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                                        <form:input path="usuario" placeholder="Usuario único" class="form-control"/>
                                                </div>
                                                <form:errors cssClass="label label-warning" path="usuario"/>
                                                <div id="errUsuario" class='label label-warning'></div>
                                            </div>
                                        </div>

                                        <!-- Text input-->

                                        <div class="form-group">
                                            <form:label path="clave" class="col-md-4 control-label">Clave</form:label>  
                                                <div class="col-md-4 inputGroupContainer">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                                        <form:input path="clave" placeholder="Clave" class="form-control"/>
                                                </div>
                                                <form:errors cssClass="label label-warning" path="clave"/>
                                                <div id="errClave" class='label label-warning'></div>
                                            </div>
                                        </div>

                                        <!-- Text input-->

                                        <div class="form-group">
                                            <form:label path="nombre" class="col-md-4 control-label">Nombre</form:label>  
                                                <div class="col-md-4 inputGroupContainer">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                                        <form:input path="nombre" placeholder="Nombre" class="form-control"/>
                                                </div>
                                                <form:errors cssClass="label label-warning" path="nombre"/>
                                                <div id="errNombreUsu" class='label label-warning'></div>
                                            </div>
                                        </div>

                                        <!-- Text input-->

                                        <div class="form-group">
                                            <form:label path="apellidos" class="col-md-4 control-label" >Apellidos</form:label> 
                                                <div class="col-md-4 inputGroupContainer">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                                        <form:input path="apellidos" placeholder="Apellido" class="form-control"/>
                                                </div>
                                                <form:errors cssClass="label label-warning" path="apellidos"/>
                                                <div id="errApellidos" class='label label-warning'></div>
                                            </div>
                                        </div>

                                        <!-- Text input-->
                                        <div class="form-group">
                                            <form:label path="mail" class="col-md-4 control-label">E-Mail</form:label>  
                                                <div class="col-md-4 inputGroupContainer">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                                                        <form:input path="mail" placeholder="Dirección de correo electrónico" class="form-control"/>
                                                </div>
                                                <form:errors cssClass="label label-warning" path="mail"/>
                                                <div id="errMail" class='label label-warning'></div>
                                            </div>
                                        </div>


                                        <!-- Text input-->

                                        <div class="form-group">
                                            <form:label path="telefono" class="col-md-4 control-label">Número de teléfono</form:label>  
                                                <div class="col-md-4 inputGroupContainer">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                                                        <form:input path="telefono" placeholder="Número de teléfono" class="form-control"/>
                                                </div>
                                                <form:errors cssClass="label label-warning" path="telefono"/>
                                                <div id="errTelefono" class='label label-warning'></div>
                                            </div>
                                        </div>

                                        <!-- Select Basic -->

                                        <div class="form-group"> 
                                            <form:label path="pais" class="col-md-4 control-label">País</form:label>
                                                <div class="col-md-4 selectContainer">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><i class="glyphicon glyphicon-flag"></i></span>
                                                        <form:select path="pais" class="form-control selectpicker" >
                                                            <c:forEach var="p" items="${paises}">
                                                                <form:option value="${p}"/>
                                                            </c:forEach>
                                                        </form:select>
                                                </div>
                                            </div>
                                        </div>


                                        <!-- Text input-->

                                        <div class="form-group">
                                            <form:label path="ciudad" class="col-md-4 control-label">Ciudad</form:label>  
                                                <div class="col-md-4 inputGroupContainer">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                                                        <form:input path="ciudad" placeholder="Ciudad" class="form-control"/>
                                                </div>
                                                <form:errors cssClass="label label-warning" path="ciudad"/>
                                                <div id="errCiudad" class='label label-warning'></div>
                                            </div>
                                        </div>


                                        <!-- Text input-->
                                        <div class="form-group">
                                            <form:label path="web" class="col-md-4 control-label">Sitio web o dominio</form:label>  
                                                <div class="col-md-4 inputGroupContainer">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><i class="glyphicon glyphicon-globe"></i></span>
                                                        <form:input path="web" placeholder="Página Web" class="form-control"/>
                                                </div>
                                                <form:errors cssClass="label label-warning" path="web"/>
                                                <div id="errWeb" class='label label-warning'></div>
                                            </div>
                                        </div>

                                        <!-- Text area -->

                                        <div class="form-group">
                                            <form:label path="hobbies" class="col-md-4 control-label">Intereses/Hobbies</form:label>
                                                <div class="col-md-4 inputGroupContainer">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><i class="glyphicon glyphicon-star"></i></span>
                                                        <form:textarea class="form-control" path="hobbies" placeholder="Descripción"/>
                                                </div>
                                                <form:errors cssClass="label label-warning" path="hobbies"/>
                                                <div id="errHobbies" class='label label-warning'></div>
                                            </div>
                                        </div>

                                        <!-- Button -->
                                        <div class="form-group">
                                            <label class="col-md-4 control-label"></label>
                                            <div class="col-md-4"> 
                                                <input type="submit" value="Guardar" class="btn btn-warning"/>
                                                <div id="confirm" class='label label-success'></div>
                                            </div>
                                        </div>

                                        <!-- Button -->
                                        <a href="<c:url value='/main/usuarios/eliminar?id=${usuario.id}'/>">Eliminar cuenta</a>

                                    </fieldset>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
            
            
        <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/js/validation/valida_usu.js"></script>
        <%@include file="/WEB-INF/layout/scripts_pie.jspf" %>
    </body>
</html>
