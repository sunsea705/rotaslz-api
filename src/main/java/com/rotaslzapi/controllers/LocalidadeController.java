package com.rotaslzapi.controllers;

import com.rotaslzapi.entities.Localidade;
import com.rotaslzapi.requests.CriarLocalidadeRequest;
import com.rotaslzapi.requests.EditarLocalidadeRequest;
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
    public ResponseEntity<List<Localidade>> findAll() {
        return ResponseEntity.ok(localidadeService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Localidade> criarLocalidade(@Valid @RequestBody CriarLocalidadeRequest criarLocalidadeRequest) {
        return ResponseEntity.ok(localidadeService.criarLocalidade(criarLocalidadeRequest));
    }

    @PutMapping
    public ResponseEntity<Localidade> editarLocalidade(@Valid @RequestBody EditarLocalidadeRequest editarLocalidadeRequest) {
        System.out.println("editarLocalidadeRequest = " + editarLocalidadeRequest);
        return ResponseEntity.ok(localidadeService.editarLocalidade(editarLocalidadeRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarLocalidade(@PathVariable Long id){
        localidadeService.deletarLocalidadePorId(id);
        return ResponseEntity.ok("Localidade de ID " + id + " deletada com sucesso!");
    }


}
