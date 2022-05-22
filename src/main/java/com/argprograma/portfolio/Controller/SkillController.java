/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprograma.portfolio.Controller;

import com.argprograma.portfolio.Service.IService;
import com.argprograma.portfolio.Modelo.Skill;
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
@RequestMapping("/skills")
public class SkillController {
    
    @Autowired
    private IService<Skill> skillServ;
    
    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Skill>> buscarSkills(){
        List<Skill> todosLosSkills = skillServ.buscarObjetos();
        return new ResponseEntity<>(todosLosSkills, HttpStatus.OK);
    }
    
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Skill> buscarSkillByID(@PathVariable("id") Long id){
        Skill skillEncontrado = skillServ.buscarObjetoById(id);
        return new ResponseEntity<>(skillEncontrado, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Skill> crearSkill(@RequestBody Skill skill){
        Skill nuevoSkill = skillServ.crearObjeto(skill);
        return new ResponseEntity<>(nuevoSkill, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Skill> editarSkill(@RequestBody Skill skill){
        Skill skillEditado = skillServ.editarObjeto(skill);
        return new ResponseEntity<>(skillEditado, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarSkill(@PathVariable("id") Long id){
        skillServ.borrarObjetoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
