package org.una.Tareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.Tareas.entities.Tarea;

import java.util.List;
import java.util.Optional;

public interface ITareaRepository extends JpaRepository<Tarea, Long> {

    Optional<List<Tarea>> findByProyectoId(long id);
}
