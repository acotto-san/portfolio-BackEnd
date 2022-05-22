
package com.argprograma.portfolio.Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter @Setter
@Entity
public class ExperienciaLaboral implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Autowired
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn(name="experiencia_laboral")
    private List<ExperienciaPuesto> puestos;
    
    @Autowired
    @JoinColumn(name="logo_id")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true )
    private Imagen logoImg;
    
    private String nombreEmpresa;
    private String ubicacion;
    private String tipoJornada;
}
