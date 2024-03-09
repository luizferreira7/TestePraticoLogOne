package com.teste.pratico.service;

import com.teste.pratico.model.entity.Vagas;
import com.teste.pratico.model.vo.VagasVO;
import com.teste.pratico.repository.VagasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagasService {

    @Autowired
    private VagasRepository vagasRepository;

    public void criaNovasVagas(VagasVO vagasVO) {

        Vagas vagas = new Vagas(vagasVO.getInicio(), vagasVO.getFim(), vagasVO.getQuantidade());

        vagasRepository.save(vagas);

    }

    public List<Vagas> recuperaTodasVagas() {
        return vagasRepository.findAll();
    }
}