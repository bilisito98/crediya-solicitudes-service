package co.com.crediya.solicitudes.infrastructure.mapper;

import co.com.crediya.solicitudes.domain.model.Usuario;
import co.com.crediya.solicitudes.infrastructure.entity.UsuarioEntity;

public class UsuarioMapper {

    private UsuarioMapper() {

    }

    public static Usuario toDomain(UsuarioEntity entity) {
        if (entity == null) {
            return null;
        }
        return Usuario.builder()
                .id(entity.getId())
                .nombres(entity.getNombres())
                .apellidos(entity.getApellidos())
                .fechaNacimiento(entity.getFechaNacimiento())
                .direccion(entity.getDireccion())
                .telefono(entity.getTelefono())
                .correoElectronico(entity.getCorreoElectronico())
                .salarioBase(entity.getSalarioBase())
                .build();
    }

    public static UsuarioEntity toEntity(Usuario domain) {
        if (domain == null) {
            return null;
        }
        return UsuarioEntity.builder()
                .id(domain.getId())
                .nombres(domain.getNombres())
                .apellidos(domain.getApellidos())
                .fechaNacimiento(domain.getFechaNacimiento())
                .direccion(domain.getDireccion())
                .telefono(domain.getTelefono())
                .correoElectronico(domain.getCorreoElectronico())
                .salarioBase(domain.getSalarioBase())
                .build();
    }
}
