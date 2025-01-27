package com.rotaslzapi.repositories.custom.linhalocalidade;

import com.rotaslzapi.entities.LinhaLocalidade;
import com.rotaslzapi.requests.linhalocalidade.BuscarLinhaLocalidadeRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class LinhaLocalidadeCustomRepositoryImpl implements LinhaLocalidadeCustomRepository {

    private final EntityManager entityManager;

    @Override
    public List<LinhaLocalidade> buscarPorFiltro(BuscarLinhaLocalidadeRequest buscarLinhaLocalidadeRequest) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<LinhaLocalidade> queryLinhaLocalidade = cb.createQuery(LinhaLocalidade.class);
        Root<LinhaLocalidade> linhaLocalidadeRoot = queryLinhaLocalidade.from(LinhaLocalidade.class);
        List<Predicate> predicados = new ArrayList<>();

        if (buscarLinhaLocalidadeRequest.linhaId() != null) {
            predicados.add(cb.equal(linhaLocalidadeRoot.get("linha").get("id"), buscarLinhaLocalidadeRequest.linhaId()));
        }

        if (buscarLinhaLocalidadeRequest.localidadeId() != null) {
            predicados.add(cb.equal(linhaLocalidadeRoot.get("localidade").get("id"), buscarLinhaLocalidadeRequest.localidadeId()));
        }

        if (!predicados.isEmpty()) {
            queryLinhaLocalidade.where(predicados.toArray(new Predicate[0]));
        }

        TypedQuery<LinhaLocalidade> query = entityManager.createQuery(queryLinhaLocalidade);

        return query.getResultList();

    }

}
