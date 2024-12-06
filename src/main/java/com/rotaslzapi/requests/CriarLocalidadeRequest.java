package com.rotaslzapi.requests;

import com.rotaslzapi.enums.Sentido;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CriarLocalidadeRequest(
    @NotNull Sentido sentido,
    @NotNull @NotEmpty String descricao,
    @NotNull Long tipoLocalidadeId
) {}
