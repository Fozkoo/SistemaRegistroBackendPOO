package com.example.sistema_alumnos_registro.controllers;
import com.example.sistema_alumnos_registro.services.SexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/sexo")
public class SexoController {

    @Autowired
    private SexoService sexoService;

    @CrossOrigin
    @GetMapping("/getAllSexo")
    public ResponseEntity<?> getAllSexo (){
        return sexoService.getAllSexo();
    }

    @CrossOrigin
    @GetMapping("/getBySexo/{sexo}")
    public ResponseEntity<?> getBySexo(@PathVariable String sexo){
        return sexoService.getBySexo(sexo);
    }


}
