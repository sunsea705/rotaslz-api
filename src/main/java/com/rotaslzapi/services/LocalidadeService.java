package com.rotaslzapi.services;

import com.rotaslzapi.entities.Localidade;
import com.rotaslzapi.entities.TipoLocalidade;
import com.rotaslzapi.repositories.jpa.LocalidadeJpaRepository;
import com.rotaslzapi.requests.localidade.AtualizarLocalidadeRequest;
import com.rotaslzapi.requests.localidade.CriarLocalidadeRequest;
import com.rotaslzapi.utils.OperacoesSimplesJpa;
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

    public Localidade buscarPorId(Long id) {
        return OperacoesSimplesJpa.buscarPorId(id, localidadeJpaRepository, "Localidade");
    }

    public Localidade criar(CriarLocalidadeRequest criarLocalidadeRequest) {

        TipoLocalidade tipoLocalidade = tipoLocalidadeService.buscarPorId(criarLocalidadeRequest.tipoLocalidadeId());

        Localidade localidade = Localidade.builder()
            .sentido(criarLocalidadeRequest.sentido())
            .descricao(criarLocalidadeRequest.descricao())
            .tipoLocalidade(tipoLocalidade)
            .build();

        return localidadeJpaRepository.save(localidade);
    }

    public Localidade atualizar(AtualizarLocalidadeRequest atualizarLocalidadeRequest) {

        Localidade localidade = buscarPorId(atualizarLocalidadeRequest.localidadeId());

        TipoLocalidade tipoLocalidade = Optional
            .ofNullable(atualizarLocalidadeRequest.tipoLocalidadeId())
            .map(tipoLocalidadeService::buscarPorId)
            .orElse(null);

        localidade.atualizarInstancia(atualizarLocalidadeRequest.sentido(), atualizarLocalidadeRequest.descricao(), tipoLocalidade);

        return localidadeJpaRepository.save(localidade);

    }

    public void deletarPorId(Long localidadeId) {
        OperacoesSimplesJpa.deletarSimplesPorId(localidadeId, localidadeJpaRepository, "Localidade");
    }

}
