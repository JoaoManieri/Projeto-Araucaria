module com.manieri.projetosequoia {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires com.fasterxml.jackson.databind;
    requires annotations;
    requires de.jensd.fx.glyphs.fontawesome;
    requires javafx.graphics;

    requires software.amazon.awssdk.auth;
    requires software.amazon.awssdk.regions;
    requires software.amazon.awssdk.services.s3;
    requires software.amazon.awssdk.awscore;
    requires java.desktop;
    requires software.amazon.awssdk.core;

    exports com.manieri.projetosequoia;
    exports com.manieri.projetosequoia.ui.mainmenu;
    exports com.manieri.projetosequoia.files;
    exports com.manieri.projetosequoia.validadeFields;

    opens com.manieri.projetosequoia.ui.task;
    opens com.manieri.projetosequoia to javafx.fxml;
    opens com.manieri.projetosequoia.ui.mainmenu to javafx.fxml;

}