create database HOTELESPROYECTO;

use HOTELESPROYECTO;

create table USUARIOS(
	id_usuario int auto_increment,
    email varchar(255) not null unique,
    pass varchar(30) not null,
    nombre varchar(255) not null,
    apellido varchar(255) not null,
    primary key(id_usuario)
);

create table huespedes(
    id_huesped int auto_increment,
    nombre varchar(255) not null,
    apellido varchar(255) not null,
    email varchar(255) not null unique,
    fecha_nacimiento date not null,
    id_nacionalidad int not null,
    telefono varchar(255) not null,
    primary key(id_huesped)
);

create table paises(
    id_nacionalidad int auto_increment,
    nombre varchar(255) not null,
    primary key(id_nacionalidad)
);

create table hoteles (
  id_hotel int auto_increment primary key,
  nombre_hotel varchar(255) not null
);

create table tipos_habitacion (
  id_tipo_habitacion int auto_increment primary key,
  nombre_tipo_habitacion varchar(255) not null,
  descripcion_tipo_habitacion text not null
);

create table habitaciones (
  id_habitacion int auto_increment primary key,
  id_hotel int not null,
  id_tipo_habitacion int not null,
  num_habitacion int not null,
  precio_habitacion decimal(10, 2) not null,
  max_personas int not null,
  disponible bool not null default true
);

-- CREATE TABLE servicios_habitacion (
--   id_servicio_habitacion INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
--   nombre_servicio_habitacion VARCHAR(255) NOT NULL,
--   descripcion_servicio_habitacion TEXT NOT NULL
-- );

-- CREATE TABLE servicios_hotel (
--   id_servicio_hotel INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
--   nombre_servicio_hotel VARCHAR(255) NOT NULL,
--   descripcion_servicio_hotel TEXT NOT NULL
-- );

create table reservaciones (
  id_reservacion int auto_increment primary key,
  id_huesped int not null,
  id_habitacion int not null,
  fecha_inicio date not null,
  fecha_fin date not null,
  num_personas int not null,
  id_metodo_pago int not null
);

create table facturacion (
  id_factura int auto_increment primary key,
  id_reservacion int not null,
  monto_total decimal(10, 2) not null,
  fecha_pago date not null
);

create table metodos_pago (
  id_metodo_pago int auto_increment primary key,
  nombre_metodo_pago varchar(255) not null
);

alter table habitaciones 
add constraint fk_id_hotel foreign key (id_hotel) references hoteles(id_hotel) on update cascade on delete cascade,
add constraint fk_id_tipo_habitacion foreign key (id_tipo_habitacion) references tipos_habitacion(id_tipo_habitacion) on update cascade on delete cascade;

alter table reservaciones 
add constraint fk_id_huesped foreign key (id_huesped) references huespedes(id_huesped) on update cascade on delete cascade,
add constraint fk_id_habitacion foreign key (id_habitacion) references habitaciones(id_habitacion) on update cascade on delete cascade,
add constraint fk_id_metodo_pago foreign key (id_metodo_pago) references metodos_pago(id_metodo_pago) on update cascade on delete cascade;

alter table facturacion 
add constraint fk_id_reservacion foreign key (id_reservacion) references reservaciones(id_reservacion) on update cascade on delete cascade;

alter table huespedes 
add constraint fk_id_nacionalidad foreign key (id_nacionalidad) references paises(id_nacionalidad) on update cascade on delete cascade;

insert into paises(nombre) values 
('Afganistán'),
('Albania'),
('Alemania'),
('Andorra'),
('Angola'),
('Antigua y Barbuda'),
('Arabia Saudita'),
('Argelia'),
('Argentina'),
('Armenia'),
('Australia'),
('Austria'),
('Azerbaiyán'),
('Bahamas'),
('Bangladés'),
('Barbados'),
('Baréin'),
('Bélgica'),
('Belice'),
('Benín'),
('Bielorrusia'),
('Birmania'),
('Bolivia'),
('Bosnia y Herzegovina'),
('Botsuana'),
('Brasil'),
('Brunéi'),
('Bulgaria'),
('Burkina Faso'),
('Burundi'),
('Bután'),
('Cabo Verde'),
('Camboya'),
('Camerún'),
('Canadá'),
('Catar'),
('Chad'),
('Chile'),
('China'),
('Chipre'),
('Ciudad del Vaticano'),
('Colombia'),
('Comoras'),
('Corea del Norte'),
('Corea del Sur'),
('Costa de Marfil'),
('Costa Rica'),
('Croacia'),
('Cuba'),
('Dinamarca'),
('Dominica'),
('Ecuador'),
('Egipto'),
('El Salvador'),
('Emiratos Árabes Unidos'),
('Eritrea'),
('Eslovaquia'),
('Eslovenia'),
('España'),
('Estados unidos'),
('Estonia'),
('Etiopía'),
('Filipinas'),
('Finlandia'),
('Fiyi'),
('Francia'),
('Gabón'),
('gambia'),
('georgia'),
('Ghana'),
('Granada'),
('Grecia'),
('guatemala'),
('Guinea'),
('guinea-Bisáu'),
('Guinea Ecuatorial'),
('Guyana'),
('Haití'),
('Honduras'),
('Hungría'),
('India'),
('Indonesia'),
('Irak'),
('Irán'),
('Irlanda'),
('Islandia'),
('Islas Marshall'),
('Islas Salomón'),
('Israel'),
('Italia'),
('Jamaica'),
('Japón'),
('Jordania'),
('Kazajistán'),
('Kenia'),
('Kirguistán'),
('Kiribati'),
('Kuwait'),
('Laos'),
('Lesoto'),
('Letonia'),
('Líbano'),
('Liberia'),
('Libia'),
('Liechtenstein'),
('Lituania'),
('Luxemburgo'),
('Madagascar'),
('Malasia'),
('Malaui'),
('Maldivas'),
('Malí'),
('Malta'),
('Marruecos'),
('Mauricio'),
('Mauritania'),
('México'),
('Micronesia'),
('Moldavia'),
('Mónaco'),
('Mongolia'),
('Montenegro'),
('Mozambique'),
('Namibia'),
('Nauru'),
('Nepal'),
('Nicaragua'),
('Níger'),
('Nigeria'),
('Noruega'),
('Nueva Zelanda'),
('Omán'),
('Países Bajos'),
('Pakistán'),
('Palaos'),
('Panamá'),
('Papúa Nueva Guinea'),
('Paraguay'),
('Perú'),
('Polonia'),
('Portugal'),
('Reino Unido'),
('República Centroafricana'),
('República Checa'),
('República del Congo'),
('República Democrática del Congo'),
('República Dominicana'),
('República sudafricana'),
('Ruanda'),
('Rumania'),
('Rusia'),
('Samoa'),
('San Cristóbal y nieves'),
('San Marino'),
('San Vicente y las Granadinas'),
('Santa Lucía'),
('Santo Tomé y Príncipe'),
('Senegal'),
('Serbia'),
('Seychelles'),
('Sierra Leona'),
('Singapur'),
('Siria'),
('Somalia'),
('Sri lanka'),
('Suazilandia'),
('Sudán'),
('Sudán del Sur'),
('Suecia'),
('Suiza'),
('Surinam'),
('Tailandia'),
('Tanzania'),
('Tayikistán'),
('Timor Oriental'),
('Togo'),
('Tonga'),
('Trinidad y Tobago'),
('Túnez'),
('Turkmenistán'),
('Turquía'),
('tuvalu'),
('Ucrania'),
('Uganda'),
('Uruguay'),
('Uzbekistán'),
('Vanuatu'),
('Venezuela'),
('Vietnam'),
('Yemen'),
('Yibuti'),
('Zambia'),
('Zimbabue');

insert into usuarios (email, pass, nombre, apellido)
values
('admin@alura.com','12345', 'Admin', 'Alura'),
('dei@alura.com','12345', 'Deivi', 'Campos');

insert into hoteles(nombre_hotel)
values
('Alurebi'),
('Gökolura');

INSERT INTO huespedes (nombre, apellido, email, fecha_nacimiento, id_nacionalidad, telefono) 
VALUES 
('Ava', 'Dubois', 'ava.dubois@gmail.com', '1992-05-12', 66, '+33 6 12 34 56 78'), -- Francia
('Oliver', 'Kim', 'oliver.kim@gmail.com', '1985-09-23', 45, '+82 10-1234-5678'), -- Corea del Sur
('Liam', 'Garcia', 'liam.garcia@gmail.com', '1998-03-15', 60, '+1 212-555-0123'), -- Estados Unidos
('Emilia', 'Santos', 'emilia.santos@gmail.com', '1987-08-29', 26, '+55 11 9 8765-4321'), -- Brasil
('Gabriella', 'Aalto', 'gabriella.aalto@gmail.com', '1995-06-08', 64, '+358 40 1234567'), -- Finlandia
('Luka', 'Horvat', 'luka.horvat@gmail.com', '1990-12-03', 48, '+385 1 1234567'), -- Croacia
('Maria', 'González', 'maria.gonzalez@gmail.com', '1979-11-21', 59, '+34 912 345 678'), -- España
('Hans', 'Johansen', 'hans.johansen@gmail.com', '1983-04-17', 130, '+47 123 45 678'), -- Noruega
('Anastasia', 'Ivanova', 'anastasia.ivanova@gmail.com', '1994-02-06', 151, '+7 495 123-45-67'), -- Rusia
('Giuseppe', 'Rizzo', 'giuseppe.rizzo@gmail.com', '1982-07-11', 90, '+39 06 1234567'), -- Italia
('Mia', 'Andersson', 'mia.andersson@gmail.com', '1996-01-30', 11, '+46 8 123 45 67'), -- Suecia
('Hassan', 'Ali', 'hassan.ali@gmail.com', '1991-10-20', 169, '+92 21 1234567'), -- Pakistán
('Raphael', 'Bouchard', 'raphael.bouchard@gmail.com', '1988-09-16', 35, '+1 514-555-1234'), -- Canadá
('Ayumi', 'Sato', 'ayumi.sato@gmail.com', '1997-12-24', 92, '+81 3-1234-5678'), -- Japón
('Sebastian', 'García', 'sebastian.garcia@gmail.com', '1993-06-27', 42, '+57 1 1234567'), -- Colombia
("Andrea", "Castillo", "acastillo@gmail.com", "1990-05-15", 42, "+1 555-555-5555"), -- Colombia
("Mariano", "Gómez", "mgomez@hotmail.com", "1985-02-10", 9, "+54 9 11 5555-5555"), -- Argentina
("Eliza", "Johnson", "eliza_johnson@yahoo.com", "1996-09-22", 60, "+1 555-555-5555"), -- Estados Unidos
("Hans", "Schmidt", "hansschmidt@gmail.com", "1982-11-07", 3, "+49 5555 555555"), -- Alemania
("Sophie", "Dubois", "sophie_dubois@gmail.com", "1998-04-30", 66, "+33 6 55 55 55 55"), -- Francia
("Alessandro", "Russo", "arusso@hotmail.com", "1995-06-01", 90, "+39 555 555 5555"), -- Italia
("Sofia", "Vargas", "svargas@gmail.com", "1989-12-12", 47, "+506 310 5555555"), -- Costa Rica
("Juan", "Rodríguez", "jrodriguez@hotmail.com", "1978-08-08", 47, "+506 316 5555555"), -- Costa Rica
("Héctor", "González", "hectorgonzalez@yahoo.com", "1990-02-28", 118, "+52 55 5555 5555"), -- México
("Lucía", "Sánchez", "luciasanchez@hotmail.com", "1984-05-03", 118, "+52 55 5555 5555"), -- México
("Chiara", "Rossi", "chiara.rossi@gmail.com", "1993-01-20", 90, "+39 333 5555555"), -- Italia
("Rafael", "Castro", "rafael.castro@yahoo.com", "1987-07-15", 9, "+54 9 11 5555-5555"), -- Argentina
("Emilia", "Martínez", "emilia_martinez@gmail.com", "1996-11-25", 9, "+54 9 11 5555-5555"), -- Argentina
("Jesper", "Lund", "jesper_lund@hotmail.com", "1980-03-18", 50, "+45 55 55 55 55"), -- Dinamarca
("Lena", "Klein", "lenaklein@gmail.com", "1991-12-04", 3, "+49 5555 555555"); -- Alemania


-- alurebi
INSERT INTO tipos_habitacion (nombre_tipo_habitacion, descripcion_tipo_habitacion)
VALUES
('Oceanía', 'Habitación con cama king size y vista panorámica al océano Pacífico.'),
('Presidencial', 'Amplia habitación con cama king size, sala de estar, jacuzzi privado y vista al mar.'),
('Palma Real', 'Habitación con cama king size, balcón privado y vista al jardín tropical.'),
('Tropicalia', 'Habitación con dos dormitorios, cada uno con cama king size, sala de estar y vista a la selva tropical.'),
('Brisas del Este', 'Habitación con cama king size, bañera de hidromasaje y vista al amanecer caribeño.'),
('Vistas del Sur', 'Habitación con cama king size, terraza privada y vista panorámica a la bahía.'),
('Suite Sinfonía', 'Habitación con cama king size, sala de estar, jacuzzi privado y vista panorámica al océano.');

INSERT INTO habitaciones (id_hotel, id_tipo_habitacion, num_habitacion, precio_habitacion, max_personas)
VALUES
(1, 1, 101, 100.00, 2),
(1, 1, 102, 100.00, 2),
(1, 1, 103, 100.00, 2),
(1, 1, 104, 100.00, 2),
(1, 1, 105, 100.00, 2),
(1, 2, 106, 150.00, 2),
(1, 2, 107, 150.00, 2),
(1, 2, 108, 150.00, 2),
(1, 2, 109, 150.00, 2),
(1, 2, 110, 150.00, 2),
(1, 3, 201, 250.00, 3),
(1, 3, 202, 250.00, 3),
(1, 3, 203, 250.00, 3),
(1, 3, 204, 250.00, 3),
(1, 3, 205, 250.00, 3),
(1, 4, 303, 350.00, 4),
(1, 4, 303, 350.00, 4),
(1, 4, 304, 350.00, 4),
(1, 4, 305, 350.00, 4),
(1, 4, 306, 350.00, 4),
(1, 5, 407, 300.00, 2),
(1, 5, 408, 300.00, 2),
(1, 5, 409, 300.00, 2),
(1, 5, 410, 300.00, 2),
(1, 5, 411, 300.00, 2),
(1, 6, 01, 1000.00, 2),
(1, 7, 02, 1500.00, 2);

-- gotolura
INSERT INTO tipos_habitacion (nombre_tipo_habitacion, descripcion_tipo_habitacion) 
VALUES 
('Selva Esmeralda', 'Habitación con cama king size y vista a la exuberante selva tropical.'),
('Suite Imperial', 'Amplia habitación con cama king size, sala de estar, chimenea y vista panorámica a la selva.'),
('Río Azul', 'Habitación con cama king size, balcón privado y vista al río cristalino.'),
('Suite Foresta', 'Habitación con dos dormitorios, cada uno con cama king size, sala de estar y vista a la selva tropical.'),
('Montaña Dorada', 'Habitación con cama king size, bañera de hidromasaje y vista panorámica a las montañas.'),
('Cascada de Cristal', 'Habitación con cama king size, terraza privada y vista a la cascada de agua cristalina.'),
('Cielo del Bosque', 'Habitación con cama king size, sala de estar, chimenea y vista panorámica a la selva.');

INSERT INTO habitaciones (id_hotel, id_tipo_habitacion, num_habitacion, precio_habitacion, max_personas)
VALUES
(2, 6, 101, 100.00, 2),
(2, 6, 102, 100.00, 2),
(2, 6, 103, 100.00, 2),
(2, 6, 104, 100.00, 2),
(2, 6, 105, 100.00, 2),
(2, 7, 106, 150.00, 2),
(2, 7, 107, 150.00, 2),
(2, 7, 108, 150.00, 2),
(2, 7, 109, 150.00, 2),
(2, 7, 110, 150.00, 2),
(2, 8, 201, 250.00, 3),
(2, 8, 202, 250.00, 3),
(2, 8, 203, 250.00, 3),
(2, 8, 204, 250.00, 3),
(2, 8, 205, 250.00, 3),
(2, 9, 303, 350.00, 4),
(2, 9, 303, 350.00, 4),
(2, 9, 304, 350.00, 4),
(2, 9, 305, 350.00, 4),
(2, 9, 306, 350.00, 4),
(2, 10, 407, 300.00, 2),
(2, 10, 408, 300.00, 2),
(2, 10, 409, 300.00, 2),
(2, 10, 410, 300.00, 2),
(2, 10, 411, 300.00, 2),
(2, 11, 01, 2000.00, 2),
(2, 12, 02, 3500.00, 2);

-- Crear algunos métodos de pago
INSERT INTO metodos_pago (nombre_metodo_pago) VALUES
('Tarjeta de crédito'),
('PayPal'),
('Criptomoneda'),
('Transferencia bancaria'),
('Efectivo');

-- Crear algunas facturas
-- INSERT INTO facturacion (id_reservacion, monto_total, fecha_pago) VALUES
-- (1, 300.00, '2023-06-15'),
-- (2, 600.00, '2023-07-01'),
-- (3, 1000.00, '2023-08-10'),
-- (4, 350.00, '2023-09-01'),
-- (5, 1800.00, '2023-10-01'),
-- (6, 200.00, '2023-12-24'),
-- (7, 1200.00, '2023-12-28'),
-- (8, 2500.00, '2024-01-15'),
-- (9, 400.00, '2024-02-14'),
-- (10, 800.00, '2024-03-01');

Delimiter $$
CREATE TRIGGER insert_facturacion AFTER INSERT ON reservaciones
FOR EACH ROW
BEGIN
    DECLARE monto_total DECIMAL(10, 2);
    DECLARE fecha_pago DATE;
    SELECT precio_habitacion INTO monto_total FROM habitaciones WHERE id_habitacion = NEW.id_habitacion;
    SET monto_total = monto_total * (DATEDIFF(NEW.fecha_fin, NEW.fecha_inicio) + 1);
    SET fecha_pago = NEW.fecha_inicio;
    
    INSERT INTO facturacion (id_reservacion, monto_total, fecha_pago)
    VALUES (NEW.id_reservacion, monto_total, fecha_pago);
    
    UPDATE habitaciones SET disponible = FALSE WHERE id_habitacion = NEW.id_habitacion;
END;
$$

Delimiter $$
CREATE TRIGGER update_facturacion AFTER UPDATE ON reservaciones
FOR EACH ROW
BEGIN
    DECLARE monto_total DECIMAL(10, 2);
    DECLARE fecha_pago DATE;
    SELECT precio_habitacion INTO monto_total FROM habitaciones WHERE id_habitacion = NEW.id_habitacion;
    SET monto_total = monto_total * DATEDIFF(NEW.fecha_fin, NEW.fecha_inicio);
    SET fecha_pago = NEW.fecha_inicio;
    
    UPDATE facturacion SET monto_total = monto_total, fecha_pago = fecha_pago WHERE id_reservacion = NEW.id_reservacion;
    
END;
$$

Delimiter $$
CREATE PROCEDURE liberarHabitaciones()
BEGIN
  UPDATE habitaciones
  SET disponible = true
  WHERE id_habitacion IN (
    SELECT r.id_habitacion
    FROM reservaciones r
    WHERE r.fecha_fin < CURDATE()
  );
END;
$$
-- Crear algunas reservaciones
INSERT INTO reservaciones (id_huesped, id_habitacion, fecha_inicio, fecha_fin, num_personas,id_metodo_pago)
VALUES
(1, 1, '2023-03-15', '2023-03-18', 2, 5),
(2, 25, '2023-07-01', '2023-07-05', 2, 4),
(3, 33, '2023-08-10', '2023-08-14', 4, 2),
(4, 50, '2023-09-01', '2023-09-03', 2, 1),
(5, 5, '2023-10-01', '2023-10-07', 2, 1),
(6, 11, '2023-12-24', '2023-12-26', 2, 2),
(7, 22, '2023-12-28', '2024-01-02', 2, 3),
(8, 31, '2024-01-15', '2024-01-20', 4, 2),
(9, 10, '2024-02-14', '2024-02-16', 2, 5),
(10, 14, '2024-03-01', '2024-03-05', 2, 3);

-- call liberarHabitaciones;















