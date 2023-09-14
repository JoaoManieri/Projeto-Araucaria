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

    requires java.desktop;
    requires javafx.web;
    requires java.net.http;

    exports com.manieri.projetoaraucaria;
    exports com.manieri.projetoaraucaria.ui.mainmenu;
    exports com.manieri.projetoaraucaria.files;
    exports com.manieri.projetoaraucaria.validadeFields;

    opens com.manieri.projetoaraucaria.ui.task;
    opens com.manieri.projetoaraucaria.ui.fastDaily;
    opens com.manieri.projetoaraucaria to javafx.fxml;
    opens com.manieri.projetoaraucaria.ui.mainmenu to javafx.fxml;
}