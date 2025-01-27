package com.rotaslzapi.requests.linhalocalidade;

public record BuscarLinhaLocalidadeRequest(
    Long linhaId,
    Long localidadeId
) {}
