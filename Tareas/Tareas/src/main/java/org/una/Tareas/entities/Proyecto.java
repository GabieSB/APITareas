package org.una.Tareas.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exa_mon_proyectos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Proyecto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, name = "nombre")
    private String titulo;

    @Column(length = 100 ,name="objetivo")
    private String objetivo;


    @Column(name="estado")
    private Boolean estado;


    private static final long serialVersionUID = 1L;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto", fetch = FetchType.LAZY)
    private List<Tarea> tareas = new ArrayList<>();


}
