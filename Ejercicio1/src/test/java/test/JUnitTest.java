package test;


import org.example.Modelo.Departamento;
import org.example.dao.DaoDepartamento;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JUnitTest {
    private DaoDepartamento daoDepartamento;

@Before
public void setUp() {
    daoDepartamento = new DaoDepartamento();
}

    @Test
    public void obtnerNombreMásLargo() {

        List lista = daoDepartamento.obtenerNombreMasLargo();

        List<Departamento> departamentos = daoDepartamento.obtenerTodosDepartamentos();
        List lista2 = departamentos.stream().map(Departamento::getNombre)
                .filter(nombreDepartamento -> nombreDepartamento
                        .length() == departamentos.stream().map(Departamento::getNombre)
                        .mapToInt(String::length).max().getAsInt()).toList();
        assert lista.equals(lista2);


    }
}
