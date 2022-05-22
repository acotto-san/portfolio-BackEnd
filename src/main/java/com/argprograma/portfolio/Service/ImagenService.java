/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprograma.portfolio.Service;

import com.argprograma.portfolio.Modelo.Imagen;
import com.argprograma.portfolio.Repository.ImagenRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagenService implements IService<Imagen>{
    
    @Autowired
    public ImagenRepository imagenRepo;
    
    @Override
    public List<Imagen> buscarObjetos(){
        return imagenRepo.findAll();
    };
    
    @Override
    public Imagen buscarObjetoById(Long id){
        return imagenRepo.findById(id).orElse(null);
    };
    
    @Override
    public Imagen crearObjeto(Imagen img){
        return imagenRepo.save(img);
    };
    
    @Override
    public Imagen editarObjeto(Imagen img){
        return imagenRepo.save(img);
    };
    
    @Override
    public void borrarObjetoById(Long id){
        imagenRepo.deleteById(id);
    };
 
}