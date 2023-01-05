package org.example;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dao.DaoCliente;
import org.example.dao.DaoProducto;
import org.example.dao.DaoVenta;
import org.example.model.Cliente;
import org.example.model.Producto;
import org.example.model.Venta;

import java.util.Date;
import java.util.Optional;


public class Main {
    public static void main(String[] args) {
        DaoProducto daoProducto = new DaoProducto();
        DaoVenta daoVenta = new DaoVenta();
        DaoCliente daoCliente = new DaoCliente();

       // A) Insertar un cliente.


/*        Cliente cliente = Cliente.builder()
                .nombre("Juan")
                .direccion("Calle 1")
                .poblacion("Madrid")
                .telefono("123456789")
                .nif("123456789")
                .build();
        System.out.println("Insertando cliente: " + cliente);
        try {

            daoCliente.insertar(cliente);
        } catch (Exception e) {
            System.out.println("Error al insertar cliente: " + e.getMessage());
        }*/


        // B) Insertar un producto.



/*        Producto producto = Producto.builder()
                .descripcion("Producto 1")
                .stockActual(10)
                .stockMinimo(5)
                .precio(10.5f)
                .build();
        try {
            daoProducto.insertar(producto);
        } catch (Exception e) {
            System.out.println("Error al insertar producto: " + e.getMessage());
        }*/


//        C) Insertar una venta. Se debe comprobar que tanto el cliente como el producto
//        relacionados con la venta existen en la base de datos.



/*            Venta venta = Venta.builder()
                    .fecha(new Date())
                    .cantidad(1)
                    .build();

        Optional<Cliente> clienteOptional = Optional.ofNullable((Cliente)daoCliente.obtenerPorId(1));
        clienteOptional.ifPresentOrElse(venta::setCliente, () -> {
            System.out.println("No existe el cliente");

        });


        Optional<Producto> productoOptional = Optional.ofNullable((Producto)daoProducto.obtenerPorId(1));
        productoOptional.ifPresentOrElse(venta::setProducto, () -> {
            System.out.println("No existe el producto");
        });

        try {
            daoVenta.insertar(venta);
        } catch (Exception e) {
            System.out.println("Error al insertar venta: " + e.getMessage());
        }*/


//        D) Leer una venta, y además, su cliente y su producto correspondientes.

/*            Optional<Venta> ventaRead = Optional.ofNullable((Venta) daoVenta.obtenerPorId(1));
            ventaRead.ifPresentOrElse(System.out::println, () -> {
                System.out.println("No existe la venta");
            });*/

//        E) Eliminar un producto. Previamente, se debe eliminar todas las ventas realizadas de dicho
//        producto. Utiliza una transacción.


/*            Optional<Producto> productoDelete = Optional.ofNullable((Producto) daoProducto.obtenerPorId(1));
            productoDelete.ifPresentOrElse(producto -> {
                try {
                    System.out.println("Eliminando producto yu sus ventas: " + producto);
                    daoProducto.eliminarProductoYVentas(producto.getId());
                } catch (Exception e) {
                    System.out.println("Error al eliminar producto: " + e.getMessage());
                }
            }, () -> {
                System.out.println("No existe el producto");
            });*/

            //F) Eliminar un cliente. Previamente, se debe eliminar todas las ventas realizadas por dicho
        //cliente. Utiliza una transacción.

/*            Optional<Cliente> clienteDelete = Optional.ofNullable((Cliente) daoCliente.obtenerPorId(1));
            clienteDelete.ifPresentOrElse(clienteDel -> {
                try {
                    System.out.println("Eliminando cliente y sus ventas: " + clienteDel);
                    daoCliente.eliminarClienteYVentas(clienteDel.getId());
                } catch (Exception e) {
                    System.out.println("Error al eliminar cliente: " + e.getMessage());
                }
            }, () -> {
                System.out.println("No existe el cliente");
            });*/




    }
}