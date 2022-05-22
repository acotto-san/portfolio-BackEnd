
package com.argprograma.portfolio.Repository;

import com.argprograma.portfolio.Modelo.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum, Long>{
    
}
