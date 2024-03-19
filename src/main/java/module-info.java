module com.example.picaria_ldp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.picaria_ldp to javafx.fxml;
    exports com.example.picaria_ldp;
}