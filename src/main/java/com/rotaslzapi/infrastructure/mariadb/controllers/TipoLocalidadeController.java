package com.rotaslzapi.infrastructure.mariadb.controllers;

import com.rotaslzapi.infrastructure.mariadb.entities.TipoLocalidade;
import com.rotaslzapi.infrastructure.mariadb.services.TipoLocalidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mariadb/tipo-localidade")
@RequiredArgsConstructor
public class TipoLocalidadeController {

    private final TipoLocalidadeService tipoLocalidadeService;

    @GetMapping
    public ResponseEntity<List<TipoLocalidade>> listarTodos() {
        return ResponseEntity.ok(tipoLocalidadeService.buscarTodos());
    }

}
