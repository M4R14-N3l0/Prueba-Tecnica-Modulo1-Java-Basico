package org.example.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entities.Empleado;

import java.util.List;

public class EmpleadoJPA {

    // Se realizan las operaciones CRUD

    public void create(Empleado nuevoEmpleado) {
        EntityManager em = ConfigJPA.getEntityManager();

        try{
            // Guardar en la DB
            em.getTransaction().begin(); // Iniciar una transaccion
            em.persist(nuevoEmpleado);
            em.getTransaction().commit();

        }finally {
            em.close();
        }
    }

    public Empleado findOne(Integer idBuscado) {
        EntityManager em = ConfigJPA.getEntityManager();
        try{
            return em.find(Empleado.class, idBuscado);
        }finally {
            em.close();
        }

    }

    public List<Empleado> findAll() {
        EntityManager em = ConfigJPA.getEntityManager();
        try{
            TypedQuery<Empleado> query = em.createQuery("SELECT p FROM empleados p", Empleado.class);
            return query.getResultList();
        }finally {
            em.close();
        }

    }

    public void update(Empleado actualizarEmpleado) {
        EntityManager em = ConfigJPA.getEntityManager();
        try{
            em.getTransaction().begin(); // Iniciar una transaccion
            em.merge(actualizarEmpleado);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    public void delete(Integer idEliminar) {
        EntityManager em = ConfigJPA.getEntityManager();
        try{
            em.getTransaction().begin(); // Iniciar una transaccion
            Empleado empleado = em.find(Empleado.class, idEliminar);
            if (empleado != null){
                em.remove(empleado);
            }else{
                System.err.println("El id " + idEliminar + " No existe ese identificador");
            }
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
}
