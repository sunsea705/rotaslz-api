package com.rotaslzapi.services;

import com.rotaslzapi.entities.Linha;
import com.rotaslzapi.entities.Prefixo;
import com.rotaslzapi.repositories.LinhaJpaRepository;
import com.rotaslzapi.requests.linha.CriarLinhaRequest;
import com.rotaslzapi.requests.linha.AtualizarLinhaRequest;
import com.rotaslzapi.utils.OperacoesSimplesJpa;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LinhaService {

    private final LinhaJpaRepository linhaJpaRepository;

    private final PrefixoService prefixoService;

    public List<Linha> buscarTodos() {
        return linhaJpaRepository.findAll();
    }

    public Linha criarLinha(CriarLinhaRequest criarLinhaRequest) {

        Prefixo prefixo = prefixoService
            .buscarPorId(criarLinhaRequest.prefixoId())
            .orElseThrow( () -> new EntityNotFoundException("Prefixo de ID " + criarLinhaRequest.prefixoId() + " não encontrado."));

        Linha linha = Linha.builder()
            .descricao(criarLinhaRequest.descricao())
            .numero(criarLinhaRequest.numero())
            .prefixo(prefixo)
            .build();

        return linhaJpaRepository.save(linha);
    }

    public Linha atualizarLinha(AtualizarLinhaRequest atualizarLinhaRequest) {

        Linha linha = linhaJpaRepository
            .findById(atualizarLinhaRequest.linhaId())
            .orElseThrow( () -> new EntityNotFoundException("Linha de ID " + atualizarLinhaRequest.linhaId() + " não encontrado."));

        Prefixo prefixo = Optional.ofNullable(atualizarLinhaRequest.prefixoId())
            .map(prefixoService::buscarPorId)
            .orElseThrow( () -> new EntityNotFoundException("Prefixo de ID " + atualizarLinhaRequest.prefixoId() + " não encontrado." ))
            .orElse(null);

        linha.atualizarInstancia(atualizarLinhaRequest.numero(), atualizarLinhaRequest.descricao(), prefixo);

        return linhaJpaRepository.save(linha);
    }

    public void deletarLinha(Long linhaId) {
        OperacoesSimplesJpa.deletarSimplesPorId(linhaId, linhaJpaRepository, "Linha");
    }
}
