package org.una.Tareas.dto;

import lombok.*;
import org.una.Tareas.entities.Proyecto;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TareaDTO {

    Long id;
    String descripcion;
    Date fechaInicio;
    Date fechaFinalizacion;
    Long importancia;
    Long urgencia;
    Long porcentajeAvance;
    @Setter(AccessLevel.NONE)
    ProyectoDTO proyecto ;

}
