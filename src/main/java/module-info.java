module alkfejl {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens alkfejl to javafx.fxml;
    exports alkfejl;
    exports alkfejl.controller;
    exports alkfejl.DAO;
    exports alkfejl.model;
}
