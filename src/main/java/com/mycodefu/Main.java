package com.mycodefu;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {
        Group mainNode = createMainNode(primaryStage);
        Scene scene = createScene(mainNode);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    Scene createScene(Group mainNode) {
        return new Scene(mainNode, 1024, 768, Color.BLACK);
    }

    Group createMainNode(Stage primaryStage) {
        return new Group();
    }
}
