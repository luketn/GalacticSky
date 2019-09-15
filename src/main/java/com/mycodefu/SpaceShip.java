package com.mycodefu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SpaceShip extends ImageView implements GameSprite {
    private static final Image IMAGE = new Image(SpaceShip.class.getResourceAsStream("/spaceship.png"));
    
    private final ImageViewMovementController movementController;

    public SpaceShip(Stage stage) {
        super(IMAGE);
        this.movementController = new ImageViewMovementController(stage, this, 15);
    }

    @Override
    public void update(long now) {
        movementController.update(now);
    }
}
