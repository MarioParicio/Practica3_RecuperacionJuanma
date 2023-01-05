package org.example.dao;

import java.util.List;

public interface DaoGenerico<T> {
    void insertar(T entidad);
    List<T> obtenerTodos();
    T obtenerPorId(int id);
    void eliminar(int id);
    void actualizar(T entidad);
}