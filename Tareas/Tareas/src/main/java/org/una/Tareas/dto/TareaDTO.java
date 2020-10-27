package org.una.Tareas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
}
