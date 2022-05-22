/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprograma.portfolio.Controller;

import com.argprograma.portfolio.Service.IService;
import com.argprograma.portfolio.Modelo.ExperienciaPuesto;
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
@RequestMapping("/exp-puestos")
public class ExperienciaPuestoController {
    
    @Autowired
    private IService<ExperienciaPuesto> expPuestoServ;
    
    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<ExperienciaPuesto>> buscarExperienciasPuestos(){
        List<ExperienciaPuesto> todasLasExperienciasPuestos = expPuestoServ.buscarObjetos();
        return new ResponseEntity<>(todasLasExperienciasPuestos, HttpStatus.OK);
    }
    
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<ExperienciaPuesto> buscarExperienciaPuestoByID(@PathVariable("id") Long id){
        ExperienciaPuesto experienciaPuestoEncontrada = expPuestoServ.buscarObjetoById(id);
        return new ResponseEntity<>(experienciaPuestoEncontrada, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<ExperienciaPuesto> crearExperienciaPuesto(@RequestBody ExperienciaPuesto expPuesto){
        ExperienciaPuesto nuevaExperienciaPuesto = expPuestoServ.crearObjeto(expPuesto);
        return new ResponseEntity<>(nuevaExperienciaPuesto, HttpStatus.CREATED);
    }
    
    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<ExperienciaPuesto> editarExperienciaPuesto(@RequestBody ExperienciaPuesto expPuesto){
        ExperienciaPuesto experienciaPuestoEditada = expPuestoServ.editarObjeto(expPuesto);
        return new ResponseEntity<>(experienciaPuestoEditada, HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarExperienciaPuesto(@PathVariable("id") Long id){
        expPuestoServ.borrarObjetoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
