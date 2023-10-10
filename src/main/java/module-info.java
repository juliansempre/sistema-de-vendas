module com.vendas.sistemadevendas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens com.vendas.sistemadevendas to javafx.fxml;
    opens com.vendas.sistemadevendas.vender.controller to javafx.fxml; // Adicione esta linha
    opens com.vendas.sistemadevendas.painel to javafx.fxml;
    opens com.vendas.sistemadevendas.painel.controller to javafx.fxml;
    opens com.vendas.sistemadevendas.adm.autentificacao.login.controller to javafx.fxml;
    opens com.vendas.sistemadevendas.adm.autentificacao.login.model to javafx.fxml;
    opens com.vendas.sistemadevendas.adm.autentificacao.login.DAO;
    opens com.vendas.sistemadevendas.adm.autentificacao.cadastrar.model to javafx.fxml;
    opens com.vendas.sistemadevendas.adm.autentificacao.cadastrar.controller;
    opens com.vendas.sistemadevendas.vender.model to javafx.base;

    exports com.vendas.sistemadevendas;
    exports com.vendas.sistemadevendas.vender.controller;
    exports com.vendas.sistemadevendas.painel;
    exports com.vendas.sistemadevendas.painel.controller;
    exports com.vendas.sistemadevendas.adm.autentificacao.login.controller;
    exports com.vendas.sistemadevendas.adm.autentificacao.login.model;
    exports com.vendas.sistemadevendas.adm.autentificacao.login.DAO;
    exports com.vendas.sistemadevendas.adm.autentificacao.cadastrar.model;
    exports com.vendas.sistemadevendas.adm.autentificacao.cadastrar.controller;
    exports com.vendas.sistemadevendas.vender.model;
}
