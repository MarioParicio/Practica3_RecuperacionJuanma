package org.example.dao;

import org.example.model.Venta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class DaoVenta extends DaoGenericoImpl{
    private final EntityManagerFactory entityManagerFactory = super.entityManagerFactory;
    private final EntityManager entityManager = super.entityManager;

    public DaoVenta() {
        super(Venta.class);
    }

}