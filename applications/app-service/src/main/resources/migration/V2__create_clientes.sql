CREATE TABLE IF NOT EXISTS clientes (
                                        id UUID PRIMARY KEY,
                                        nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    correo_electronico VARCHAR(150) UNIQUE NOT NULL,
    telefono VARCHAR(50),
    documento VARCHAR(50) UNIQUE NOT NULL
    );
