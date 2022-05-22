/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprograma.portfolio.Service;

import com.argprograma.portfolio.Modelo.Banner;
import com.argprograma.portfolio.Repository.BannerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerService implements IService<Banner>{
    
    @Autowired
    public BannerRepository proyectoRepo;
    
    @Override
    public List<Banner> buscarObjetos(){
        return proyectoRepo.findAll();
    };
    
    @Override
    public Banner buscarObjetoById(Long id){
        return proyectoRepo.findById(id).orElse(null);
    };
    
    @Override
    public Banner crearObjeto(Banner cv){
        return proyectoRepo.save(cv);
    };
    
    @Override
    public Banner editarObjeto(Banner cv){
        return proyectoRepo.save(cv);
    };
    
    @Override
    public void borrarObjetoById(Long id){
        proyectoRepo.deleteById(id);
    };
 
}