package com.example.demo.services;

import com.example.demo.model.PersonagemRegisterModel;
import com.example.demo.repositories.PersonagemRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonagemRegisterService {


    @Autowired
    PersonagemRegisterRepository personagemRepository;


    @Transactional
    public PersonagemRegisterModel save(PersonagemRegisterModel personagemModel) {

        return personagemRepository.save(personagemModel);
    }

    public boolean existsByPersonagemNickname(String personagemName){
        return personagemRepository.existsByPersonagemNickname(personagemName);
    }

    public boolean existsByPersonagemType(String personagemType){
        return personagemRepository.existsByPersonagemType(personagemType);
    }

    public List<PersonagemRegisterModel> findAll(){
        return personagemRepository.findAll();
    }

    public Optional<PersonagemRegisterModel> findById(UUID id){
        return personagemRepository.findById(id);
    }

    public void deleteById(PersonagemRegisterModel personagemModel){
        personagemRepository.delete(personagemModel);
    }




}
