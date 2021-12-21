package game.player;

import config.GameConfig;
import de.ur.mi.oop.graphics.Circle;
import game.snowballs.Snowball;
import game.snowballs.SnowballTarget;
import sprites.SpriteActor;
import sprites.SpriteSet;

public class Player extends SpriteActor implements SnowballTarget {

    private boolean isJumping;
    private boolean isFalling;
    private int jumpTargetPosition;
    private int originalPosition;

    public Player(int xPos, int yPos, SpriteSet[] sprites) {
        super(xPos, yPos, sprites);
        isJumping = false;
        isFalling = false;
    }

    public void jump() {
        if (!isJumping) {
            isJumping = true;
            originalPosition = this.getYPos();
            jumpTargetPosition = originalPosition - GameConfig.PLAYER_JUMP_HEIGHT;
            selectSpriteSet("jumping");
        }
    }

    @Override
    public void update() {
        super.update();
        if (isJumping && !isFalling) {
            move(0, -GameConfig.PLAYER_JUMP_SPEED);
            if (getYPos() == jumpTargetPosition) {
                isFalling = true;
            }
        }
        if (isFalling) {
            move(0, GameConfig.PLAYER_JUMP_SPEED);
            if (getYPos() == originalPosition) {
                isJumping = false;
                isFalling = false;
                selectSpriteSet("running");
            }
        }
    }

    @Override
    public boolean wasHitBySnowball(Snowball snowball) {
        Circle center = new Circle(getXPos(), getYPos(), GameConfig.PLAYER_HIT_BOX_RADIUS);
        return center.hitTest(snowball.getXPos(), snowball.getYPos());
    }
}

