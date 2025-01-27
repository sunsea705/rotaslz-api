package com.rotaslzapi.services;

import com.rotaslzapi.entities.TipoLocalidade;
import com.rotaslzapi.repositories.jpa.TipoLocalidadeJpaRepository;
import com.rotaslzapi.utils.OperacoesSimplesJpa;
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

    public TipoLocalidade buscarPorId(Long id) {
        return OperacoesSimplesJpa.buscarPorId(id, tipoLocalidadeJpaRepository, "Tipo Localidade");
    }

}
