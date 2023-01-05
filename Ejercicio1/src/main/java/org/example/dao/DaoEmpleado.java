package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.example.Modelo.Empleado;

public class DaoEmpleado {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;




    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();

    }

    public void insertarEmpleado(Empleado empleado) {
        try {
            entityManager.getTransaction().begin();

            entityManager.persist(empleado);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    public Empleado obtenerEmpleado(int id) {
        return entityManager.find(Empleado.class, id);
    }



    public void eliminarEmpleado(int id) {
        Empleado empleado = obtenerEmpleado(id);
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(empleado);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
    }


    public void actualizarEmpleado(Empleado empleado) {
        try {


            entityManager.getTransaction().begin();
            entityManager.merge(empleado);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
    }


    public void cierra (){
        entityManager.close();
        entityManagerFactory.close();
    }


}
