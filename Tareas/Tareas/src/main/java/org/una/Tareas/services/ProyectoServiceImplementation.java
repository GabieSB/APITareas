package org.una.Tareas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.Tareas.dto.ProyectoDTO;
import org.una.Tareas.entities.Proyecto;
import org.una.Tareas.repositories.IProyectoRepository;
import org.una.Tareas.utils.MapperUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProyectoServiceImplementation implements IProyectoService {


    @Autowired
    IProyectoRepository proyectoRepository;
    @Override
    public ProyectoDTO create(ProyectoDTO proyectoDTO) {
        Proyecto entity = MapperUtils.entityFromDto(proyectoDTO, Proyecto.class);
        entity = proyectoRepository.save(entity);
        return MapperUtils.DtoFromEntity(entity, ProyectoDTO.class);
    }

    @Override
    public List<ProyectoDTO> getByEstado(boolean estado) {

        Optional<List<Proyecto>> result = proyectoRepository.findByEstado(estado);
        if (result.isPresent()) {
            return MapperUtils.DtoListFromEntityList(result.get(), ProyectoDTO.class);
        }
        return new ArrayList();

    }
}
