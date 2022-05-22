
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
public class Curriculum implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean firstInit = false;
    
    @Autowired
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn(name="banner_id")
    private Banner banner;
    
    @Autowired
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn(name="curriculum_id")
    private List<ExperienciaLaboral> experiencias;
    
    @Autowired
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn(name="curriculum_id")
    private List<ExperienciaEducativa> estudios;
    
    @Autowired
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn(name="curriculum_id")
    private List<Skill> skills;
    
    @Autowired
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn(name="curriculum_id")
    private List<Proyecto> proyectos;
    
    @Autowired
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn(name="curriculum_id")
    private List<RedSocial> redes;
}
