/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprograma.portfolio.Service;

import com.argprograma.portfolio.Modelo.Skill;
import com.argprograma.portfolio.Repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements IService<Skill>{
    
    @Autowired
    public SkillRepository bannerRepo;
    
    @Override
    public List<Skill> buscarObjetos(){
        return bannerRepo.findAll();
    };
    
    @Override
    public Skill buscarObjetoById(Long id){
        return bannerRepo.findById(id).orElse(null);
    };
    
    @Override
    public Skill crearObjeto(Skill skill){
        return bannerRepo.save(skill);
    };
    
    @Override
    public Skill editarObjeto(Skill skill){
        return bannerRepo.save(skill);
    };
    
    @Override
    public void borrarObjetoById(Long id){
        bannerRepo.deleteById(id);
    };
 
}