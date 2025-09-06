CREATE TABLE IF NOT EXISTS solicitudes (
                                           id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    cliente_id UUID NOT NULL,
    tipo_prestamo_id INT NOT NULL,
    monto NUMERIC(15,2) NOT NULL CHECK (monto > 0),
    plazo_meses INT NOT NULL CHECK (plazo_meses > 0),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_cliente FOREIGN KEY (cliente_id)
    REFERENCES clientes(id) ON DELETE CASCADE,

    CONSTRAINT fk_tipo_prestamo FOREIGN KEY (tipo_prestamo_id)
    REFERENCES tipos_prestamo(id) ON DELETE RESTRICT
    );
