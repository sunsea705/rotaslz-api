package com.rotaslzapi.controllers;


import com.rotaslzapi.entities.LinhaLocalidade;
import com.rotaslzapi.services.LinhaLocalidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/linha")
@RequiredArgsConstructor
public class LinhaLocalidadeController {

    private final LinhaLocalidadeService localidadeService;

    @PostMapping
    public ResponseEntity<LinhaLocalidade>
}


