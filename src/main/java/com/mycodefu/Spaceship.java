package com.mycodefu;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.concurrent.ConcurrentSkipListSet;

import static com.mycodefu.SpaceshipMoves.*;

public class Spaceship extends ImageView {
    private static final Image IMAGE = new Image(Spaceship.class.getResourceAsStream("/spaceship.png"));
    
    private final MovementController movementController;

    public Spaceship(Stage stage) {
        super(IMAGE);

        this.movementController = new MovementController(this, stage);
        this.movementController.start();
    }
    
    private static class MovementController extends AnimationTimer {
        private static final int SPEED = 15;

        private final ConcurrentSkipListSet<SpaceshipMoves> moves;
        private Spaceship spaceship;
        private Stage stage;

        public MovementController(Spaceship spaceship, Stage stage) {
            this.spaceship = spaceship;
            this.stage = stage;
            this.moves = new ConcurrentSkipListSet<>();
            addKeyListeners(stage);
        }

        @Override
        public void handle(long now) {
            if (moves.size() > 0) {
                double x = spaceship.getX();
                double y = spaceship.getY();
                double height = IMAGE.getHeight();
                double width = IMAGE.getWidth();
                if (moves.contains(Down)) {
                    if (y + SPEED + height < stage.getHeight()) {
                        y += SPEED;
                    }
                }
                if (moves.contains(Up)) {
                    if (y > 0) {
                        y -= SPEED;
                    }
                }
                if (moves.contains(Left)) {
                    if (x > 0) {
                        x -= SPEED;
                    }
                }
                if (moves.contains(Right)) {
                    if (x + SPEED + width < stage.getWidth()) {
                        x += SPEED;
                    }
                }

                spaceship.setX(x);
                spaceship.setY(y);
            }
        }

        private void addKeyListeners(Stage stage) {
            stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                switch (event.getCode()) {
                    case DOWN: {
                        moves.add(Down);
                        break;
                    }
                    case UP: {
                        moves.add(Up);
                        break;
                    }
                    case LEFT: {
                        moves.add(Left);
                        break;
                    }
                    case RIGHT: {
                        moves.add(Right);
                        break;
                    }
                }
            });
            stage.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
                switch (event.getCode()) {
                    case DOWN: {
                        moves.remove(Down);
                        break;
                    }
                    case UP: {
                        moves.remove(Up);
                        break;
                    }
                    case LEFT: {
                        moves.remove(Left);
                        break;
                    }
                    case RIGHT: {
                        moves.remove(Right);
                        break;
                    }
                }
            });
        }
    }

}
