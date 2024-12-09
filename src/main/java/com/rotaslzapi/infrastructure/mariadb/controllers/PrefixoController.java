package com.rotaslzapi.infrastructure.mariadb.controllers;

import com.rotaslzapi.infrastructure.mariadb.entities.Prefixo;
import com.rotaslzapi.infrastructure.mariadb.services.PrefixoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mariadb/prefixo")
@RequiredArgsConstructor
public class PrefixoController {

    private final PrefixoService prefixoService;

    @GetMapping
    public ResponseEntity<List<Prefixo>> buscarTodos(){
        return ResponseEntity.ok(prefixoService.buscarTodos());
    }
}
