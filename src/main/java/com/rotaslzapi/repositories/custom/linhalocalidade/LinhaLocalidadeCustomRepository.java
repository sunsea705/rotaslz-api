package com.rotaslzapi.repositories.custom.linhalocalidade;

import com.rotaslzapi.entities.LinhaLocalidade;
import com.rotaslzapi.requests.linhalocalidade.BuscarLinhaLocalidadeRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinhaLocalidadeCustomRepository {

    List<LinhaLocalidade> buscarPorFiltro(BuscarLinhaLocalidadeRequest buscarLinhaLocalidadeRequest);

}
