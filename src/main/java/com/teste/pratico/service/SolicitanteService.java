package com.teste.pratico.service;

import com.teste.pratico.model.entity.Solicitante;
import com.teste.pratico.model.util.CustomMapper;
import com.teste.pratico.model.vo.SolicitanteVO;
import com.teste.pratico.repository.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitanteService {

    @Autowired
    private SolicitanteRepository solicitanteRepository;

    public void criaNovoSolicitante(SolicitanteVO solicitanteVO) {

        Solicitante solicitante = new Solicitante(solicitanteVO.getNome());

        solicitanteRepository.save(solicitante);
    }

    public List<SolicitanteVO> findSolicitantesVO(String nome) {
        return solicitanteRepository.findSolicitantesByNome(nome);
    }

    public SolicitanteVO findSolicitanteVOByIdAsString(String id) {
        Optional<Solicitante> optionalSolicitante = solicitanteRepository.findById(Long.valueOf(id));

        if (optionalSolicitante.isPresent()) {
            return CustomMapper.map(optionalSolicitante.get(), SolicitanteVO.class);
        }

        throw new RuntimeException();
    }
}
