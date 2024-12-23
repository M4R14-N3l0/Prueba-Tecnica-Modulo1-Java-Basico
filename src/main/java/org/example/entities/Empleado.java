package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name= "empleados")
public class Empleado {
    // Crear columnas de la tabla empleados
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    //@Column(nullable=false, length= 255)
    @Column
    private String nombre;
    //@Column(nullable=false, length= 255)
    @Column
    private String apellido ;
    //@Column(nullable=false, length= 150 )
    @Column
    private String cargo;
    //@Column(nullable=false)
    @Column
    private Double salario;
    @Column (name= "fecha_inicio")
    private LocalDateTime fechaInicio;

    public Empleado() {
    }

    public Empleado(Integer id, String nombre, String apellido, String cargo, Double salario, LocalDateTime fechaInicio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.salario = salario;
        this.fechaInicio = fechaInicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", fechaInicio=" + fechaInicio +
                '}';
    }
}
