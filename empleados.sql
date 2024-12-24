--  Creación de la DB
CREATE DATABASE IF NOT EXISTS empleados_db;

--  Usando la DB
USE empleados_db;

--  Creación de la Tabla Movies
CREATE TABLE IF NOT EXISTS empleados (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    cargo VARCHAR(150) NOT NULL,
    salario DOUBLE,
    fecha_inicio DATETIME(5)
);

--  Insertando datos en la Tabla Movies
INSERT INTO empleados (nombre, apellido, cargo, salario, fecha_inicio)
VALUES
('Maria', "Nelo", "CEO", 6000.0, '2024-03-15 00:00'),
('Daniel', "Aviles", "analista junior", 3000.0, '2023-04-20 00:00'),
('Guillermo', "Figueroa", "analista de ciberseguridad", 3000.0, '2022-05-10 00:00'),
('Frain', "Reyes", "forense", 4000.0, '2024-05-21 00:00'),
('Alex', "", "CISO", 5000.0, '2024-03-15 00:00'),
('Andrea', "Troyano", "programadora", 3000.0, '2021-06-05 00:00')



