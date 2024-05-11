package com.teste.pratico.model.util;

import com.teste.pratico.model.enums.ValidationErrorCode;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Component
public class MessagesUtil {

    public void renderWarnMessage(String message) {
        addMessage(FacesMessage.SEVERITY_WARN, message, null, "msg");
    }

    public void renderInfoMessage(String message) {
        addMessage(FacesMessage.SEVERITY_INFO, message, null, "msg");
    }

    public void renderInfoPopup(String title, String body) {
        addMessage(FacesMessage.SEVERITY_INFO, title, body, "popup");
    }

    public void renderErroMessage(String message) {
        addMessage(FacesMessage.SEVERITY_ERROR, message, null, "msg");
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail, String type) {
        FacesContext.getCurrentInstance().addMessage(type, new FacesMessage(severity, summary, detail));
    }
}
