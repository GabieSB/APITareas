package org.una.Tareas.services;

import org.una.Tareas.dto.ProyectoDTO;

import java.util.List;
import java.util.Optional;

public interface IProyectoService {

    ProyectoDTO create(ProyectoDTO clienteDTO);

    ProyectoDTO update(ProyectoDTO clienteDTO);

    void delete(long id);

    List<ProyectoDTO> getByEstado(boolean estado);

    List<ProyectoDTO> getByPorcentajeTareasBetween(long porcentajeInicio, long porcentajeFinal);




}
