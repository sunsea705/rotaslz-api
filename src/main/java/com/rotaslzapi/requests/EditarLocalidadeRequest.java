package com.rotaslzapi.requests;

import com.rotaslzapi.config.validations.EnumValidator;
import com.rotaslzapi.enums.Sentido;
import jakarta.validation.constraints.NotNull;

public record EditarLocalidadeRequest(
    @NotNull Long localidadeId,
    @EnumValidator(enumClass = Sentido.class, message = "O valor para 'Sentido' deve ser 'BAIRRO' ou 'CENTRO'.")
    Sentido sentido,
    String descricao,
    Long tipoLocalidadeId
) {}
