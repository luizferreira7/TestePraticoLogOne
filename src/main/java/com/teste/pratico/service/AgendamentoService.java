package com.teste.pratico.service;

import com.teste.pratico.model.entity.Agendamento;
import com.teste.pratico.model.entity.Solicitante;
import com.teste.pratico.model.exception.DatabaseOperationException;
import com.teste.pratico.model.exception.ResourceNotFoundException;
import com.teste.pratico.model.vo.AgendamentoVO;
import com.teste.pratico.repository.AgendamentoRepository;
import com.teste.pratico.repository.SolicitanteRepository;
import com.teste.pratico.repository.VagasRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    private final SolicitanteRepository solicitanteRepository;

    private final VagasRepository vagasRepository;

    private final ModelMapper modelMapper;

    public void criarNovoAgendamento(AgendamentoVO agendamentoVO)
    {
        Optional<Solicitante> optionalSolicitante = solicitanteRepository.findById(agendamentoVO.getSolicitante().getId());

        if (optionalSolicitante.isEmpty()) {
            throw new ResourceNotFoundException("solicitante", agendamentoVO.getSolicitante().getNome());
        }

        Agendamento agendamento = modelMapper.map(agendamentoVO, Agendamento.class);

        try {
            agendamentoRepository.save(agendamento);
        } catch (Exception e) {
            throw new DatabaseOperationException(e);
        }
    }

    public List<AgendamentoVO> findAgendamentosVO(Date inicio, Date fim, String numero, String motivo) {
        List<Agendamento> agendamentos = agendamentoRepository.findAgendamentoByInicioAndFim(inicio, fim, numero, motivo);

        return agendamentos.stream().map(a -> modelMapper.map(a, AgendamentoVO.class)).toList();
    }

    public Boolean validarAgendamento(AgendamentoVO agendamentoVO) {
        int quantidadeVagas = vagasRepository.findQuantidadeVagasByData(agendamentoVO.getData());
        int quantidadeAgendamentos = agendamentoRepository.findQuantidadeAgendamentosByData(agendamentoVO.getData());

        return quantidadeVagas != 0 && quantidadeAgendamentos < quantidadeVagas;
    }

    public void salvarAgendamento(AgendamentoVO agendamentoVO) {
        Optional<Agendamento> optionalAgendamento = agendamentoRepository.findById(agendamentoVO.getId());

        if (optionalAgendamento.isEmpty()) {
            throw new ResourceNotFoundException("agendamento", agendamentoVO.getId().toString());
        }

        Agendamento agendamento = optionalAgendamento.get();

        modelMapper.map(agendamentoVO, agendamento);

        Optional<Solicitante> optionalSolicitante = solicitanteRepository.findById(agendamentoVO.getSolicitante().getId());

        if (optionalSolicitante.isEmpty()) {
            throw new ResourceNotFoundException("solicitante", agendamentoVO.getSolicitante().getNome());
        }

        agendamento.setSolicitante(optionalSolicitante.get());

        try {
            agendamentoRepository.saveAndFlush(agendamento);
        } catch (Exception e) {
            throw new DatabaseOperationException(e);
        }
    }
}
