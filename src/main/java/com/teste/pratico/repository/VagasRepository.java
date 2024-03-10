package com.teste.pratico.repository;

import com.teste.pratico.model.entity.Vagas;
import com.teste.pratico.model.vo.VagasVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface VagasRepository extends JpaRepository<Vagas, String> {

    @Query("select new com.teste.pratico.model.vo.VagasVO(v.id, v.inicio, v.fim, v.quantidade) " +
            "from Vagas v " +
            "where (:inicio is null or v.inicio >= :inicio) " +
            "and (:fim is null or v.fim <= :fim)")
    public List<VagasVO> findVagasByInicioAndFim(Date inicio, Date fim);
}
