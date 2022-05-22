/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argprograma.portfolio.Service;

import java.util.List;


public interface IService<T> {
    
    public List<T> buscarObjetos();
    
    public T buscarObjetoById(Long id);
    
    public T crearObjeto(T obj);
    
    public T editarObjeto(T obj);
    
    public void borrarObjetoById(Long id);
}
