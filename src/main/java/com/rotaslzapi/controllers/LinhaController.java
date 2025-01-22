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
    public ResponseEntity<List<Linha>> buscarTodos() {
        return ResponseEntity.ok(linhaService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Linha> criar(@Valid @RequestBody CriarLinhaRequest criarLinhaRequest){
        return ResponseEntity.ok(linhaService.criar(criarLinhaRequest));
    }

    @PutMapping
    public ResponseEntity<Linha> atualizar(@Valid @RequestBody AtualizarLinhaRequest atualizarLinhaRequest){
        return ResponseEntity.ok(linhaService.atualizar(atualizarLinhaRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        linhaService.deletarPorId(id);
        return ResponseEntity.ok("Linha de ID " + id + " deletada com sucesso!");
    }


}
