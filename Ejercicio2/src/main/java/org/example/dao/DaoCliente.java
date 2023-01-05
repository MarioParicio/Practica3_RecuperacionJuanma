package org.example.dao;

import org.example.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class DaoCliente extends DaoGenericoImpl{

    private final EntityManagerFactory entityManagerFactory = super.entityManagerFactory;
    private final EntityManager entityManager = super.entityManager;

    public DaoCliente() {
        super(Cliente.class);
    }

    public void eliminarClienteYVentas(int i) {
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM Venta v WHERE v.cliente.id = :id").setParameter("id", i).executeUpdate();
            entityManager.createQuery("DELETE FROM Cliente c WHERE c.id = :id").setParameter("id", i).executeUpdate();
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
    }

}
