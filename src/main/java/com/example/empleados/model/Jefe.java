package com.example.empleados.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Jefe")
public class Jefe {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer presupuesto;

}
