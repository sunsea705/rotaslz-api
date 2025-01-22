package com.rotaslzapi.controllers;

import com.rotaslzapi.entities.Localidade;
import com.rotaslzapi.requests.localidade.CriarLocalidadeRequest;
import com.rotaslzapi.requests.localidade.AtualizarLocalidadeRequest;
import com.rotaslzapi.services.LocalidadeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localidade")
@RequiredArgsConstructor
public class LocalidadeController {

    private final LocalidadeService localidadeService;

    @GetMapping
    public ResponseEntity<List<Localidade>> buscarTodos() {
        return ResponseEntity.ok(localidadeService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Localidade> criarLocalidade(@Valid @RequestBody CriarLocalidadeRequest criarLocalidadeRequest) {
        return ResponseEntity.ok(localidadeService.criar(criarLocalidadeRequest));
    }

    @PutMapping
    public ResponseEntity<Localidade> atualizarLocalidade(@Valid @RequestBody AtualizarLocalidadeRequest atualizarLocalidadeRequest) {
        System.out.println("atualizarLocalidadeRequest = " + atualizarLocalidadeRequest);
        return ResponseEntity.ok(localidadeService.atualizar(atualizarLocalidadeRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarLocalidade(@PathVariable Long id){
        localidadeService.deletarPorId(id);
        return ResponseEntity.ok("Localidade de ID " + id + " deletada com sucesso!");
    }


}
