package com.teste.pratico.model.util;

import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Component
public class MessagesUtil {

    public void addMessageInfo(String summary, String detail, String type) {
        addMessage(FacesMessage.SEVERITY_INFO, summary, detail, type);
    }

    public void addMessageErro(String summary, String detail, String type) {
        addMessage(FacesMessage.SEVERITY_ERROR, summary, detail, type);
    }

    public void addMessageWarn(String summary, String detail, String type) {
        addMessage(FacesMessage.SEVERITY_WARN, summary, detail, type);
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        addMessage(severity, summary, detail, null);
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail, String type) {
        FacesContext.getCurrentInstance().addMessage(type, new FacesMessage(severity, summary, detail));
    }
}
