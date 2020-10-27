package org.una.Tareas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.Tareas.dto.TareaDTO;
import org.una.Tareas.dto.TareaDTO;
import org.una.Tareas.entities.Tarea;
import org.una.Tareas.repositories.ITareaRepository;
import org.una.Tareas.utils.MapperUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TareaServiceImplementation  implements  ITareaService{


    @Autowired
    ITareaRepository tareaRepository;
    @Override
    public TareaDTO create(TareaDTO tareaDTO) {
        Tarea entity = MapperUtils.entityFromDto(tareaDTO, Tarea.class);
        entity = tareaRepository.save(entity);
        return MapperUtils.DtoFromEntity(entity, TareaDTO.class);
    }

    @Override
    public List<TareaDTO> getByProyectoId(long id) {

        Optional<List<Tarea>> result = tareaRepository.findByProyectoId(id);
        if (result.isPresent()) {
            return MapperUtils.DtoListFromEntityList(result.get(), TareaDTO.class);
        }
        return new ArrayList();

    }
}
