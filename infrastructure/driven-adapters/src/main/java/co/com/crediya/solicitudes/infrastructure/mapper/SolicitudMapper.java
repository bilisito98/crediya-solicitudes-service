package co.com.crediya.solicitudes.infrastructure.mapper;

import co.com.crediya.solicitudes.domain.model.Solicitud;
import co.com.crediya.solicitudes.infrastructure.entity.SolicitudEntity;

public class SolicitudMapper {

    public static SolicitudEntity toEntity(Solicitud solicitud) {
        if (solicitud == null) return null;
        return SolicitudEntity.builder()
                .id(solicitud.getId())
                .clienteId(solicitud.getClienteId())
                .numero(solicitud.getNumero())
                .monto(solicitud.getMonto())
                .plazoMeses(solicitud.getPlazoMeses())
                .estado(solicitud.getEstado())
                .fechaCreacion(solicitud.getFechaCreacion())
                .usuarioId(solicitud.getUsuarioId())
                .fecha(solicitud.getFecha())
                .build();
    }

    public static Solicitud toModel(SolicitudEntity entity) {
        if (entity == null) return null;
        return Solicitud.builder()
                .id(entity.getId())
                .clienteId(entity.getClienteId())
                .numero(entity.getNumero())
                .monto(entity.getMonto())
                .plazoMeses(entity.getPlazoMeses())
                .estado(entity.getEstado())
                .fechaCreacion(entity.getFechaCreacion())
                .usuarioId(entity.getUsuarioId())
                .fecha(entity.getFecha())
                .build();
    }
}

