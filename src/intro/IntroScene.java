package intro;

import config.Assets;
import de.ur.mi.oop.events.KeyPressedEvent;
import scenes.Scene;
import scenes.SceneListener;

public class IntroScene extends Scene {

    public IntroScene(String tag, SceneListener listener) {
        super(tag, Assets.INTRO_CARD, listener);
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        if (event.getKeyCode() == KeyPressedEvent.VK_SPACE) {
            getListener().onSceneFinished(this);
        }
    }

}
