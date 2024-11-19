
CREATE TABLE IF NOT EXISTS roles (
    id SERIAL PRIMARY KEY,
    codeText CHAR(8) NOT NULL,
    name_rol VARCHAR(50) NOT NULL,
    description VARCHAR(1000) NOT NULL
    );


CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    codeText CHAR(8) NOT NULL,
    fullname VARCHAR(50) NOT NULL,
    cedula INT NOT NULL,
    email VARCHAR(50) NOT NULL,
    roll_id INT,
    password VARCHAR(25),
    FOREIGN KEY (roll_id) REFERENCES roles(id)
    );


CREATE TABLE IF NOT EXISTS dispositivos (
    id SERIAL PRIMARY KEY,
    codeText CHAR(8) NOT NULL,
    latitud DOUBLE PRECISION,
    longitud DOUBLE PRECISION,
    nivel_capacidad INT,
    dateCreacion DATE,
    estado VARCHAR(50),
    last_mantenimiento DATE
    );


CREATE TABLE IF NOT EXISTS containers (
    id SERIAL PRIMARY KEY,
    codeText CHAR(8) NOT NULL,
    capacidad INT,
    last_emptying DATE,
    id_dispositivo INT,
    FOREIGN KEY (id_dispositivo) REFERENCES dispositivos(id)
    );
