module com.example.task_7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires jdk.unsupported;


    opens com.example.task_7 to javafx.fxml;
    exports com.example.task_7;
}