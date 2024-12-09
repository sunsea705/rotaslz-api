package com.rotaslzapi.infrastructure.mariadb.repositories;

import com.rotaslzapi.infrastructure.mariadb.entities.TipoLocalidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoLocalidadeJpaRepository extends JpaRepository<TipoLocalidade, Long> {
}
