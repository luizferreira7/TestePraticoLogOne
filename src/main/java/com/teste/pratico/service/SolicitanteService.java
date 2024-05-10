package com.teste.pratico.service;

import com.teste.pratico.model.entity.Solicitante;
import com.teste.pratico.model.exception.DatabaseOperationException;
import com.teste.pratico.model.exception.ResourceNotFoundException;
import com.teste.pratico.model.vo.SolicitanteVO;
import com.teste.pratico.repository.SolicitanteRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SolicitanteService {

    private final SolicitanteRepository solicitanteRepository;

    private final ModelMapper modelMapper;

    public void criarNovoSolicitante(SolicitanteVO solicitanteVO)
    {

        Solicitante solicitante = new Solicitante(solicitanteVO.getNome());

        try {
            solicitanteRepository.save(solicitante);
        } catch (Exception e) {
            throw new DatabaseOperationException(e);
        }
    }

    public List<SolicitanteVO> findSolicitantesVO(String nome)
    {
        return solicitanteRepository.findSolicitantesByNome(nome);
    }

    public SolicitanteVO findSolicitanteVOByIdAsString(String id)
    {
        Optional<Solicitante> optionalSolicitante = solicitanteRepository.findById(Long.valueOf(id));

        if (optionalSolicitante.isPresent()) {
            return modelMapper.map(optionalSolicitante.get(), SolicitanteVO.class);
        }

        throw new ResourceNotFoundException("solicitante", id);
    }

    public void salvarSolicitante(SolicitanteVO solicitanteVO)
    {
        Optional<Solicitante> optionalSolicitante = solicitanteRepository.findById(solicitanteVO.getId());

        if (optionalSolicitante.isEmpty()) {
            throw new ResourceNotFoundException("solicitante", solicitanteVO.getId().toString());
        }

        Solicitante solicitante = optionalSolicitante.get();
        solicitante.setNome(solicitanteVO.getNome());

        try {
            solicitanteRepository.save(solicitante);
        } catch (Exception e) {
            throw new DatabaseOperationException(e);
        }
    }
}
