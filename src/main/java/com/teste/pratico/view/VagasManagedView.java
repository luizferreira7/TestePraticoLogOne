package com.teste.pratico.view;

import com.teste.pratico.model.util.MessagesUtil;
import com.teste.pratico.model.vo.VagasVO;
import com.teste.pratico.service.VagasService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.Date;

@ManagedBean
@ViewScoped
public class VagasManagedView {

    @Autowired
    private VagasService vagasService;

    @Autowired
    protected MessagesUtil messagesUtil;

    private VagasVO vagasVO = new VagasVO();

    private Date dataAtual = new Date();

    public void salvarVagas() {
        if (vagasVO.getId() != null) {
            vagasService.salvarVagas(vagasVO);
            messagesUtil.addMessageInfo("SUCESSO", "Vagas atualizadas.", "popup");
        } else {
            vagasService.criaNovasVagas(vagasVO);
            messagesUtil.addMessageInfo("Vagas cadastradas com sucesso.", null, "msg");
        }
        clearVagasVO();
    }

    public VagasVO getVagasVO() {
        return vagasVO;
    }

    public void setVagasVO(VagasVO vagasVO) {
        this.vagasVO = vagasVO;
    }

    public Date getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }

    public void clearVagasVO() {
        vagasVO = new VagasVO();
    }
}