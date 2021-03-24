--Delete previous tables
DROP TABLE Recursos;

create table Recursos
(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	nombre VARCHAR(35),
	tipo VARCHAR(25),
	descripcion VARCHAR(255),
        descargas INTEGER,
        likes INTEGER,
        privacidad BOOLEAN,
        usuario VARCHAR(50),
        fecha DATE,
        hora TIME
);

-- Insert sample records
insert into Recursos (nombre,tipo,descripcion,descargas,likes,privacidad,usuario,fecha,hora) VALUES ('RecursoBBDD1','Recur de BBDD','Este es un recurso de prueba de JOSE7PC almacenado en la BBDD Dervy de Oracle.',201,50,false,'jjpc0007','2017-03-15','09:21:15');
insert into Recursos (nombre,tipo,descripcion,descargas,likes,privacidad,usuario,fecha,hora) VALUES ('RecursoBBDD2','Recur de BBDD','Este es un recurso almacenado en la BBDD Dervy de Oracle.',0,0,false,'Pepa','2017-03-18','09:21:15');
insert into Recursos (nombre,tipo,descripcion,descargas,likes,privacidad,usuario,fecha,hora) VALUES ('RecursoBBDD3','Recur de BBDD','Este es un recurso almacenado en la BBDD Dervy de Oracle.',0,0,false,'jjpc0007','2017-04-01','09:21:15');
insert into Recursos (nombre,tipo,descripcion,descargas,likes,privacidad,usuario,fecha,hora) VALUES ('RecursoBBDD4','Recur de BBDD','Este es un recurso almacenado en la BBDD Dervy de Oracle.',0,0,false,'jmvm0014','2017-01-03','19:25:15');
insert into Recursos (nombre,tipo,descripcion,descargas,likes,privacidad,usuario,fecha,hora) VALUES ('RecursoBBDD5','Recur de BBDD','Este es un recurso almacenado en la BBDD Dervy de Oracle.',0,0,true,'jmvm0014','2017-03-03','19:26:15');
insert into Recursos (nombre,tipo,descripcion,descargas,likes,privacidad,usuario,fecha,hora) VALUES ('RecursoBBDD6','Recur de BBDD','Este es un recurso almacenado en la BBDD Dervy de Oracle.',0,0,false,'jjpc0007','2017-04-01','08:26:15');
insert into Recursos (nombre,tipo,descripcion,descargas,likes,privacidad,usuario,fecha,hora) VALUES ('RecursoBBDD7','Recur de BBDD','Este es un recurso almacenado en la BBDD Dervy de Oracle.',0,0,false,'jjpc0007','2017-03-03','09:26:15');
insert into Recursos (nombre,tipo,descripcion,descargas,likes,privacidad,usuario,fecha,hora) VALUES ('RecursoBBDD8','Recur de BBDD','Este es un recurso almacenado en la BBDD Dervy de Oracle.',0,0,true,'jmvm0014','2017-01-03','09:26:15');
insert into Recursos (nombre,tipo,descripcion,descargas,likes,privacidad,usuario,fecha,hora) VALUES ('RecursoBBDD9','Recur de BBDD','Este es un recurso almacenado en la BBDD Dervy de Oracle.',0,0,false,'jmvm0014','2017-02-03','09:26:15');
insert into Recursos (nombre,tipo,descripcion,descargas,likes,privacidad,usuario,fecha,hora) VALUES ('RecursoBBDD10','Recur de BBDD','Este es un recurso almacenado en la BBDD Dervy de Oracle.',0,0,false,'jjpc0007','2017-04-01','09:26:15');
insert into Recursos (nombre,tipo,descripcion,descargas,likes,privacidad,usuario,fecha,hora) VALUES ('RecursoBBDD11','Recur de BBDD','Este es un recurso almacenado en la BBDD Dervy de Oracle.',0,0,false,'jjpc0007','2017-04-02','09:26:15');
insert into Recursos (nombre,tipo,descripcion,descargas,likes,privacidad,usuario,fecha,hora) VALUES ('RecursoBBDD12','Recur de BBDD','Este es un recurso almacenado en la BBDD Dervy de Oracle.',0,0,false,'jmvm0014','2017-04-03','09:26:15');

DROP TABLE Usuarios;
DROP TABLE Roles;

create table Usuarios (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    usuario VARCHAR(50) not null primary key,
    clave VARCHAR(50) not null,
    nombre VARCHAR(30),
    apellidos VARCHAR(40),
    mail VARCHAR(40),
    telefono INTEGER,
    pais VARCHAR(20),
    ciudad VARCHAR(20),
    web VARCHAR(40),
    hobbies VARCHAR(255),
    fecha_crea DATE );

create table Roles (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    usuario VARCHAR(50) not null,
    rol VARCHAR(50) not null );

insert into Usuarios (usuario,clave,nombre,apellidos,mail,telefono,pais,ciudad,web,hobbies,fecha_crea) values ('jmvm0014','0014','Jose Maria','Viñas Martinez','jmvm0014@red.ujaen.es',666666666,'España','Jaen',' ','Mis hobbies son programar en HTML5 aplicaciones como esta.','2017-04-01');
insert into Usuarios (usuario,clave,nombre,apellidos,mail,telefono,pais,ciudad,web,hobbies,fecha_crea) values ('jjpc0007','0007','Jose Javier','Perez Cruz','jjpc0007@red.ujaen.es',666666666,'España','Alcobendas',' ','Mis hobbies son tantos que no cabrían en la base de datos debido al tamaño maximo de esta columna, por eso no los pongo.','2017-04-05');
insert into Roles (usuario,rol) values ('jmvm0014','USUARIOS');
insert into Roles (usuario,rol) values ('jjpc0007','ADMINISTRADORES');

