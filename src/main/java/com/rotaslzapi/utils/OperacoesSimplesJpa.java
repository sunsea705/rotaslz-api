package com.rotaslzapi.utils;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public class OperacoesSimplesJpa {

    public static <E> E buscarPorId(Long idEntidade, JpaRepository<E, Long> repository, String nomeEntidade) {
        if (idEntidade == null) {
            throw new IllegalArgumentException("Informe um(a) " + nomeEntidade + " válido(a).");
        }

        return repository
            .findById(idEntidade)
            .orElseThrow(() -> new EntityNotFoundException(nomeEntidade + " de ID " + idEntidade + " não encontrado(a)."));
    }

    /**
     * @param idEntidade id da entidade a ser deletada
     * @param repository repositório JPA da entidade
     * @param nomeEntidade nome da entidade a ser exibido em caso de erro
     */
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
