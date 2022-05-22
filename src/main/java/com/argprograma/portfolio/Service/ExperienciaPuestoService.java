/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprograma.portfolio.Service;

import com.argprograma.portfolio.Modelo.ExperienciaPuesto;
import com.argprograma.portfolio.Repository.ExperienciaPuestoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaPuestoService implements IService<ExperienciaPuesto>{
    
    @Autowired
    public ExperienciaPuestoRepository ExperienciaPuestoRepo;
    
    @Override
    public List<ExperienciaPuesto> buscarObjetos(){
        return ExperienciaPuestoRepo.findAll();
    };
    
    @Override
    public ExperienciaPuesto buscarObjetoById(Long id){
        return ExperienciaPuestoRepo.findById(id).orElse(null);
    };
    
    @Override
    public ExperienciaPuesto crearObjeto(ExperienciaPuesto expPuesto){
        return ExperienciaPuestoRepo.save(expPuesto);
    };
    
    @Override
    public ExperienciaPuesto editarObjeto(ExperienciaPuesto expPuesto){
        return ExperienciaPuestoRepo.save(expPuesto);
    };
    
    @Override
    public void borrarObjetoById(Long id){
        ExperienciaPuestoRepo.deleteById(id);
    };
 
}