package com.rotaslzapi.utils;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public class OperacoesSimplesJpa {

    public static void deletarSimplesPorId(Long idEntidade, JpaRepository<?, Long> repository, String nomeEntidade){

        if (idEntidade == null) {
            throw new IllegalArgumentException("Informe um(a) " + nomeEntidade + " válido(a).");
        }

        repository
            .findById(idEntidade)
            .orElseThrow(() -> new EntityNotFoundException(nomeEntidade + " de ID " + idEntidade + " não encontrado(a)."));

        repository.deleteById(idEntidade);

    }
}
