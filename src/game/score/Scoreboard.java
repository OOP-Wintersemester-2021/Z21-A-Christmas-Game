package game.score;

import config.GameConfig;
import de.ur.mi.oop.graphics.Label;

public class Scoreboard {

    private final Label label;

    public Scoreboard(int xPos, int yPos) {
        this.label = new Label(xPos, yPos, "");
        this.label.setFont(GameConfig.SCOREBOARD_FONT);
        this.label.setFontSize(GameConfig.SCOREBOARD_FONT_SIZE);
        this.label.setColor(GameConfig.SCOREBOARD_FONT_COLOR);
    }

    public void setScore(int score) {
        int scoreStringTargetLength = String.valueOf(GameConfig.MAX_SCORE).length();
        StringBuilder builder = new StringBuilder();
        builder.append(score);
        while (builder.length() < scoreStringTargetLength) {
            builder.insert(0, "0");
        }
        label.setText(builder.toString());
    }

    public void draw() {
        label.draw();
    }

}
