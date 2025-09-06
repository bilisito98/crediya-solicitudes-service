package co.com.crediya.solicitudes.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public class Usuario {

    private UUID id;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private Double salarioBase;

    public Usuario() {
    }

    public Usuario(UUID id, String nombres, String apellidos, LocalDate fechaNacimiento,
                   String direccion, String telefono, String correoElectronico, Double salarioBase) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.salarioBase = salarioBase;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    public Double getSalarioBase() { return salarioBase; }
    public void setSalarioBase(Double salarioBase) { this.salarioBase = salarioBase; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private UUID id;
        private String nombres;
        private String apellidos;
        private LocalDate fechaNacimiento;
        private String direccion;
        private String telefono;
        private String correoElectronico;
        private Double salarioBase;

        public Builder id(UUID id) { this.id = id; return this; }
        public Builder nombres(String nombres) { this.nombres = nombres; return this; }
        public Builder apellidos(String apellidos) { this.apellidos = apellidos; return this; }
        public Builder fechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; return this; }
        public Builder direccion(String direccion) { this.direccion = direccion; return this; }
        public Builder telefono(String telefono) { this.telefono = telefono; return this; }
        public Builder correoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; return this; }
        public Builder salarioBase(Double salarioBase) { this.salarioBase = salarioBase; return this; }

        public Usuario build() {
            return new Usuario(id, nombres, apellidos, fechaNacimiento, direccion, telefono, correoElectronico, salarioBase);
        }
    }
}
