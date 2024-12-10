package com.rotaslzapi.services;

import com.rotaslzapi.entities.Localidade;
import com.rotaslzapi.entities.TipoLocalidade;
import com.rotaslzapi.repositories.LocalidadeJpaRepository;
import com.rotaslzapi.requests.CriarLocalidadeRequest;
import com.rotaslzapi.requests.EditarLocalidadeRequest;
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

    public Localidade editarLocalidade(EditarLocalidadeRequest editarLocalidadeRequest) {

        Localidade localidade = localidadeJpaRepository
            .findById(editarLocalidadeRequest.localidadeId())
            .orElseThrow( () -> new EntityNotFoundException("Localidade de ID " + editarLocalidadeRequest.localidadeId() + " não encontrada."));

        TipoLocalidade tipoLocalidade = Optional.ofNullable(editarLocalidadeRequest.tipoLocalidadeId())
            .map(tipoLocalidadeId -> tipoLocalidadeService.buscarPorId(tipoLocalidadeId)
            .orElseThrow(() -> new EntityNotFoundException("Tipo Localidade de ID " + tipoLocalidadeId + " não encontrado.")))
            .orElse(null);

        localidade.editarInstancia(editarLocalidadeRequest.sentido(), editarLocalidadeRequest.descricao(), tipoLocalidade);

        return localidadeJpaRepository.save(localidade);

    }

    public void deletarLocalidadePorId(Long localidadeId) {
        OperacoesSimplesJpa.deletarSimplesPorId(localidadeId, localidadeJpaRepository, "Localidade");
    }

}
