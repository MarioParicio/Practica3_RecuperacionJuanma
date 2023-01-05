package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Modelo.Departamento;

import java.util.List;


public class DaoDepartamento {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;


    public DaoDepartamento() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();

    }




    public void insertarDepartamento(Departamento departamento) {
        try {
        entityManager.getTransaction().begin();
        entityManager.persist(departamento);
        entityManager.getTransaction().commit();
    } finally {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }
    }
    public List<Departamento> obtenerTodosDepartamentos() {
        return entityManager.createQuery("SELECT d FROM Departamento d", Departamento.class).getResultList();
    }

    public Departamento obtenerDepartamento(int id) {
        return entityManager.find(Departamento.class, id);
    }

    public void eliminarDepartamento(int id) {
        Departamento departamento = obtenerDepartamento(id);
        departamento.getEmpleados().forEach(empleado -> {
            empleado.setDepartamento(null);
            entityManager.merge(empleado);
        });
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(departamento);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    public void actualizarDepartamento(Departamento departamento) {
        try {


            entityManager.getTransaction().begin();
            entityManager.merge(departamento);
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

    public List obtenerNombreMasLargo() {
        return entityManager.createQuery("SELECT d.nombre FROM Departamento d WHERE LENGTH(d.nombre) = (SELECT MAX(LENGTH(d2.nombre)) FROM Departamento d2)").getResultList();
    }
}