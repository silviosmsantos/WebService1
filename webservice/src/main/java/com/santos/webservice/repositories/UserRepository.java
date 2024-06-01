package com.santos.webservice.repositories;

import com.santos.webservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    //Spring data JPA ja possui uma implementação padrão para esse tipo de interface
    //não há necessidade aqui em implementar manualmente
}
