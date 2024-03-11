package com.teste.pratico.service;

import com.teste.pratico.model.entity.Vagas;
import com.teste.pratico.model.exception.DatabaseOperationException;
import com.teste.pratico.model.exception.ResourceNotFoundException;
import com.teste.pratico.model.vo.VagasVO;
import com.teste.pratico.repository.VagasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VagasService {

    @Autowired
    private VagasRepository vagasRepository;

    public void criaNovasVagas(VagasVO vagasVO) {

        Vagas vagas = new Vagas(vagasVO.getInicio(), vagasVO.getFim(), vagasVO.getQuantidade());

        try {
            vagasRepository.save(vagas);
        } catch (Exception e) {
            throw new DatabaseOperationException(e);
        }
    }

    public void salvarVagas(VagasVO vagasVO) {
        Optional<Vagas> optionalVagas = vagasRepository.findById(vagasVO.getId());

        if (!optionalVagas.isPresent()) {
            throw new ResourceNotFoundException("vagas", vagasVO.getId().toString());
        }

        Vagas vagas = optionalVagas.get();
        vagas.setQuantidade(vagasVO.getQuantidade());
        vagas.setInicio(vagasVO.getInicio());
        vagas.setFim(vagasVO.getFim());

        try {
            vagasRepository.save(vagas);
        } catch (Exception e) {
            throw new DatabaseOperationException(e);
        }
    }

    public List<VagasVO> findVagasVO(Date inicio, Date fim) {
        return vagasRepository.findVagasByInicioAndFim(inicio, fim);
    }
}