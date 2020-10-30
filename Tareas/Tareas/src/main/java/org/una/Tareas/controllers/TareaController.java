package org.una.Tareas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.Tareas.dto.ProyectoDTO;
import org.una.Tareas.dto.TareaDTO;
import org.una.Tareas.services.ITareaService;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    ITareaService tareaService;

    @GetMapping("getByProyectoid/{id}")
    @ResponseBody
    public ResponseEntity<?> findByProyectoId(@PathVariable(value = "id") long id) {
        try {
            List<TareaDTO> result = tareaService.getByProyectoId(id);
            if (!result.isEmpty()) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            return new ResponseEntity<>("Sin resultados", HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody TareaDTO tarea) {
        try {
            TareaDTO result = tareaService.create(tarea);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody TareaDTO tarea) {
        try {
            TareaDTO result = tareaService.update(tarea);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            tareaService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
