import config.Assets;
import config.GameConfig;
import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.audio.AudioClip;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;
import game.GameScene;
import intro.IntroScene;
import scenes.Scene;
import scenes.SceneListener;

public class SnowballFight extends GraphicsApp implements SceneListener {

    private Scene[] scenes;
    private Scene currentScene;

    @Override
    public void initialize() {
        setFrameRate(GameConfig.TARGET_FPS);
        setCanvasSize(GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT);
        preloadScenes();
        setScene(GameConfig.INTRO_SCENE_TAG);
        initBackgroundMusic();
    }

    private void preloadScenes() {
        scenes = new Scene[2];
        scenes[0] = new IntroScene(GameConfig.INTRO_SCENE_TAG, this);
        scenes[1] = new GameScene(GameConfig.GAME_SCENE_TAG, this);
    }

    private void setScene(String tag) {
        for (Scene scene : scenes) {
            if (scene.getTag().equals(tag)) {
                currentScene = scene;
                break;
            }
        }
        currentScene.initialize();
    }

    private void initBackgroundMusic() {
        AudioClip backgroundMusic = new AudioClip(Assets.BACKGROUND_MUSIC_PATH);
        backgroundMusic.loop();
    }

    @Override
    public void draw() {
        drawBackground(Colors.WHITE);
        currentScene.update();
        currentScene.draw();
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        currentScene.onKeyPressed(event);
    }

    @Override
    public void onSceneFinished(Scene scene) {
        setScene(GameConfig.GAME_SCENE_TAG);
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch("SnowballFight");
    }
}
