/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprograma.portfolio.Controller;

import com.argprograma.portfolio.Service.IService;
import com.argprograma.portfolio.Modelo.RedSocial;
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
@RequestMapping("/redes-sociales")
public class RedSocialController {
    
    @Autowired
    private IService<RedSocial> redSocialServ;
    
    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<RedSocial>> buscarRedesSociales(){
        List<RedSocial> todasLasRedSociales = redSocialServ.buscarObjetos();
        return new ResponseEntity<>(todasLasRedSociales, HttpStatus.OK);
    }
    
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<RedSocial> buscarRedSocialByID(@PathVariable("id") Long id){
        RedSocial redSocialEncontrada = redSocialServ.buscarObjetoById(id);
        return new ResponseEntity<>(redSocialEncontrada, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<RedSocial> crearRedSocial(@RequestBody RedSocial redSocial){
        RedSocial nuevaRedSocial = redSocialServ.crearObjeto(redSocial);
        return new ResponseEntity<>(nuevaRedSocial, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<RedSocial> editarRedSocial(@RequestBody RedSocial redSocial){
        RedSocial redSocialEditada = redSocialServ.editarObjeto(redSocial);
        return new ResponseEntity<>(redSocialEditada, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarRedSocial(@PathVariable("id") Long id){
        redSocialServ.borrarObjetoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
