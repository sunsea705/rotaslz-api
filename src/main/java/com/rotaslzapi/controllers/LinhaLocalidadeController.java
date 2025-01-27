package com.rotaslzapi.controllers;


import com.rotaslzapi.entities.LinhaLocalidade;
import com.rotaslzapi.requests.linhalocalidade.BuscarLinhaLocalidadeRequest;
import com.rotaslzapi.requests.linhalocalidade.CriarLinhaLocalidadeRequest;
import com.rotaslzapi.requests.linhalocalidade.EditarOrdemLinhaLocalidadeRequest;
import com.rotaslzapi.services.LinhaLocalidadeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/linha-localidade")
@RequiredArgsConstructor
public class LinhaLocalidadeController {

    private final LinhaLocalidadeService linhaLocalidadeService;

    @PostMapping
    public ResponseEntity<LinhaLocalidade> criar(@Valid @RequestBody CriarLinhaLocalidadeRequest criarLinhaLocalidadeRequest) {
        return ResponseEntity.ok(
            linhaLocalidadeService.criar(criarLinhaLocalidadeRequest)
        );
    }

    @PostMapping
    public ResponseEntity<String> editarOrdem(@Valid @RequestBody EditarOrdemLinhaLocalidadeRequest editarOrdemLinhaLocalidadeRequest) {
        linhaLocalidadeService.editarOrdem(editarOrdemLinhaLocalidadeRequest);
        return ResponseEntity.ok("Ordem da LinhaLocalidade de ID " + editarOrdemLinhaLocalidadeRequest.linhaLocalidadeId() + " atualizada com sucesso!");
    }

    @GetMapping("/buscar-por-filtro")
    public ResponseEntity<List<LinhaLocalidade>> buscarPorFiltro(@Valid @RequestBody BuscarLinhaLocalidadeRequest buscarLinhaLocalidadeRequest) {
        return ResponseEntity.ok(
            linhaLocalidadeService.buscarPorFiltro(buscarLinhaLocalidadeRequest)
        );
    }

    @DeleteMapping("/deletar-por-id/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        linhaLocalidadeService.deletarPorId(id);
        return ResponseEntity.ok("Linha Localidade de ID: " + " deletada com sucesso!");
    }

}


