package model.scenes;

import menuObjects.Button;
import menuObjects.ButtonBar;
import model.gameobjects.Pixel;
import model.gameobjects.PlainText;
import model.gameobjects.SceneObjects;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by michal on 21.12.16.
 */
public class EndScene implements Scene {
    private PlainText scoreText;
    private Button newGame;
    private Button quit;
    private ButtonBar buttonBar;
    private boolean enterPressed = false;

    public EndScene(int score){
        scoreText = new PlainText("Your score: " + Integer.toString(score));
        newGame = new Button("New game");
        quit = new Button("Quit");
        buttonBar = new ButtonBar(new Pixel(0,1));
        buttonBar.addButton(newGame);
        buttonBar.addButton(quit);
        newGame.selected(true);

    }
    @Override
    public List<List<SceneObjects>> returnSceneObjects() {
        List<List<SceneObjects>> group = new LinkedList<>();
        group.add(Collections.singletonList(scoreText));
        group.add(buttonBar.getButtonBarObjects());
        return group;
    }
    public synchronized void setNextSelected(){buttonBar.setNextSelected();}
    public synchronized void setPrevSelected(){buttonBar.setPrevSelected();}
    public int getSelected(){ return buttonBar.getSelected(); }
    public synchronized void setEnterPressed(boolean enterPressed){
        this.enterPressed = enterPressed;
    }
    public boolean getEnterPressed(){ return enterPressed;}
}
