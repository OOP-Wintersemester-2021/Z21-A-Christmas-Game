package sprites;

import de.ur.mi.oop.graphics.Image;

public class SpriteSet {

    public final String name;
    public final Image[] sprites;
    public final int animationSpeed;
    private int currentFrame;
    private int frameCounter;

    public SpriteSet(String name, Image[] sprites, int animationSpeed) {
        this.name = name;
        this.sprites = sprites;
        this.animationSpeed = animationSpeed;
        this.currentFrame = 0;
        this.frameCounter = 0;
    }

    public void setPositions(int xPos, int yPos) {
        for (Image sprite : sprites) {
            sprite.setPosition(xPos, yPos);
        }
    }

    public Image getFirstSprite() {
        return sprites[0];
    }

    public Image getSprite() {
        if (frameCounter > animationSpeed / sprites.length) {
            currentFrame++;
            if (currentFrame == sprites.length) {
                currentFrame = 0;
            }
            frameCounter = 0;
        } else {
            frameCounter++;
        }
        return sprites[currentFrame];
    }

    public static SpriteSet createSet(String name, String[] sources, int animationSpeed) {
        Image[] sprites = loadSprites(sources);
        return new SpriteSet(name, sprites, animationSpeed);
    }

    private static Image[] loadSprites(String[] sources) {
        Image[] sprites = new Image[sources.length];
        for (int i = 0; i < sources.length; i++) {
            sprites[i] = new Image(0, 0, sources[i]);
        }
        return sprites;
    }
}
