CREATE TABLE IF NOT EXISTS tipos_prestamo (
                                              id SERIAL PRIMARY KEY,
                                              nombre VARCHAR(50) UNIQUE NOT NULL
    );

INSERT INTO tipos_prestamo (nombre) VALUES
                                        ('PERSONAL'),
                                        ('HIPOTECARIO'),
                                        ('VEHICULO'),
                                        ('EDUCATIVO')
    ON CONFLICT (nombre) DO NOTHING;
