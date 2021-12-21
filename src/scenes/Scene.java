package scenes;

import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.graphics.Image;

public class Scene {

    private final String tag;
    private final SceneListener listener;
    private final Image backgroundImage;

    public Scene(String tag, String backgroundImagePath, SceneListener listener) {
        this.tag = tag;
        this.listener = listener;
        this.backgroundImage = new Image(0, 0, backgroundImagePath);
    }

    public String getTag() {
        return tag;
    }

    public SceneListener getListener() {
        return listener;
    }

    public void initialize() {

    }

    public void update() {

    }

    public void draw() {
        this.backgroundImage.draw();
    }

    public void onKeyPressed(KeyPressedEvent event) {

    }
}
