package com.rotaslzapi.services;

import com.rotaslzapi.models.Prefixo;
import com.rotaslzapi.repositories.PrefixoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrefixoService {

    private final PrefixoJpaRepository prefixoJpaRepository;

    public List<Prefixo> buscarTodos(){
        return prefixoJpaRepository.findAll();
    }


}
