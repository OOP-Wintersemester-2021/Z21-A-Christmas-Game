package game;

import config.Assets;
import config.GameConfig;
import de.ur.mi.oop.events.KeyPressedEvent;
import game.background.BackgroundObjects;
import game.player.Player;
import game.score.Scoreboard;
import game.snowballs.SnowBallListener;
import game.snowballs.SnowballDispenser;
import game.snowballs.SnowballSpeed;
import scenes.Scene;
import scenes.SceneListener;
import sprites.SpriteSet;

public class GameScene extends Scene implements SnowBallListener {

    private BackgroundObjects backgroundObjects;
    private Player player;
    private SnowballDispenser snowballDispenser;
    private Scoreboard scoreboard;
    private int score;

    public GameScene(String tag, SceneListener listener) {
        super(tag, Assets.BACKGROUND_IMAGE_PATH, listener);
    }

    public void initialize() {
        initBackground();
        initPlayer();
        initSnowballs();
        initScoreboard();
    }

    private void initBackground() {
        backgroundObjects = new BackgroundObjects(0, 0);
    }

    private void initPlayer() {
        SpriteSet[] sprites = new SpriteSet[2];
        sprites[0] = SpriteSet.createSet("running", Assets.PLAYER_SPRITES_RUNNING, GameConfig.PLAYER_ANIMATION_SPEED);
        sprites[1] = SpriteSet.createSet("jumping", Assets.PLAYER_SPRITES_JUMPING, GameConfig.PLAYER_ANIMATION_SPEED);
        player = new Player(GameConfig.PLAYER_START_POSITION_X, GameConfig.PLAYER_START_POSITION_Y, sprites);
    }

    private void initSnowballs() {
        snowballDispenser = new SnowballDispenser(GameConfig.MAX_SNOWBALLS, GameConfig.SNOWBALL_SPAWN_DELAY);
        snowballDispenser.setSnowballListener(this);
        snowballDispenser.setSpeed(SnowballSpeed.SLOW);
        snowballDispenser.setTarget(player);
    }

    private void initScoreboard() {
        score = 0;
        scoreboard = new Scoreboard(GameConfig.SCOREBOARD_POSITION_X, GameConfig.SCOREBOARD_POSITION_Y);
        scoreboard.setScore(score);
    }

    public void update() {
        backgroundObjects.update();
        player.update();
        snowballDispenser.update();
    }

    public void draw() {
        super.draw();
        backgroundObjects.draw();
        player.draw();
        snowballDispenser.draw();
        scoreboard.draw();
    }

    public void onKeyPressed(KeyPressedEvent event) {
        if (event.getKeyCode() == KeyPressedEvent.VK_SPACE) {
            player.jump();
        }
    }

    @Override
    public void onSnowballHitPlayer() {
        score = 0;
        scoreboard.setScore(score);
    }

    @Override
    public void onSnowballLeftScreen() {
        score++;
        scoreboard.setScore(score);
    }
}
