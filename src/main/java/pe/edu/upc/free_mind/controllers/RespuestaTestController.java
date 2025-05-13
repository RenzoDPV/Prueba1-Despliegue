package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.RespuestaTestDTO;
import pe.edu.upc.free_mind.entities.RespuestaTest;
import pe.edu.upc.free_mind.servicesinterfaces.IRespuestaTestService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador REST para la entidad RespuestaTest.
 * Gestiona los endpoints relacionados a resultados de test.
 */
@RestController
@RequestMapping("/respuestas")
public class RespuestaTestController {

    @Autowired
    private IRespuestaTestService respuestaTestService;

    /**
     * Lista todas las respuestas del test.
     * @return Lista de RespuestaTestDTO
     */
    @GetMapping
    public List<RespuestaTestDTO> listar() {
        return respuestaTestService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RespuestaTestDTO.class);
        }).collect(Collectors.toList());
    }

    /**
     * Inserta una nueva respuesta de test.
     * @param dto DTO recibido desde el cliente
     */
    @PostMapping
    public void insertar(@RequestBody RespuestaTestDTO dto) {
        ModelMapper m = new ModelMapper();
        RespuestaTest r = m.map(dto, RespuestaTest.class);
        respuestaTestService.insert(r);
    }

    /**
     * Elimina una respuesta por su ID.
     * @param id ID de la respuesta
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        respuestaTestService.delete(id);
    }

    /**
     * Obtiene una respuesta por su ID.
     * @param id ID buscado
     * @return DTO correspondiente
     */
    @GetMapping("/{id}")
    public RespuestaTestDTO obtenerPorId(@PathVariable("id") Integer id) {
        RespuestaTest r = respuestaTestService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(r, RespuestaTestDTO.class);
    }

    /**
     * Modifica una respuesta existente.
     * @param dto DTO con los datos actualizados
     */
    @PutMapping
    public void modificar(@RequestBody RespuestaTestDTO dto) {
        ModelMapper m = new ModelMapper();
        RespuestaTest r = m.map(dto, RespuestaTest.class);
        respuestaTestService.update(r);
    }
}
