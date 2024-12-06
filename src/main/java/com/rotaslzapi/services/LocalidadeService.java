package com.rotaslzapi.services;

import com.rotaslzapi.models.Localidade;
import com.rotaslzapi.repositories.LocalidadeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocalidadeService {

    private final LocalidadeJpaRepository localidadeJpaRepository;

    public List<Localidade> buscarTodos() {
        return localidadeJpaRepository.findAll();
    }

}
