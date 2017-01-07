package model.engine;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;
import model.gameobjects.SceneObjects;
import model.scenes.Scene;
import java.io.IOException;
import java.util.List;

/**
 * Created by michal on 07.12.16.
 */
public class GameWindow extends Screen {
    private TerminalSize defaultTerminalSize;
    public GameWindow(Terminal terminal) throws IOException {
        super(terminal);
        defaultTerminalSize = terminal.getTerminalSize();
    }
    public void startWindow(Scene scene) throws IOException {
        this.startScreen();
        refreshGameWindow(scene);
    }
    public synchronized void refreshGameWindow(Scene scene) {
        this.clear();
        List<List<SceneObjects>> res = scene.returnSceneObjects();
        for(List<SceneObjects> x: res){
            for(SceneObjects o: x){
                this.putString(o.getPosition().getX(), o.getPosition().getY(), o.getBody(),
                        Terminal.Color.WHITE, Terminal.Color.BLACK);
            }
        }
        this.refresh();
    }
    public TerminalSize getDefaultTerminalSize(){ return defaultTerminalSize; }
}
