package org.una.Tareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.Tareas.entities.Proyecto;

import java.util.List;
import java.util.Optional;

public interface IProyectoRepository extends JpaRepository<Proyecto, Long> {

    Optional<List<Proyecto>> findByEstado(boolean estado);
}
