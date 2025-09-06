package co.com.crediya.solicitudes.domain.model;

import java.util.UUID;

public class Cliente {

    private UUID id;
    private String nombres;
    private String apellidos;
    private String correoElectronico;
    private String telefono;
    private String documento;

    public Cliente() {
    }

    public Cliente(UUID id, String nombres, String apellidos, String correoElectronico,
                   String telefono, String documento) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.documento = documento;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private UUID id;
        private String nombres;
        private String apellidos;
        private String correoElectronico;
        private String telefono;
        private String documento;

        public Builder id(UUID id) { this.id = id; return this; }
        public Builder nombres(String nombres) { this.nombres = nombres; return this; }
        public Builder apellidos(String apellidos) { this.apellidos = apellidos; return this; }
        public Builder correoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; return this; }
        public Builder telefono(String telefono) { this.telefono = telefono; return this; }
        public Builder documento(String documento) { this.documento = documento; return this; }

        public Cliente build() {
            return new Cliente(id, nombres, apellidos, correoElectronico, telefono, documento);
        }
    }
}
