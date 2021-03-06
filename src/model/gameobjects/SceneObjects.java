package model.gameobjects;

import com.googlecode.lanterna.terminal.Terminal;

/**
 * Created by michal on 06.12.16.
 */
public interface SceneObjects {
    public String getBody();
    public Pixel getPosition();
    public void addIntToPositionX(int i);
    public void addIntToPositionY(int i);
    public int getWidth();
    public int getHeight();
    public Terminal.Color getColor();
}
