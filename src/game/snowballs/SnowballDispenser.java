package game.snowballs;

public class SnowballDispenser {

    private SnowballTarget target;
    private SnowBallListener listener;
    private SnowballSpeed speed = SnowballSpeed.SLOW;
    private final Snowball[] snowballs;
    private final int spawnDelay;
    private int framesSinceLastSpawn;


    public SnowballDispenser(int maxSnowballs, int spawnDelayInFrames) {
        this.snowballs = new Snowball[maxSnowballs];
        this.spawnDelay = spawnDelayInFrames;
        this.framesSinceLastSpawn = this.spawnDelay;
    }

    public void update() {
        if (framesSinceLastSpawn == spawnDelay) {
            spawnSnowball();
            framesSinceLastSpawn = 0;
        }
        framesSinceLastSpawn++;
        updateSnowBalls();
    }

    public void draw() {
        drawSnowballs();
    }

    private void spawnSnowball() {
        for (int i = 0; i < snowballs.length; i++) {
            if (snowballs[i] == null) {
                snowballs[i] = Snowball.createSnowball(speed);
                return;
            }
        }
    }

    private void updateSnowBalls() {
        for (int i = snowballs.length - 1; i >= 0; i--) {
            if (snowballs[i] != null) {
                snowballs[i].update();
                if (target.wasHitBySnowball(snowballs[i])) {
                    listener.onSnowballHitPlayer();
                    removeSnowball(i);
                    return;
                }
                if (snowballs[i].getXPos() < 0) {
                    listener.onSnowballLeftScreen();
                    removeSnowball(i);
                }
            }
        }
    }

    private void removeSnowball(int position) {
        snowballs[position] = null;
    }

    private void drawSnowballs() {
        for (int i = 0; i < snowballs.length; i++) {
            if (snowballs[i] != null) {
                snowballs[i].draw();
            }
        }
    }

    public void setSnowballListener(SnowBallListener listener) {
        this.listener = listener;
    }

    public void setSpeed(SnowballSpeed speed) {
        this.speed = speed;
    }

    public void setTarget(SnowballTarget target) {
        this.target = target;
    }
}
