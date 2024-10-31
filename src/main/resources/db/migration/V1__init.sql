CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    codeText VARCHAR(100) NOT NULL,
    fullname VARCHAR(50) NOT NULL,
    cedula INT NOT NULL,
    email VARCHAR(50) NOT NULL,
    roll_id INT,
    password VARCHAR(25)
    );

    CREATE TABLE IF NOT EXISTS dispositivos (
    id SERIAL PRIMARY KEY,
    codeText VARCHAR(100),
    location VARCHAR(100),
    dateCreacion DATE,
    estado VARCHAR(50),
    last_mantenimiento DATE
    );

CREATE TABLE IF NOT EXISTS containers (
    id SERIAL PRIMARY KEY,
    codeText VARCHAR(100),
    location VARCHAR(100),
    capacidad INT,
    last_emptying DATE,
    filling_weight INT,
    id_dispositivo INT,
    FOREIGN KEY (id_dispositivo) REFERENCES dispositivos(id)
    );
