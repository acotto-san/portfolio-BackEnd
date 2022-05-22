/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprograma.portfolio.Controller;

import com.argprograma.portfolio.Service.IService;
import com.argprograma.portfolio.Modelo.Proyecto;
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
@RequestMapping("/proyectos")
public class ProyectoController {
    
    @Autowired
    private IService<Proyecto> proyectoServ;
    
    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Proyecto>> buscarProyectos(){
        List<Proyecto> todosLosProyectos = proyectoServ.buscarObjetos();
        return new ResponseEntity<>(todosLosProyectos, HttpStatus.OK);
    }
    
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> buscarProyectoByID(@PathVariable("id") Long id){
        Proyecto proyectoEncontrado = proyectoServ.buscarObjetoById(id);
        return new ResponseEntity<>(proyectoEncontrado, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto){
        Proyecto nuevoProyecto = proyectoServ.crearObjeto(proyecto);
        return new ResponseEntity<>(nuevoProyecto, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Proyecto> editarProyecto(@RequestBody Proyecto proyecto){
        Proyecto proyectoEditado = proyectoServ.editarObjeto(proyecto);
        return new ResponseEntity<>(proyectoEditado, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarProyecto(@PathVariable("id") Long id){
        proyectoServ.borrarObjetoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
