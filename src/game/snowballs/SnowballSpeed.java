package game.snowballs;

public enum SnowballSpeed {
    SLOW(3),
    MEDIUM(6),
    FAST(9);

    public final int pixelPerFrame;

    SnowballSpeed(int pixelPerFrame) {
        this.pixelPerFrame = pixelPerFrame;
    }
}
