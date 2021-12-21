package sprites;

import de.ur.mi.oop.graphics.Image;

public class SpriteActor {

    private final SpriteSet[] spriteSets;
    private SpriteSet currentSpriteSet;
    private Image currentSprite;
    private int xPos;
    private int yPos;

    public SpriteActor(int xPos, int yPos, SpriteSet[] sprites) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.spriteSets = sprites;
        selectSpriteSet(sprites[0].name);
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void selectSpriteSet(String name) {
        for (int i = 0; i < spriteSets.length; i++) {
            if (spriteSets[i].name == name) {
                currentSpriteSet = spriteSets[i];
                currentSprite = currentSpriteSet.getFirstSprite();
                return;
            }
        }
        currentSpriteSet = null;
    }

    public void setPosition(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void move(int xPos, int yPos) {
        int newX = this.xPos + xPos;
        int newY = this.yPos + yPos;
        setPosition(newX, newY);
    }

    public Image getCurrentSprite() {
        return currentSprite;
    }

    public void update() {
        currentSprite = currentSpriteSet.getSprite();
    }

    public void draw() {
        currentSprite.setPosition(this.getXPos(), this.getYPos());
        currentSprite.draw();
    }
}
