package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class DaoGenericoImpl<T> implements DaoGenerico<T> {
        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;
        private Class<T> tipo;

        public DaoGenericoImpl(Class<T> tipo) {
                this.tipo = tipo;
                entityManagerFactory = Persistence.createEntityManagerFactory("default");
                entityManager = entityManagerFactory.createEntityManager();
        }

        @Override
        public void insertar(T entidad) {
                try {
                        entityManager.getTransaction().begin();
                        entityManager.persist(entidad);
                        entityManager.getTransaction().commit();
                } finally {
                        if (entityManager.getTransaction().isActive()) {
                                entityManager.getTransaction().rollback();
                        }
                }
        }

        @Override
        public List<T> obtenerTodos() {
                return entityManager.createQuery("SELECT e FROM " + tipo.getSimpleName() + " e", tipo).getResultList();
        }

        @Override
        public T obtenerPorId(int id) {
                return entityManager.find(tipo, id);
        }

        @Override
        public void eliminar(int id) {
                T entidad = obtenerPorId(id);
                try {
                        entityManager.getTransaction().begin();
                        entityManager.remove(entidad);
                        entityManager.getTransaction().commit();
                } finally {
                        if (entityManager.getTransaction().isActive()) {
                                entityManager.getTransaction().rollback();
                        }
                }
        }

        @Override
        public void actualizar(T entidad) {
                try {
                        entityManager.getTransaction().begin();
                        entityManager.merge(entidad);
                        entityManager.getTransaction().commit();
                } finally {
                        if (entityManager.getTransaction().isActive()) {
                                entityManager.getTransaction().rollback();
                        }
                }
        }}