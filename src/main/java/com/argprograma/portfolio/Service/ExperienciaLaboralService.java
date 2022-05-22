/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprograma.portfolio.Service;

import com.argprograma.portfolio.Modelo.ExperienciaLaboral;
import com.argprograma.portfolio.Repository.ExperienciaLaboralRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaLaboralService implements IService<ExperienciaLaboral>{
    
    @Autowired
    public ExperienciaLaboralRepository expLaboralRepo;
    
    @Override
    public List<ExperienciaLaboral> buscarObjetos(){
        return expLaboralRepo.findAll();
    };
    
    @Override
    public ExperienciaLaboral buscarObjetoById(Long id){
        return expLaboralRepo.findById(id).orElse(null);
    };
    
    @Override
    public ExperienciaLaboral crearObjeto(ExperienciaLaboral expLaboral){
        return expLaboralRepo.save(expLaboral);
    };
    
    @Override
    public ExperienciaLaboral editarObjeto(ExperienciaLaboral expLaboral){
        return expLaboralRepo.save(expLaboral);
    };
    
    @Override
    public void borrarObjetoById(Long id){
        expLaboralRepo.deleteById(id);
    };
 
}