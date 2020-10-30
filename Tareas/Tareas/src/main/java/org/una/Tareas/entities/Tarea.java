package org.una.Tareas.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "exa_mon_tareas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tarea implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @Column(name = "fecha_finalizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinalizacion;

    @Column(name = "importancia")
    private Long importancia;


    @Column(name = "urgencia")
    private Long urgencia;

    @Column(name = "porcentaje_avance")
    private Long porcentajeAvance;

    private static final long serialVersionUID = 1L;


    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;







}
