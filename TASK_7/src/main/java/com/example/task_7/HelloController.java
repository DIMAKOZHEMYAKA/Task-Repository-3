package com.example.task_7;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import observableElements.Animation;
import observableElements.Timer;
import observableElements.VideoPlayer;
import observer.TimeServer;

public class HelloController {
    private TimeServer timeServer;
    @FXML
    public HBox showPane;
    private VideoPlayer videoPlayer1;

    public void initialize() {
        timeServer = new TimeServer();
        Timer timer = new Timer();
        videoPlayer1 = new VideoPlayer();
        Animation animation = new Animation();

        timeServer.attach(timer);
        timeServer.attach(videoPlayer1);
        timeServer.attach(animation);
        showPane.getChildren().add(timer);
        showPane.getChildren().add(videoPlayer1);
        showPane.getChildren().add(animation);
    }

    @FXML
    protected void onButtonStart() {
        timeServer.start();
        videoPlayer1.onComp(2);
    }

    @FXML
    protected void onButtonStop() {
        timeServer.stop();
        videoPlayer1.offComp();
    }
}