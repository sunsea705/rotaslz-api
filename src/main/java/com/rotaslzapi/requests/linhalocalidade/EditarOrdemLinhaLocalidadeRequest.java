package com.rotaslzapi.requests.linhalocalidade;

import jakarta.validation.constraints.NotNull;

public record EditarOrdemLinhaLocalidadeRequest(
    @NotNull Long linhaLocalidadeId,
    @NotNull Integer ordem
) {}
