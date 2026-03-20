module gui.iposca {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;

    opens gui.iposca to javafx.fxml;
    exports gui.iposca;
    exports IPOS_CA_ORD;
    opens IPOS_CA_ORD to javafx.fxml;
}