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



                    <div class="tab-content">

                        <h2 class="loginincorrecto">Usuario y/o contraseña incorrectos</h2>
                        <p class="loginincorrecto"> Inténtelo de nuevo</p>
                        
                        <a href="${pageContext.request.contextPath}/login.jsp"><button value="Volver" class="button button-block centered"> Volver </button></a>

                    </div><!-- tab-content -->
                </div>
            </div> <!-- /form -->
        </div>

    </body>
</html>
