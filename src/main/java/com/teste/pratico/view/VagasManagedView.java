package com.teste.pratico.view;

import com.teste.pratico.model.util.MessagesUtil;
import com.teste.pratico.model.vo.VagasVO;
import com.teste.pratico.service.VagasService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@ManagedBean
@ViewScoped
public class VagasManagedView {

    private final VagasService vagasService;

    private final MessagesUtil messagesUtil;

    private VagasVO vagasVO = new VagasVO();

    private Date dataAtual = new Date();

    public void salvarVagas() {
        if (vagasVO.getId() != null) {
            vagasService.salvarVagas(vagasVO);
            messagesUtil.renderInfoPopup("SUCESSO", "Vagas atualizadas.");
        } else {
            vagasService.criarNovaVagas(vagasVO);
            messagesUtil.renderInfoMessage("Vagas cadastradas com sucesso.");
        }
        clearVagasVO();
    }

    public void clearVagasVO() {
        vagasVO = new VagasVO();
    }
}