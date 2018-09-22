package com.mycodefu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Spaceship extends ImageView {
    public static final int SPEED = 15;

    public Spaceship(Stage stage) {
        super(new Image(Spaceship.class.getResourceAsStream("/spaceship.png")));
        addKeyListeners(stage);
    }

    private void addKeyListeners(Stage stage) {
        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case DOWN: {
                    this.setY(this.getY()+ SPEED);
                    break;
                }
                case UP: {
                    this.setY(this.getY()-SPEED);
                    break;
                }
                case LEFT: {
                    this.setX(this.getX()-SPEED);
                    break;
                }
                case RIGHT: {
                    this.setX(this.getX()+SPEED);
                    break;
                }
            }
        });
    }
}
