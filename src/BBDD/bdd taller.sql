create database Taller

create table Empleado(
usuario varchar (15) primary key,
nombre varchar(15),
apellido1 varchar(15),
apellido2 varchar(15),
departamento varchar(15),
password int
)
insert into Empleado values ('admin','Ali','Smili','Bushido', 'Mecanico', 1234);
insert into Empleado values ('admin2','Jose','Perez','Rodrigez', 'Mecanico', 3456);
insert into Empleado values ('admin3','Felipe','Rosas','Marquez', 'Mecanico', 7890);
insert into Empleado values ('admin4','Emmanuel','Magaña','Perez', 'Mecanico', 0123);
insert into Empleado values ('admin5','Oscar','Palma','Aceituno', 'Mecanico', 2345);

create table Cliente(
dni varchar(9) primary key,
nombre varchar(15),
apellido1 varchar(15),
apellido2 varchar(15),
direccion varchar(50),
email varchar(25),
telefono int,
comentarios varchar(max)
)

create table Vehiculo (
matricula varchar(10) primary key,
marca varchar(10),
modelo varchar(10),
dni varchar(9) foreign key REFERENCES Cliente,
tipo int  CHECK (tipo='Coche' OR tipo='Moto' OR tipo='Camion'),
color varchar(10)
)

create table Reparacion(
idReparacion varchar(10) primary key,
matricula varchar(10) foreign key REFERENCES Vehiculo,
fechainicio datetime,
fechafin datetime,
averia varchar(max),
estado varchar(10)									--En la bbdd resulta más representativo un varchar para ver el estado de la averia y si se ha reparado el vehiculo
)



