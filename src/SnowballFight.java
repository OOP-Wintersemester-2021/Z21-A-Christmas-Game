import config.GameConfig;
import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class SnowballFight extends GraphicsApp {


    @Override
    public void initialize() {
        setFrameRate(GameConfig.TARGET_FPS);
        setCanvasSize(GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT);
    }

    @Override
    public void draw() {
        drawBackground(Colors.WHITE);
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch("SnowballFight");
    }
}
