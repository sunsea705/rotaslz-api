package com.rotaslzapi.controllers;

import com.rotaslzapi.entities.Linha;
import com.rotaslzapi.requests.linha.AtualizarLinhaRequest;
import com.rotaslzapi.requests.linha.CriarLinhaRequest;
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

    @PutMapping
    public ResponseEntity<Linha> atualizarLinha(@Valid @RequestBody AtualizarLinhaRequest atualizarLinhaRequest){
        return ResponseEntity.ok(linhaService.atualizarLinha(atualizarLinhaRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarLinha(@PathVariable Long id){
        linhaService.deletarLinha(id);
        return ResponseEntity.ok("Linha de ID " + id + " deletada com sucesso!");
    }


}
