package com.vendas.sistemadevendas;

import com.vendas.sistemadevendas.adm.autentificacao.login.controller.LoginController;
import com.vendas.sistemadevendas.adm.autentificacao.login.model.LoginModel;
import com.vendas.sistemadevendas.adm.autentificacao.login.model.LoginStart;
import com.vendas.sistemadevendas.painel.PainelApplication;
import com.vendas.sistemadevendas.painel.controller.PainelController;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartApp {
    public static void main(String[] args) {
        LoginStart loginStart = new LoginStart();
        loginStart.main(args);
    }
}
