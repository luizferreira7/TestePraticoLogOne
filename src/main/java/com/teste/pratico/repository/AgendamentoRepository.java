package com.teste.pratico.repository;

import com.teste.pratico.model.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    @Query("""
            select a
            from Agendamento a
            join fetch a.solicitante s
            where ( (cast(:fim as timestamp) is null or a.data >= :inicio)
            and (cast(:inicio as timestamp) is null or a.data <= :fim) )
            or a.data BETWEEN :inicio and :fim
            """)
    List<Agendamento> findAgendamentoByInicioAndFim(Date inicio, Date fim);

    @Query("""
            select coalesce(count(a), 0)
            from Agendamento a
            where a.data = :data
            """)
    int findQuantidadeAgendamentosByData(Date data);
}
