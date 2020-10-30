package org.una.Tareas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public TareaDTO create(TareaDTO tareaDTO) {
        Tarea entity = MapperUtils.entityFromDto(tareaDTO, Tarea.class);
        entity = tareaRepository.save(entity);
        return MapperUtils.DtoFromEntity(entity, TareaDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TareaDTO> getByProyectoId(long id) {

        Optional<List<Tarea>> result = tareaRepository.findByProyectoId(id);
        if (result.isPresent()) {
            return MapperUtils.DtoListFromEntityList(result.get(), TareaDTO.class);
        }
        return new ArrayList();

    }

    @Override
    @Transactional
    public TareaDTO update(TareaDTO tarea) {
        Optional<Tarea> result = tareaRepository.findById(tarea.getId());
        if (result.isPresent()) {
            Tarea entity = MapperUtils.entityFromDto(tarea, Tarea.class);
            entity = tareaRepository.save(entity);
            return MapperUtils.DtoFromEntity(entity, TareaDTO.class);
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(long id) {
        tareaRepository.deleteById(id);

    }

}
