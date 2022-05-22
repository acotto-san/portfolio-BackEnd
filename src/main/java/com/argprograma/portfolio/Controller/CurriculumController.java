
package com.argprograma.portfolio.Controller;

import com.argprograma.portfolio.Service.IService;
import com.argprograma.portfolio.Modelo.Curriculum;


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
@RequestMapping("/curriculums")
public class CurriculumController {
    
    @Autowired
    private IService<Curriculum> cvServ;
    
    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Curriculum>> buscarCurriculums(){
        List<Curriculum> todosLosCurriculums = cvServ.buscarObjetos();
        return new ResponseEntity<>(todosLosCurriculums, HttpStatus.OK);
    }
    
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Curriculum> buscarCurriculumByID(@PathVariable("id") Long id){
        Curriculum curriculumEncontrado = cvServ.buscarObjetoById(id);
        return new ResponseEntity<>(curriculumEncontrado, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Curriculum> crearCurriculum(@RequestBody Curriculum cv){
        Curriculum nuevoCurriculum = cvServ.crearObjeto(cv);
        return new ResponseEntity<>(nuevoCurriculum, HttpStatus.CREATED);
    }
    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<Curriculum> editarCurriculum(@RequestBody Curriculum cv){
        Curriculum curriculumEditado = cvServ.editarObjeto(cv);
        return new ResponseEntity<>(curriculumEditado, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarCurriculum(@PathVariable("id") Long id){
        cvServ.borrarObjetoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
