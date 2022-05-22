/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprograma.portfolio.Controller;

import com.argprograma.portfolio.Service.IService;
import com.argprograma.portfolio.Modelo.Imagen;
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
@RequestMapping("/imagenes")
public class ImagenController {
    
    @Autowired
    private IService<Imagen> imagenServ;
    
    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Imagen>> buscarImagen(){
        List<Imagen> todasLasImagenes = imagenServ.buscarObjetos();
        return new ResponseEntity<>(todasLasImagenes, HttpStatus.OK);
    }
    
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Imagen> buscarImagenByID(@PathVariable("id") Long id){
        Imagen imagenEncontrada = imagenServ.buscarObjetoById(id);
        return new ResponseEntity<>(imagenEncontrada, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Imagen> crearImagen(@RequestBody Imagen img){
        Imagen nuevaImagen = imagenServ.crearObjeto(img);
        return new ResponseEntity<>(nuevaImagen, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Imagen> editarImagen(@RequestBody Imagen img){
        Imagen imagenEditada = imagenServ.editarObjeto(img);
        return new ResponseEntity<>(imagenEditada, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarImagen(@PathVariable("id") Long id){
        imagenServ.borrarObjetoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
