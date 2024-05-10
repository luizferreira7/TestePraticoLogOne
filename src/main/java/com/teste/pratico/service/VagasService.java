package com.teste.pratico.service;

import com.teste.pratico.model.entity.Vagas;
import com.teste.pratico.model.exception.DatabaseOperationException;
import com.teste.pratico.model.exception.ResourceNotFoundException;
import com.teste.pratico.model.vo.VagasVO;
import com.teste.pratico.repository.VagasRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VagasService {

    private final VagasRepository vagasRepository;

    private final ModelMapper modelMapper;

    public void criarNovaVagas(VagasVO vagasVO) {
        Vagas vagas = new Vagas(vagasVO.getInicio(), vagasVO.getFim(), vagasVO.getQuantidade());

        try {
            vagasRepository.save(vagas);
        } catch (Exception e) {
            throw new DatabaseOperationException(e);
        }
    }

    public void salvarVagas(VagasVO vagasVO) {
        Optional<Vagas> optionalVagas = vagasRepository.findById(vagasVO.getId());

        if (optionalVagas.isEmpty()) {
            throw new ResourceNotFoundException("vagas", vagasVO.getId().toString());
        }

        Vagas vagas = optionalVagas.get();

        modelMapper.map(vagasVO, vagas);

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