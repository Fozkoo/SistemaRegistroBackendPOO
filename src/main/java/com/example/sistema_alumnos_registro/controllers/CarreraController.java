package com.example.sistema_alumnos_registro.controllers;
import com.example.sistema_alumnos_registro.repositories.EstudianteRepository;
import com.example.sistema_alumnos_registro.services.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/carrera")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @CrossOrigin
    @GetMapping("/getAllCarreras")
    public ResponseEntity<?> getAllCarreras(){
        return carreraService.getAllCarrera();
    }


    @CrossOrigin
    @GetMapping("getBy/informatica")
    public ResponseEntity<?> getCarreraInfomatica(){
        return ResponseEntity.ok(estudianteRepository.alumnosInformatica(10));
    }


}
