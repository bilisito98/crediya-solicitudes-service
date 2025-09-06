package co.com.crediya.solicitudes.infrastructure.mapper;

import co.com.crediya.solicitudes.domain.model.Solicitud;
import co.com.crediya.solicitudes.infrastructure.entity.SolicitudEntity;

public final class SolicitudMapper {

    private SolicitudMapper() {}

    public static Solicitud toDomain(SolicitudEntity entity) {
        if (entity == null) return null;
        return new Solicitud(
                entity.getId(),
                entity.getClienteId(),
                entity.getDocumentoIdentidad(),
                entity.getNumero(),
                entity.getMonto(),
                entity.getPlazoMeses(),
                entity.getTipoPrestamo(),
                entity.getEstado(),
                entity.getFechaCreacion(),
                entity.getUsuarioId()
        );
    }

    public static SolicitudEntity toEntity(Solicitud domain) {
        if (domain == null) return null;
        return SolicitudEntity.builder()
                .id(domain.getId())
                .clienteId(domain.getClienteId())
                .documentoIdentidad(domain.getDocumentoIdentidad())
                .numero(domain.getNumero())
                .monto(domain.getMonto())
                .plazoMeses(domain.getPlazoMeses())
                .tipoPrestamo(domain.getTipoPrestamo())
                .estado(domain.getEstado())
                .fechaCreacion(domain.getFecha())
                .usuarioId(domain.getUsuarioId())
                .build();
    }
}
