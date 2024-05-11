package com.teste.pratico.view;

import com.teste.pratico.model.util.MessagesUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public abstract class AbstractManagedView<T> {

    List<T> novasEntidades = new ArrayList<>();

    private final MessagesUtil messagesUtil;

    public abstract void salvar();

    public void clearEntidades() {
        this.novasEntidades = new ArrayList<>();
    }
}
