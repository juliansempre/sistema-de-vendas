package com.vendas.sistemadevendas.vender.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Tarefas {
    private final IntegerProperty id;
    private final StringProperty tarefa;

    public Tarefas(int id, String tarefa) {
        this.id = new SimpleIntegerProperty(id);
        this.tarefa = new SimpleStringProperty(tarefa);
    }

    public int getId() {
        return id.get();
    }

    public String getTarefa() {
        return tarefa.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty tarefaProperty() {
        return tarefa;
    }
}
