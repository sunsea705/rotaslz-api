package com.rotaslzapi.infrastructure.mariadb.services;

import com.rotaslzapi.infrastructure.mariadb.entities.TipoLocalidade;
import com.rotaslzapi.infrastructure.mariadb.repositories.TipoLocalidadeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoLocalidadeService {

    private final TipoLocalidadeJpaRepository tipoLocalidadeJpaRepository;

    public List<TipoLocalidade> buscarTodos() {
        return tipoLocalidadeJpaRepository.findAll();
    }

    public Optional<TipoLocalidade> buscarPorId(Long id) {
        return tipoLocalidadeJpaRepository.findById(id);
    }

}
