package org.una.Tareas.services;


import org.una.Tareas.dto.TareaDTO;

import java.util.List;
import java.util.Optional;

public interface ITareaService {

    TareaDTO create(TareaDTO clienteDTO);

    List<TareaDTO> getByProyectoId(long id);
 }
