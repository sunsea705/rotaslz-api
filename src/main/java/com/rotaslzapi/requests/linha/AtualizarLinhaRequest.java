package com.rotaslzapi.requests.linha;

import jakarta.validation.constraints.NotNull;

public record AtualizarLinhaRequest(
    @NotNull Long linhaId,
    String numero,
    String descricao,
    Long prefixoId
) {}
