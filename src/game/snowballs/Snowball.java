package game.snowballs;

import config.Assets;
import config.GameConfig;
import sprites.SpriteActor;
import sprites.SpriteSet;

public class Snowball extends SpriteActor {

    private final SnowballSpeed speed;

    private Snowball(int xPos, SpriteSet[] sprites, SnowballSpeed speed) {
        super(xPos, GameConfig.SNOWBALL_HEIGHT, sprites);
        this.speed = speed;
    }

    @Override
    public void update() {
        move(-speed.pixelPerFrame, 0);
        super.update();

    }

    public static Snowball createSnowball(SnowballSpeed speed) {
        SpriteSet[] sprites = new SpriteSet[1];
        sprites[0] = SpriteSet.createSet("flying", Assets.SNOWBALL_SPRITES, GameConfig.SNOWBALL_ANIMATION_SPEED);
        return new Snowball(GameConfig.SCREEN_WIDTH, sprites, speed);
    }

}
