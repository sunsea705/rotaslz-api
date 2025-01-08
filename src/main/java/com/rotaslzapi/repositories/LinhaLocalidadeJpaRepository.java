package com.rotaslzapi.repositories;

import com.rotaslzapi.entities.LinhaLocalidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinhaLocalidadeJpaRepository extends JpaRepository<LinhaLocalidade, Long> {

    List<LinhaLocalidade> findByLinhaIdAndLocalidadeIdOrderByOrdemDesc(Long linhaId, Long localidadeId);

}
