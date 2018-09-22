package com.mycodefu;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {
        Group mainNode = createMainNode(primaryStage);
        Scene scene = createScene(mainNode);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    Scene createScene(Group mainNode) {
        return new Scene(mainNode, 1920,1080, new ImagePattern(new Image(this.getClass().getResourceAsStream("/background.jpg"))));
    }

    Group createMainNode(Stage primaryStage) {
        return new Group(new Spaceship(primaryStage));
    }
}
