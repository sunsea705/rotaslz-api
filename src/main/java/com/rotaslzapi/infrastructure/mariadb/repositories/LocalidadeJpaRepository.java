package com.rotaslzapi.infrastructure.mariadb.repositories;

import com.rotaslzapi.infrastructure.mariadb.entities.Localidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalidadeJpaRepository extends JpaRepository<Localidade, Long> {
}
