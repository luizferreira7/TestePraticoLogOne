package com.teste.pratico.model.converter;

import com.teste.pratico.model.vo.SolicitanteVO;
import com.teste.pratico.service.SolicitanteService;
import lombok.RequiredArgsConstructor;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@Named
@FacesConverter(value = "solicitanteConverter")
@RequiredArgsConstructor
public class SolicitanteConverter implements Converter {

    private final SolicitanteService solicitanteService;

    @Override
    public SolicitanteVO getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.trim().isEmpty()) {
            try {
                return solicitanteService.findSolicitanteVOByIdAsString(value);
            }
            catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de conversão", "Solicitante não é válido."));
            }
        }
        else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            SolicitanteVO solicitanteVO = (SolicitanteVO) value;

            return Long.toString(solicitanteVO.getId());
        }
        else {
            return null;
        }
    }
}