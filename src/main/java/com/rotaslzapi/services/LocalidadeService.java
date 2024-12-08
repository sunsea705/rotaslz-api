package com.rotaslzapi.services;

import com.rotaslzapi.entities.Localidade;
import com.rotaslzapi.entities.TipoLocalidade;
import com.rotaslzapi.repositories.LocalidadeJpaRepository;
import com.rotaslzapi.requests.CriarLocalidadeRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocalidadeService {

    private final LocalidadeJpaRepository localidadeJpaRepository;

    private final TipoLocalidadeService tipoLocalidadeService;

    public List<Localidade> buscarTodos() {
        return localidadeJpaRepository.findAll();
    }

    public Localidade criarLocalidade(CriarLocalidadeRequest criarLocalidadeRequest) {

        TipoLocalidade tipoLocalidade = tipoLocalidadeService
            .buscarPorId(criarLocalidadeRequest.tipoLocalidadeId())
            .orElseThrow( () -> new EntityNotFoundException("Tipo Localidade de ID " + criarLocalidadeRequest.tipoLocalidadeId() + " não encontrado."));

        Localidade localidade = Localidade.builder()
            .sentido(criarLocalidadeRequest.sentido())
            .descricao(criarLocalidadeRequest.descricao())
            .tipoLocalidade(tipoLocalidade)
            .build();

        return localidadeJpaRepository.save(localidade);
    }

}
