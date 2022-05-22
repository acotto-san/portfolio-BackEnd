/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprograma.portfolio.Service;

import com.argprograma.portfolio.Modelo.ExperienciaEducativa;
import com.argprograma.portfolio.Repository.ExperienciaEducativaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaEducativaService implements IService<ExperienciaEducativa>{
    
    @Autowired
    public ExperienciaEducativaRepository expEducativaRepo;
    
    @Override
    public List<ExperienciaEducativa> buscarObjetos(){
        return expEducativaRepo.findAll();
    };
    
    @Override
    public ExperienciaEducativa buscarObjetoById(Long id){
        return expEducativaRepo.findById(id).orElse(null);
    };
    
    @Override
    public ExperienciaEducativa crearObjeto(ExperienciaEducativa expEducativa){
        return expEducativaRepo.save(expEducativa);
    };
    
    @Override
    public ExperienciaEducativa editarObjeto(ExperienciaEducativa expEducativa){
        return expEducativaRepo.save(expEducativa);
    };
    
    @Override
    public void borrarObjetoById(Long id){
        expEducativaRepo.deleteById(id);
    };
 
}