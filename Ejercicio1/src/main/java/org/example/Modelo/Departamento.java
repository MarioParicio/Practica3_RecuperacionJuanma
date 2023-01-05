package org.example.Modelo;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dep")
    private int id;

    @Column(name = "nombre", length = 15)
    private String nombre;

    @Column(name = "localidad", length = 15)
    private String localidad;

    @OneToMany(mappedBy = "departamento")
    @Builder.Default
    private List<Empleado> empleados = new ArrayList<>();



    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                '}';
    }

    public void addEmpleado(Empleado empleado){
        empleado.setDepartamento(this);
        empleados.add(empleado);
    }
}
