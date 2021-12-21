package config;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;

public abstract class GameConfig {

    public static final int SCREEN_WIDTH = 320;
    public static final int SCREEN_HEIGHT = 288;
    public static final int TARGET_FPS = 60;
    public static final String INTRO_SCENE_TAG = "Intro";
    public static final String GAME_SCENE_TAG = "Game";
    public static final int PLAYER_JUMP_HEIGHT = 125;
    public static final int PLAYER_JUMP_SPEED = 5;
    public static final int PLAYER_HIT_BOX_RADIUS = 60;
    public static final int PLAYER_START_POSITION_X = 25;
    public static final int PLAYER_START_POSITION_Y = 120;
    public static final int PLAYER_ANIMATION_SPEED = 10;
    public static final int MAX_SNOWBALLS = 3;
    public static final int SNOWBALL_ANIMATION_SPEED = 30;
    public static final int SNOWBALL_SPAWN_DELAY = TARGET_FPS * 3;
    public static final int SNOWBALL_HEIGHT = 175;
    public static final int SCOREBOARD_POSITION_X = 30;
    public static final int SCOREBOARD_POSITION_Y = 30;
    public static final int MAX_SCORE = 999999;
    public static final String SCOREBOARD_FONT = "Arial Rounded MT Bold";
    public static final int SCOREBOARD_FONT_SIZE = 24;
    public static final Color SCOREBOARD_FONT_COLOR = Colors.WHITE;

}
