package com.teste.pratico.service;

import com.teste.pratico.model.entity.Agendamento;
import com.teste.pratico.model.entity.Solicitante;
import com.teste.pratico.model.util.CustomMapper;
import com.teste.pratico.model.vo.AgendamentoVO;
import com.teste.pratico.repository.AgendamentoRepository;
import com.teste.pratico.repository.SolicitanteRepository;
import com.teste.pratico.repository.VagasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

        if (optionalSolicitante.isPresent() && validarAgendamento(agendamentoVO))
        {
            Agendamento agendamento = new Agendamento(agendamentoVO.getData(), agendamentoVO.getNumero(), agendamentoVO.getMotivo(), optionalSolicitante.get());

            agendamentoRepository.save(agendamento);

            info();

            return;
        }

        erro();
    }

    public List<AgendamentoVO> findAgendamentosVO(Date inicio, Date fim) {
        List<Agendamento> agendamentos = agendamentoRepository.findAgendamentoByInicioAndFim(inicio, fim);

        return agendamentos.stream().map(a -> CustomMapper.<AgendamentoVO, AgendamentoVO>map(a, AgendamentoVO.class)).collect(Collectors.toList());
    }

    public Boolean validarAgendamento(AgendamentoVO agendamentoVO) {
        int quantidadeVagas = vagasRepository.findQuantidadeVagasByData(agendamentoVO.getData());

        if (quantidadeVagas > 0) {
            int quantidadeAgendamentos = agendamentoRepository.findQuantidadeAgendamentosByData(agendamentoVO.getData());

            return quantidadeAgendamentos < quantidadeVagas;
        }

        return false;
    }

    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Agendamento cadastrado."));
    }

    public void erro() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Falha ao cadastrar agendamento."));
    }
}
