package org.una.Tareas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.Tareas.dto.ProyectoDTO;
import org.una.Tareas.dto.TareaDTO;
import org.una.Tareas.services.IProyectoService;

import java.util.List;

@RestController
@RequestMapping("/proyectos")

public class ProyectoController {

    @Autowired
    IProyectoService proyectoService;

    @GetMapping("getByEstado/{estado}")
    @ResponseBody
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        try {
            List<ProyectoDTO> result = proyectoService.getByEstado(estado);
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
    public ResponseEntity<?> create(@RequestBody ProyectoDTO proyecto) {
        try {
            ProyectoDTO result = proyectoService.create(proyecto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody ProyectoDTO proyecto) {
        try {
            ProyectoDTO result = proyectoService.update(proyecto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            proyectoService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
