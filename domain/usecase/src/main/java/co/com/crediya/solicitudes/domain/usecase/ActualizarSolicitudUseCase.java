package co.com.crediya.solicitudes.domain.usecase;

import co.com.crediya.solicitudes.domain.model.Solicitud;

public class ActualizarSolicitudUseCase {

    public Solicitud ejecutar(Solicitud solicitud) {
        System.out.println("Ejecutando caso de uso: ActualizarSolicitud -> " + solicitud);

        return solicitud;
    }
}
