$(function () {
    valida_recu.init();
});

var valida_recu = {
    config: {
        ibNombreRecu:"[name=nombre]",
        ibTipo:"[name=tipo]",
        ibDescripcion:"[name=descripcion]",
        
        //Formularios
        form_creaRecu:"#creaRecu",
        form_editaRecu:"#editaRecu",

        //Mensajes error
        errNombreRecu:"#errNombreRecu",
        errTipo:"#errTipo",
        errDescripcion:"#errDescripcion"
        
    },
    init: function () {
        var self = this; //that=this
        $(this.config.form_creaRecu).on('submit', function (event) {
            if (!self.validaRecurso()) {
                event.preventDefault();
            }
        });
        $(this.config.form_editaRecu).on('submit', function (event) {
            if (!self.validaRecurso()) {
                event.preventDefault();
            }
        });
        console.log("controlador recurso inicializado");
    },
    validaRecurso: function () {
        var valido=true;
        var nombre_recu = $(this.config.ibNombreRecu).val().trim();
        var tipo = $(this.config.ibTipo).val().trim();
        var descripcion = $(this.config.ibDescripcion).val().trim();
        
        if (nombre_recu.length === 0) {
            $(this.config.errNombreRecu).text("no puede estar vacío");
            valido=false;
        }else if(nombre_recu.length > 35){
            $(this.config.errNombreRecu).text("El 'nombre' no puede superar los 35 caracteres");
            valido=false;
        }
        
        if (tipo.length === 0) {
            $(this.config.errTipo).text("no puede estar vacío");
            valido=false;
        }else if(tipo.length > 25){
            $(this.config.errTipo).text("El 'tipo' no puede superar los 25 caracteres");
            valido=false;
        }
        
        if (descripcion.length === 0) {
            $(this.config.errDescripcion).text("no puede estar vacío");
            valido=false;
        }else if(descripcion.length > 255){
            $(this.config.errDescripcion).text("La 'descripcion' no puede superar los 255 caracteres");
            valido=false;
        }
        
        if(valido){
            console.log("Se ha aceptado el recurso %s", nombre_recu);
            $('#confirm').text("Los datos han sido validados correctamente");
        }else{
            console.log("No se ha aceptado el recurso");
        }
        
        return valido;
    }

};
