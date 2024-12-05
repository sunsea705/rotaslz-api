package com.rotaslzapi.services;

import com.rotaslzapi.models.TipoLocalidade;
import com.rotaslzapi.repositories.TipoLocalidadeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoLocalidadeService {

    private final TipoLocalidadeJpaRepository tipoLocalidadeJpaRepository;

    public List<TipoLocalidade> buscarTodos() {
        return tipoLocalidadeJpaRepository.findAll();
    }

}
