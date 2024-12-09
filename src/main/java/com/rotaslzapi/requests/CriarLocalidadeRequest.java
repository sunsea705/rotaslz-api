package com.rotaslzapi.requests;

import com.rotaslzapi.config.validations.EnumValidator;
import com.rotaslzapi.enums.Sentido;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CriarLocalidadeRequest(
    @NotNull @NotEmpty String descricao,
    @NotNull Long tipoLocalidadeId,
    @NotNull
    @EnumValidator(enumClass = Sentido.class, message = "O valor para 'Sentido' deve ser 'BAIRRO' ou 'CENTRO'.")
    Sentido sentido
) {}
