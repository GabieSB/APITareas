package org.una.Tareas.services;

import org.una.Tareas.dto.ProyectoDTO;

import java.util.List;
import java.util.Optional;

public interface IProyectoService {

    ProyectoDTO create(ProyectoDTO clienteDTO);

    List<ProyectoDTO> getByEstado(boolean estado);


}
