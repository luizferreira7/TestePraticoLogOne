package com.teste.pratico.repository;

import com.teste.pratico.model.entity.Solicitante;
import com.teste.pratico.model.vo.SolicitanteVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SolicitanteRepository extends JpaRepository<Solicitante, Long> {

    @Query("select new com.teste.pratico.model.vo.SolicitanteVO(s.id, s.nome) " +
            "from Solicitante s " +
            "where :nome is null or s.nome like %:nome%")
    List<SolicitanteVO> findSolicitantesByNome(String nome);
}
