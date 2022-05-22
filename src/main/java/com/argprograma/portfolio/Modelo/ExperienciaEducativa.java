
package com.argprograma.portfolio.Modelo;


import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter @Setter
@Entity
public class ExperienciaEducativa implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
    @Autowired
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="credencial_img_id")
    private Imagen credencialImg;

    private String institucion;
    private String titulo;
    private String credencial;
    private String linkValidacion;    
    private String fechaInicio;
    private String fechaFin;
}
