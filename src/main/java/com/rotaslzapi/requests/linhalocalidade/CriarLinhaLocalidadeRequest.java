package com.rotaslzapi.requests.linhalocalidade;

import jakarta.validation.constraints.NotNull;

public record CriarLinhaLocalidadeRequest(
        @NotNull Long linhaId,
        @NotNull Long localidadeId,
        @NotNull Integer ordem
) {}
