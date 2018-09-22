package com.mycodefu;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Window;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import static com.mycodefu.ImageViewMovementController.Moves.*;

public class ImageViewMovementController extends AnimationTimer {
    private final Set<Moves> moves;
    private Window window;
    private ImageView imageView;
    private int speed;

    public ImageViewMovementController(Window window, ImageView imageView, int speed) {
        this.moves = new ConcurrentSkipListSet<>();
        this.window = window;
        this.imageView = imageView;
        this.speed = speed;
        addKeyListeners(window);
    }

    @Override
    public void handle(long now) {
        if (moves.size() > 0) {
            double x = imageView.getX();
            double y = imageView.getY();
            double height = imageView.getImage().getHeight();
            double width = imageView.getImage().getWidth();
            if (moves.contains(Down)) {
                if (y + speed + height < window.getHeight()) {
                    y += speed;
                }
            }
            if (moves.contains(Up)) {
                if (y > 0) {
                    y -= speed;
                }
            }
            if (moves.contains(Left)) {
                if (x > 0) {
                    x -= speed;
                }
            }
            if (moves.contains(Right)) {
                if (x + speed + width < window.getWidth()) {
                    x += speed;
                }
            }

            imageView.setX(x);
            imageView.setY(y);
        }
    }

    private void addKeyListeners(Window window) {
        window.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
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
        window.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
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

    enum Moves {
        Up,
        Down,
        Left,
        Right
    }
}
