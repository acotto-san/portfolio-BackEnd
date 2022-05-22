/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprograma.portfolio.Service;

import com.argprograma.portfolio.Modelo.Proyecto;
import com.argprograma.portfolio.Repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IService<Proyecto>{
    
    @Autowired
    public ProyectoRepository proyectoRepo;
    
    @Override
    public List<Proyecto> buscarObjetos(){
        return proyectoRepo.findAll();
    };
    
    @Override
    public Proyecto buscarObjetoById(Long id){
        return proyectoRepo.findById(id).orElse(null);
    };
    
    @Override
    public Proyecto crearObjeto(Proyecto proyecto){
        return proyectoRepo.save(proyecto);
    };
    
    @Override
    public Proyecto editarObjeto(Proyecto proyecto){
        return proyectoRepo.save(proyecto);
    };
    
    @Override
    public void borrarObjetoById(Long id){
        proyectoRepo.deleteById(id);
    };
 
}