package com.teste.pratico.repository;

import com.teste.pratico.model.entity.Vagas;
import com.teste.pratico.model.vo.VagasVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface VagasRepository extends JpaRepository<Vagas, Long> {

    @Query("""
            select new com.teste.pratico.model.vo.VagasVO(v.id, v.inicio, v.fim, v.quantidade)
            from Vagas v
            where (cast(:inicio as timestamp) is null or v.inicio >= :inicio)
            and (cast(:fim as timestamp) is null or v.fim <= :fim)
            and (:quantidade is null or :quantidade = v.quantidade)
            """)
    List<VagasVO> findVagasByInicioAndFim(Date inicio, Date fim, Integer quantidade);

    @Query("""
            select coalesce(sum(v.quantidade), 0)
            from Vagas v
            where :data between v.inicio and v.fim
            """)
    int findQuantidadeVagasByData(Date data);
}
