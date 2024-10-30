package com.example.sistema_alumnos_registro.services;


import com.example.sistema_alumnos_registro.models.Estudiante;
import com.example.sistema_alumnos_registro.models.Sexo;
import com.example.sistema_alumnos_registro.repositories.EstudianteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Service
@Transactional
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public ResponseEntity<?> getAll () {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        return ResponseEntity.ok(estudiantes);
    }


    public ResponseEntity<Estudiante> createEstudiante (Estudiante estudiante){
        Estudiante savedEstudiante = estudianteRepository.save(estudiante);
        return ResponseEntity.ok(savedEstudiante);
    }

    public ResponseEntity<?> deleteEstudianteById(int id) {
        try {
            estudianteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error " + e.getMessage());
        }
    }



}
