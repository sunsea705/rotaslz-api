package com.rotaslzapi.services;

import com.rotaslzapi.entities.Prefixo;
import com.rotaslzapi.repositories.PrefixoJpaRepository;
import com.rotaslzapi.utils.OperacoesSimplesJpa;
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

    public Prefixo buscarPorId(Long id){
        return OperacoesSimplesJpa.buscarPorId(id, prefixoJpaRepository, "Prefixo");
    }

}
