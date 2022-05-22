/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprograma.portfolio.Service;

import com.argprograma.portfolio.Modelo.Persona;
import com.argprograma.portfolio.Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaService implements IService<Persona>{

    @Autowired
    public PersonaRepository persoRepo;
    
    @Override
    public List<Persona> buscarObjetos() {
      return persoRepo.findAll();
    }

    @Override
    public Persona buscarObjetoById(Long id) {
        return persoRepo.findById(id).orElse(null);
    }
    
    @Override
    public Persona crearObjeto(Persona per) {
        return persoRepo.save(per);
    }
    
    @Override
    public Persona editarObjeto(Persona per){
        return persoRepo.save(per);
    }

    @Override
    public void borrarObjetoById(Long id) {
        persoRepo.deleteById(id);
    }

    
    
}
