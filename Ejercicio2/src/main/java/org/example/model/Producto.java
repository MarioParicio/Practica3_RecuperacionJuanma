package org.example.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "descripcion", length = 50)
    private String descripcion;

    @Column(name = "stockactual")
    private int stockActual;

    @Column(name = "stockminimo")
    private int stockMinimo;

    @Column(name = "precio")
    private float precio;
}
