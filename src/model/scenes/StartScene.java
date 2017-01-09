package model.scenes;

import com.googlecode.lanterna.terminal.TerminalSize;
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
    private TerminalSize resolution;

    public StartScene(Pixel position, TerminalSize resolution){
        this.resolution = resolution;
        this.position = position;
        newGame = new Button("Start");
        newGame.selected(true);
        quit = new Button("Quit");
        buttonBar = new ButtonBar();
        buttonBar.addButton(newGame);
        buttonBar.addButton(quit);
        buttonBar.updateButtonsPosition(new Pixel(resolution.getColumns()/2-buttonBar.getWidth(),
                resolution.getRows()/2-1));
    }
    @Override
    public synchronized List<List<SceneObjects>> returnSceneObjects() {
        List<List<SceneObjects>> list = new LinkedList<>();
        list.add(buttonBar.getButtonBarObjects());
        return list;
    }

    @Override
    public void setResolution(TerminalSize terminalSize) {
        resolution = terminalSize;
    }

    //synchronized??
    public synchronized void setNextSelected(){buttonBar.setNextSelected();}
    public synchronized void setPrevSelected(){buttonBar.setPrevSelected();}
    public int getSelected(){ return buttonBar.getSelected(); }
    public void resizeAction(TerminalSize terminalSize){
        buttonBar.setPosition(new Pixel(terminalSize.getColumns()/2-buttonBar.getWidth(),
                terminalSize.getRows()/2 - 1));
    }
}
