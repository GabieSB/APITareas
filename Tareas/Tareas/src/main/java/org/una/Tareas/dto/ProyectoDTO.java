package org.una.Tareas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProyectoDTO {

    Long id;
    String nombre;
    String objetivo;
    Boolean estado;
    List<TareaDTO> tareas ;
}
