package com.example.demo.controller;

import com.example.demo.DTO.PersonagemRegisterDto;
import com.example.demo.model.PersonagemRegisterModel;
import com.example.demo.services.PersonagemRegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/personagemInfo")
@CrossOrigin(origins = "*",maxAge = 3600)
public class PersonagemRegisterController {


   @Autowired
   PersonagemRegisterService personagemService;


    @PostMapping("/")
    public ResponseEntity<Object> savePlayerInfo(@RequestBody @Valid PersonagemRegisterDto personagemDto){

        if(personagemService.existsByPersonagemNickname(personagemDto.getPersonagemNickname())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O nome ja esta cadastrado na Base");
        }

        if(personagemService.existsByPersonagemType(personagemDto.getPersonagemType())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ja temos um usuario cadastrado com essa raça");
        }


        var personagemModel = new PersonagemRegisterModel();
        BeanUtils.copyProperties(personagemDto,personagemModel);
        personagemModel.setLoginTime(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(personagemService.save(personagemModel));

    }

    @GetMapping("/")
    public ResponseEntity<List<PersonagemRegisterModel>> getAllPersonagens(){
        return ResponseEntity.status(HttpStatus.OK).body(personagemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPlayerById(@PathVariable(value = "id") UUID id){
        Optional<PersonagemRegisterModel> personagemModelOptional = personagemService.findById(id);
        if(personagemModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(personagemModelOptional.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esse Id nao existe");

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePlayerById(@PathVariable(value = "id") UUID id){
        Optional<PersonagemRegisterModel> personagemModelOptional = personagemService.findById(id);
        if(personagemModelOptional.isPresent() ==  false){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id nao encontrado");
        }else{
            personagemService.deleteById(personagemModelOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
        }
    }







}
