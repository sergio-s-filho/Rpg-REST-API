package com.example.demo.DTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter


public class PersonagemRegisterDto {

    @NotBlank
    private String personagemType;
    @NotBlank
    private String personagemNickname;
    @NotBlank
    private String personagemLevel;
}
