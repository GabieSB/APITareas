package org.una.Tareas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public ProyectoDTO create(ProyectoDTO proyectoDTO) {
        Proyecto entity = MapperUtils.entityFromDto(proyectoDTO, Proyecto.class);
        entity = proyectoRepository.save(entity);
        return MapperUtils.DtoFromEntity(entity, ProyectoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProyectoDTO> getByEstado(boolean estado) {

        Optional<List<Proyecto>> result = proyectoRepository.findByEstado(estado);
        if (result.isPresent()) {
            return MapperUtils.DtoListFromEntityList(result.get(), ProyectoDTO.class);
        }
        return new ArrayList();

    }

    @Override
    @Transactional(readOnly = true)
    public List<ProyectoDTO> getByPorcentajeTareasBetween(long porcentajeInicio, long porcentajeFinal) {
        Optional<List<Proyecto>> result = proyectoRepository.findByTareasPorcentajeAvanceBetween(porcentajeInicio,porcentajeFinal);
        if (result.isPresent()) {
            return MapperUtils.DtoListFromEntityList(result.get(), ProyectoDTO.class);
        }
        return new ArrayList();
    }

    @Override
    @Transactional
    public ProyectoDTO update(ProyectoDTO proyecto) {
        Optional<Proyecto> result = proyectoRepository.findById(proyecto.getId());
        if (result.isPresent()) {
            Proyecto entity = MapperUtils.entityFromDto(proyecto, Proyecto.class);
            entity = proyectoRepository.save(entity);
            return MapperUtils.DtoFromEntity(entity, ProyectoDTO.class);
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(long id) {
        proyectoRepository.deleteById(id);
    }
}
