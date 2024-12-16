package com.rotaslzapi.services;

import com.rotaslzapi.entities.Localidade;
import com.rotaslzapi.entities.TipoLocalidade;
import com.rotaslzapi.repositories.LocalidadeJpaRepository;
import com.rotaslzapi.requests.localidade.CriarLocalidadeRequest;
import com.rotaslzapi.requests.localidade.AtualizarLocalidadeRequest;
import com.rotaslzapi.utils.OperacoesSimplesJpa;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Localidade atualizarLocalidade(AtualizarLocalidadeRequest atualizarLocalidadeRequest) {

        Localidade localidade = localidadeJpaRepository
            .findById(atualizarLocalidadeRequest.localidadeId())
            .orElseThrow( () -> new EntityNotFoundException("Localidade de ID " + atualizarLocalidadeRequest.localidadeId() + " não encontrada."));

        TipoLocalidade tipoLocalidade = Optional.ofNullable(atualizarLocalidadeRequest.tipoLocalidadeId())
            .map(tipoLocalidadeService::buscarPorId)
            .orElseThrow(() -> new EntityNotFoundException("Tipo Localidade de ID " + atualizarLocalidadeRequest.tipoLocalidadeId() + " não encontrado."))
            .orElse(null);

        localidade.atualizarInstancia(atualizarLocalidadeRequest.sentido(), atualizarLocalidadeRequest.descricao(), tipoLocalidade);

        return localidadeJpaRepository.save(localidade);

    }

    public void deletarLocalidadePorId(Long localidadeId) {
        OperacoesSimplesJpa.deletarSimplesPorId(localidadeId, localidadeJpaRepository, "Localidade");
    }

}
