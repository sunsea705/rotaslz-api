package com.rotaslzapi.infrastructure.mariadb.services;

import com.rotaslzapi.infrastructure.mariadb.entities.Prefixo;
import com.rotaslzapi.infrastructure.mariadb.repositories.PrefixoJpaRepository;
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
