/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprograma.portfolio.Service;

import com.argprograma.portfolio.Modelo.RedSocial;
import com.argprograma.portfolio.Repository.RedSocialRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedSocialService implements IService<RedSocial>{
    
    @Autowired
    public RedSocialRepository redSocialRepo;
    
    @Override
    public List<RedSocial> buscarObjetos(){
        return redSocialRepo.findAll();
    };
    
    @Override
    public RedSocial buscarObjetoById(Long id){
        return redSocialRepo.findById(id).orElse(null);
    };
    
    @Override
    public RedSocial crearObjeto(RedSocial rrss){
        return redSocialRepo.save(rrss);
    };
    
    @Override
    public RedSocial editarObjeto(RedSocial rrss){
        return redSocialRepo.save(rrss);
    };
    
    @Override
    public void borrarObjetoById(Long id){
        redSocialRepo.deleteById(id);
    };
 
}