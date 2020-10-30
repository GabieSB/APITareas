package org.una.Tareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.Tareas.entities.Proyecto;

import java.util.List;
import java.util.Optional;

public interface IProyectoRepository extends JpaRepository<Proyecto, Long> {

    Optional<List<Proyecto>> findByEstado(boolean estado);

   // @Query("select p from  Proyecto  p join p.tareas t where t.porcentajeAvance between  :porcentajeInicio and :porcentajeFinal")
   // @Query(value = "select * from exa_mon_proyectos join exa_mon_tareas  where exa_mon_tareas.porcentaje_avance between :porcentajeInicio and :porcentajeFinal", nativeQuery = true)
   // Optional<List<Proyecto>> findByTareasPorcentajeBetween(@Param("porcentajeInicio") long porcentajeInicio, @Param("porcentajeFinal") long porcentajeFinal );
    Optional<List<Proyecto>> findByTareasPorcentajeAvanceBetween(@Param("porcentajeInicio") long porcentajeInicio, @Param("porcentajeFinal") long porcentajeFinal );



}
