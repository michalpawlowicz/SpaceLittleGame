package model.engine.drawing;

import model.engine.GameWindow;
import model.scenes.Scene;

import java.io.IOException;

/**
 * Created by michal on 08.12.16.
 */
public class DrawingThread extends Thread{
    private Scene scene;
    private GameWindow screen;
    private boolean draw = false;
    public DrawingThread(Scene scene, GameWindow screen){
        super();
        this.scene = scene;
        this.screen = screen;
    }

    @Override
    public void run() {
        while(draw) {
            try {
                screen.refreshGameWindow(scene);
                this.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void setDrawingScene(Scene scene){
        this.scene = scene;
    }
    public void drawing(boolean draw){ this.draw = draw; }

}
