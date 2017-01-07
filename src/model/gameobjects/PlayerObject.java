package model.gameobjects;

import java.awt.geom.Point2D;
import java.util.Collections;
import java.util.List;

/**
 * Created by michal on 06.12.16.
 */
public class PlayerObject implements SceneObjects {
    private final String body = "/-^-\\";
    private Pixel playerPosition;
    private final int height = 1;
    private final int width = 5;
    private int sconre = 0;
    private int lives = 3;

    public PlayerObject(){ playerPosition = new Pixel(); }
    public PlayerObject(Pixel position){ this.playerPosition = position; }
    public Pixel getPlayerPosition() {
        return playerPosition;
    }
    public void setPlayerPosition(Pixel playerPosition) {
        this.playerPosition = playerPosition;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    @Override
    public String getBody() {
        return body;
    }
    @Override
    public Pixel getPosition() { return playerPosition; }
    @Override
    public void addIntToPositionX(int p){
        playerPosition.addX(p);
    }
    @Override
    public void addIntToPositionY(int p){ playerPosition.addY(p); }
    public List<SceneObjects> getPlayersList(){ return Collections.singletonList(this); }
    public void addPoints(int points){ sconre += points; }
    public int getScore(){ return  sconre; }
    public int getLives(){ return lives; }
    public void setLives(int lives){ this.lives = lives; }
    public void subLives(int s){ lives -= s; }
}