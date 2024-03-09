package com.teste.pratico.repository;

import com.teste.pratico.model.entity.Vagas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagasRepository extends JpaRepository<Vagas, String> {
}
