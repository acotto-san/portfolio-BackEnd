
package com.argprograma.portfolio.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.argprograma.portfolio.Modelo.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserDao extends JpaRepository<DAOUser, Long> {
    DAOUser findByUsername(String username);
}