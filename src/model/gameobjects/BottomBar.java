package model.gameobjects;

import com.googlecode.lanterna.terminal.Terminal;

import java.util.Collections;
import java.util.List;

/**
 * Created by michal on 20.12.16.
 */
public class BottomBar implements SceneObjects{
    private String score;
    private String currentLives;
    private Pixel position;
    private int width;
    private int height;

    public BottomBar(int score, int currentLives, Pixel position){
        this.position = position;
        this.score = Integer.toString(score);
        this.currentLives = Integer.toString(currentLives);
    }

    public List<SceneObjects> getListOfObjects(){
        return Collections.singletonList(new PlainText("Score: " + score + " Lives: " + currentLives));
    }
    @Override
    public String getBody() { return "Score: " + score + " Lives: " + currentLives; }
    @Override
    public Pixel getPosition() {
        return position;
    }
    @Override
    public void addIntToPositionX(int i) {
        position.addX(i);
    }
    @Override
    public void addIntToPositionY(int i) {
        position.addY(i);
    }
    @Override
    public int getWidth() {
        return width;
    }
    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public Terminal.Color getColor() {
        return null;
    }

    public void setScore(int score){ this.score = Integer.toString(score); }
    public void setLives(int lives){ this.currentLives = Integer.toString(lives); }
}
