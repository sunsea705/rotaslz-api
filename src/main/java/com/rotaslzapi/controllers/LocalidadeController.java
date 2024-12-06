package com.rotaslzapi.controllers;

import com.rotaslzapi.models.Localidade;
import com.rotaslzapi.services.LocalidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/localidade")
@RequiredArgsConstructor
public class LocalidadeController {

    private final LocalidadeService localidadeService;

    @GetMapping
    public ResponseEntity<List<Localidade>> findAll() {
        return ResponseEntity.ok(localidadeService.buscarTodos());
    }

}
