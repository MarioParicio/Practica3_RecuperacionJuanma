package org.example.dao;

import org.example.model.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.model.Venta;

import java.util.List;

public class DaoProducto extends DaoGenericoImpl  {
    private final EntityManagerFactory entityManagerFactory = super.entityManagerFactory;
    private final EntityManager entityManager = super.entityManager;





    public DaoProducto() {
        super(Producto.class);
    }



    public void eliminarProductoYVentas(int id) {
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM Venta v WHERE v.producto.id = :id").setParameter("id", id).executeUpdate();
            entityManager.createQuery("DELETE FROM Producto p WHERE p.id = :id").setParameter("id", id).executeUpdate();
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
    }

}
