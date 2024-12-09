package com.rotaslzapi.services;

import com.rotaslzapi.entities.Prefixo;
import com.rotaslzapi.repositories.PrefixoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrefixoService {

    private final PrefixoJpaRepository prefixoJpaRepository;

    public List<Prefixo> buscarTodos(){
        return prefixoJpaRepository.findAll();
    }

    public Optional<Prefixo> buscarPorId(Long id){ return prefixoJpaRepository.findById(id); }

}
