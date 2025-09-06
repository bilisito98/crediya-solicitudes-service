package co.com.crediya.solicitudes.infrastructure.mapper;

import co.com.crediya.solicitudes.domain.model.Cliente;
import co.com.crediya.solicitudes.infrastructure.entity.ClienteEntity;

/**
 * Mapea entre Cliente (dominio) y ClienteEntity (persistencia).
 */
public class ClienteMapper {

    /**
     * Convierte de entidad a dominio.
     *
     * @param entity ClienteEntity
     * @return Cliente dominio
     */
    public static Cliente toDomain(ClienteEntity entity) {
        if (entity == null) return null;
        return Cliente.builder()
                .id(entity.getId())
                .nombres(entity.getNombres())
                .apellidos(entity.getApellidos())
                .correoElectronico(entity.getCorreoElectronico())
                .telefono(entity.getTelefono())
                .documento(entity.getDocumento())
                .build();
    }

    /**
     * Convierte de dominio a entidad.
     *
     * @param domain Cliente dominio
     * @return ClienteEntity
     */
    public static ClienteEntity toEntity(Cliente domain) {
        if (domain == null) return null;
        return ClienteEntity.builder()
                .id(domain.getId())
                .nombres(domain.getNombres())
                .apellidos(domain.getApellidos())
                .correoElectronico(domain.getCorreoElectronico())
                .telefono(domain.getTelefono())
                .documento(domain.getDocumento())
                .build();
    }
}
