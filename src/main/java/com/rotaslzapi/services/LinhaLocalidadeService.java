package com.rotaslzapi.services;

import com.rotaslzapi.entities.Linha;
import com.rotaslzapi.entities.LinhaLocalidade;
import com.rotaslzapi.entities.Localidade;
import com.rotaslzapi.repositories.custom.linhalocalidade.LinhaLocalidadeCustomRepository;
import com.rotaslzapi.repositories.jpa.LinhaLocalidadeJpaRepository;
import com.rotaslzapi.requests.linhalocalidade.BuscarLinhaLocalidadeRequest;
import com.rotaslzapi.requests.linhalocalidade.CriarLinhaLocalidadeRequest;
import com.rotaslzapi.requests.linhalocalidade.EditarOrdemLinhaLocalidadeRequest;
import com.rotaslzapi.utils.OperacoesSimplesJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LinhaLocalidadeService {

    private final LinhaLocalidadeJpaRepository linhaLocalidadeJpaRepository;
    private final LinhaLocalidadeCustomRepository linhaLocalidadeCustomRepository;
    private final LinhaService linhaService;
    private final LocalidadeService localidadeService;

    public LinhaLocalidade buscarPorId(Long id) {
        return OperacoesSimplesJpa.buscarPorId(id, linhaLocalidadeJpaRepository, "Linha Localidade");
    }

    public List<LinhaLocalidade> buscarPorFiltro(BuscarLinhaLocalidadeRequest buscarLinhaLocalidadeRequest) {
        return linhaLocalidadeCustomRepository.buscarPorFiltro(buscarLinhaLocalidadeRequest);
    }

    public LinhaLocalidade criar(CriarLinhaLocalidadeRequest criarLinhaLocalidadeRequest) {

        if (criarLinhaLocalidadeRequest.ordem() <= 0) {
            throw new IllegalArgumentException("O ordem informada deve ser maior que zero!");
        }

        Linha linha = linhaService.buscarPorId(criarLinhaLocalidadeRequest.linhaId());
        Localidade localidade = localidadeService.buscarPorId(criarLinhaLocalidadeRequest.localidadeId());
        
        validarOrdem(linha.getId(), localidade.getId(), criarLinhaLocalidadeRequest.ordem());

        LinhaLocalidade linhaLocalidade = LinhaLocalidade
            .builder()
            .linha(linha)
            .localidade(localidade)
            .ordem(criarLinhaLocalidadeRequest.ordem())
            .descricao(linha + " / " + localidade.getDescricao())
            .build();

        linhaLocalidade = linhaLocalidadeJpaRepository.save(linhaLocalidade);

        remanejarOrdens(linha.getId(), localidade.getId(), linhaLocalidade.getOrdem(), true);

        return linhaLocalidade;

    }

    public void editarOrdem(EditarOrdemLinhaLocalidadeRequest editarOrdemLinhaLocalidadeRequest) {

        if (editarOrdemLinhaLocalidadeRequest.ordem() <= 0) {
            throw new IllegalArgumentException("A ordem informada deve ser maior que zero!");
        }

        LinhaLocalidade linhaLocalidade = OperacoesSimplesJpa.buscarPorId(editarOrdemLinhaLocalidadeRequest.linhaLocalidadeId(), linhaLocalidadeJpaRepository, "Linha Localidade");

        validarOrdem(linhaLocalidade.getLinha().getId(), linhaLocalidade.getLocalidade().getId(), editarOrdemLinhaLocalidadeRequest.ordem());

        linhaLocalidade.setOrdem(editarOrdemLinhaLocalidadeRequest.ordem());

        linhaLocalidade = linhaLocalidadeJpaRepository.save(linhaLocalidade);

        remanejarOrdens(linhaLocalidade.getLinha().getId(), linhaLocalidade.getLocalidade().getId(), linhaLocalidade.getOrdem(), true);

    }

    public void deletarPorId(Long id) {
        LinhaLocalidade linhaLocalidade = OperacoesSimplesJpa.buscarPorId(id, linhaLocalidadeJpaRepository, "Linha Localidade");
        OperacoesSimplesJpa.deletarSimplesPorId(id, linhaLocalidadeJpaRepository, "Linha Localidade");
        remanejarOrdens(linhaLocalidade.getLinha().getId(), linhaLocalidade.getLocalidade().getId(), linhaLocalidade.getOrdem(), false);
    }

    private void validarOrdem(Long linhaId, Long localidadeId, Integer ordem) {

        List<LinhaLocalidade> linhaLocalidades = linhaLocalidadeJpaRepository.findByLinhaIdAndLocalidadeIdOrderByOrdemDesc(linhaId, localidadeId);

        if (linhaLocalidades.isEmpty() && ordem > 1) {
            throw new IllegalArgumentException("A ordem informada neste caso precisa ser 1: não há LinhasLocalidades cadastradas.");
        }

        int proximaOrdem = linhaLocalidades.get(linhaLocalidades.size() - 1).getOrdem() + 1;

        if (ordem > proximaOrdem) {
            throw new IllegalArgumentException("A ordem informada neste caso precisa ser " + proximaOrdem + ", pois a última ordem cadastrada é " + (proximaOrdem - 1));
        }
    }

    private void editarOrdem(Long linhaLocalidadeId, Integer ordem) {

        if (ordem <= 0) {
            throw new IllegalArgumentException("O ordem informada deve ser maior que zero!");
        }

        LinhaLocalidade linhaLocalidade = buscarPorId(linhaLocalidadeId);
        linhaLocalidade.setOrdem(ordem);

        linhaLocalidadeJpaRepository.save(linhaLocalidade);
    }

    private void remanejarOrdens(Long linhaId, Long localidadeId, Integer ordem, boolean isAdicionar) {

        List<LinhaLocalidade> linhaLocalidades = new ArrayList<>();

        linhaLocalidadeJpaRepository.findByLinhaIdAndLocalidadeIdOrderByOrdemDesc(linhaId, localidadeId)
            .forEach(linhaLocalidade -> {
                if (isAdicionar) {
                    if (linhaLocalidade.getOrdem() >= ordem) {
                        linhaLocalidades.add(linhaLocalidade);
                    }
                }
                else {
                    if (linhaLocalidade.getOrdem() > ordem) {
                        linhaLocalidades.add(linhaLocalidade);
                    }
                }

            }
        );

        for (LinhaLocalidade linhaLocalidade : linhaLocalidades) {
            editarOrdem(linhaLocalidade.getId(),
                isAdicionar ? (linhaLocalidade.getOrdem() + 1) : (linhaLocalidade.getOrdem() - 1)
            );
        }

    }
}
