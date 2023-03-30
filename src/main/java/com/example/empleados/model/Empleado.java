package com.example.empleados.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Empleado")
public class Empleado {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @Column(name = "lastname")
    private String lastName;
    private String cargo;
    private Integer money;


}
