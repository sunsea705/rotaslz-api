package com.rotaslzapi.infrastructure.mariadb.controllers;

import com.rotaslzapi.infrastructure.mariadb.entities.Localidade;
import com.rotaslzapi.requests.CriarLocalidadeRequest;
import com.rotaslzapi.infrastructure.mariadb.services.LocalidadeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mariadb/localidade")
@RequiredArgsConstructor
public class LocalidadeController {

    private final LocalidadeService localidadeService;

    @GetMapping
    public ResponseEntity<List<Localidade>> findAll() {
        return ResponseEntity.ok(localidadeService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Localidade> criarLocalidade(@Valid @RequestBody CriarLocalidadeRequest criarLocalidadeRequest) {
        return ResponseEntity.ok(localidadeService.criarLocalidade(criarLocalidadeRequest));
    }

}
