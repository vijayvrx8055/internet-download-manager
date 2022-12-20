module com.vrx.idm {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.vrx.idm to javafx.fxml;
    exports com.vrx.idm;
}
