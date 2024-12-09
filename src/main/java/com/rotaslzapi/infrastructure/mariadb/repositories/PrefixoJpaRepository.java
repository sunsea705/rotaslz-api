package com.rotaslzapi.infrastructure.mariadb.repositories;

import com.rotaslzapi.infrastructure.mariadb.entities.Prefixo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrefixoJpaRepository extends JpaRepository<Prefixo, Long> {}
