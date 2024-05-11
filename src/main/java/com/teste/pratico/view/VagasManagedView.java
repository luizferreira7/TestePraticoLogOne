package com.teste.pratico.view;

import com.teste.pratico.model.util.MessagesUtil;
import com.teste.pratico.model.vo.VagasVO;
import com.teste.pratico.service.VagasService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.Date;

@Getter
@Setter
@ManagedBean
@ViewScoped
public class VagasManagedView extends AbstractManagedView<VagasVO> {

    private final VagasService vagasService;

    private VagasVO vagasVO = new VagasVO();

    private Date dataAtual = new Date();

    public VagasManagedView(MessagesUtil messagesUtil, VagasService vagasService) {
        super(messagesUtil);
        this.vagasService = vagasService;
    }

    @Override
    public void salvar() {
        if (vagasVO.getId() != null) {
            vagasService.salvarVagas(vagasVO);
            getMessagesUtil().renderInfoPopup("SUCESSO", "Vagas atualizadas.");
        } else {
            vagasService.criarNovaVagas(vagasVO);
            getMessagesUtil().renderInfoMessage("Vagas cadastradas com sucesso.");
            getNovasEntidades().add(vagasVO);
        }
        clearVagasVO();
    }

    public void clearVagasVO() {
        vagasVO = new VagasVO();
    }
}