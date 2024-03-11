package com.teste.pratico.service;

import com.teste.pratico.model.entity.Agendamento;
import com.teste.pratico.model.entity.Solicitante;
import com.teste.pratico.model.exception.DatabaseOperationException;
import com.teste.pratico.model.exception.ResourceNotFoundException;
import com.teste.pratico.model.util.CustomMapper;
import com.teste.pratico.model.vo.AgendamentoVO;
import com.teste.pratico.model.vo.SolicitanteVO;
import com.teste.pratico.repository.AgendamentoRepository;
import com.teste.pratico.repository.SolicitanteRepository;
import com.teste.pratico.repository.VagasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private SolicitanteRepository solicitanteRepository;

    @Autowired
    private VagasRepository vagasRepository;

    public void criaNovoAgendamento(AgendamentoVO agendamentoVO) {

        Optional<Solicitante> optionalSolicitante = solicitanteRepository.findById(agendamentoVO.getSolicitante().getId());

        if (!optionalSolicitante.isPresent()) {
            throw new ResourceNotFoundException("solicitante", agendamentoVO.getSolicitante().getNome());
        }

        Agendamento agendamento = new Agendamento(agendamentoVO.getData(), agendamentoVO.getNumero(), agendamentoVO.getMotivo(), optionalSolicitante.get());

        try {
            agendamentoRepository.save(agendamento);
        } catch (Exception e) {
            throw new DatabaseOperationException(e);
        }
    }

    public List<AgendamentoVO> findAgendamentosVO(Date inicio, Date fim) {
        List<Agendamento> agendamentos = agendamentoRepository.findAgendamentoByInicioAndFim(inicio, fim);

        return agendamentos.stream().map(a -> {
            AgendamentoVO agendamentoVO = CustomMapper.map(a, AgendamentoVO.class);
            SolicitanteVO solicitanteVO = CustomMapper.map(a.getSolicitante(), SolicitanteVO.class);

            agendamentoVO.setSolicitante(solicitanteVO);

            return agendamentoVO;
        }).collect(Collectors.toList());
    }

    public Boolean validarAgendamento(AgendamentoVO agendamentoVO) {
        int quantidadeVagas = vagasRepository.findQuantidadeVagasByData(agendamentoVO.getData());
        int quantidadeAgendamentos = agendamentoRepository.findQuantidadeAgendamentosByData(agendamentoVO.getData());

        return quantidadeVagas != 0 && quantidadeAgendamentos < quantidadeVagas;
    }

    public void salvarAgendamento(AgendamentoVO agendamentoVO) {
        Optional<Agendamento> optionalAgendamento = agendamentoRepository.findById(agendamentoVO.getId());

        if (!optionalAgendamento.isPresent()) {
            throw new ResourceNotFoundException("agendamento", agendamentoVO.getId().toString());
        }

        Agendamento agendamento = optionalAgendamento.get();
        agendamento.setData(agendamentoVO.getData());
        agendamento.setMotivo(agendamentoVO.getMotivo());
        agendamento.setNumero(agendamentoVO.getNumero());

        Optional<Solicitante> optionalSolicitante = solicitanteRepository.findById(agendamentoVO.getSolicitante().getId());

        if (!optionalSolicitante.isPresent()) {
            throw new ResourceNotFoundException("solicitante", agendamentoVO.getSolicitante().getNome());
        }

        agendamento.setSolicitante(optionalSolicitante.get());

        try {
            agendamentoRepository.save(agendamento);
        } catch (Exception e) {
            throw new DatabaseOperationException(e);
        }
    }
}
