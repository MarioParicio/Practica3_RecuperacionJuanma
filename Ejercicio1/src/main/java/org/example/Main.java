package org.example;

import org.apache.commons.math3.stat.StatUtils;
import org.example.Modelo.Departamento;
import org.example.Modelo.Empleado;
import org.example.dao.DaoDepartamento;
import org.example.dao.DaoEmpleado;


import java.time.LocalDate;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        DaoDepartamento daoDepartamento = new DaoDepartamento();
        DaoEmpleado daoEmpleado = new DaoEmpleado();






        //Modificar departamento

/*        int id = 1;
        Optional<Departamento> departamento = Optional.ofNullable(daoDepartamento.obtenerDepartamento(id));
        departamento.map(dep -> {
            System.out.println("Este departamento se va a modificar: \n" + dep);
            dep.setNombre("Informatica");
            return dep;
        }).ifPresentOrElse(dep -> {
            daoDepartamento.actualizarDepartamento(dep);
            System.out.println("Este departamento se ha modificado: \n" + dep);
        }, () -> System.out.println("No existe el departamento"));*/

/*        int id = 2;
        Optional<Departamento> departamento = Optional.ofNullable(daoDepartamento.obtenerDepartamento(id));
        departamento.ifPresentOrElse(dep -> {
            System.out.println("Este departamento se va a modificar: \n" + dep);
            dep.setNombre("Sexo");
            daoDepartamento.actualizarDepartamento(dep);
            System.out.println("Este departamento se ha modificado: \n" + dep);
        }, () -> System.out.println("No existe el departamento"));*/




/*        //Insertar departamento
        String nombre = "Herobrine";
        System.out.println(nombre.length());
        Departamento departamentoInsert = Departamento.builder()
                .nombre("PatataFrit")
                .localidad("Betis")
                .build();
        daoDepartamento.insertarDepartamento(departamentoInsert);
        System.out.println("Departamento insertado: \n" + departamentoInsert);*/

/*        //Leer empleado
        Optional<Empleado> empleadoLeer = Optional.ofNullable(daoEmpleado.obtenerEmpleado(1));
        empleadoLeer.ifPresentOrElse(System.out::println, () -> System.out.println("No existe el empleado"));

        //Eliminar empleado

        Optional<Empleado> empleadoEliminar = Optional.ofNullable(daoEmpleado.obtenerEmpleado(1));
        empleadoEliminar.map(Empleado::getId).ifPresentOrElse(e -> {
            daoEmpleado.eliminarEmpleado(e);
            System.out.println("Empleado eliminado");
        }, () -> System.out.println("No existe el empleado"));


        //Eliminar departamento y sus empleados

        Optional<Departamento> departamentoEliminar = Optional.ofNullable(daoDepartamento.obtenerDepartamento(1));
        departamentoEliminar.map(Departamento::getId).ifPresentOrElse(d -> {
            daoDepartamento.eliminarDepartamento(d);
            System.out.println("Departamento eliminado");
        }, () -> System.out.println("No existe el departamento"));*/


         //Obtener nombre más largo por consulta mysql y por consulta en java y medir tiempo de ejecución


// Number of times to run each test
        int numTests = 100;



// Array to store the results of the Java test
        long[] javaResults = new long[numTests];

// Array to store the results of the MySQL test
        long[] mysqlResults = new long[numTests];



        daoDepartamento.cierra();
        DaoDepartamento pruebaDaoMysql = new DaoDepartamento();
// Run the MySQL test multiple times
        for (int i = 0; i < numTests; i++) {


            long inicio2 = System.currentTimeMillis();

            pruebaDaoMysql.obtenerNombreMasLargo().forEach(System.out::println);

            mysqlResults[i] = System.currentTimeMillis() - inicio2;
        }
        daoDepartamento.cierra();
        DaoDepartamento pruebaDaoJava = new DaoDepartamento();

// Run the Java test multiple times
        for (int i = 0; i < numTests; i++) {

            long inicio = System.currentTimeMillis();

            List<Departamento> departamentos = pruebaDaoJava.obtenerTodosDepartamentos();
            departamentos.stream().map(Departamento::getNombre).filter(nombreDepartamento -> nombreDepartamento.length() == departamentos.stream().map(Departamento::getNombre).mapToInt(String::length).max().getAsInt()).forEach(System.out::println);

            javaResults[i] = System.currentTimeMillis() - inicio;


        }




// Calculate the mean and standard deviation of the MySQL results
        double mysqlMean = StatUtils.mean(Arrays.stream(mysqlResults).mapToDouble(i -> i).toArray());
        double mysqlStdDev = Math.sqrt(StatUtils.variance(Arrays.stream(mysqlResults).mapToDouble(i -> i).toArray()));

// Calculate the mean and standard deviation of the Java results
        double javaMean = StatUtils.mean(Arrays.stream(javaResults).mapToDouble(i -> i).toArray());
        double javaStdDev = Math.sqrt(StatUtils.variance(Arrays.stream(javaResults).mapToDouble(i -> i).toArray()));

// Print the results
        System.out.println("MySQL mean time: " + mysqlMean + " ms");
        System.out.println("MySQL standard deviation: " + mysqlStdDev + " ms");
        System.out.println("Java mean time: " + javaMean + " ms");
        System.out.println("Java standard deviation: " + javaStdDev + " ms");








    }


}