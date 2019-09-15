package com.mycodefu;

public interface GameSprite {
    /**
     * Update the sprite for the current frame of the game loop.
     * @param now the time elapsed in the game.
     */
    void update(long now);
}
