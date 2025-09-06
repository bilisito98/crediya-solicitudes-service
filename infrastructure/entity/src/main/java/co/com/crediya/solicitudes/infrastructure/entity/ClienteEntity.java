package co.com.crediya.solicitudes.infrastructure.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

/**
 * Entidad R2DBC para clientes.
 */
@Data
@Builder
@Table("clientes")
public class ClienteEntity {

    @Id
    private UUID id;

    private String nombres;
    private String apellidos;
    private String documento;
    private String correoElectronico;
    private String telefono;
}
