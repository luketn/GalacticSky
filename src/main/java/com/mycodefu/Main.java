package com.mycodefu;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

public class Main extends Application {

    public static final int SPEED = 15;
    private ImageView spaceship;

    public void start(Stage primaryStage) throws Exception {
        Group mainNode = createMainNode(primaryStage);
        Scene scene = createScene(mainNode);
        addKeyListeners(scene);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addKeyListeners(Scene scene) {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case DOWN: {
                    spaceship.setY(spaceship.getY()+ SPEED);
                    break;
                }
                case UP: {
                    spaceship.setY(spaceship.getY()-SPEED);
                    break;
                }
                case LEFT: {
                    spaceship.setX(spaceship.getX()-SPEED);
                    break;
                }
                case RIGHT: {
                    spaceship.setX(spaceship.getX()+SPEED);
                    break;
                }
            }
        });
    }

    Scene createScene(Group mainNode) {
        return new Scene(mainNode, 1920,1080, new ImagePattern(new Image(this.getClass().getResourceAsStream("/background.jpg"))));
    }

    Group createMainNode(Stage primaryStage) {
        return new Group(createSpaceShip());
    }

    private Node createSpaceShip() {
        this.spaceship = new ImageView(new Image(getClass().getResourceAsStream("/spaceship.png")));
        return spaceship;
    }
}
