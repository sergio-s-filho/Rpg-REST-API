package com.example.demo.repositories;

import com.example.demo.model.PersonagemRegisterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface PersonagemRegisterRepository extends JpaRepository<PersonagemRegisterModel,UUID> {
    boolean existsByPersonagemNickname(String personagemName);
    boolean existsByPersonagemType(String personagemType);

}
