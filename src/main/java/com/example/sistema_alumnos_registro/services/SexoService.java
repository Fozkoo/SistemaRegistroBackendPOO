package com.example.sistema_alumnos_registro.services;

import com.example.sistema_alumnos_registro.models.Sexo;
import com.example.sistema_alumnos_registro.repositories.EstudianteRepository;
import com.example.sistema_alumnos_registro.repositories.SexoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class SexoService {

    @Autowired
    private SexoRepository sexoRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;

    public ResponseEntity<?> getAllSexo (){
        List<Sexo> sexos = sexoRepository.findAll();
        return ResponseEntity.ok(sexos);
    }

    public ResponseEntity<?> getBySexo(@PathVariable String sexo){
        try {
            int idSexo = sexoRepository.findByNombre(sexo).getId();
            return ResponseEntity.ok(estudianteRepository.buscarHombres(idSexo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

}
