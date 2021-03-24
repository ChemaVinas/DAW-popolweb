<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <title>Popol web</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugins/normalize.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">


        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugins/login.css">
        <link href="${pageContext.request.contextPath}/css/plugins/popol.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i&amp;subset=cyrillic" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:500,700" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/resource.ico">
    </head>

    <body class="loginbg">
        <div class="row">
            <div class="col-md-6">
                <a href="https://popol.es"><img class="logo" src="${pageContext.request.contextPath}/images/logo.png" alt=""></a>
                <h1>Crea. Comparte. Juega.</h1>
            </div>

            <div class="col-md-6">
                <div class="form">

                    <a href="https://popol.es"><img class="logo" src="${pageContext.request.contextPath}/images/logoblue.png" alt=""></a>

                    <ul class="tab-group">
                        <li class="tab"><a href="<c:url value='/main/recursos'/>">Iniciar Sesión</a></li>
                        <li class="tab active" active><a href="#signup">Registrarse</a></li>
                    </ul>

                    <div class="tab-content">

                        <form:form id="registerUsu" method="POST" modelAttribute="usuario">

                            <div class="top-row">
                                <div class="field-wrap">
                                    <p>
                                        Nombre <span style="font-size: 12px;" id="errNombreUsu" class='label label-warning'></span>
                                        <form:errors style="font-size: 12px;" cssClass="label label-warning" path="nombre"/>
                                    </p>
                                    <form:input path="nombre"  />
                                </div>

                                <div class="field-wrap">
                                    <p>
                                        Apellidos <span style="font-size: 12px;" id="errApellidos" class='label label-warning'></span>
                                        <form:errors style="font-size: 12px;" cssClass="label label-warning" path="apellidos"/>
                                    </p>
                                    <form:input path="apellidos" />
                                </div>
                            </div>

                            <div class="field-wrap">
                                <p>
                                    Nombre de Usuario <span class="req">*</span><span style="font-size: 12px;" id="errUsuario" class='label label-warning'></span>
                                    <form:errors style="font-size: 12px;" cssClass="label label-warning" path="usuario"/>
                                </p>
                                <form:input path="usuario" autocomplete="off"/>
                            </div>

                            <div class="field-wrap">
                                <p>
                                    Contraseña<span class="req">*</span> <span style="font-size: 12px;" id="errClave" class='label label-warning'></span>
                                    <form:errors style="font-size: 12px;" cssClass="label label-warning" path="clave"/>
                                </p>
                                <form:input type="password" path="clave" autocomplete="off"/>
                            </div>

                            <!--<button type="submit" class="button button-block"/>Get Started</button>-->
                            <input type="submit" value="Entrar" class="button button-block centered"/>

                        </form:form>



                    </div><!-- tab-content -->

                </div> <!-- /form -->
            </div>
        </div>
        <!--<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>-->
        <!--<script src="${pageContext.request.contextPath}/js/plugins/textindex.js"></script>
        <script src="${pageContext.request.contextPath}/js/index.js"></script>-->
        <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/js/validation/valida_usu.js"></script>
    </body>
</html>
