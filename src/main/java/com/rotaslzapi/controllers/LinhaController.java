package com.rotaslzapi.controllers;

import com.rotaslzapi.entities.Linha;
import com.rotaslzapi.requests.CriarLinhaRequest;
import com.rotaslzapi.services.LinhaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/linha")
@RequiredArgsConstructor
public class LinhaController {

    private final LinhaService linhaService;

    @GetMapping
    public ResponseEntity<List<Linha>> listaLinhas() {
        return ResponseEntity.ok(linhaService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Linha> criarLinha(@Valid @RequestBody CriarLinhaRequest criarLinhaRequest){
        return ResponseEntity.ok(linhaService.criarLinha(criarLinhaRequest));
    }

}
