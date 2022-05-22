
package com.argprograma.portfolio.Controller;

import com.argprograma.portfolio.Service.IService;
import com.argprograma.portfolio.Modelo.ExperienciaEducativa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/exp-educativas")
public class ExperienciaEducativaController {
    
    @Autowired
    private IService<ExperienciaEducativa> expEducativaRepo;
    
    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<ExperienciaEducativa>> buscarExperienciaEducativas(){
        List<ExperienciaEducativa> todasLasExperienciaEducativas = expEducativaRepo.buscarObjetos();
        return new ResponseEntity<>(todasLasExperienciaEducativas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienciaEducativa> buscarExperienciaEducativaByID(@PathVariable("id") Long id){
        ExperienciaEducativa ExperienciaEducativaEncontrado = expEducativaRepo.buscarObjetoById(id);
        return new ResponseEntity<>(ExperienciaEducativaEncontrado, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<ExperienciaEducativa> crearExperienciaEducativa(@RequestBody ExperienciaEducativa expEducativa){
        ExperienciaEducativa nuevoExperienciaEducativa = expEducativaRepo.crearObjeto(expEducativa);
        return new ResponseEntity<>(nuevoExperienciaEducativa, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<ExperienciaEducativa> editarExperienciaEducativa(@RequestBody ExperienciaEducativa expEducativa){
        ExperienciaEducativa ExperienciaEducativaEditado = expEducativaRepo.editarObjeto(expEducativa);
        return new ResponseEntity<>(ExperienciaEducativaEditado, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarExperienciaEducativa(@PathVariable("id") Long id){
        expEducativaRepo.borrarObjetoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
