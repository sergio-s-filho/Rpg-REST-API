package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter


@Table(name = "TB_PERSONAGEM_INFO")
public class PersonagemRegisterModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false,unique = true,length = 10)
    private String personagemType;

    @Column(nullable = false,unique = true,length = 24)
    private String personagemNickname;

    @Column(nullable = false,unique = true,length = 24)
    private String personagemLevel;

    @Column(nullable = false)
    private LocalDateTime loginTime;


}
