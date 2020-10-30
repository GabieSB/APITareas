package org.una.Tareas.services;


import org.una.Tareas.dto.TareaDTO;
import org.una.Tareas.entities.Proyecto;

import java.util.List;
import java.util.Optional;

public interface ITareaService {

    TareaDTO create(TareaDTO clienteDTO);

    TareaDTO update(TareaDTO clienteDTO);

    void delete(long id);

    List<TareaDTO> getByProyectoId(long id);
 }
