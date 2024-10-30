package com.example.sistema_alumnos_registro.controllers;
import com.example.sistema_alumnos_registro.models.Carrera;
import com.example.sistema_alumnos_registro.models.Estudiante;
import com.example.sistema_alumnos_registro.DTO.EstudianteDto;
import com.example.sistema_alumnos_registro.models.Sexo;
import com.example.sistema_alumnos_registro.repositories.CarreraRepository;
import com.example.sistema_alumnos_registro.repositories.SexoRepository;
import com.example.sistema_alumnos_registro.services.EstudianteService;
import com.example.sistema_alumnos_registro.services.SexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private SexoRepository sexoRepository;

    @Autowired
    private CarreraRepository carreraRepository;



    @CrossOrigin
    @GetMapping("/getAllEstudiantes")
    public ResponseEntity<?> getEstudiantes() {
        return estudianteService.getAll();
    }


    @CrossOrigin
    @PostMapping("/cargarEstudiante")
    public ResponseEntity<?> addEstudiante(@RequestBody EstudianteDto estudiante) {

        Sexo sexo = sexoRepository.findById(estudiante.getSexoId());
        Carrera carrera = carreraRepository.findById(estudiante.getCarreraId());

        return estudianteService.createEstudiante(new Estudiante(estudiante, sexo, carrera));
    }


    @CrossOrigin
    @DeleteMapping("/borrarEstudianteById/{id}")
    public ResponseEntity<?> deleteEstudiante(@PathVariable int id) {
        return estudianteService.deleteEstudianteById(id);
    }



}