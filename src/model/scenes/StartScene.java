package model.scenes;

import menuObjects.Button;
import menuObjects.ButtonBar;
import model.gameobjects.Pixel;
import model.gameobjects.SceneObjects;

import java.util.LinkedList;
import java.util.List;
/**
 * Created by michal on 19.12.16.
 */
public class StartScene implements Scene {
    private Pixel position;
    private Button newGame;
    private Button quit;
    private ButtonBar buttonBar;

    public StartScene(Pixel position){
        this.position = position;
        newGame = new Button("Start");
        newGame.selected(true);
        quit = new Button("Quit");
        buttonBar = new ButtonBar(new Pixel(0,0));
        buttonBar.addButton(newGame);
        buttonBar.addButton(quit);
    }
    @Override
    //synchronized?
    public List<List<SceneObjects>> returnSceneObjects() {
        List<List<SceneObjects>> list = new LinkedList<>();
        list.add(buttonBar.getButtonBarObjects());
        return list;
    }
    //synchronized??
    public synchronized void setNextSelected(){buttonBar.setNextSelected();}
    public synchronized void setPrevSelected(){buttonBar.setPrevSelected();}
    public int getSelected(){ return buttonBar.getSelected(); }

}
