package com.rotaslzapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sentido {

    BAIRRO("Bairro"),
    CENTRO("Centro");

    private final String descricao;

}
