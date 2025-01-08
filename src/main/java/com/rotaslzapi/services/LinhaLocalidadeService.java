package com.rotaslzapi.services;

import com.rotaslzapi.entities.Linha;
import com.rotaslzapi.entities.LinhaLocalidade;
import com.rotaslzapi.entities.Localidade;
import com.rotaslzapi.repositories.LinhaLocalidadeJpaRepository;
import com.rotaslzapi.requests.linhalocalidade.CriarLinhaLocalidadeRequest;
import com.rotaslzapi.utils.OperacoesSimplesJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LinhaLocalidadeService {

    private final LinhaLocalidadeJpaRepository linhaLocalidadeJpaRepository;
    private final LinhaService linhaService;
    private final LocalidadeService localidadeService;

    public LinhaLocalidade buscarPorId(Long id) {
        return OperacoesSimplesJpa.buscarPorId(id, linhaLocalidadeJpaRepository, "Linha Localidade");
    }

    public LinhaLocalidade criarLinhaLocalidade(CriarLinhaLocalidadeRequest criarLinhaLocalidadeRequest) {

        if (criarLinhaLocalidadeRequest.ordem() <= 0) {
            throw new IllegalArgumentException("O ordem informada deve ser maior que zero!");
        }

        Linha linha = linhaService.buscarPorId(criarLinhaLocalidadeRequest.linhaId());
        Localidade localidade = localidadeService.buscarPorId(criarLinhaLocalidadeRequest.localidadeId());

        return null;

    }

    public LinhaLocalidade editarOrdem(Long linhaLocalidadeId, Integer ordem) {

        if (ordem <= 0) {
            throw new IllegalArgumentException("O ordem informada deve ser maior que zero!");
        }

        LinhaLocalidade linhaLocalidade = buscarPorId(linhaLocalidadeId);
        linhaLocalidade.setOrdem(ordem);

        remanejarOrdens(linhaLocalidade.getLinha().getId(), linhaLocalidade.getLocalidade().getId(), ordem);

        return linhaLocalidadeJpaRepository.save(linhaLocalidade);
    }

    private void remanejarOrdens(Long linhaId, Long localidadeId, Integer ordem) {

        List<LinhaLocalidade> linhaLocalidades = new ArrayList<>();

        linhaLocalidadeJpaRepository.findByLinhaIdAndLocalidadeIdOrderByOrdemDesc(linhaId, localidadeId)
            .forEach(linhaLocalidade -> {
                if (linhaLocalidade.getOrdem() >= ordem) {
                    linhaLocalidades.add(linhaLocalidade);
                }
            }
        );

        for (LinhaLocalidade linhaLocalidade : linhaLocalidades) {
            editarOrdem(linhaLocalidade.getId(), linhaLocalidade.getOrdem() + 1);
        }


    }
}
