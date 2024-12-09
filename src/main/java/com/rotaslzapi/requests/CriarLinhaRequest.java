package com.rotaslzapi.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CriarLinhaRequest(
    @NotNull @NotEmpty String numero,
    @NotNull @NotEmpty String descricao,
    @NotNull Long prefixoId
) {}
