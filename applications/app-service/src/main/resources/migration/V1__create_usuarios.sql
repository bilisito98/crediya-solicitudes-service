CREATE TABLE IF NOT EXISTS usuarios (
                                        id UUID PRIMARY KEY,
                                        nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    direccion VARCHAR(200),
    telefono VARCHAR(50),
    correo_electronico VARCHAR(150) UNIQUE NOT NULL,
    salario_base NUMERIC(15,2) NOT NULL
    );
