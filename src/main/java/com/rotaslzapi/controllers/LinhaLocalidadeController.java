package com.rotaslzapi.controllers;


import com.rotaslzapi.entities.LinhaLocalidade;
import com.rotaslzapi.requests.linhalocalidade.CriarLinhaLocalidadeRequest;
import com.rotaslzapi.requests.linhalocalidade.EditarOrdemLinhaLocalidadeRequest;
import com.rotaslzapi.services.LinhaLocalidadeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}


