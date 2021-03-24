$(function () {
    valida_usu.init();
});

var valida_usu = {
    config: {
        //Usuario
        ibUsuario:"[name=usuario]",
        ibClave:"[name=clave]",
        ibNombreUsu:"[name=nombre]",
        ibApellidos:"[name=apellidos]",
        ibMail:"[name=mail]",
        ibTelefono:"[name=telefono]",
        ibCiudad:"[name=ciudad]",
        ibWeb:"[name=web]",
        ibHobbies:"[name=hobbies]",
        
        //Formularios
        form_perfilUsu:"#perfilUsu",
        form_registerUsu:"#registerUsu",

        //Mensajes error
        errUsuario:"#errUsuario",
        errClave:"#errClave",
        errNombreUsu:"#errNombreUsu",
        errApellidos:"#errApellidos",
        errMail:"#errMail",
        errTelefono:"#errTelefono",
        errCiudad:"#errCiudad",
        errWeb:"#errWeb",
        errHobbies:"#errHobbies",
        
        //Errores
        ERtlfn: /^((\+?34([ \t|\-])?)?[9|6|7]((\d{1}([ \t|\-])?[0-9]{3})|(\d{2}([ \t|\-])?[0-9]{2}))([ \t|\-])?[0-9]{2}([ \t|\-])?[0-9]{2})$/ ,
        ERemail: /^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$/,
        ERweb: /^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \?=.-]*)*\/?$/,
        ERweb2:/^(http?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \?=.-]*)*\/?$/
    },
    init: function () {
        var self = this; //that=this
        $(this.config.form_perfilUsu).on('submit', function (event) {
            if (!self.validaPerfilUsu()) {
                event.preventDefault();
            }
        });
        $(this.config.form_registerUsu).on('submit', function (event) {
            if (!self.validaRegisterUsu()) {
                event.preventDefault();
            }
        });
        console.log("controlador usuario inicializado");
    },
    validaPerfilUsu: function () {
        var valido=true;
        var usuario = $(this.config.ibUsuario).val().trim();
        var clave = $(this.config.ibClave).val().trim();
        var nombre_usu = $(this.config.ibNombreUsu).val().trim();
        var apellidos = $(this.config.ibApellidos).val().trim();
        var mail = $(this.config.ibMail).val().trim();
        var telefono = $(this.config.ibTelefono).val().trim();
        var ciudad = $(this.config.ibCiudad).val().trim();
        var web = $(this.config.ibWeb).val().trim();
        var hobbies = $(this.config.ibHobbies).val().trim();
        
        if (usuario.length === 0) {
            $(this.config.errUsuario).text("no puede estar vacío");
            valido=false;
        }else if(usuario.length > 50){
            $(this.config.errUsuario).text("El 'usuario' no puede superar los 50 caracteres");
            valido=false;
        }
        
        if (clave.length === 0) {
            $(this.config.errClave).text("no puede estar vacío");
            valido=false;
        }else if(clave.length > 50){
            $(this.config.errClave).text("La 'clave' no puede superar los 50 caracteres");
            valido=false;
        }
        
        if(nombre_usu.length > 30){
            $(this.config.errNombreUsu).text("El 'nombre' no puede superar los 30 caracteres");
            valido=false;
        }
        
        if(apellidos.length > 40){
            $(this.config.errApellidos).text("Los 'apellidos' no puede superar los 40 caracteres");
            valido=false;
        }
        
        if(mail.length > 40){
            $(this.config.errMail).text("El 'mail' no puede superar los 40 caracteres");
            valido=false;
        }if(!this.config.ERemail.test(mail) && mail.length > 0){
            $(this.config.errMail).text("El email "+mail+" no cumple el formato");
            valido=false;
        }
        
        
        if(!this.config.ERtlfn.test(telefono) && telefono.length>0){
            $(this.config.errTelefono).text("El 'telefono' no es correcto");
            valido=false;
        }
        
        if(ciudad.length > 20){
            $(this.config.errCiudad).text("La 'ciudad' no puede superar los 20 caracteres");
            valido=false;
        }
        
        if(web.length > 40){
            $(this.config.errWeb).text("La 'web' no puede superar los 40 caracteres");
            valido=false;
        }else if(!this.config.ERweb.test(web) && !this.config.ERweb2.test(web) && web.length > 0){
            $(this.config.errWeb).text("La 'web' no tiene el formato correcto");
            valido=false;
        }
        
        if(hobbies.length > 255){
            $(this.config.errHobbies).text("Los 'hobbies' no puede superar los 255 caracteres");
            valido=false;
        }
        
        if(valido){
            console.log("Se ha aceptado el usuario %s", usuario);
            $('#confirm').text("Los datos han sido validados correctamente");
        }else console.log("No se ha aceptado el usuario");
        
        return valido;
    },
    validaRegisterUsu: function () {
        var valido=true;
        var usuario = $(this.config.ibUsuario).val().trim();
        var clave = $(this.config.ibClave).val().trim();
        var nombre_usu = $(this.config.ibNombreUsu).val().trim();
        var apellidos = $(this.config.ibApellidos).val().trim();
        
        if (usuario.length === 0) {
            $(this.config.errUsuario).text("no puede estar vacío");
            valido=false;
        }else if(usuario.length > 50){
            $(this.config.errUsuario).text("El 'usuario' no puede superar los 50 caracteres");
            valido=false;
        }
        
        if (clave.length === 0) {
            $(this.config.errClave).text("no puede estar vacío");
            valido=false;
        }else if(clave.length > 50){
            $(this.config.errClave).text("La 'clave' no puede superar los 50 caracteres");
            valido=false;
        }
        
        if(nombre_usu.length > 30){
            $(this.config.errNombreUsu).text("El 'nombre' no puede superar los 30 caracteres");
            valido=false;
        }
        
        if(apellidos.length > 40){
            $(this.config.errApellidos).text("Los 'apellidos' no puede superar los 40 caracteres");
            valido=false;
        }
        
        if(valido){
            console.log("Se ha aceptado el usuario %s", usuario);
        }else{
            console.log("No se ha aceptado el usuario");
        }
        
        return valido;
    }

};
