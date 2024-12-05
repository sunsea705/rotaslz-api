package com.rotaslzapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prefixo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prefixo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sigla", nullable = false)
    @NotNull
    private String sigla;

    @Column(name = "descricao", nullable = false)
    @NotNull
    private String descricao;

}
