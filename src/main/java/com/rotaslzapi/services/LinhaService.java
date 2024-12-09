package com.rotaslzapi.services;

import com.rotaslzapi.entities.Linha;
import com.rotaslzapi.entities.Prefixo;
import com.rotaslzapi.repositories.LinhaJpaRepository;
import com.rotaslzapi.requests.CriarLinhaRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
            .orElseThrow( () -> new EntityNotFoundException("Prefixo de ID " + criarLinhaRequest.prefixoId() + " não encontrado."));;

        Linha linha = Linha.builder()
            .descricao(criarLinhaRequest.descricao())
            .numero(criarLinhaRequest.numero())
            .prefixo(prefixo)
            .build();

        return linhaJpaRepository.save(linha);
    }
}
