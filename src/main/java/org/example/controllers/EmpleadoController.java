package org.example.controllers;

import org.example.entities.Empleado;
import org.example.persistence.EmpleadoJPA;

import java.util.List;

public class EmpleadoController {

    // Contendrá el llamado a los métodos CRUD de EmpleadoJPA

    EmpleadoJPA empleadoJPA = new EmpleadoJPA();
    public void create(Empleado nuevoEmpleado) {
        empleadoJPA.create(nuevoEmpleado);
    }

    public Empleado findOne(Integer idBuscado) {
        return empleadoJPA.findOne(idBuscado);
    }

    public List<Empleado> findAll() {
        return empleadoJPA.findAll();
    }

    public void update(Empleado actualizarEmpleado) {
        empleadoJPA.update(actualizarEmpleado);
    }

    public void delete(Integer idEliminar) {
        empleadoJPA.delete(idEliminar);
    }
}