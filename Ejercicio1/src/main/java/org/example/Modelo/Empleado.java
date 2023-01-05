package org.example.Modelo;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "empleado")
public class Empleado {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_emp")
    private int id;

    @Column(length = 10)
    private String nombre;


    @Column(length = 10)
    private String apellido;

    @Column(length = 10)
    private String oficio;

    private Date fecha_alta;

    @Column(length = 6, precision = 2)
    private float salario;

    @Column(length = 6, precision = 2)
    private float comision;

    @ManyToOne
    @JoinColumn(name = "id_dep")
    private Departamento departamento;


}